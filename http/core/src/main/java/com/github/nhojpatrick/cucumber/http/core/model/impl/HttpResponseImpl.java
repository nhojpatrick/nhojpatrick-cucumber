package com.github.nhojpatrick.cucumber.http.core.model.impl;

import com.github.nhojpatrick.cucumber.http.core.model.HttpResponse;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static java.util.Objects.isNull;

public class HttpResponseImpl
        implements HttpResponse {

    private final Optional<byte[]> body;
    private final Map<String, String> headers;
    private final int statusCode;
    private final String statusMessage;

    public HttpResponseImpl(final int statusCode,
                            final String statusMessage,
                            final Map<String, String> headers,
                            final Optional<byte[]> body) {

        if (statusCode < 100
                || statusCode >= 600) {
            throw new IllegalArgumentException(String.format("Invalid StatusCode '%s'", statusCode));
        }

        this.headers = isNull(headers) ? new HashMap<>() : new HashMap<>(headers);
        this.statusCode = statusCode;
        this.statusMessage = statusMessage;
        this.body = body;
    }

    @Override
    public Optional<byte[]> getBody() {
        return this.body;
    }

    @Override
    public final Map<String, String> getHeaders() {
        return new HashMap<>(this.headers);
    }

    @Override
    public int getStatusCode() {
        return this.statusCode;
    }

    @Override
    public String getStatusMessage() {
        return this.statusMessage;
    }

}
