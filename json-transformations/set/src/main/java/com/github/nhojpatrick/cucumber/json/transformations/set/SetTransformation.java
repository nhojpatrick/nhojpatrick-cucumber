package com.github.nhojpatrick.cucumber.json.transformations.set;

import com.github.nhojpatrick.cucumber.core.exceptions.IllegalKeyException;
import com.github.nhojpatrick.cucumber.json.core.exceptions.NullPathElementException;
import com.github.nhojpatrick.cucumber.json.core.transform.Transformation;
import com.github.nhojpatrick.cucumber.json.core.validation.PathElement;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static org.apache.commons.lang3.builder.ToStringStyle.SHORT_PREFIX_STYLE;

public class SetTransformation
        implements Transformation {

    private final Object value;

    public SetTransformation(final Object value) {
        this.value = value;
    }

    @Override
    public boolean equals(final Object obj) {

        if (!(obj instanceof SetTransformation)) {
            return false;
        }

        final SetTransformation that = (SetTransformation) obj;

        return new EqualsBuilder()
                .append(this.value, that.value)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(this.value)
                .toHashCode();
    }

    @Override
    public Map<String, Object> perform(final Map<String, Object> input, final PathElement pathElement)
            throws IllegalKeyException {

        if (Objects.isNull(pathElement)) {
            throw new NullPathElementException();
        }

        final Map<String, Object> output = Objects.nonNull(input)
                ? input : new HashMap<>();

        output.put(pathElement.getElement(), this.value);

        return output;
    }

    @Override
    public String toString() {
        final String toString = new ToStringBuilder(this, SHORT_PREFIX_STYLE)
                .append(this.value)
                .toString();
        return toString;
    }

}
