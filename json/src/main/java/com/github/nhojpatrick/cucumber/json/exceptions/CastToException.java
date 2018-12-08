package com.github.nhojpatrick.cucumber.json.exceptions;

import com.github.nhojpatrick.cucumber.core.exceptions.CheckedIllegalArgumentException;

public abstract class CastToException
        extends CheckedIllegalArgumentException {

    public CastToException(final String message) {
        super(message);
    }

    public CastToException(final String message, final Throwable cause) {
        super(message, cause);
    }

}
