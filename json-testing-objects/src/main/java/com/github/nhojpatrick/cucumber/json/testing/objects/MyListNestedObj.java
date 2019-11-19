package com.github.nhojpatrick.cucumber.json.testing.objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({
        "lnName",
        "lnId",
        "lnBottom"
})
public class MyListNestedObj {

    @JsonProperty
    private final String lnName;

    @JsonProperty
    private final int lnId;

    @JsonProperty
    private final MyListNestedBottomObj lnBottom;

    public MyListNestedObj(final String lnName,
                           final int lnId,
                           final MyListNestedBottomObj lnBottom) {
        this.lnName = lnName;
        this.lnId = lnId;
        this.lnBottom = lnBottom;
    }

}
