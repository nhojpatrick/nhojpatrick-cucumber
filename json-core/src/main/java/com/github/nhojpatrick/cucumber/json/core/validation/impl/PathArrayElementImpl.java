package com.github.nhojpatrick.cucumber.json.core.validation.impl;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import static org.apache.commons.lang3.builder.ToStringStyle.SHORT_PREFIX_STYLE;

public class PathArrayElementImpl
        extends AbstractPathElement {

    public PathArrayElementImpl(final String elementRaw, final String element, final int arrayIndex) {
        super(elementRaw, element, arrayIndex);
    }

    @Override
    public boolean equals(final Object obj) {

        if (!(obj instanceof PathArrayElementImpl)) {
            return false;
        }

        final PathArrayElementImpl other = (PathArrayElementImpl) obj;

        final EqualsBuilder eb = new EqualsBuilder();
        eb.append(this.elementRaw, other.elementRaw);
        eb.append(this.element, other.element);
        eb.append(this.arrayIndex, other.arrayIndex);
        return eb.isEquals();
    }

    @Override
    public int hashCode() {
        final HashCodeBuilder hcb = new HashCodeBuilder(17, 37);
        hcb.append(this.elementRaw);
        hcb.append(this.element);
        hcb.append(this.arrayIndex);
        return hcb.toHashCode();
    }

    @Override
    public String toString() {
        final String toString = new ToStringBuilder(this, SHORT_PREFIX_STYLE)
                .append(this.element)
                .append(this.arrayIndex)
                .toString();
        return toString;
    }

}
