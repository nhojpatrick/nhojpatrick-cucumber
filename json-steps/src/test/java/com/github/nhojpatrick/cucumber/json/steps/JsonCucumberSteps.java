package com.github.nhojpatrick.cucumber.json.steps;

import com.github.nhojpatrick.cucumber.state.RunState;
import com.google.inject.Inject;

public class JsonCucumberSteps {

    private RunState runState;

    @Inject
    public JsonCucumberSteps(final RunState runState) {
        this.runState = runState;
    }

}
