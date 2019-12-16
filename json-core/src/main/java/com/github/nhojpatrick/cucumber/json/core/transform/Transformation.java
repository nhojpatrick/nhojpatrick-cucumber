package com.github.nhojpatrick.cucumber.json.core.transform;

import com.github.nhojpatrick.cucumber.core.exceptions.IllegalKeyException;
import com.github.nhojpatrick.cucumber.json.core.exceptions.IllegalPathOperationException;
import com.github.nhojpatrick.cucumber.json.core.validation.PathElement;

import java.util.Map;

@FunctionalInterface
public interface Transformation {

    Map<String, Object> perform(Map<String, Object> input, PathElement pathElement, String currentPath)
            throws IllegalKeyException,
            IllegalPathOperationException;

}
