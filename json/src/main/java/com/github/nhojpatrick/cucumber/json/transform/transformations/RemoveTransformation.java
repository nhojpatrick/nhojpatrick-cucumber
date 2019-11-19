package com.github.nhojpatrick.cucumber.json.transform.transformations;

import com.github.nhojpatrick.cucumber.core.exceptions.IllegalKeyException;
import com.github.nhojpatrick.cucumber.json.core.exceptions.NullPathElementException;
import com.github.nhojpatrick.cucumber.json.core.transform.Transformation;
import com.github.nhojpatrick.cucumber.json.core.validation.PathElement;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import static com.github.nhojpatrick.cucumber.json.core.transform.utils.ListTypeUtil.isTypedList;
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
    public Map<String, Object> perform(final Map<String, Object> input, final PathElement pathElement)
            throws IllegalKeyException {

        if (Objects.isNull(pathElement)) {
            throw new NullPathElementException();
        }

        final Map<String, Object> output = Objects.nonNull(input)
                ? input : new HashMap<>();

        if (output.containsKey(pathElement.getElement())) {

            if (!pathElement.isArrayElement()) {
                output.remove(pathElement.getElement());

            } else {

                final Object objRaw = output.get(pathElement.getElement());

                if (pathElement.isArrayElement()) {
                    if (isTypedList(objRaw, Map.class)) {

                        final List<Map> listMap = (List<Map>) objRaw;

                        if (pathElement.getArrayIndex() < listMap.size()) {
                            listMap.remove(pathElement.getArrayIndex());
                            output.put(pathElement.getElement(), listMap);
                        }

                    } else if (isTypedList(objRaw, Object.class)) {

                        final List<Object> listObj = (List<Object>) objRaw;

                        if (pathElement.getArrayIndex() < listObj.size()) {
                            listObj.remove(pathElement.getArrayIndex());
                            output.put(pathElement.getElement(), listObj);
                        }
                    }
                }
            }
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
