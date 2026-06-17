package com.github.nhojpatrick.cucumber.http.core.model;

import java.util.Map;
import java.util.Optional;

public interface HttpResponse {

    Optional<byte[]> getBody();

    Map<String, String> getHeaders();

    int getStatusCode();

    String getStatusMessage();

}
