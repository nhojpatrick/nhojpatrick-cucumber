package com.github.nhojpatrick.cucumber.json.testing;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MySimpleObj {

    @JsonProperty
    private final String simpleName;

    public MySimpleObj(final String simpleName) {
        this.simpleName = simpleName;
    }

}
