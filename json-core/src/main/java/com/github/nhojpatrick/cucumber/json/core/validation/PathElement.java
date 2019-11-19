package com.github.nhojpatrick.cucumber.json.core.validation;

public interface PathElement {

    int getArrayIndex();

    String getElement();

    String getElementRaw();

    boolean isArrayElement();

}
