package com.github.nhojpatrick.cucumber.json.transformations.core;

import com.github.nhojpatrick.cucumber.json.core.transform.Transformation;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

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
    @SuppressFBWarnings(value = {"USBR_UNNECESSARY_STORE_BEFORE_RETURN",
            "COM_COPIED_OVERRIDDEN_METHOD"},
            justification = "Useful for debugging")
    public int hashCode() {
        final int hashCode = new HashCodeBuilder(17, 37)
                .toHashCode();
        return hashCode;
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

    @Override
    public boolean isParentPathAutoCreated() {
        return true;
    }

}
