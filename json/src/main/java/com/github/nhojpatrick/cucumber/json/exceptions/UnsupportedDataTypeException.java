package com.github.nhojpatrick.cucumber.json.exceptions;

import com.github.nhojpatrick.cucumber.core.exceptions.CheckedIllegalArgumentException;

public class UnsupportedDataTypeException
        extends CheckedIllegalArgumentException {

    public static final String UNSUPPORTED_DATA_TYPE_MSG = "Unsupported data type '%s'.";

    public UnsupportedDataTypeException(final String type) {
        super(String.format(UNSUPPORTED_DATA_TYPE_MSG, type));
    }

}
