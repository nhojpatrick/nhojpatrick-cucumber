package com.github.nhojpatrick.cucumber.json.core.validation.impl;

import com.github.nhojpatrick.cucumber.json.core.validation.PathArrayElement;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import static org.apache.commons.lang3.builder.ToStringStyle.SHORT_PREFIX_STYLE;

public class PathArrayElementImpl
        extends AbstractPathElement
        implements PathArrayElement {

    public PathArrayElementImpl(final String elementRaw,
                                final String element,
                                final int arrayIndex) {
        super(elementRaw, element, arrayIndex);
    }

    @Override
    @SuppressFBWarnings(value = "USBR_UNNECESSARY_STORE_BEFORE_RETURN", justification = "Useful for debugging")
    public boolean equals(final Object obj) {

        if (!(obj instanceof PathArrayElementImpl)) {
            return false;
        }

        final PathArrayElementImpl other = (PathArrayElementImpl) obj;

        final boolean equal = new EqualsBuilder()
                .append(this.elementRaw, other.elementRaw)
                .append(this.element, other.element)
                .append(this.arrayIndex, other.arrayIndex)
                .isEquals();
        return equal;
    }

    @Override
    @SuppressFBWarnings(value = "USBR_UNNECESSARY_STORE_BEFORE_RETURN", justification = "Useful for debugging")
    public int hashCode() {
        final int hashCode = new HashCodeBuilder(17, 37)
                .append(this.elementRaw)
                .append(this.element)
                .append(this.arrayIndex)
                .toHashCode();
        return hashCode;
    }

    @Override
    @SuppressFBWarnings(value = "USBR_UNNECESSARY_STORE_BEFORE_RETURN", justification = "Useful for debugging")
    public String toString() {
        final String toString = new ToStringBuilder(this, SHORT_PREFIX_STYLE)
                .append(this.element)
                .append(this.arrayIndex)
                .toString();
        return toString;
    }

}
