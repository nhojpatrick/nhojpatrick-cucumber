package com.github.nhojpatrick.cucumber.json.transformations.remove;

import com.github.nhojpatrick.cucumber.core.exceptions.IllegalKeyException;
import com.github.nhojpatrick.cucumber.json.core.exceptions.NullPathElementException;
import com.github.nhojpatrick.cucumber.json.core.validation.PathElement;
import com.github.nhojpatrick.cucumber.json.transformations.core.BaseTransformation;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.ArrayList;
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
    public Map<String, Object> perform(final PathElement pathElement,
                                       final Map<String, Object> inputRaw,
                                       final String currentPath)
            throws IllegalKeyException {

        if (isNull(pathElement)) {
            throw new NullPathElementException();
        }

        final Map<String, Object> output = nonNull(inputRaw)
                ? inputRaw
                : new HashMap<>();

        if (!output.containsKey(pathElement.getElement())) {
            return output;
        }

        if (pathElement.isNotArrayElement()) {
            output.remove(pathElement.getElement());

        } else {

            Object objRaw = output.get(pathElement.getElement());

            objRaw = nonNull(objRaw)
                    ? objRaw
                    : new ArrayList<Map<String, Object>>();

            if (!isTypedList(objRaw, Object.class)) {
                throw new UnsupportedOperationException(
                        "RemoveTransformation PathElement not typed List and Path isArrayElement"
                );
            }

            final List<Object> listObj = (List<Object>) objRaw;

            if (pathElement.getArrayIndex() < listObj.size()) {
                listObj.remove(pathElement.getArrayIndex());

            } else {
                final int size = listObj.size();
                final int arrayIndex = pathElement.getArrayIndex();

                for (int i = size; i < arrayIndex; i++) {
                    listObj.add(null);
                }
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
