package com.github.nhojpatrick.cucumber.json.validation;

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
