package com.github.nhojpatrick.cucumber.core.exceptions.tests;

import com.github.nhojpatrick.cucumber.core.exceptions.IllegalKeyException;
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

public class IllegalKeyExceptionTest {

    class TestingIllegalKeyException
            extends IllegalKeyException {

        public TestingIllegalKeyException(final String message) {
            super(message);
        }

    }

    @TestFactory
    public Collection<DynamicTest> exceptions() {

        return Arrays.asList(

                dynamicTest("message", () -> {
                    final Executable testMethod = () -> {
                        throw new TestingIllegalKeyException("message");
                    };
                    final IllegalKeyException thrown = assertThrows(IllegalKeyException.class, testMethod);
                    assertAll("Checking Exception",
                            () -> assertThat(thrown.getMessage(), is(equalTo("message"))),
                            () -> assertThat(thrown.getCause(), is(nullValue()))
                    );
                })

        );
    }

}
