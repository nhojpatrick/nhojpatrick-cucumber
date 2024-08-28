package com.github.nhojpatrick.cucumber.json.core.validation.impl;

import com.github.nhojpatrick.cucumber.json.core.validation.PathAttributeElement;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import static org.apache.commons.lang3.builder.ToStringStyle.SHORT_PREFIX_STYLE;

public class PathAttributeElementImpl
        extends AbstractPathElement
        implements PathAttributeElement {

    public PathAttributeElementImpl(final String element) {
        super(element, element, null);
    }

    @Override
    @SuppressFBWarnings(value = "USBR_UNNECESSARY_STORE_BEFORE_RETURN", justification = "Useful for debugging")
    public boolean equals(final Object obj) {

        if (!(obj instanceof PathAttributeElementImpl)) {
            return false;
        }

        final PathAttributeElementImpl other = (PathAttributeElementImpl) obj;

        final boolean equal = new EqualsBuilder()
                .append(this.element, other.element)
                .isEquals();
        return equal;
    }

    @Override
    @SuppressFBWarnings(value = "USBR_UNNECESSARY_STORE_BEFORE_RETURN", justification = "Useful for debugging")
    public int hashCode() {
        final int hashCode = new HashCodeBuilder(17, 37)
                .append(this.element)
                .toHashCode();
        return hashCode;
    }

    @Override
    @SuppressFBWarnings(value = "USBR_UNNECESSARY_STORE_BEFORE_RETURN", justification = "Useful for debugging")
    public String toString() {
        final String toString = new ToStringBuilder(this, SHORT_PREFIX_STYLE)
                .append(this.element)
                .toString();
        return toString;
    }

}
