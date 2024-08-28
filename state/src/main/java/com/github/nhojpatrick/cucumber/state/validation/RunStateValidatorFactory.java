package com.github.nhojpatrick.cucumber.state.validation;

import com.github.nhojpatrick.cucumber.state.validation.impl.RunStateValidatorImpl;

import java.util.function.Supplier;

public class RunStateValidatorFactory
        implements Supplier<RunStateValidator> {

    private static final RunStateValidatorFactory FACTORY = new RunStateValidatorFactory();

    public static RunStateValidator getInstance() {
        return FACTORY.get();
    }

    public RunStateValidatorFactory() {
    }

    @Override
    public RunStateValidator get() {
        return new RunStateValidatorImpl();
    }

}
