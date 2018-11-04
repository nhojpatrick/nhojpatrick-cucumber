package com.github.nhojpatrick.cucumber.json.exceptions;

import com.github.nhojpatrick.cucumber.core.exceptions.IllegalKeyException;

public class NullPathElementException
        extends IllegalKeyException {

    public NullPathElementException() {
        super("Null Path Element.");
    }

}
