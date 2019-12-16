package com.github.nhojpatrick.cucumber.json.transformations.remove;

import com.github.nhojpatrick.cucumber.core.exceptions.IllegalKeyException;
import com.github.nhojpatrick.cucumber.json.core.exceptions.NullPathElementException;
import com.github.nhojpatrick.cucumber.json.core.transform.Transformation;
import com.github.nhojpatrick.cucumber.json.core.validation.PathElement;
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
        implements Transformation {

    public RemoveTransformation() {
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
    public Map<String, Object> perform(Map<String, Object> input,
                                       final PathElement pathElement,
                                       final String currentPath)
            throws IllegalKeyException {

        if (isNull(pathElement)) {
            throw new NullPathElementException();
        }

        if (isNull(input)) {
            input = new HashMap<>();
        }

//        if (!input.containsKey(pathElement.getElement())) {
//            return input;
//        }

        if (!pathElement.isArrayElement()) {
            input.remove(pathElement.getElement());

        } else {

            Object objRaw = input.get(pathElement.getElement());

            objRaw = nonNull(objRaw)
                    ? objRaw
                    : new ArrayList<Map<String, Object>>();

            if (isTypedList(objRaw, Object.class)) {

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

                input.put(pathElement.getElement(), listObj);

            } else {
                throw new UnsupportedOperationException(
                        "RemoveTransformation PathElement not typed List and Path isArrayElement"
                );
            }
        }

        return input;
    }

    @Override
    public String toString() {
        final String toString = new ToStringBuilder(this, SHORT_PREFIX_STYLE)
                .toString();
        return toString;
    }

}
