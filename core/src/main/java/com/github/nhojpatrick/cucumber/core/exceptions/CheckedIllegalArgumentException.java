package com.github.nhojpatrick.cucumber.core.exceptions;

public abstract class CheckedIllegalArgumentException
        extends Exception {

    public CheckedIllegalArgumentException(final String message) {
        super(message);
    }

    public CheckedIllegalArgumentException(final String message, final Throwable cause) {
        super(message, cause);
    }

}
