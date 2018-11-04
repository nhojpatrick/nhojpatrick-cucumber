package com.github.nhojpatrick.cucumber.json.testing;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MyListNestedBottomObj {

    @JsonProperty
    private final String charlie;

    public MyListNestedBottomObj(final String charlie) {
        this.charlie = charlie;
    }

}
