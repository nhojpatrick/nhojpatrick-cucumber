package com.github.nhojpatrick.cucumber.state.validation;

import com.github.nhojpatrick.cucumber.state.validation.internal.RunStateValidatorImpl;

import java.util.function.Supplier;

public class RunStateValidatorFactory
        implements Supplier<RunStateValidator> {

    public static RunStateValidator getInstance() {
        final RunStateValidatorFactory factory = new RunStateValidatorFactory();
        final RunStateValidator validator = factory.get();
        return validator;
    }

    public RunStateValidatorFactory() {
    }

    @Override
    public RunStateValidator get() {
        final RunStateValidator validator = new RunStateValidatorImpl();
        return validator;
    }

}
