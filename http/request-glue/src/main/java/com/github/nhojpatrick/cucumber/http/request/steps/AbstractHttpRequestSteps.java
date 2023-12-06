package com.github.nhojpatrick.cucumber.http.request.steps;

import com.github.nhojpatrick.cucumber.state.RunState;
import com.google.inject.Inject;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;

public abstract class AbstractHttpRequestSteps {

    @SuppressFBWarnings(value = "EI_EXPOSE_REP2", justification = "Accepted will look at changing")
    protected final RunState runState;

    @Inject
    public AbstractHttpRequestSteps(final RunState runState) {
        this.runState = runState;
    }

}
