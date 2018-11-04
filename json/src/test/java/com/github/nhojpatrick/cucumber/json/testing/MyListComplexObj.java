package com.github.nhojpatrick.cucumber.json.testing;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({
        "lcName",
        "lcId",
        "lcBottom"
})
public class MyListComplexObj {

    @JsonProperty
    private final String lcName;

    @JsonProperty
    private final int lcId;

    @JsonProperty
    private final MyListComplexBottomObj lcBottom;

    public MyListComplexObj(final String lcName,
                            final int lcId,
                            final MyListComplexBottomObj lcBottom) {
        this.lcName = lcName;
        this.lcId = lcId;
        this.lcBottom = lcBottom;
    }

}
