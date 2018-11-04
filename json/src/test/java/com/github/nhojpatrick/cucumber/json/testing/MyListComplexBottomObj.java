package com.github.nhojpatrick.cucumber.json.testing;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MyListComplexBottomObj {

    @JsonProperty
    private final String bravo;

    public MyListComplexBottomObj(final String bravo) {
        this.bravo = bravo;
    }

}
