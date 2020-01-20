package com.github.nhojpatrick.cucumber.json.transformations.set;

import com.github.nhojpatrick.cucumber.core.exceptions.IllegalKeyException;
import com.github.nhojpatrick.cucumber.json.core.exceptions.IllegalPathOperationException;
import com.github.nhojpatrick.cucumber.json.core.exceptions.NullPathElementException;
import com.github.nhojpatrick.cucumber.json.core.validation.PathElement;
import com.github.nhojpatrick.cucumber.json.transformations.core.BaseTransformation;
import org.apache.commons.lang3.builder.EqualsBuilder;
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

public class SetTransformation
        extends BaseTransformation {

    private final Object value;

    public SetTransformation(final Object value) {
        super();

        this.value = value;
    }

    @Override
    public boolean equals(final Object obj) {

        if (!(obj instanceof SetTransformation)) {
            return false;
        }

        final SetTransformation that = (SetTransformation) obj;

        return new EqualsBuilder()
                .append(this.value, that.value)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(this.value)
                .toHashCode();
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
            output.put(pathElement.getElement(), this.value);

        } else {

            Object objRaw = output.get(pathElement.getElement());

            objRaw = nonNull(objRaw)
                    ? objRaw
                    : new ArrayList<>();

            if (!isTypedList(objRaw, Object.class)) {
                throw new IllegalPathOperationException(String.format(
                        "Unable to set path '%s', as is not Array.",
                        pathElement.getPath(currentPath, false)
                ));
            }

            final List<Object> listObj = (List<Object>) objRaw;

            if (pathElement.getArrayIndex() < listObj.size()) {
                listObj.set(pathElement.getArrayIndex(), this.value);

            } else {
                final int size = listObj.size();
                final int arrayIndex = pathElement.getArrayIndex();

                for (int i = size; i < arrayIndex; i++) {
                    listObj.add(null);
                }

                listObj.add(pathElement.getArrayIndex(), this.value);
            }

            output.put(pathElement.getElement(), listObj);
        }

        return output;
    }

    @Override
    public String toString() {
        final String toString = new ToStringBuilder(this, SHORT_PREFIX_STYLE)
                .append(this.value)
                .toString();
        return toString;
    }

}
