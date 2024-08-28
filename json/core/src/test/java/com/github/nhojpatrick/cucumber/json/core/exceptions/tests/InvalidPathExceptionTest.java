package com.github.nhojpatrick.cucumber.json.core.exceptions.tests;

import com.github.nhojpatrick.cucumber.json.core.exceptions.InvalidPathException;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.function.Executable;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

public class InvalidPathExceptionTest {

    @TestFactory
    public Collection<DynamicTest> exceptions() {

        return Arrays.asList(

                dynamicTest("message", () -> {
                    final Executable testMethod = () -> {
                        throw new InvalidPathException("message");
                    };
                    final InvalidPathException thrown = assertThrows(InvalidPathException.class, testMethod);
                    assertAll(
                            () -> assertThat(thrown.getMessage(), is(equalTo("message"))),
                            () -> assertThat(thrown.getCause(), is(nullValue()))
                    );
                }),

                dynamicTest("format", () -> {
                    final Executable testMethod = () -> {
                        throw new InvalidPathException("%s", "message");
                    };
                    final InvalidPathException thrown = assertThrows(InvalidPathException.class, testMethod);
                    assertAll(
                            () -> assertThat(thrown.getMessage(), is(equalTo("message"))),
                            () -> assertThat(thrown.getCause(), is(nullValue()))
                    );
                })

        );
    }

}
