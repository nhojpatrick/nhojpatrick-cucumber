package com.github.nhojpatrick.cucumber.json.transform.validation;

import com.github.nhojpatrick.cucumber.json.core.validation.PathValidator;
import com.github.nhojpatrick.cucumber.json.core.validation.impl.PathValidatorImpl;

import java.util.function.Supplier;

public class PathValidatorFactory
        implements Supplier<PathValidator> {

    public static PathValidator getInstance() {
        final PathValidatorFactory factory = new PathValidatorFactory();
        final PathValidator validator = factory.get();
        return validator;
    }

    public PathValidatorFactory() {
    }

    public PathValidator get() {
        final PathValidator validator = new PathValidatorImpl();
        return validator;
    }

}
