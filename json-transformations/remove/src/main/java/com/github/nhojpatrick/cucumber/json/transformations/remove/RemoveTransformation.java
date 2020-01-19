package com.github.nhojpatrick.cucumber.json.transformations.remove;

import com.github.nhojpatrick.cucumber.core.exceptions.IllegalKeyException;
import com.github.nhojpatrick.cucumber.json.core.exceptions.IllegalPathOperationException;
import com.github.nhojpatrick.cucumber.json.core.exceptions.NullPathElementException;
import com.github.nhojpatrick.cucumber.json.core.validation.PathElement;
import com.github.nhojpatrick.cucumber.json.transformations.core.BaseTransformation;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.github.nhojpatrick.cucumber.json.core.transform.utils.ListTypeUtil.isTypedList;
import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;
import static org.apache.commons.lang3.builder.ToStringStyle.SHORT_PREFIX_STYLE;

public class RemoveTransformation
        extends BaseTransformation {

    public RemoveTransformation() {
        super();
    }

    @Override
    public boolean equals(final Object obj) {

        if (!(obj instanceof RemoveTransformation)) {
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
    public boolean isParentPathAutoCreated() {
        return false;
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

        if (pathElement.isAttribute()) {

            if (!output.containsKey(pathElement.getElement())) {
                throw new IllegalPathOperationException(String.format(
                        "Path does not exist at '%s'.",
                        pathElement.getPath(currentPath)
                ));
            }

            output.remove(pathElement.getElement());

        } else {

            if (!output.containsKey(pathElement.getElement())) {
                throw new IllegalPathOperationException(String.format(
                        "Path does not exist at '%s'.",
                        pathElement.getPath(currentPath, false)
                ));
            }

            if (isNull(output.get(pathElement.getElement()))) {
                throw new IllegalPathOperationException(String.format(
                        "Unable to remove 'null' value, at path '%s'.",
                        pathElement.getPath(currentPath, false)
                ));
            }

            final Object objRaw = output.get(pathElement.getElement());

            if (!isTypedList(objRaw, Object.class)) {
                throw new IllegalPathOperationException(String.format(
                        "Unable to remove path '%s', as is not Array.",
                        pathElement.getPath(currentPath, false)
                ));
            }

            final List<Object> listObj = (List<Object>) objRaw;

            if (pathElement.getArrayIndex() < listObj.size()) {
                listObj.remove(pathElement.getArrayIndex());

            } else if (listObj.isEmpty()) {
                throw new IllegalPathOperationException(String.format(
                        "Unable to remove path '%s', as array is empty.",
                        pathElement.getPath(currentPath, false)
                ));

            } else {
                throw new IllegalPathOperationException(String.format(
                        "Unable to remove path '%s', beyond index of '%s'.",
                        pathElement.getPath(currentPath),
                        listObj.size() - 1
                ));
            }

            output.put(pathElement.getElement(), listObj);
        }

        return output;
    }

    @Override
    public String toString() {
        final String toString = new ToStringBuilder(this, SHORT_PREFIX_STYLE)
                .toString();
        return toString;
    }

}
