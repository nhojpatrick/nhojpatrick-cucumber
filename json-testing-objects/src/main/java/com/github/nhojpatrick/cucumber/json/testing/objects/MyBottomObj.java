package com.github.nhojpatrick.cucumber.json.testing.objects;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MyBottomObj {

    @JsonProperty
    private final String alpha;

    public MyBottomObj(final String alpha) {
        this.alpha = alpha;
    }

}
