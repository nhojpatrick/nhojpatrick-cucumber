package com.github.nhojpatrick.cucumber.json.transform.utils;

import com.github.nhojpatrick.cucumber.core.exceptions.NullGenericsKeyException;
import com.github.nhojpatrick.cucumber.core.exceptions.NullGenericsValueException;

import java.util.Map;
import java.util.Objects;

public class MapTypeUtil {

    public static <K, V> boolean isTypedMap(final Object obj, final Class<K> keyType, final Class<V> valueType)
            throws NullGenericsKeyException,
            NullGenericsValueException {

        if (Objects.isNull(keyType)) {
            throw new NullGenericsKeyException();
        }

        if (Objects.isNull(valueType)) {
            throw new NullGenericsValueException();
        }

        if (!(obj instanceof Map)) {
            return false;
        }

        final Map<Object, Object> map = (Map<Object, Object>) obj;

        return isTypedMap(map, keyType, valueType);
    }

    public static <K, V> boolean isTypedMap(final Map<Object, Object> map, final Class<K> keyType, final Class<V> valueType)
            throws NullGenericsKeyException,
            NullGenericsValueException {

        if (Objects.isNull(keyType)) {
            throw new NullGenericsKeyException();
        }

        if (Objects.isNull(valueType)) {
            throw new NullGenericsValueException();
        }

        if (Objects.isNull(map)) {
            return false;
        }

        if (map.isEmpty()) {
            return true;
        }

        final boolean isTypeMismatch = map.entrySet()
                .stream()
                .anyMatch(p -> (Objects.nonNull(p.getKey()) && !keyType.isAssignableFrom(p.getKey().getClass()))
                        || (Objects.nonNull(p.getValue()) && !valueType.isAssignableFrom(p.getValue().getClass())));
        final boolean isTypeMatch = !isTypeMismatch;

        return isTypeMatch;
    }

}
