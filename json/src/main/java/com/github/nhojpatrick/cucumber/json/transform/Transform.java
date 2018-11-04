package com.github.nhojpatrick.cucumber.json.transform;

import com.github.nhojpatrick.cucumber.core.exceptions.IllegalKeyException;
import com.github.nhojpatrick.cucumber.core.exceptions.IllegalOperationException;
import com.github.nhojpatrick.cucumber.json.exceptions.InvalidPathException;
import com.github.nhojpatrick.cucumber.json.transform.transformations.Transformation;

import java.util.Map;

public interface Transform {

    Map<String, Object> transform(Map<String, Object> input, String path, Transformation transformation)
            throws IllegalKeyException,
                   IllegalOperationException,
                   InvalidPathException;

}
