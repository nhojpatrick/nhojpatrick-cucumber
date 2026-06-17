package com.github.nhojpatrick.cucumber.http.request.steps;

import com.github.nhojpatrick.cucumber.core.exceptions.CheckedIllegalArgumentException;
import com.github.nhojpatrick.cucumber.http.core.model.HttpResponse;
import com.github.nhojpatrick.cucumber.http.core.url.UrlWrapper;
import com.github.nhojpatrick.cucumber.http.core.url.impl.UrlWrapperImpl;
import com.github.nhojpatrick.cucumber.http.request.HttpPutRequest;
import com.github.nhojpatrick.cucumber.state.RunState;
import com.github.nhojpatrick.cucumber.state.validation.RunStateValidatorFactory;
import com.google.inject.Inject;
import io.cucumber.java.en.Given;

import static com.github.nhojpatrick.cucumber.http.constants.HttpConstants.HTTP_REQUEST_BODY;
import static com.github.nhojpatrick.cucumber.http.constants.HttpConstants.HTTP_RESPONSE_BODY;

public class HttpPutRequestSteps
        extends AbstractHttpRequestSteps {

    @Inject
    public HttpPutRequestSteps(final RunState runState) {
        super(runState);
    }

    @Given("http put to uri {string}")
    public void httpPutToUri(final String uri)
            throws CheckedIllegalArgumentException {

        RunStateValidatorFactory.getInstance()
                .withValue(HTTP_REQUEST_BODY)
                .verify(this.runState);

        final UrlWrapper urlWrapper = new UrlWrapperImpl(uri);

        final HttpResponse httpResponse = new HttpPutRequest()
                .put(urlWrapper, this.runState);

        this.runState.set(HTTP_RESPONSE_BODY, httpResponse);
    }

    @Given("http put to url {string}")
    public void httpPutToUrl(final String url)
            throws CheckedIllegalArgumentException {

        RunStateValidatorFactory.getInstance()
                .withValue(HTTP_REQUEST_BODY)
                .verify(this.runState);

        final UrlWrapper urlWrapper = new UrlWrapperImpl(url);

        final HttpResponse httpResponse = new HttpPutRequest()
                .put(urlWrapper, this.runState);

        this.runState.set(HTTP_RESPONSE_BODY, httpResponse);
    }

}
