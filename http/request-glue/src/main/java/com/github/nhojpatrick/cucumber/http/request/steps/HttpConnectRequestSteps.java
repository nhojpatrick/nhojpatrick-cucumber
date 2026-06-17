package com.github.nhojpatrick.cucumber.http.request.steps;

import com.github.nhojpatrick.cucumber.core.exceptions.CheckedIllegalArgumentException;
import com.github.nhojpatrick.cucumber.http.core.model.HttpResponse;
import com.github.nhojpatrick.cucumber.http.core.url.UrlWrapper;
import com.github.nhojpatrick.cucumber.http.core.url.impl.UrlWrapperImpl;
import com.github.nhojpatrick.cucumber.http.request.HttpConnectRequest;
import com.github.nhojpatrick.cucumber.state.RunState;
import com.google.inject.Inject;
import io.cucumber.java.en.Given;

import static com.github.nhojpatrick.cucumber.http.constants.HttpConstants.HTTP_RESPONSE_BODY;

public class HttpConnectRequestSteps
        extends AbstractHttpRequestSteps {

    @Inject
    public HttpConnectRequestSteps(final RunState runState) {
        super(runState);
    }

    @Given("http connect to uri {string}")
    public void httpConnectToUri(final String uri)
            throws CheckedIllegalArgumentException {

        final UrlWrapper urlWrapper = new UrlWrapperImpl(uri);

        final HttpResponse httpResponse = new HttpConnectRequest()
                .connect(urlWrapper, this.runState);

        this.runState.set(HTTP_RESPONSE_BODY, httpResponse);
    }

    @Given("http connect to url {string}")
    public void httpConnectToUrl(final String url)
            throws CheckedIllegalArgumentException {

        final UrlWrapper urlWrapper = new UrlWrapperImpl(url);

        final HttpResponse httpResponse = new HttpConnectRequest()
                .connect(urlWrapper, this.runState);

        this.runState.set(HTTP_RESPONSE_BODY, httpResponse);
    }

}
