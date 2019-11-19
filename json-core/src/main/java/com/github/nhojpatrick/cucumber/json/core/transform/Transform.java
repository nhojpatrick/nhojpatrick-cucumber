package com.github.nhojpatrick.cucumber.json.core.transform;

import com.github.nhojpatrick.cucumber.core.exceptions.IllegalKeyException;
import com.github.nhojpatrick.cucumber.core.exceptions.IllegalOperationException;
import com.github.nhojpatrick.cucumber.json.core.exceptions.InvalidPathException;

import java.util.Map;

public interface Transform {

    Map<String, Object> transform(Map<String, Object> input, String path, Transformation transformation)
            throws IllegalKeyException,
                   IllegalOperationException,
                   InvalidPathException;

}
