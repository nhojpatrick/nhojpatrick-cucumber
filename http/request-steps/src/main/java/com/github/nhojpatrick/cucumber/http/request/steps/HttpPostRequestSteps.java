package com.github.nhojpatrick.cucumber.http.request.steps;

import com.github.nhojpatrick.cucumber.state.RunState;
import com.google.inject.Inject;

public class HttpPostRequestSteps {

    private final RunState runState;

    @Inject
    public HttpPostRequestSteps(final RunState runState) {
        this.runState = runState;
    }

}
