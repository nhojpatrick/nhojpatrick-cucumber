package com.github.nhojpatrick.cucumber.json.map;

import com.github.nhojpatrick.cucumber.core.exceptions.IllegalKeyException;
import com.github.nhojpatrick.cucumber.core.exceptions.IllegalTypeClassException;
import com.github.nhojpatrick.cucumber.core.exceptions.TypeMismatchException;
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

public class ConvertToMapUtilTest {

    @TestFactory
    @DisplayName("Exceptions from Inputs")
    public Collection<DynamicTest> exceptionsInputs() {

        return Arrays.asList(

                DynamicTest.dynamicTest("Null ConvertToMap", () -> {
                    final Executable testMethod = () -> new ConvertToMapUtil(null);
                    final NullPointerException thrown = assertThrows(NullPointerException.class, testMethod);
                    assertAll("Checking Exception",
                            () -> assertThat(thrown.getMessage(), is(equalTo("ConvertToMap"))),
                            () -> assertThat(thrown.getCause(), is(nullValue()))
                    );
                }),

                DynamicTest.dynamicTest("Null RunState", () -> {
                    final ConvertToMapUtil classUnderTest = new ConvertToMapUtil();
                    final Executable testMethod = () -> classUnderTest.convertToMap(null,
                            null,
                            null);
                    final NullPointerException thrown = assertThrows(NullPointerException.class, testMethod);
                    assertAll("Checking Exception",
                            () -> assertThat(thrown.getMessage(), is(equalTo("RunState"))),
                            () -> assertThat(thrown.getCause(), is(nullValue()))
                    );
                }),

                DynamicTest.dynamicTest("Null RunStateObjectKey", () -> {
                    final RunState runState = new RunState();
                    final ConvertToMapUtil classUnderTest = new ConvertToMapUtil();
                    final Executable testMethod = () -> classUnderTest.convertToMap(runState,
                            null,
                            null);
                    final NullPointerException thrown = assertThrows(NullPointerException.class, testMethod);
                    assertAll("Checking Exception",
                            () -> assertThat(thrown.getMessage(), is(equalTo("RunStateObjectKey"))),
                            () -> assertThat(thrown.getCause(), is(nullValue()))
                    );
                }),

                DynamicTest.dynamicTest("Null RunStateJsonMapKey", () -> {
                    final RunState runState = new RunState();
                    final ConvertToMapUtil classUnderTest = new ConvertToMapUtil();
                    final Executable testMethod = () -> classUnderTest.convertToMap(runState,
                            "Valid_RunStateObjectKey",
                            null);
                    final NullPointerException thrown = assertThrows(NullPointerException.class, testMethod);
                    assertAll("Checking Exception",
                            () -> assertThat(thrown.getMessage(), is(equalTo("RunStateJsonMapKey"))),
                            () -> assertThat(thrown.getCause(), is(nullValue()))
                    );
                })

        );

    }

    @TestFactory
    @DisplayName("Exceptions from RunState")
    public Collection<DynamicTest> exceptionsRunState() {

        return Arrays.asList(

                DynamicTest.dynamicTest("Empty RunState", () -> {
                    final RunState runState = new RunState();

                    final ConvertToMapUtil classUnderTest = new ConvertToMapUtil();
                    final Executable testMethod = () -> classUnderTest.convertToMap(runState,
                            "Valid_RunStateObjectKey",
                            "Valid_RunStateJsonMapKey");

                    final MultipleFailuresError thrown = assertThrows(MultipleFailuresError.class, testMethod);
                    assertAll("Checking Exception",
                            () -> assertThat(thrown.getMessage(), is(equalTo(String.format("%s\n\t%s\n%s\n%s",
                                    "Run State Validation (1 failure)",
                                    "java.lang.AssertionError: Keys where value was expected to be non null",
                                    "Expected: is java.util.Collection size <0>",
                                    "     but: was java.util.Collection size <1> <[Valid_RunStateObjectKey]>"
                            )))),
                            () -> assertThat(thrown.getCause(), is(nullValue()))
                    );
                }),

                DynamicTest.dynamicTest("Missing Input, Valid Output in RunState", () -> {
                    final RunState runState = new RunState();
                    runState.set("Valid_RunStateJsonMapKey", new Object());

                    final ConvertToMapUtil classUnderTest = new ConvertToMapUtil();
                    final Executable testMethod = () -> classUnderTest.convertToMap(runState,
                            "Valid_RunStateObjectKey",
                            "Valid_RunStateJsonMapKey");

                    final MultipleFailuresError thrown = assertThrows(MultipleFailuresError.class, testMethod);
                    assertAll("Checking Exception",
                            () -> assertThat(thrown.getMessage(), is(equalTo(String.format("%s\n\t%s\n%s\n%s\n\t%s\n%s\n%s",
                                    "Run State Validation (2 failures)",
                                    "java.lang.AssertionError: Keys where value was expected to be null",
                                    "Expected: is java.util.Collection size <0>",
                                    "     but: was java.util.Collection size <1> <[Valid_RunStateJsonMapKey]>",
                                    "java.lang.AssertionError: Keys where value was expected to be non null",
                                    "Expected: is java.util.Collection size <0>",
                                    "     but: was java.util.Collection size <1> <[Valid_RunStateObjectKey]>"
                            )))),
                            () -> assertThat(thrown.getCause(), is(nullValue()))
                    );

                }),

                DynamicTest.dynamicTest("Valid Input, Valid Output in RunState", () -> {
                    final RunState runState = new RunState();
                    runState.set("Valid_RunStateObjectKey", "aValidKey");
                    runState.set("Valid_RunStateJsonMapKey", "Should not be in RunState");

                    final ConvertToMapUtil classUnderTest = new ConvertToMapUtil();
                    final Executable testMethod = () -> classUnderTest.convertToMap(runState,
                            "Valid_RunStateObjectKey",
                            "Valid_RunStateJsonMapKey");

                    final MultipleFailuresError thrown = assertThrows(MultipleFailuresError.class, testMethod);
                    assertAll("Checking Exception",
                            () -> assertThat(thrown.getMessage(), is(equalTo(String.format("%s\n\t%s\n%s\n%s",
                                    "Run State Validation (1 failure)",
                                    "java.lang.AssertionError: Keys where value was expected to be null",
                                    "Expected: is java.util.Collection size <0>",
                                    "     but: was java.util.Collection size <1> <[Valid_RunStateJsonMapKey]>"
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

        final ConvertToMap mockConvertToMap = mock(ConvertToMap.class);
        when(mockConvertToMap.apply(any()))
                .thenReturn(mockOutput);

        final RunState mockRunState = mock(RunState.class);
        when(mockRunState.get(eq("Valid_RunStateObjectKey"), any()))
                .thenReturn(mockInput);
        when(mockRunState.isSet(eq("Valid_RunStateObjectKey")))
                .thenReturn(true);
        when(mockRunState.isUnset(eq("Valid_RunStateJsonMapKey")))
                .thenReturn(true);

        new ConvertToMapUtil(mockConvertToMap)
                .convertToMap(mockRunState,
                        "Valid_RunStateObjectKey",
                        "Valid_RunStateJsonMapKey");

        assertAll("",
                () -> verify(mockConvertToMap, times(1))
                        .apply(eq(mockInput)),
                () -> verify(mockRunState, times(1))
                        .set(eq("Valid_RunStateJsonMapKey"), eq(mockOutput))
        );
    }

}
