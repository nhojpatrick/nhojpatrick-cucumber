package com.github.nhojpatrick.cucumber.http.core.url.impl.tests;

import com.github.nhojpatrick.cucumber.http.core.url.UrlWrapper;
import com.github.nhojpatrick.cucumber.http.core.url.impl.UrlWrapperImpl;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;

public class UrlWrapperImplTest {

    public static final String DEFAULT_HREF = "https://www.google.com";

    @Test
    public void defaultValid() {
        final UrlWrapper cut = new UrlWrapperImpl(DEFAULT_HREF);
        assertThat(cut.getHref(), is(equalTo(DEFAULT_HREF)));
    }

}
