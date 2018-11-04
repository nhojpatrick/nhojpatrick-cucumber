package com.github.nhojpatrick.cucumber.core.exceptions.tests;

import com.github.nhojpatrick.cucumber.core.exceptions.CheckedUnsupportedOperationException;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.function.Executable;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CheckedUnsupportedOperationExceptionTest {

    class TestingCheckedUnsupportedOperationException
            extends CheckedUnsupportedOperationException {

        public TestingCheckedUnsupportedOperationException(final String message) {
            super(message);
        }

        public TestingCheckedUnsupportedOperationException(final String message, final Throwable cause) {
            super(message, cause);
        }

    }

    @TestFactory
    public Collection<DynamicTest> exceptions() {

        return Arrays.asList(

                DynamicTest.dynamicTest("message", () -> {
                    final Executable testMethod = () -> {
                        throw new TestingCheckedUnsupportedOperationException("message");
                    };
                    final CheckedUnsupportedOperationException expectedThrown = assertThrows(CheckedUnsupportedOperationException.class, testMethod);
                    assertThat(expectedThrown.getMessage(), is(equalTo("message")));
                }),

                DynamicTest.dynamicTest("message, cause", () -> {
                    final Executable testMethod = () -> {
                        throw new TestingCheckedUnsupportedOperationException("message", new RuntimeException());
                    };
                    final CheckedUnsupportedOperationException expectedThrown = assertThrows(CheckedUnsupportedOperationException.class, testMethod);
                    assertAll("Checking Exception",
                            () -> assertThat(expectedThrown.getMessage(), is(equalTo("message"))),
                            () -> assertThat(expectedThrown.getCause(), is(instanceOf(RuntimeException.class)))
                    );
                })

        );
    }

}
