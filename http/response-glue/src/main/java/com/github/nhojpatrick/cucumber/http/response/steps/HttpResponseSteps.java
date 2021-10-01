package com.github.nhojpatrick.cucumber.http.response.steps;

import com.github.nhojpatrick.cucumber.core.exceptions.IllegalKeyException;
import com.github.nhojpatrick.cucumber.core.exceptions.IllegalTypeClassException;
import com.github.nhojpatrick.cucumber.core.exceptions.TypeMismatchException;
import com.github.nhojpatrick.cucumber.http.core.model.HttpResponse;
import com.github.nhojpatrick.cucumber.state.RunState;
import com.github.nhojpatrick.cucumber.state.exceptions.NullRunStateException;
import com.github.nhojpatrick.cucumber.state.validation.RunStateValidatorFactory;
import com.google.inject.Inject;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import io.cucumber.java.en.Given;

import static com.github.nhojpatrick.cucumber.http.constants.HttpConstants.HTTP_RESPONSE_BODY;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;

public class HttpResponseSteps {

    @SuppressFBWarnings(value = "EI_EXPOSE_REP2", justification = "Accepted will look at changing")
    private final RunState runState;

    @Inject
    public HttpResponseSteps(final RunState runState) {
        this.runState = runState;
    }

    @Given("http response status code of {int}")
    public void httpResponseStatusCode(final int expectedStatusCode)
            throws IllegalKeyException,
            IllegalTypeClassException,
            NullRunStateException,
            TypeMismatchException {

        RunStateValidatorFactory.getInstance()
                .withValue(HTTP_RESPONSE_BODY)
                .verify(this.runState);

        final HttpResponse httpResponse = this.runState.get(HTTP_RESPONSE_BODY, HttpResponse.class);
        final int actualStatusCode = httpResponse.getStatusCode();

        assertThat("Unexpected http status code", actualStatusCode, is(equalTo(expectedStatusCode)));
    }

}
