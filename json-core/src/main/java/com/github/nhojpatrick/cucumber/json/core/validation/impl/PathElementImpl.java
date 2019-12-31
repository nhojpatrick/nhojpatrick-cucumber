package com.github.nhojpatrick.cucumber.json.core.validation.impl;

import com.github.nhojpatrick.cucumber.json.core.validation.PathElement;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import static org.apache.commons.lang3.builder.ToStringStyle.SHORT_PREFIX_STYLE;

public class PathElementImpl
        extends AbstractPathElement
        implements PathElement {

    public PathElementImpl(final String element) {
        super(element, element, null);
    }

    @Override
    public boolean equals(final Object obj) {

        if (!(obj instanceof PathElementImpl)) {
            return false;
        }

        final PathElementImpl other = (PathElementImpl) obj;

        final EqualsBuilder eb = new EqualsBuilder();
        eb.append(this.element, other.element);
        return eb.isEquals();
    }

    @Override
    public int hashCode() {
        final HashCodeBuilder hcb = new HashCodeBuilder(17, 37);
        hcb.append(this.element);
        return hcb.toHashCode();
    }

    @Override
    public String toString() {
        final String toString = new ToStringBuilder(this, SHORT_PREFIX_STYLE)
                .append(this.element)
                .toString();
        return toString;
    }

}
