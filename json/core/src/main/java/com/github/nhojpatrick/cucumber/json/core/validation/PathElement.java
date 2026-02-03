package com.github.nhojpatrick.cucumber.json.core.validation;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;

import static org.apache.commons.lang3.StringUtils.isNotEmpty;

public interface PathElement {

    default String getPath(final String currentPath) {
        return getPath(currentPath, true);
    }

    @SuppressFBWarnings(value = "USBR_UNNECESSARY_STORE_BEFORE_RETURN", justification = "Useful for debugging")
    default String getPath(final String currentPath,
                           final boolean displayArrayIndex) {

        final String thisElement = displayArrayIndex && isArray()
                ? getElementRaw()
                : getElement();

        final StringBuilder sb = new StringBuilder();

        if (isNotEmpty(currentPath)) {
            sb.append(currentPath);
            sb.append('.');
        }

        sb.append(thisElement);

        final String fqp = sb.toString();
        return fqp;
    }

    int getArrayIndex();

    String getElement();

    String getElementRaw();

    boolean isArray();

    boolean isAttribute();

}
