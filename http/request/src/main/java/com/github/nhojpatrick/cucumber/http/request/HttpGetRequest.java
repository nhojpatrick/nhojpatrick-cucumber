package com.github.nhojpatrick.cucumber.http.request;

import com.github.nhojpatrick.cucumber.http.core.model.HttpResponse;
import com.github.nhojpatrick.cucumber.http.core.url.UrlWrapper;
import com.github.nhojpatrick.cucumber.state.RunState;

public class HttpGetRequest
        extends AbstractHttpRequest {

    public HttpResponse get(final UrlWrapper urlWrapper,
                            final RunState runState) {
        throw new UnsupportedOperationException("To Be Implemented");
    }

}
