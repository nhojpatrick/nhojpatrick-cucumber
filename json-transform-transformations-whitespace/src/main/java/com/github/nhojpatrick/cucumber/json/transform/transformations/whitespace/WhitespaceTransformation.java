package com.github.nhojpatrick.cucumber.json.transform.transformations.whitespace;

import com.github.nhojpatrick.cucumber.core.exceptions.IllegalKeyException;
import com.github.nhojpatrick.cucumber.json.core.exceptions.IllegalPathOperationException;
import com.github.nhojpatrick.cucumber.json.core.exceptions.NullPathElementException;
import com.github.nhojpatrick.cucumber.json.core.transform.Transformation;
import com.github.nhojpatrick.cucumber.json.core.validation.PathElement;
import com.github.nhojpatrick.cucumber.json.transform.transformations.whitespace.exceptions.WhitespacePrefixException;
import com.github.nhojpatrick.cucumber.json.transform.transformations.whitespace.exceptions.WhitespaceSuffixException;
import com.github.nhojpatrick.cucumber.json.transform.transformations.whitespace.exceptions.WhitespaceTransformationArgumentException;
import com.google.common.annotations.VisibleForTesting;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static com.github.nhojpatrick.cucumber.json.core.transform.utils.ListTypeUtil.isTypedList;
import static com.github.nhojpatrick.cucumber.json.core.transform.utils.MapTypeUtil.isTypedMap;
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

        if (Objects.isNull(pathElement)) {
            throw new NullPathElementException();
        }

        final Map<String, Object> output = Objects.nonNull(input)
                ? input : new HashMap<>();

        if (output.containsKey(pathElement.getElement())) {

            if (!pathElement.isArrayElement()) {

                final Object obj = output.get(pathElement.getElement());

                if (isTypedMap(obj, String.class, Object.class)) {
                    throw new IllegalPathOperationException("FIXME 0");

                } else if (isTypedList(obj, Map.class)) {
                    throw new IllegalPathOperationException("FIXME 1");

                } else if (isTypedList(obj, Object.class)) {
                    throw new IllegalPathOperationException("FIXME 2");
                }

                final String str;
                if (Objects.isNull(obj)) {
                    str = "";

                } else if (obj instanceof String) {
                    str = (String) obj;

                } else {
                    str = String.valueOf(obj);
                }

                final String padded = pad(str, this.prefix, this.suffix);

                output.put(pathElement.getElement(), padded);

            } else {
                throw new IllegalPathOperationException("FIXME 3");
            }

        } else {
            final String padded = pad(null, this.prefix, this.suffix);
            output.put(pathElement.getElement(), padded);
        }

        return output;
    }

    @VisibleForTesting
    String pad(final String input, final int prefix, final int suffix) {

        String str = Objects.isNull(input) ? "" : input;

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
