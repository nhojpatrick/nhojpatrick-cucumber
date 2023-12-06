package com.github.nhojpatrick.cucumber.http.constants.tests;

import org.junit.jupiter.api.Test;

import static com.github.nhojpatrick.cucumber.http.constants.HttpConstants.HTTP_REQUEST_BODY;
import static com.github.nhojpatrick.cucumber.http.constants.HttpConstants.HTTP_RESPONSE_BODY;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.jupiter.api.Assertions.assertAll;

public class HttpConstantsTest {

    @Test
    public void httpConstants() {

        assertAll("Http Constants",
                () -> assertThat(HTTP_REQUEST_BODY, is(equalTo("Http.Request.Body"))),
                () -> assertThat(HTTP_RESPONSE_BODY, is(equalTo("Http.Response.Body")))
        );
    }

}
