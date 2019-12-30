package com.github.nhojpatrick.cucumber.json.map;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.nhojpatrick.cucumber.core.exceptions.NullObjectException;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import static java.util.Objects.isNull;

public class ConvertToMap
        implements Function<Object, Map<String, Object>> {

    public Map<String, Object> apply(final Object obj) {

        if (isNull(obj)) {
            throw new RuntimeException(new NullObjectException());
        }

        final ObjectMapper objectMapper = new ObjectMapper();
//        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        final TypeReference<HashMap<String, Object>> typeRef = new TypeReference<HashMap<String, Object>>() {
        };
        final Map<String, Object> jsonMap = objectMapper.convertValue(obj, typeRef);
        return jsonMap;
    }

}
