package com.github.nhojpatrick.cucumber.core.exceptions.tests;

import com.github.nhojpatrick.cucumber.core.exceptions.IllegalOperationException;
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

public class IllegalOperationExceptionTest {

    class TestingIllegalOperationException
            extends IllegalOperationException {

        public TestingIllegalOperationException(final String message) {
            super(message);
        }

    }

    @TestFactory
    public Collection<DynamicTest> exceptions() {

        return Arrays.asList(

                DynamicTest.dynamicTest("message", () -> {
                    final Executable testMethod = () -> {
                        throw new TestingIllegalOperationException("message");
                    };
                    final IllegalOperationException expectedThrown = assertThrows(IllegalOperationException.class, testMethod);
                    assertAll("Checking Exception",
                            () -> assertThat(expectedThrown.getMessage(), is(equalTo("message"))),
                            () -> assertThat(expectedThrown.getCause(), is(nullValue()))
                    );
                })

        );
    }

}
