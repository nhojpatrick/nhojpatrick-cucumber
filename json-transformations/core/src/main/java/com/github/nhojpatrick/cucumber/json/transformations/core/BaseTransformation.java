package com.github.nhojpatrick.cucumber.json.transformations.core;

import com.github.nhojpatrick.cucumber.json.core.exceptions.NullPathElementException;
import com.github.nhojpatrick.cucumber.json.core.transform.Transformation;
import com.github.nhojpatrick.cucumber.json.core.validation.PathElement;
import com.google.common.annotations.VisibleForTesting;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import static java.util.Objects.isNull;
import static org.apache.commons.lang3.builder.ToStringStyle.SHORT_PREFIX_STYLE;

public abstract class BaseTransformation
        implements Transformation {

    public BaseTransformation() {
    }

    @Override
    public boolean equals(final Object obj) {

        if (!(obj instanceof BaseTransformation)) {
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
    public String toString() {
        final String toString = new ToStringBuilder(this, SHORT_PREFIX_STYLE)
                .toString();
        return toString;
    }

    @VisibleForTesting
    protected void requireNonNullPath(final PathElement pathElement)
            throws NullPathElementException {

        if (isNull(pathElement)) {
            throw new NullPathElementException();
        }
    }

    @VisibleForTesting
    protected String getPath(final String currentPath,
                             final PathElement pathElement)
            throws NullPathElementException {

        requireNonNullPath(pathElement);

        final String element = pathElement.isAttribute()
                ? pathElement.getElement()
                : pathElement.getElementRaw();

        String path;
        if (isNull(currentPath)) {
            path = element;

        } else if ("".equals(currentPath)) {
            path = element;

        } else {
            path = currentPath + "." + element;
        }

        return path;
    }

}
