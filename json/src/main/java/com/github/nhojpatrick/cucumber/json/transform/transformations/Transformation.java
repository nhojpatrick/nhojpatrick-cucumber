package com.github.nhojpatrick.cucumber.json.transform.transformations;

import com.github.nhojpatrick.cucumber.core.exceptions.IllegalKeyException;
import com.github.nhojpatrick.cucumber.json.exceptions.IllegalPathOperationException;
import com.github.nhojpatrick.cucumber.json.validation.PathElement;

import java.util.Map;

@FunctionalInterface
public interface Transformation {

    Map<String, Object> perform(Map<String, Object> input, PathElement pathElement)
            throws IllegalKeyException,
            IllegalPathOperationException;

}
