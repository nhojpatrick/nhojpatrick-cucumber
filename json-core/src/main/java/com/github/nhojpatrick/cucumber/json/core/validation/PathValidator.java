package com.github.nhojpatrick.cucumber.json.core.validation;

import com.github.nhojpatrick.cucumber.json.core.exceptions.InvalidPathException;

import java.util.List;

public interface PathValidator {

    List<PathElement> parsePath(String path)
            throws InvalidPathException;

}
