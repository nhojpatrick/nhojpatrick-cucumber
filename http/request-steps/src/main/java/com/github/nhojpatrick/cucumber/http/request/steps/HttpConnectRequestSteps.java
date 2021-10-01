package com.github.nhojpatrick.cucumber.http.request.steps;

import com.github.nhojpatrick.cucumber.state.RunState;
import com.google.inject.Inject;

public class HttpConnectRequestSteps {

    private final RunState runState;

    @Inject
    public HttpConnectRequestSteps(final RunState runState) {
        this.runState = runState;
    }

}
