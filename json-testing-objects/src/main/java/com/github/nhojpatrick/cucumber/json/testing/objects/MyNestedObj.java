package com.github.nhojpatrick.cucumber.json.testing.objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;

@JsonPropertyOrder({
        "name",
        "labels",
        "bottom",
        "nests"
})
public class MyNestedObj {

    @JsonProperty
    private final String name;

    @JsonProperty
    private List<String> labels;

    @JsonProperty
    private final MyBottomObj bottom;

    @JsonProperty
    private final List<MyListNestedObj> nests;

    public MyNestedObj(final String name,
                       final List<String> labels,
                       final MyBottomObj bottom,
                       final List<MyListNestedObj> nests) {
        this.name = name;
        this.labels = labels;
        this.bottom = bottom;
        this.nests = nests;
    }

}
