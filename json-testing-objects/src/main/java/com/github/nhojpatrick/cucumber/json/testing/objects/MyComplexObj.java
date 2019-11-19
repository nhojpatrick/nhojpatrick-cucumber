package com.github.nhojpatrick.cucumber.json.testing.objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;

@JsonPropertyOrder({
        "title",
        "active",
        "count",
        "tags",
        "nested",
        "objs"
})
public class MyComplexObj {

    @JsonProperty
    private final String title;

    @JsonProperty
    private final boolean active;

    @JsonProperty
    private final int count;

    @JsonProperty
    private List<String> tags;

    @JsonProperty
    private final MyNestedObj nested;

    @JsonProperty
    private final List<MyListComplexObj> objs;

    public MyComplexObj(final String title,
                        final boolean active,
                        final int count,
                        final List<String> tags,
                        final MyNestedObj nested,
                        final List<MyListComplexObj> objs) {
        this.title = title;
        this.active = active;
        this.count = count;
        this.tags = tags;
        this.nested = nested;
        this.objs = objs;
    }

}
