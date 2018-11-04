package com.github.nhojpatrick.cucumber.core.exceptions;

public abstract class CheckedUnsupportedOperationException
        extends Exception {

    public CheckedUnsupportedOperationException(final String message) {
        super(message);
    }

    public CheckedUnsupportedOperationException(final String message, final Throwable cause) {
        super(message, cause);
    }

}
