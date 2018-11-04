package com.github.nhojpatrick.cucumber.core.exceptions;

public class NullObjectException
        extends CheckedIllegalArgumentException {

    public NullObjectException() {
        super("Null object.");
    }

}
