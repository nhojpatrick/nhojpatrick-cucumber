package com.github.nhojpatrick.cucumber.json.exceptions;

import com.github.nhojpatrick.cucumber.core.exceptions.CheckedIllegalArgumentException;

public class InvalidTransformActionException
        extends CheckedIllegalArgumentException {

    public static final String INVALID_TRANSFORM_ACTION_MSG = "Invalid transform action '%s'.";

    public InvalidTransformActionException(final String action) {
        super(String.format(INVALID_TRANSFORM_ACTION_MSG, String.valueOf(action)));
    }

}
