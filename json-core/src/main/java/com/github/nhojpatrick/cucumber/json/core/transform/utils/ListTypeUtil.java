package com.github.nhojpatrick.cucumber.json.core.transform.utils;

import com.github.nhojpatrick.cucumber.core.exceptions.NullGenericsValueException;

import java.util.List;

import static java.util.Objects.isNull;

public class ListTypeUtil {

    public static <V> boolean isTypedList(final Object obj, final Class<V> valueType)
            throws NullGenericsValueException {

        if (isNull(valueType)) {
            throw new NullGenericsValueException();
        }

        if (!(obj instanceof List)) {
            return false;
        }

        final List<Object> list = (List<Object>) obj;

        return isTypedList(list, valueType);
    }

    public static <V> boolean isTypedList(final List<Object> list, final Class<V> valueType)
            throws NullGenericsValueException {

        if (isNull(valueType)) {
            throw new NullGenericsValueException();
        }

        if (isNull(list)) {
            return false;
        }

        if (list.isEmpty()) {
            return true;
        }

        final boolean isTypeMismatch = list.stream()
                .anyMatch(p -> !valueType.isAssignableFrom(p.getClass()));
        final boolean isTypeMatch = !isTypeMismatch;

        return isTypeMatch;
    }

    ListTypeUtil() {
        throw new AssertionError("Static utility class - cannot be instantiated.");
    }

}
