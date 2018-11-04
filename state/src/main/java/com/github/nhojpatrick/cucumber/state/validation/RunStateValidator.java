package com.github.nhojpatrick.cucumber.state.validation;

import com.github.nhojpatrick.cucumber.core.exceptions.IllegalKeyException;
import com.github.nhojpatrick.cucumber.state.RunState;
import com.github.nhojpatrick.cucumber.state.exceptions.NullRunStateException;

public interface RunStateValidator {

    RunStateValidator withNull(String key)
            throws IllegalKeyException;

    RunStateValidator withValue(String key)
            throws IllegalKeyException;

    void verify(RunState runState)
            throws NullRunStateException;

}
