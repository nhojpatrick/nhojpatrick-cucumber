package com.github.nhojpatrick.cucumber.http.request.steps;

import com.github.nhojpatrick.cucumber.state.RunState;
import com.google.inject.Inject;

public class HttpPutRequestSteps {

    private final RunState runState;

    @Inject
    public HttpPutRequestSteps(final RunState runState) {
        this.runState = runState;
    }

}
