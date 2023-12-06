package com.github.nhojpatrick.cucumber.http.core.model.impl.tests;

import com.github.nhojpatrick.cucumber.http.core.model.HttpResponse;
import com.github.nhojpatrick.cucumber.http.core.model.impl.HttpResponseImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.function.Executable;

import java.util.HashMap;
import java.util.Optional;
import java.util.stream.Stream;

import static com.github.nhojpatrick.hamcrest.optionals.IsOptional.optionalIsEmpty;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

public class HttpResponseImplTest {

    @TestFactory
    public Stream<DynamicTest> Constructor() {
        return Stream.of(
                dynamicTest("Constructor Empty", () -> {
                    final HttpResponse cut = new HttpResponseImpl(200, "", new HashMap<>(), Optional.empty());
                    assertAll(
                            () -> assertThat(cut.getHeaders(), is(equalTo(new HashMap<>()))),
                            () -> assertThat(cut.getStatusCode(), is(equalTo(200))),
                            () -> assertThat(cut.getStatusMessage(), is(equalTo(""))),
                            () -> assertThat(cut.getBody(), is(optionalIsEmpty()))
                    );
                }),
                dynamicTest("Constructor Nulls", () -> {
                    final HttpResponse cut = new HttpResponseImpl(200, null, null, Optional.empty());
                    assertAll(
                            () -> assertThat(cut.getHeaders(), is(equalTo(new HashMap<>()))),
                            () -> assertThat(cut.getStatusCode(), is(equalTo(200))),
                            () -> assertThat(cut.getStatusMessage(), is(equalTo(null))),
                            () -> assertThat(cut.getBody(), is(optionalIsEmpty()))
                    );
                })
        );
    }

    @TestFactory
    public Stream<DynamicTest> StatusCode() {
        return Stream.of(
                dynamicTest("StatusCode '0'", () -> {
                    final Executable testMethod = () -> new HttpResponseImpl(0, null, null, Optional.empty());
                    final IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, testMethod);
                    final String expectedExceptionMessage = "Invalid StatusCode '0'";
                    assertThat(thrown.getMessage(), is(equalTo(expectedExceptionMessage)));
                }),
                dynamicTest("StatusCode '600'", () -> {
                            final Executable testMethod = () -> new HttpResponseImpl(600, null, null, Optional.empty());
                            final IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, testMethod);
                            final String expectedExceptionMessage = "Invalid StatusCode '600'";
                            assertThat(thrown.getMessage(), is(equalTo(expectedExceptionMessage)));
                        }
                )
        );
    }

}
