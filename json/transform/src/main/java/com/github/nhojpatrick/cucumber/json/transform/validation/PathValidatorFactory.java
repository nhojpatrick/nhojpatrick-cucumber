package com.github.nhojpatrick.cucumber.json.transform.validation;

import com.github.nhojpatrick.cucumber.json.core.validation.PathValidator;
import com.github.nhojpatrick.cucumber.json.core.validation.impl.PathValidatorImpl;

import java.util.function.Supplier;

public class PathValidatorFactory
        implements Supplier<PathValidator> {

    private static final PathValidatorFactory FACTORY = new PathValidatorFactory();

    public static synchronized PathValidatorFactory getFactory() {
        return FACTORY;
    }

    private PathValidatorFactory() {
    }

    @Override
    public PathValidator get() {
        return new PathValidatorImpl();
    }

}
