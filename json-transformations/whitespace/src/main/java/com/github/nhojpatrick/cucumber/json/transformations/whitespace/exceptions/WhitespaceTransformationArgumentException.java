package com.github.nhojpatrick.cucumber.json.transformations.whitespace.exceptions;

import com.github.nhojpatrick.cucumber.core.exceptions.CheckedIllegalArgumentException;

public abstract class WhitespaceTransformationArgumentException
        extends CheckedIllegalArgumentException {

    public WhitespaceTransformationArgumentException(final String message) {
        super(message);
    }

}
