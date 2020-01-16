package com.github.nhojpatrick.cucumber.json.core.transform;

import com.github.nhojpatrick.cucumber.core.exceptions.IllegalKeyException;
import com.github.nhojpatrick.cucumber.json.core.exceptions.IllegalPathOperationException;
import com.github.nhojpatrick.cucumber.json.core.validation.PathElement;

import java.util.Map;

public interface Transformation {

    boolean isParentPathAutoCreated();

    Map<String, Object> perform(PathElement pathElement,
                                Map<String, Object> input,
                                String currentPath)
            throws IllegalKeyException,
            IllegalPathOperationException;

}
