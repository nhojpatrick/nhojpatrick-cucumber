package com.github.nhojpatrick.cucumber.core.exceptions;

public abstract class IllegalTypeClassException
        extends CheckedIllegalArgumentException {

    public IllegalTypeClassException(final String message) {
        super(message);
    }

}
