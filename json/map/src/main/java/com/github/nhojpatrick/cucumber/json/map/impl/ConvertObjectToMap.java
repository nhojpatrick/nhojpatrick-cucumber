package com.github.nhojpatrick.cucumber.json.map.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.github.nhojpatrick.cucumber.core.exceptions.NullObjectException;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;

import static java.util.Objects.isNull;

@SuppressFBWarnings(value = "THROWS_METHOD_THROWS_RUNTIMEEXCEPTION", justification = "Accepted will look at changing")
public class ConvertObjectToMap
        implements Function<Object, Map<String, Object>> {

    @SuppressFBWarnings(value = "USBR_UNNECESSARY_STORE_BEFORE_RETURN", justification = "Useful for debugging")
    public Map<String, Object> apply(final Object obj) {

        if (isNull(obj)) {
            throw new RuntimeException(new NullObjectException());
        }

        final ObjectMapper objectMapper = new ObjectMapper()
                .configure(SerializationFeature.ORDER_MAP_ENTRIES_BY_KEYS, true);

        final TypeReference<LinkedHashMap<String, Object>> typeRef =
                new TypeReference<LinkedHashMap<String, Object>>() {
                };

        final Map<String, Object> jsonMap = objectMapper.convertValue(obj, typeRef);
        return jsonMap;
    }

}
