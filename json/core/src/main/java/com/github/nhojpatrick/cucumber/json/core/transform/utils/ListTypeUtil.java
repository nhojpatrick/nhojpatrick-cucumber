package com.github.nhojpatrick.cucumber.json.core.transform.utils;

import com.github.nhojpatrick.cucumber.core.exceptions.NullGenericsValueException;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;

import java.util.List;
import java.util.Objects;

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

    @SuppressFBWarnings(value = "USBR_UNNECESSARY_STORE_BEFORE_RETURN", justification = "Useful for debugging")
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
                .filter(Objects::nonNull)
                .anyMatch(p -> !valueType.isAssignableFrom(p.getClass()));
        final boolean isTypeMatch = !isTypeMismatch;

        return isTypeMatch;
    }

    public ListTypeUtil() {
        throw new AssertionError("Static utility class - cannot be instantiated.");
    }

}
