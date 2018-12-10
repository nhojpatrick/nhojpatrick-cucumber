package com.github.nhojpatrick.cucumber.json.exceptions;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.function.Executable;

import java.util.Arrays;
import java.util.Collection;

import static com.github.nhojpatrick.hamcrest.lang.IsThrowable.throwable;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CastToExceptionTest {

    class TestingCastToException
            extends CastToException {

        public TestingCastToException(final String message) {
            super(message);
        }

        public TestingCastToException(final String message, final Throwable cause) {
            super(message, cause);
        }

    }

    @TestFactory
    public Collection<DynamicTest> exceptions() {

        return Arrays.asList(

                DynamicTest.dynamicTest("message", () -> {
                    final Executable testMethod = () -> {
                        throw new TestingCastToException("message");
                    };
                    final CastToException expectedThrown = assertThrows(CastToException.class, testMethod);
                    assertAll(
                            () -> assertThat(expectedThrown.getMessage(), is(equalTo("message"))),
                            () -> assertThat(expectedThrown.getCause(), is(nullValue()))
                    );
                }),

                DynamicTest.dynamicTest("message & cause", () -> {
                    final Executable testMethod = () -> {
                        throw new TestingCastToException("message", new RuntimeException());
                    };
                    final CastToException expectedThrown = assertThrows(CastToException.class, testMethod);
                    assertAll(
                            () -> assertThat(expectedThrown.getMessage(), is(equalTo("message"))),
                            () -> assertThat(expectedThrown.getCause(), is(throwable(RuntimeException.class)))
                    );
                })

        );
    }

}
