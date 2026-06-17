package com.github.nhojpatrick.cucumber.http.core.url;

import java.util.List;
import java.util.Map;

public interface UrlWrapper {

    void addQueryParam(final String queryParam);

    void addQueryParam(final String queryParamName, final String queryParamValue);

    void addHeader(String headerName,
                   String headerValue);

    boolean isFollowRedirects();

    String getHref();

    Map<String, String> getHeaders();

    List<String> getQueryParams();

}
