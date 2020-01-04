package com.github.nhojpatrick.cucumber.json.transformations.reverse;

import com.github.nhojpatrick.cucumber.core.exceptions.IllegalKeyException;
import com.github.nhojpatrick.cucumber.json.core.exceptions.IllegalPathOperationException;
import com.github.nhojpatrick.cucumber.json.core.exceptions.NullPathElementException;
import com.github.nhojpatrick.cucumber.json.core.validation.PathElement;
import com.github.nhojpatrick.cucumber.json.transformations.core.BaseTransformation;
import com.google.common.annotations.VisibleForTesting;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.github.nhojpatrick.cucumber.json.core.transform.utils.ListTypeUtil.isTypedList;
import static com.github.nhojpatrick.cucumber.json.core.transform.utils.MapTypeUtil.isTypedMap;
import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;
import static org.apache.commons.lang3.builder.ToStringStyle.SHORT_PREFIX_STYLE;

public class ReverseTransformation
        extends BaseTransformation {

    public ReverseTransformation() {
        super();
    }

    @Override
    public boolean equals(final Object obj) {

        if (!(obj instanceof ReverseTransformation)) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .toHashCode();
    }

    @Override
    public Map<String, Object> perform(final PathElement pathElement,
                                       final Map<String, Object> inputRaw,
                                       final String currentPath)
            throws IllegalKeyException,
            IllegalPathOperationException {

        if (isNull(pathElement)) {
            throw new NullPathElementException();
        }

        final Map<String, Object> output = nonNull(inputRaw)
                ? inputRaw
                : new HashMap<>();

        if (pathElement.isNotArrayElement()) {

            final Object obj = output.get(pathElement.getElement());

            if (isTypedMap(obj, String.class, Object.class)) {
                throw new IllegalPathOperationException(String.format(
                        "Unable to reverse JsonObject, at path '%s'.",
                        currentPath
                ));
            }

            if (isTypedList(obj, Object.class)) {

                final List<Object> listObj = (List<Object>) obj;
                Collections.reverse(listObj);
                output.put(pathElement.getElement(), listObj);

            } else {
                if (output.containsKey(pathElement.getElement())) {
                    final String reversed = reverse(currentPath, obj);
                    output.put(pathElement.getElement(), reversed);
                }
            }

        } else {

            Object objRaw = output.get(pathElement.getElement());

            objRaw = nonNull(objRaw)
                    ? objRaw
                    : new ArrayList<>();

            if (isTypedList(objRaw, Object.class)) {

                final List<Object> listObj = (List<Object>) objRaw;

                if (pathElement.getArrayIndex() < listObj.size()) {

                    final Object obj = listObj.get(pathElement.getArrayIndex());
                    final String reversed = reverse(currentPath, obj);

                    listObj.set(pathElement.getArrayIndex(), reversed);

                } else {
                    final int size = listObj.size();
                    final int arrayIndex = pathElement.getArrayIndex();

                    for (int i = size; i <= arrayIndex; i++) {
                        listObj.add(null);
                    }
                }

                output.put(pathElement.getElement(), listObj);

            } else {
                throw new UnsupportedOperationException("FIXME reverse issue");
            }
        }

        return output;
    }

    @VisibleForTesting
    String reverse(final String currentPath,
                   final Object input)
            throws IllegalPathOperationException {

        if (input instanceof Map) {
            throw new IllegalPathOperationException(String.format(
                    "Unable to reverse JsonObject, at path '%s'.",
                    currentPath
            ));
//            throw new UnsupportedOperationException("Unable to reverse JsonObject.");
        }

        if (input instanceof List) {
            throw new IllegalPathOperationException(String.format(
                    "Unable to reverse JsonArray<>, at path '%s'.",
                    currentPath
            ));
        }

        if (isNull(input)) {
            return null;
        }

        String str;
        if (input instanceof String) {
            str = (String) input;

        } else {
            str = String.valueOf(input);
        }

        return StringUtils.reverse(str);
    }

    @Override
    public String toString() {
        final String toString = new ToStringBuilder(this, SHORT_PREFIX_STYLE)
                .toString();
        return toString;
    }

}
