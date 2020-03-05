package com.github.nhojpatrick.cucumber.json.transformations.print;

import com.github.nhojpatrick.cucumber.core.exceptions.IllegalKeyException;
import com.github.nhojpatrick.cucumber.json.core.exceptions.IllegalPathOperationException;
import com.github.nhojpatrick.cucumber.json.core.exceptions.NullPathElementException;
import com.github.nhojpatrick.cucumber.json.core.validation.PathElement;
import com.github.nhojpatrick.cucumber.json.transformations.core.BaseTransformation;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.github.nhojpatrick.cucumber.json.core.transform.utils.ListTypeUtil.isTypedList;
import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;
import static org.apache.commons.lang3.builder.ToStringStyle.SHORT_PREFIX_STYLE;

public class PrintTransformation
        extends BaseTransformation {

    private static final Logger LOGGER = LoggerFactory.getLogger(PrintTransformation.class);

    public PrintTransformation() {
        super();
    }

    @Override
    public boolean equals(final Object obj) {

        if (!(obj instanceof PrintTransformation)) {
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
    public Map<String, Object> perform(final PathElement pathElement,
                                       final Map<String, Object> inputRaw,
                                       final String currentPath)
            throws IllegalKeyException,
            IllegalPathOperationException {

        if (isNull(pathElement)) {
            throw new NullPathElementException();
        }

        final Map<String, Object> output = nonNull(inputRaw)
                ? inputRaw
                : new HashMap<>();

        if (!output.containsKey(pathElement.getElement())) {
            throw new IllegalPathOperationException(String.format(
                    "Unable to print path '%s', does not exist.",
                    pathElement.getPath(currentPath, false)
            ));
        }

        if (pathElement.isAttribute()) {

            LOGGER.error("Printing Path '{}' Value '{}'",
                    pathElement.getPath(currentPath),
                    output.get(pathElement.getElement())
            );

        } else {

            Object objRaw = output.get(pathElement.getElement());

            if (!isTypedList(objRaw, Object.class)) {
                throw new IllegalPathOperationException(String.format(
                        "Unable to print path '%s', as is not Array.",
                        pathElement.getPath(currentPath, false)
                ));
            }

            final List<Object> listObj = (List<Object>) objRaw;

            if (pathElement.getArrayIndex() >= listObj.size()) {
                throw new IllegalPathOperationException(String.format(
                        "Unable to print path '%s', beyond index of '%s'.",
                        pathElement.getPath(currentPath),
                        listObj.size() - 1
                ));
            }

            LOGGER.error("Printing Path '{}' Value '{}'",
                    pathElement.getElementRaw(),
                    listObj.get(pathElement.getArrayIndex())
            );
        }

        return output;
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

}
