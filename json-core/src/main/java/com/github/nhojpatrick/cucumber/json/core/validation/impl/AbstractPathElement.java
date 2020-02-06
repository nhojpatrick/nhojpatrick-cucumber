package com.github.nhojpatrick.cucumber.json.core.validation.impl;

import com.github.nhojpatrick.cucumber.json.core.validation.PathElement;

import static java.util.Objects.isNull;

public abstract class AbstractPathElement
        implements PathElement {

    protected final String element;
    protected final String elementRaw;
    protected final Integer arrayIndex;

    public AbstractPathElement(final String elementRaw,
                               final String element,
                               final Integer arrayIndex) {
        this.elementRaw = elementRaw;
        this.element = element;
        this.arrayIndex = arrayIndex;
    }

    @Override
    public int getArrayIndex() {
        return this.arrayIndex;
    }

    @Override
    public String getElement() {
        return this.element;
    }

    @Override
    public String getElementRaw() {
        return this.elementRaw;
    }

    @Override
    public boolean isArray() {
        return !isAttribute();
    }

    @Override
    public boolean isAttribute() {
        return isNull(this.arrayIndex);
    }

}
