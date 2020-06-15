package com.github.nhojpatrick.cucumber.json.core.transform.utils;

import com.github.nhojpatrick.cucumber.core.exceptions.NullGenericsKeyException;
import com.github.nhojpatrick.cucumber.core.exceptions.NullGenericsValueException;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;

import java.util.Map;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

public class MapTypeUtil {

    public static <K, V> boolean isTypedMap(final Object obj,
                                            final Class<K> keyType,
                                            final Class<V> valueType)
            throws NullGenericsKeyException,
            NullGenericsValueException {

        if (isNull(keyType)) {
            throw new NullGenericsKeyException();
        }

        if (isNull(valueType)) {
            throw new NullGenericsValueException();
        }

        if (!(obj instanceof Map)) {
            return false;
        }

        final Map<Object, Object> map = (Map<Object, Object>) obj;

        return isTypedMap(map, keyType, valueType);
    }

    @SuppressFBWarnings(value = "USBR_UNNECESSARY_STORE_BEFORE_RETURN", justification = "Useful for debugging")
    public static <K, V> boolean isTypedMap(final Map<Object, Object> map,
                                            final Class<K> keyType,
                                            final Class<V> valueType)
            throws NullGenericsKeyException,
            NullGenericsValueException {

        if (isNull(keyType)) {
            throw new NullGenericsKeyException();
        }

        if (isNull(valueType)) {
            throw new NullGenericsValueException();
        }

        if (isNull(map)) {
            return false;
        }

        if (map.isEmpty()) {
            return true;
        }

        final boolean isTypeMismatch = map.entrySet()
                .stream()
                .anyMatch(p -> {
                    final boolean keyMismatch = nonNull(p.getKey())
                            && !keyType.isAssignableFrom(p.getKey().getClass());
                    final boolean valueMismatch = nonNull(p.getValue())
                            && !valueType.isAssignableFrom(p.getValue().getClass());
                    return keyMismatch || valueMismatch;
                });
        final boolean isTypeMatch = !isTypeMismatch;

        return isTypeMatch;
    }

    public MapTypeUtil() {
        throw new AssertionError("Static utility class - cannot be instantiated.");
    }

}
