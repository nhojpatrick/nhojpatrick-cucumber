package com.github.nhojpatrick.cucumber.core.exceptions.tests;

import com.github.nhojpatrick.cucumber.core.exceptions.CheckedIllegalArgumentException;
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
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

public class CheckedIllegalArgumentExceptionTest {

    class TestingCheckedIllegalArgumentException
            extends CheckedIllegalArgumentException {

        public TestingCheckedIllegalArgumentException(final String message) {
            super(message);
        }

        public TestingCheckedIllegalArgumentException(final String message, final Throwable cause) {
            super(message, cause);
        }

    }

    @TestFactory
    public Collection<DynamicTest> exceptions() {

        return Arrays.asList(

                dynamicTest("message", () -> {
                    final Executable testMethod = () -> {
                        throw new TestingCheckedIllegalArgumentException("message");
                    };
                    final CheckedIllegalArgumentException thrown = assertThrows(CheckedIllegalArgumentException.class, testMethod);
                    assertAll("Checking Exception",
                            () -> assertThat(thrown.getMessage(), is(equalTo("message"))),
                            () -> assertThat(thrown.getCause(), is(nullValue()))
                    );
                }),

                dynamicTest("message, cause", () -> {
                    final Executable testMethod = () -> {
                        throw new TestingCheckedIllegalArgumentException("message", new RuntimeException());
                    };
                    final CheckedIllegalArgumentException thrown = assertThrows(CheckedIllegalArgumentException.class, testMethod);
                    assertAll("Checking Exception",
                            () -> assertThat(thrown.getMessage(), is(equalTo("message"))),
                            () -> assertThat(thrown.getCause(), is(throwable(RuntimeException.class)))
                    );
                })

        );
    }

}
