package com.github.nhojpatrick.cucumber.http.request.steps;

import com.github.nhojpatrick.cucumber.state.RunState;
import com.google.inject.Inject;

public class HttpOptionsRequestSteps {

    private final RunState runState;

    @Inject
    public HttpOptionsRequestSteps(final RunState runState) {
        this.runState = runState;
    }

}
