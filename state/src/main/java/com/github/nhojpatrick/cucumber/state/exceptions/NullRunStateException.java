package com.github.nhojpatrick.cucumber.state.exceptions;

import com.github.nhojpatrick.cucumber.core.exceptions.CheckedIllegalArgumentException;

public class NullRunStateException
        extends CheckedIllegalArgumentException {

    public NullRunStateException() {
        super("Null Run State.");
    }

}
