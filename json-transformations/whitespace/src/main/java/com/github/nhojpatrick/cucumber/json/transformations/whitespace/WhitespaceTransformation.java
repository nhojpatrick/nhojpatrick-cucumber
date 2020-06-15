package com.github.nhojpatrick.cucumber.json.transformations.whitespace;

import com.github.nhojpatrick.cucumber.core.exceptions.IllegalKeyException;
import com.github.nhojpatrick.cucumber.json.core.exceptions.IllegalPathOperationException;
import com.github.nhojpatrick.cucumber.json.core.exceptions.NullPathElementException;
import com.github.nhojpatrick.cucumber.json.core.validation.PathElement;
import com.github.nhojpatrick.cucumber.json.transformations.core.BaseTransformation;
import com.github.nhojpatrick.cucumber.json.transformations.whitespace.exceptions.WhitespacePrefixException;
import com.github.nhojpatrick.cucumber.json.transformations.whitespace.exceptions.WhitespaceSuffixException;
import com.github.nhojpatrick.cucumber.json.transformations.whitespace.exceptions.WhitespaceTransformationArgumentException;
import com.google.common.annotations.VisibleForTesting;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.github.nhojpatrick.cucumber.json.core.transform.utils.ListTypeUtil.isTypedList;
import static com.github.nhojpatrick.cucumber.json.core.transform.utils.MapTypeUtil.isTypedMap;
import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;
import static org.apache.commons.lang3.builder.ToStringStyle.SHORT_PREFIX_STYLE;

public class WhitespaceTransformation
        extends BaseTransformation {

    private final int prefix;
    private final int suffix;

    public WhitespaceTransformation(final int prefix, final int suffix)
            throws WhitespaceTransformationArgumentException {

        super();

        if (prefix < 0) {
            throw new WhitespacePrefixException(prefix);
        }
        this.prefix = prefix;

        if (suffix < 0) {
            throw new WhitespaceSuffixException(suffix);
        }
        this.suffix = suffix;
    }

    @Override
    @SuppressFBWarnings(value = "USBR_UNNECESSARY_STORE_BEFORE_RETURN", justification = "Useful for debugging")
    public boolean equals(final Object obj) {

        if (!(obj instanceof WhitespaceTransformation)) {
            return false;
        }

        final WhitespaceTransformation that = (WhitespaceTransformation) obj;

        final boolean equal = new EqualsBuilder()
                .append(this.prefix, that.prefix)
                .append(this.suffix, that.suffix)
                .isEquals();
        return equal;
    }

    @Override
    @SuppressFBWarnings(value = "USBR_UNNECESSARY_STORE_BEFORE_RETURN", justification = "Useful for debugging")
    public int hashCode() {
        final int hashCode = new HashCodeBuilder(17, 37)
                .append(this.prefix)
                .append(this.suffix)
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
                        "Unable to whitespace 'null' value, at path '%s'.",
                        pathElement.getPath(currentPath)
                ));
            }

            final Object obj = output.get(pathElement.getElement());

            if (isTypedMap(obj, String.class, Object.class)) {
                throw new IllegalPathOperationException(String.format(
                        "Unable to whitespace JsonObject, at path '%s'.",
                        pathElement.getPath(currentPath)
                ));
            }

            final String padded = pad(
                    obj,
                    this.prefix,
                    this.suffix,
                    pathElement.getPath(currentPath)
            );

            output.put(pathElement.getElement(), padded);

        } else {

            if (!output.containsKey(pathElement.getElement())) {
                throw new IllegalPathOperationException(String.format(
                        "Path does not exist at '%s'.",
                        pathElement.getPath(currentPath, false)
                ));
            }

            if (isNull(output.get(pathElement.getElement()))) {
                throw new IllegalPathOperationException(String.format(
                        "Unable to whitespace 'null' value, at path '%s'.",
                        pathElement.getPath(currentPath, false)
                ));
            }

            final Object objRaw = output.get(pathElement.getElement());

            if (!isTypedList(objRaw, Object.class)) {
                throw new IllegalPathOperationException(String.format(
                        "Unable to whitespace path '%s', as is not Array.",
                        pathElement.getPath(currentPath, false)
                ));
            }

            final List<Object> listObj = (List<Object>) objRaw;

            if (pathElement.getArrayIndex() < listObj.size()) {

                final Object obj = listObj.get(pathElement.getArrayIndex());

                if (isTypedMap(obj, String.class, Object.class)) {
                    throw new IllegalPathOperationException(String.format(
                            "Unable to whitespace JsonObject, at path '%s'.",
                            pathElement.getPath(currentPath)
                    ));
                }

                final String padded = pad(
                        obj,
                        this.prefix,
                        this.suffix,
                        pathElement.getPath(currentPath)
                );

                listObj.set(pathElement.getArrayIndex(), padded);

            } else if (listObj.isEmpty()) {
                throw new IllegalPathOperationException(String.format(
                        "Unable to whitespace path '%s', as array is empty.",
                        pathElement.getPath(currentPath, false)
                ));

            } else {
                throw new IllegalPathOperationException(String.format(
                        "Unable to whitespace path '%s', beyond index of '%s'.",
                        pathElement.getPath(currentPath),
                        listObj.size() - 1
                ));
            }

            output.put(pathElement.getElement(), listObj);
        }

        return output;
    }

    @VisibleForTesting
    String pad(final Object input,
               final int prefix,
               final int suffix,
               final String currentPath)
            throws IllegalPathOperationException {

        if (input instanceof Map) {
            throw new IllegalPathOperationException(String.format(
                    "Unable to whitespace JsonObject, at path '%s'.",
                    currentPath
            ));
        }

        if (input instanceof List) {
            throw new IllegalPathOperationException(String.format(
                    "Unable to whitespace JsonArray<>, at path '%s'.",
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

        return pad(str, prefix, suffix);
    }

    @VisibleForTesting
    @SuppressFBWarnings(value = "USBR_UNNECESSARY_STORE_BEFORE_RETURN", justification = "Useful for debugging")
    public String pad(final String input, final int prefix, final int suffix) {

        String str = isNull(input) ? "" : input;

        str = StringUtils.leftPad(str, str.length() + prefix);
        str = StringUtils.rightPad(str, str.length() + suffix);

        return str;
    }

    @Override
    @SuppressFBWarnings(value = "USBR_UNNECESSARY_STORE_BEFORE_RETURN", justification = "Useful for debugging")
    public String toString() {
        final String toString = new ToStringBuilder(this, SHORT_PREFIX_STYLE)
                .append(this.prefix)
                .append(this.suffix)
                .toString();
        return toString;
    }

}
