package com.github.nhojpatrick.cucumber.state.validation;

import com.github.nhojpatrick.cucumber.core.exceptions.NullKeyException;
import com.github.nhojpatrick.cucumber.state.RunState;
import com.github.nhojpatrick.cucumber.state.exceptions.NullRunStateException;
import com.github.nhojpatrick.cucumber.state.validation.internal.RunStateValidatorImpl;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.function.Executable;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class RunStateValidatorImplTest {

    @TestFactory
    public Collection<DynamicTest> exceptions() {

        return Arrays.asList(

                DynamicTest.dynamicTest("null withNull", () -> {
                    final RunStateValidator runStateValidator = new RunStateValidatorImpl();

                    final Executable testMethod = () -> runStateValidator.withNull(null);
                    final NullKeyException expectedThrown = assertThrows(NullKeyException.class, testMethod);
                    assertThat(expectedThrown.getMessage(), is(equalTo("Null Key.")));
                }),

                DynamicTest.dynamicTest("null withValue", () -> {
                    final RunStateValidator runStateValidator = new RunStateValidatorImpl();

                    final Executable testMethod = () -> runStateValidator.withValue(null);
                    final NullKeyException expectedThrown = assertThrows(NullKeyException.class, testMethod);
                    assertThat(expectedThrown.getMessage(), is(equalTo("Null Key.")));
                }),

                DynamicTest.dynamicTest("null run state", () -> {
                    final RunState runState = mock(RunState.class);
                    when(runState.isSet("withNullKey"))
                            .thenReturn(true);

                    final RunStateValidator runStateValidator = new RunStateValidatorImpl()
                            .withNull("withNullKey");

                    final Executable testMethod = () -> runStateValidator.verify(null);
                    final NullRunStateException expectedThrown = assertThrows(NullRunStateException.class, testMethod);
                    assertThat(expectedThrown.getMessage(), is(equalTo("Null Run State.")));
                }),

                DynamicTest.dynamicTest("invalid withNull", () -> {
                    final RunState runState = mock(RunState.class);
                    when(runState.isSet("withNullKey"))
                            .thenReturn(true);

                    final RunStateValidator runStateValidator = new RunStateValidatorImpl()
                            .withNull("withNullKey");

                    final Executable testMethod = () -> runStateValidator.verify(runState);
                    final AssertionError expectedThrown = assertThrows(AssertionError.class, testMethod);
                    assertThat(expectedThrown.getMessage(), is(equalTo("Run State Validation (1 failure)\n\tKeys where value was expected to be null\nExpected: is java.util.Collection size <0>\n     but: was java.util.Collection size <1> <[withNullKey]>")));
                }),

                DynamicTest.dynamicTest("invalid withValue", () -> {
                    final RunState runState = mock(RunState.class);
                    when(runState.isUnset("withValueKey"))
                            .thenReturn(true);

                    final RunStateValidator runStateValidator = new RunStateValidatorImpl()
                            .withValue("withValueKey");

                    final Executable testMethod = () -> runStateValidator.verify(runState);
                    final AssertionError expectedThrown = assertThrows(AssertionError.class, testMethod);
                    assertThat(expectedThrown.getMessage(), is(equalTo("Run State Validation (1 failure)\n\tKeys where value was expected to be non null\nExpected: is java.util.Collection size <0>\n     but: was java.util.Collection size <1> <[withValueKey]>")));
                }),

                DynamicTest.dynamicTest("invalid withNull and withValue", () -> {
                    final RunState runState = mock(RunState.class);
                    when(runState.isSet("withNullKey"))
                            .thenReturn(true);
                    when(runState.isUnset("withValueKey"))
                            .thenReturn(true);

                    final RunStateValidator runStateValidator = new RunStateValidatorImpl()
                            .withNull("withNullKey")
                            .withValue("withValueKey");

                    final Executable testMethod = () -> runStateValidator.verify(runState);
                    final AssertionError expectedThrown = assertThrows(AssertionError.class, testMethod);
                    assertThat(expectedThrown.getMessage(), is(equalTo("Run State Validation (2 failures)\n\tKeys where value was expected to be null\nExpected: is java.util.Collection size <0>\n     but: was java.util.Collection size <1> <[withNullKey]>\n\tKeys where value was expected to be non null\nExpected: is java.util.Collection size <0>\n     but: was java.util.Collection size <1> <[withValueKey]>")));
                })

        );
    }

    @TestFactory
    public Collection<DynamicTest> success() {

        return Arrays.asList(

                DynamicTest.dynamicTest("IllegalKeyException withNull", () -> {
                    final RunState runState = mock(RunState.class);
                    when(runState.isSet("withNullKey"))
                            .thenThrow(new NullKeyException());

                    final RunStateValidator runStateValidator = new RunStateValidatorImpl()
                            .withNull("withNullKey");

                    runStateValidator.verify(runState);
                }),

                DynamicTest.dynamicTest("IllegalKeyException withValue", () -> {
                    final RunState runState = mock(RunState.class);
                    when(runState.isUnset("withValueKey"))
                            .thenThrow(new NullKeyException());

                    final RunStateValidator runStateValidator = new RunStateValidatorImpl()
                            .withValue("withValueKey");

                    runStateValidator.verify(runState);
                }),

                DynamicTest.dynamicTest("valid withNull", () -> {
                    final RunState runState = mock(RunState.class);
                    when(runState.isUnset("withNullKey"))
                            .thenReturn(true);

                    final RunStateValidator runStateValidator = new RunStateValidatorImpl()
                            .withNull("withNullKey");

                    runStateValidator.verify(runState);
                }),

                DynamicTest.dynamicTest("valid withValue", () -> {
                    final RunState runState = mock(RunState.class);
                    when(runState.isSet("withNullKey"))
                            .thenReturn(true);

                    final RunStateValidator runStateValidator = new RunStateValidatorImpl()
                            .withValue("withValueKey");

                    runStateValidator.verify(runState);
                }),

                DynamicTest.dynamicTest("valid withNull and withValue", () -> {
                    final RunState runState = mock(RunState.class);
                    when(runState.isUnset("withNullKey"))
                            .thenReturn(true);
                    when(runState.isSet("withValueKey"))
                            .thenReturn(true);

                    final RunStateValidator runStateValidator = new RunStateValidatorImpl()
                            .withNull("withNullKey")
                            .withValue("withValueKey");

                    runStateValidator.verify(runState);
                })

        );
    }

}
