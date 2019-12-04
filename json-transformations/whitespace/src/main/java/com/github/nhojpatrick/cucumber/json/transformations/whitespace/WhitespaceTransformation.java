package com.github.nhojpatrick.cucumber.json.transformations.whitespace;

import com.github.nhojpatrick.cucumber.core.exceptions.IllegalKeyException;
import com.github.nhojpatrick.cucumber.json.core.exceptions.IllegalPathOperationException;
import com.github.nhojpatrick.cucumber.json.core.exceptions.NullPathElementException;
import com.github.nhojpatrick.cucumber.json.core.transform.Transformation;
import com.github.nhojpatrick.cucumber.json.core.validation.PathElement;
import com.github.nhojpatrick.cucumber.json.transformations.whitespace.exceptions.WhitespacePrefixException;
import com.github.nhojpatrick.cucumber.json.transformations.whitespace.exceptions.WhitespaceSuffixException;
import com.github.nhojpatrick.cucumber.json.transformations.whitespace.exceptions.WhitespaceTransformationArgumentException;
import com.google.common.annotations.VisibleForTesting;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.github.nhojpatrick.cucumber.json.core.transform.utils.ListTypeUtil.isTypedList;
import static com.github.nhojpatrick.cucumber.json.core.transform.utils.MapTypeUtil.isTypedMap;
import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;
import static org.apache.commons.lang3.builder.ToStringStyle.SHORT_PREFIX_STYLE;

public class WhitespaceTransformation
        implements Transformation {

    private final int prefix;
    private final int suffix;

    public WhitespaceTransformation(final int prefix, final int suffix)
            throws WhitespaceTransformationArgumentException {

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
    public boolean equals(final Object obj) {

        if (!(obj instanceof WhitespaceTransformation)) {
            return false;
        }

        final WhitespaceTransformation that = (WhitespaceTransformation) obj;

        return new EqualsBuilder()
                .append(this.prefix, that.prefix)
                .append(this.suffix, that.suffix)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(this.prefix)
                .append(this.suffix)
                .toHashCode();
    }

    @Override
    public Map<String, Object> perform(final Map<String, Object> input, final PathElement pathElement)
            throws IllegalKeyException,
            IllegalPathOperationException {

        if (isNull(pathElement)) {
            throw new NullPathElementException();
        }

        final Map<String, Object> output = nonNull(input)
                ? input
                : new HashMap<>();

        if (!pathElement.isArrayElement()) {

            final Object obj = output.get(pathElement.getElement());

            if (isTypedMap(obj, String.class, Object.class)) {
                throw new UnsupportedOperationException("Unable to whitespace JsonObject.");
            }

            if (isTypedList(obj, Object.class)) {

                final List<Object> listObj = (List<Object>) obj;
                final List<Object> listObjPadded = listObj.stream()
                        .map(p -> pad(p, this.prefix, this.suffix))
                        .collect(Collectors.toList());
                output.put(pathElement.getElement(), listObjPadded);

            } else {
                final String padded = pad(obj, this.prefix, this.suffix);
                output.put(pathElement.getElement(), padded);
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
                    final String padded = pad(obj, this.prefix, this.suffix);

                    listObj.set(pathElement.getArrayIndex(), padded);

                } else {
                    final int size = listObj.size();
                    final int arrayIndex = pathElement.getArrayIndex();

                    for (int i = size; i < arrayIndex; i++) {
                        listObj.add(null);
                    }

                    final String padded = pad(null, this.prefix, this.suffix);

                    listObj.add(pathElement.getArrayIndex(), padded);
                }

                output.put(pathElement.getElement(), listObj);

            } else {
                throw new UnsupportedOperationException("FIXME whitespace issue");
            }
        }

        return output;
    }

    @VisibleForTesting
    String pad(final Object input, final int prefix, final int suffix) {

        if (input instanceof Map) {
            throw new UnsupportedOperationException("Unable to whitespace JsonObject.");
        }

        if (input instanceof List) {
            throw new UnsupportedOperationException("Unable to whitespace JsonArray<>.");
        }

        String str;
        if (isNull(input)) {
            str = "";

        } else if (input instanceof String) {
            str = (String) input;

        } else {
            str = String.valueOf(input);
        }

        return pad(str, prefix, suffix);
    }

    @VisibleForTesting
    String pad(final String input, final int prefix, final int suffix) {

        String str = isNull(input) ? "" : input;

        str = StringUtils.leftPad(str, str.length() + prefix);
        str = StringUtils.rightPad(str, str.length() + suffix);

        return str;
    }

    @Override
    public String toString() {
        final String toString = new ToStringBuilder(this, SHORT_PREFIX_STYLE)
                .append(this.prefix)
                .append(this.suffix)
                .toString();
        return toString;
    }

}
