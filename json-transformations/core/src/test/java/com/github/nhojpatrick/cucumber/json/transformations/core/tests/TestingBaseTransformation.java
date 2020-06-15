package com.github.nhojpatrick.cucumber.json.transformations.core.tests;

import com.github.nhojpatrick.cucumber.json.core.validation.PathElement;
import com.github.nhojpatrick.cucumber.json.transformations.core.BaseTransformation;

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
