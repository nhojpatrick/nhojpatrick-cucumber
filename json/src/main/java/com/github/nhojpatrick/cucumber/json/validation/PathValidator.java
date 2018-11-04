package com.github.nhojpatrick.cucumber.json.validation;

import com.github.nhojpatrick.cucumber.json.exceptions.InvalidPathException;

import java.util.List;

public interface PathValidator {

    List<PathElement> parsePath(String path)
            throws InvalidPathException;

}
