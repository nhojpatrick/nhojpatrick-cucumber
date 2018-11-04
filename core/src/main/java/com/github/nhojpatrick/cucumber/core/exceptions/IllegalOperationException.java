package com.github.nhojpatrick.cucumber.core.exceptions;

public abstract class IllegalOperationException
        extends CheckedUnsupportedOperationException {

    public IllegalOperationException(final String message) {
        super(message);
    }

}
