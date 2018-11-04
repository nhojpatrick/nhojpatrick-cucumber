package com.github.nhojpatrick.cucumber.json.exceptions;

import com.github.nhojpatrick.cucumber.core.exceptions.CheckedIllegalArgumentException;

public class InvalidPathException
        extends CheckedIllegalArgumentException {

    public InvalidPathException(final String message) {
        super(message);
    }

    public InvalidPathException(final String format, final Object... vars) {
        this(String.format(format, vars));
    }

}
