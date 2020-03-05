package com.github.nhojpatrick.cucumber.json.map.impl;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.github.nhojpatrick.cucumber.core.exceptions.NullObjectException;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;

import java.util.Map;
import java.util.function.Function;

import static java.util.Objects.isNull;

public class ConvertMapToJson
        implements Function<Map<String, Object>, String> {

    private final boolean format;

    public ConvertMapToJson() {
        this(true);
    }

    public ConvertMapToJson(final boolean format) {
        this.format = format;
    }

    @SuppressFBWarnings(value = {"EXS_EXCEPTION_SOFTENING_NO_CONSTRAINTS",
            "USBR_UNNECESSARY_STORE_BEFORE_RETURN"},
            justification = "Want no args method, Useful for debugging")
    public String apply(final Map<String, Object> jsonMap) {

        if (isNull(jsonMap)) {
            throw new RuntimeException(new NullObjectException());
        }

        final ObjectMapper objectMapper = new ObjectMapper()
                .configure(SerializationFeature.ORDER_MAP_ENTRIES_BY_KEYS, true)
                .setSerializationInclusion(JsonInclude.Include.ALWAYS);

        if (this.format) {
            objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        }

        try {
            final String jsonStr = objectMapper.writeValueAsString(jsonMap);
            return jsonStr;

        } catch (final JsonProcessingException jpe) {
            throw new RuntimeException(jpe);
        }
    }

}
