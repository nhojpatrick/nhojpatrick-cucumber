package com.github.nhojpatrick.cucumber.core.exceptions;

public abstract class IllegalKeyException
        extends CheckedIllegalArgumentException {

    public IllegalKeyException(final String message) {
        super(message);
    }

}
