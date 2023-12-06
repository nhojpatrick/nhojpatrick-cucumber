package com.github.nhojpatrick.cucumber.http.core.url.impl;

import com.github.nhojpatrick.cucumber.http.core.url.UrlWrapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.Objects.isNull;

public class UrlWrapperImpl
        implements UrlWrapper {

    private boolean followRedirects = false;
    private final Map<String, String> headers;
    private final String href;
    private List<String> queryParam;

    public UrlWrapperImpl(final String href) {
        this(href, true, null, null);
    }

    public UrlWrapperImpl(final String href,
                          final boolean followRedirects,
                          final Map<String, String> headers,
                          final List<String> queryParam) {
        this.followRedirects = followRedirects;
        this.href = href;
        this.headers = isNull(headers) ? new HashMap<>() : new HashMap<>(headers);
        this.queryParam = isNull(queryParam) ? new ArrayList<>() : new ArrayList<>(queryParam);
    }

    @Override
    public void addQueryParam(final String queryParam) {
        this.queryParam.add(queryParam);
    }

    @Override
    public void addQueryParam(final String queryParamName, final String queryParamValue) {
        final String queryParam = String.format("%s=%s", queryParamName, queryParamValue);
        this.queryParam.add(queryParam);
    }

    @Override
    public void addHeader(final String headerName,
                          final String headerValue) {
        this.headers.put(headerName, headerValue);
    }

    @Override
    public boolean isFollowRedirects() {
        return this.followRedirects;
    }

    @Override
    public String getHref() {
        return this.href;
    }

    @Override
    public Map<String, String> getHeaders() {
        return new HashMap<>(this.headers);
    }

    @Override
    public List<String> getQueryParams() {
        return new ArrayList<>(this.queryParam);
    }

}
