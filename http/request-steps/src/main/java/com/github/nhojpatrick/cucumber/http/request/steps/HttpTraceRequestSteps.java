package com.github.nhojpatrick.cucumber.http.request.steps;

import com.github.nhojpatrick.cucumber.state.RunState;
import com.google.inject.Inject;

public class HttpTraceRequestSteps {

    private final RunState runState;

    @Inject
    public HttpTraceRequestSteps(final RunState runState) {
        this.runState = runState;
    }

}
