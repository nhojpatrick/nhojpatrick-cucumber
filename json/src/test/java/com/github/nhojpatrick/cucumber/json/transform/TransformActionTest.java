package com.github.nhojpatrick.cucumber.json.transform;

import com.github.nhojpatrick.cucumber.json.exceptions.InvalidTransformActionException;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.function.Executable;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TransformActionTest {

    @TestFactory
    public Collection<DynamicTest> resolveInvalid() {

        return Arrays.asList(

                DynamicTest.dynamicTest("Unknown Action", () -> {
                    final Executable testMethod = () -> TransformAction.resolve("Unknown Action");
                    final InvalidTransformActionException expectedThrown = assertThrows(InvalidTransformActionException.class, testMethod);
                    assertThat(expectedThrown.getMessage(), is(equalTo("Invalid transform action 'Unknown Action'.")));
                })

        );
    }

    @TestFactory
    public Collection<DynamicTest> resolveValid() {

        return Arrays.asList(

                DynamicTest.dynamicTest("Expected case", () -> {
                    final TransformAction actual = TransformAction.resolve("Set");
                    assertThat(actual, is(equalTo(TransformAction.SET)));
                }),

                DynamicTest.dynamicTest("Werid case", () -> {
                    final TransformAction actual = TransformAction.resolve("sEt");
                    assertThat(actual, is(equalTo(TransformAction.SET)));
                })

        );
    }

}
