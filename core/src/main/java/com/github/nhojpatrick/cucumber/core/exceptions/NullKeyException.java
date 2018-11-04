package com.github.nhojpatrick.cucumber.core.exceptions;

public class NullKeyException
        extends IllegalKeyException {

    public NullKeyException() {
        super("Null Key.");
    }

}
