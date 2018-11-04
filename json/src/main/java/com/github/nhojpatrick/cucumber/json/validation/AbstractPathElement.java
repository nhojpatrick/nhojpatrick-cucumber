package com.github.nhojpatrick.cucumber.json.validation;

public abstract class AbstractPathElement
        implements PathElement {

    protected final String element;
    protected final String elementRaw;
    protected final Integer arrayIndex;

    public AbstractPathElement(final String elementRaw, final String element, final Integer arrayIndex) {
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
    public boolean isArrayElement() {
        return this.arrayIndex != null;
    }

}
