package com.github.nhojpatrick.cucumber.json.transformations.core;

import com.github.nhojpatrick.cucumber.json.core.validation.PathElement;

import java.util.Map;

public class TestingBaseTransformation
        extends BaseTransformation {

    @Override
    public Map<String, Object> perform(final PathElement pathElement,
                                       final Map<String, Object> input,
                                       final String currentPath) {

        return input;
    }

}
