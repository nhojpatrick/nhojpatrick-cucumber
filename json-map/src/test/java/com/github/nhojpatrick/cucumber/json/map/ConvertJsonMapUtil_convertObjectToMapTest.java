package com.github.nhojpatrick.cucumber.json.map;

import com.github.nhojpatrick.cucumber.core.exceptions.IllegalKeyException;
import com.github.nhojpatrick.cucumber.core.exceptions.IllegalTypeClassException;
import com.github.nhojpatrick.cucumber.core.exceptions.TypeMismatchException;
import com.github.nhojpatrick.cucumber.json.map.impl.ConvertObjectToMap;
import com.github.nhojpatrick.cucumber.state.RunState;
import com.github.nhojpatrick.cucumber.state.exceptions.NullRunStateException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.function.Executable;
import org.opentest4j.MultipleFailuresError;

import java.util.Arrays;
import java.util.Collection;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ConvertJsonMapUtil_convertObjectToMapTest {

    public static final String INPUT_KEY = "Valid_RunStateObjectKey";
    public static final String OUTPUT_KEY = "Valid_RunStateJsonMapKey";

    @TestFactory
    @DisplayName("convertObjectToMap validation")
    public Collection<DynamicTest> validation() {

        return Arrays.asList(

                DynamicTest.dynamicTest("Null RunState", () -> {
                    final ConvertJsonMapUtil classUnderTest = new ConvertJsonMapUtil();
                    final Executable testMethod = () -> classUnderTest.convertObjectToMap(
                            null,
                            null,
                            null
                    );

                    final NullPointerException thrown = assertThrows(NullPointerException.class, testMethod);
                    assertAll("Checking Exception",
                            () -> assertThat(thrown.getMessage(), is(equalTo("RunState"))),
                            () -> assertThat(thrown.getCause(), is(nullValue()))
                    );
                }),

                DynamicTest.dynamicTest("Null Input_Key", () -> {
                    final RunState runState = new RunState();

                    final ConvertJsonMapUtil classUnderTest = new ConvertJsonMapUtil();
                    final Executable testMethod = () -> classUnderTest.convertObjectToMap(
                            runState,
                            null,
                            null
                    );

                    final NullPointerException thrown = assertThrows(NullPointerException.class, testMethod);
                    assertAll("Checking Exception",
                            () -> assertThat(thrown.getMessage(), is(equalTo("RunStateObjectKey"))),
                            () -> assertThat(thrown.getCause(), is(nullValue()))
                    );
                }),

                DynamicTest.dynamicTest("Null Output_Key", () -> {
                    final RunState runState = new RunState();

                    final ConvertJsonMapUtil classUnderTest = new ConvertJsonMapUtil();
                    final Executable testMethod = () -> classUnderTest.convertObjectToMap(
                            runState,
                            INPUT_KEY,
                            null
                    );

                    final NullPointerException thrown = assertThrows(NullPointerException.class, testMethod);
                    assertAll("Checking Exception",
                            () -> assertThat(thrown.getMessage(), is(equalTo("RunStateJsonMapKey"))),
                            () -> assertThat(thrown.getCause(), is(nullValue()))
                    );
                })

        );

    }

    @TestFactory
    @DisplayName("convertObjectToMap RunState validation")
    public Collection<DynamicTest> runStateValidation() {

        return Arrays.asList(

                DynamicTest.dynamicTest("Empty RunState", () -> {
                    final RunState runState = new RunState();

                    final ConvertJsonMapUtil classUnderTest = new ConvertJsonMapUtil();
                    final Executable testMethod = () -> classUnderTest.convertObjectToMap(
                            runState,
                            INPUT_KEY,
                            OUTPUT_KEY
                    );

                    final MultipleFailuresError thrown = assertThrows(MultipleFailuresError.class, testMethod);
                    assertAll("Checking Exception",
                            () -> assertThat(thrown.getMessage(), is(equalTo(String.format("%s\n\t%s\n%s\n%s",
                                    "Run State Validation (1 failure)",
                                    "java.lang.AssertionError: Keys where value was expected to be non null",
                                    "Expected: is java.util.Collection size <0>",
                                    String.format("     but: was java.util.Collection size <1> <[%s]>", INPUT_KEY)
                            )))),
                            () -> assertThat(thrown.getCause(), is(nullValue()))
                    );
                }),

                DynamicTest.dynamicTest("Missing Input, Invalid Output in RunState", () -> {
                    final RunState runState = new RunState();
                    runState.set(OUTPUT_KEY, new Object());

                    final ConvertJsonMapUtil classUnderTest = new ConvertJsonMapUtil();
                    final Executable testMethod = () -> classUnderTest.convertObjectToMap(
                            runState,
                            INPUT_KEY,
                            OUTPUT_KEY
                    );

                    final MultipleFailuresError thrown = assertThrows(MultipleFailuresError.class, testMethod);
                    assertAll("Checking Exception",
                            () -> assertThat(thrown.getMessage(), is(equalTo(String.format("%s\n\t%s\n%s\n%s\n\t%s\n%s\n%s",
                                    "Run State Validation (2 failures)",
                                    "java.lang.AssertionError: Keys where value was expected to be null",
                                    "Expected: is java.util.Collection size <0>",
                                    String.format("     but: was java.util.Collection size <1> <[%s]>", OUTPUT_KEY),
                                    "java.lang.AssertionError: Keys where value was expected to be non null",
                                    "Expected: is java.util.Collection size <0>",
                                    String.format("     but: was java.util.Collection size <1> <[%s]>", INPUT_KEY)
                            )))),
                            () -> assertThat(thrown.getCause(), is(nullValue()))
                    );

                }),

                DynamicTest.dynamicTest("Valid Input, Invalid Output in RunState", () -> {
                    final RunState runState = new RunState();
                    runState.set(INPUT_KEY, "aValidKey");
                    runState.set(OUTPUT_KEY, "Should not be in RunState");

                    final ConvertJsonMapUtil classUnderTest = new ConvertJsonMapUtil();
                    final Executable testMethod = () -> classUnderTest.convertObjectToMap(
                            runState,
                            INPUT_KEY,
                            OUTPUT_KEY
                    );

                    final MultipleFailuresError thrown = assertThrows(MultipleFailuresError.class, testMethod);
                    assertAll("Checking Exception",
                            () -> assertThat(thrown.getMessage(), is(equalTo(String.format("%s\n\t%s\n%s\n%s",
                                    "Run State Validation (1 failure)",
                                    "java.lang.AssertionError: Keys where value was expected to be null",
                                    "Expected: is java.util.Collection size <0>",
                                    String.format("     but: was java.util.Collection size <1> <[%s]>", OUTPUT_KEY)
                            )))),
                            () -> assertThat(thrown.getCause(), is(nullValue()))
                    );
                })

        );

    }

    @Test
    public void success()
            throws IllegalKeyException,
            IllegalTypeClassException,
            NullRunStateException,
            TypeMismatchException {

        final Object mockInput = mock(Object.class);

        final Map<String, Object> mockOutput = mock(Map.class);

        final ConvertObjectToMap mockConvertObjectToMap = mock(ConvertObjectToMap.class);
        when(mockConvertObjectToMap.apply(any()))
                .thenReturn(mockOutput);

        final RunState mockRunState = mock(RunState.class);
        when(mockRunState.get(eq(INPUT_KEY), any()))
                .thenReturn(mockInput);
        when(mockRunState.isSet(eq(INPUT_KEY)))
                .thenReturn(true);
        when(mockRunState.isUnset(eq(OUTPUT_KEY)))
                .thenReturn(true);

        new ConvertJsonMapUtil(mockConvertObjectToMap)
                .convertObjectToMap(
                        mockRunState,
                        INPUT_KEY,
                        OUTPUT_KEY
                );

        assertAll("",
                () -> verify(mockConvertObjectToMap, times(1))
                        .apply(eq(mockInput)),
                () -> verify(mockRunState, times(1))
                        .set(eq(OUTPUT_KEY), eq(mockOutput))
        );
    }

}
