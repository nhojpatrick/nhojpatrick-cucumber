package com.github.nhojpatrick.cucumber.json.transformations.reverse;

import com.github.nhojpatrick.cucumber.core.exceptions.IllegalKeyException;
import com.github.nhojpatrick.cucumber.json.core.exceptions.IllegalPathOperationException;
import com.github.nhojpatrick.cucumber.json.core.exceptions.NullPathElementException;
import com.github.nhojpatrick.cucumber.json.core.validation.PathElement;
import com.github.nhojpatrick.cucumber.json.transformations.core.BaseTransformation;
import com.google.common.annotations.VisibleForTesting;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

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
    @SuppressFBWarnings(value = {"USBR_UNNECESSARY_STORE_BEFORE_RETURN",
            "COM_COPIED_OVERRIDDEN_METHOD"},
            justification = "Useful for debugging")
    public int hashCode() {
        final int hashCode = new HashCodeBuilder(17, 37)
                .toHashCode();
        return hashCode;
    }

    @Override
    public boolean isParentPathAutoCreated() {
        return false;
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

        if (pathElement.isAttribute()) {

            if (!output.containsKey(pathElement.getElement())) {
                throw new IllegalPathOperationException(String.format(
                        "Path does not exist at '%s'.",
                        pathElement.getPath(currentPath)
                ));
            }

            if (isNull(output.get(pathElement.getElement()))) {
                throw new IllegalPathOperationException(String.format(
                        "Unable to reverse 'null' value, at path '%s'.",
                        pathElement.getPath(currentPath)
                ));
            }

            final Object obj = output.get(pathElement.getElement());

            if (isTypedMap(obj, String.class, Object.class)) {
                throw new IllegalPathOperationException(String.format(
                        "Unable to reverse JsonObject, at path '%s'.",
                        pathElement.getPath(currentPath)
                ));
            }

            if (isTypedList(obj, Object.class)) {

                final List<Object> listObj = (List<Object>) obj;
                Collections.reverse(listObj);
                output.put(pathElement.getElement(), listObj);

            } else {
                final String reversed = reverse(currentPath, obj);
                output.put(pathElement.getElement(), reversed);
            }

        } else {

            if (!output.containsKey(pathElement.getElement())) {
                throw new IllegalPathOperationException(String.format(
                        "Path does not exist at '%s'.",
                        pathElement.getPath(currentPath, false)
                ));
            }

            if (isNull(output.get(pathElement.getElement()))) {
                throw new IllegalPathOperationException(String.format(
                        "Unable to reverse 'null' value, at path '%s'.",
                        pathElement.getPath(currentPath, false)
                ));
            }

            final Object objRaw = output.get(pathElement.getElement());

            if (!isTypedList(objRaw, Object.class)) {
                throw new IllegalPathOperationException(String.format(
                        "Unable to reverse path '%s', as is not Array.",
                        pathElement.getPath(currentPath, false)
                ));
            }

            final List<Object> listObj = (List<Object>) objRaw;

            if (pathElement.getArrayIndex() < listObj.size()) {

                final Object obj = listObj.get(pathElement.getArrayIndex());

                if (isTypedMap(obj, String.class, Object.class)) {
                    throw new IllegalPathOperationException(String.format(
                            "Unable to reverse JsonObject, at path '%s'.",
                            pathElement.getPath(currentPath)
                    ));
                }

                final String reversed = reverse(currentPath, obj);

                listObj.set(pathElement.getArrayIndex(), reversed);

            } else if (listObj.isEmpty()) {
                throw new IllegalPathOperationException(String.format(
                        "Unable to reverse path '%s', as array is empty.",
                        pathElement.getPath(currentPath, false)
                ));

            } else {
                throw new IllegalPathOperationException(String.format(
                        "Unable to reverse path '%s', beyond index of '%s'.",
                        pathElement.getPath(currentPath),
                        listObj.size() - 1
                ));
            }

            output.put(pathElement.getElement(), listObj);
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

    @SuppressFBWarnings(value = {"USBR_UNNECESSARY_STORE_BEFORE_RETURN",
            "CSBTS_COMMONS_STRING_BUILDER_TOSTRING"},
            justification = "Useful for debugging")
    public String toString() {
        final String toString = new ToStringBuilder(this, SHORT_PREFIX_STYLE)
                .toString();
        return toString;
    }

}
