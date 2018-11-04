package com.github.nhojpatrick.cucumber.json.exceptions;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.function.Executable;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class InvalidTransformActionExceptionTest {

    @TestFactory
    public Collection<DynamicTest> exceptions() {

        return Arrays.asList(

                DynamicTest.dynamicTest("action", () -> {
                    final Executable testMethod = () -> {
                        throw new InvalidTransformActionException("Action");
                    };
                    final InvalidTransformActionException expectedThrown = assertThrows(InvalidTransformActionException.class, testMethod);
                    assertThat(expectedThrown.getMessage(), is(equalTo(String.format(InvalidTransformActionException.INVALID_TRANSFORM_ACTION_MSG, "Action"))));
                })

        );
    }

}
