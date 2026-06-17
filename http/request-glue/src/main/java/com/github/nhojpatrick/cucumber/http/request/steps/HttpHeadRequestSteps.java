package com.github.nhojpatrick.cucumber.http.request.steps;

import com.github.nhojpatrick.cucumber.core.exceptions.CheckedIllegalArgumentException;
import com.github.nhojpatrick.cucumber.http.core.model.HttpResponse;
import com.github.nhojpatrick.cucumber.http.core.url.UrlWrapper;
import com.github.nhojpatrick.cucumber.http.core.url.impl.UrlWrapperImpl;
import com.github.nhojpatrick.cucumber.http.request.HttpHeadRequest;
import com.github.nhojpatrick.cucumber.state.RunState;
import com.google.inject.Inject;
import io.cucumber.java.en.Given;

import static com.github.nhojpatrick.cucumber.http.constants.HttpConstants.HTTP_RESPONSE_BODY;

public class HttpHeadRequestSteps
        extends AbstractHttpRequestSteps {

    @Inject
    public HttpHeadRequestSteps(final RunState runState) {
        super(runState);
    }

    @Given("http head to uri {string}")
    public void httpHeadToUri(final String uri)
            throws CheckedIllegalArgumentException {

        final UrlWrapper urlWrapper = new UrlWrapperImpl(uri);

        final HttpResponse httpResponse = new HttpHeadRequest()
                .head(urlWrapper, this.runState);

        this.runState.set(HTTP_RESPONSE_BODY, httpResponse);
    }

    @Given("http head to url {string}")
    public void httpHeadToUrl(final String url)
            throws CheckedIllegalArgumentException {

        final UrlWrapper urlWrapper = new UrlWrapperImpl(url);

        final HttpResponse httpResponse = new HttpHeadRequest()
                .head(urlWrapper, this.runState);

        this.runState.set(HTTP_RESPONSE_BODY, httpResponse);
    }

}
