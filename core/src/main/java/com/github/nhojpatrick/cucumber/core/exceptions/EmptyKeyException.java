package com.github.nhojpatrick.cucumber.core.exceptions;

public class EmptyKeyException
        extends IllegalKeyException {

    public EmptyKeyException() {
        super("Empty String Key.");
    }

}
