package com.github.nhojpatrick.cucumber.json.map.tests;

import com.github.nhojpatrick.cucumber.core.exceptions.IllegalKeyException;
import com.github.nhojpatrick.cucumber.core.exceptions.IllegalTypeClassException;
import com.github.nhojpatrick.cucumber.core.exceptions.TypeMismatchException;
import com.github.nhojpatrick.cucumber.json.map.ConvertJsonMapUtil;
import com.github.nhojpatrick.cucumber.json.map.impl.ConvertMapToJson;
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
import static org.junit.jupiter.api.DynamicTest.dynamicTest;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ConvertJsonMapUtil_convertMapToJsonTest {

    @TestFactory
    @DisplayName("convertMapToJson validation")
    public Collection<DynamicTest> exceptionsInputs() {

        return Arrays.asList(

                dynamicTest("Null RunState", () -> {
                    final ConvertJsonMapUtil classUnderTest = new ConvertJsonMapUtil();
                    final Executable testMethod = () -> classUnderTest.convertMapToJson(null,
                            null,
                            null);
                    final NullPointerException thrown = assertThrows(NullPointerException.class, testMethod);
                    assertAll("Checking Exception",
                            () -> assertThat(thrown.getMessage(), is(equalTo("RunState"))),
                            () -> assertThat(thrown.getCause(), is(nullValue()))
                    );
                }),

                dynamicTest("Null RunStateJsonMapKey", () -> {
                    final RunState runState = new RunState();
                    final ConvertJsonMapUtil classUnderTest = new ConvertJsonMapUtil();
                    final Executable testMethod = () -> classUnderTest.convertMapToJson(runState,
                            null,
                            null);
                    final NullPointerException thrown = assertThrows(NullPointerException.class, testMethod);
                    assertAll("Checking Exception",
                            () -> assertThat(thrown.getMessage(), is(equalTo("RunStateJsonMapKey"))),
                            () -> assertThat(thrown.getCause(), is(nullValue()))
                    );
                }),

                dynamicTest("Null RunStateJsonStringKey", () -> {
                    final RunState runState = new RunState();
                    final ConvertJsonMapUtil classUnderTest = new ConvertJsonMapUtil();
                    final Executable testMethod = () -> classUnderTest.convertMapToJson(runState,
                            "Valid_RunStateJsonMapKey",
                            null);
                    final NullPointerException thrown = assertThrows(NullPointerException.class, testMethod);
                    assertAll("Checking Exception",
                            () -> assertThat(thrown.getMessage(), is(equalTo("RunStateJsonStringKey"))),
                            () -> assertThat(thrown.getCause(), is(nullValue()))
                    );
                })

        );

    }

    @TestFactory
    @DisplayName("convertMapToJson RunState validation")
    public Collection<DynamicTest> exceptionsRunState() {

        return Arrays.asList(

                dynamicTest("Empty RunState", () -> {
                    final RunState runState = new RunState();

                    final ConvertJsonMapUtil classUnderTest = new ConvertJsonMapUtil();
                    final Executable testMethod = () -> classUnderTest.convertMapToJson(runState,
                            "Valid_RunStateJsonMapKey",
                            "Valid_RunStateJsonStringKey");

                    final MultipleFailuresError thrown = assertThrows(MultipleFailuresError.class, testMethod);
                    assertAll("Checking Exception",
                            () -> assertThat(thrown.getMessage(), is(equalTo(String.format("%s\n\t%s\n%s\n%s",
                                    "Run State Validation (1 failure)",
                                    "java.lang.AssertionError: Keys where value was expected to be non null",
                                    "Expected: is java.util.Collection size <0>",
                                    "     but: was java.util.Collection size <1> <[Valid_RunStateJsonMapKey]>"
                            )))),
                            () -> assertThat(thrown.getCause(), is(nullValue()))
                    );
                }),

                dynamicTest("Missing Input, Valid Output in RunState", () -> {
                    final RunState runState = new RunState();
                    runState.set("Valid_RunStateJsonStringKey", new Object());

                    final ConvertJsonMapUtil classUnderTest = new ConvertJsonMapUtil();
                    final Executable testMethod = () -> classUnderTest.convertMapToJson(runState,
                            "Valid_RunStateJsonMapKey",
                            "Valid_RunStateJsonStringKey");

                    final MultipleFailuresError thrown = assertThrows(MultipleFailuresError.class, testMethod);
                    assertAll("Checking Exception",
                            () -> assertThat(thrown.getMessage(), is(equalTo(String.format("%s\n\t%s\n%s\n%s\n\t%s\n%s\n%s",
                                    "Run State Validation (2 failures)",
                                    "java.lang.AssertionError: Keys where value was expected to be null",
                                    "Expected: is java.util.Collection size <0>",
                                    "     but: was java.util.Collection size <1> <[Valid_RunStateJsonStringKey]>",
                                    "java.lang.AssertionError: Keys where value was expected to be non null",
                                    "Expected: is java.util.Collection size <0>",
                                    "     but: was java.util.Collection size <1> <[Valid_RunStateJsonMapKey]>"
                            )))),
                            () -> assertThat(thrown.getCause(), is(nullValue()))
                    );

                }),

                dynamicTest("Valid Input, Valid Output in RunState", () -> {
                    final RunState runState = new RunState();
                    runState.set("Valid_RunStateJsonMapKey", "aValidKey");
                    runState.set("Valid_RunStateJsonStringKey", "Should not be in RunState");

                    final ConvertJsonMapUtil classUnderTest = new ConvertJsonMapUtil();
                    final Executable testMethod = () -> classUnderTest.convertMapToJson(runState,
                            "Valid_RunStateJsonMapKey",
                            "Valid_RunStateJsonStringKey");

                    final MultipleFailuresError thrown = assertThrows(MultipleFailuresError.class, testMethod);
                    assertAll("Checking Exception",
                            () -> assertThat(thrown.getMessage(), is(equalTo(String.format("%s\n\t%s\n%s\n%s",
                                    "Run State Validation (1 failure)",
                                    "java.lang.AssertionError: Keys where value was expected to be null",
                                    "Expected: is java.util.Collection size <0>",
                                    "     but: was java.util.Collection size <1> <[Valid_RunStateJsonStringKey]>"
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

        final Map<String, Object> mockInput = mock(Map.class);

        final String output = "output";

        final ConvertMapToJson mockConvertMapToJson = mock(ConvertMapToJson.class);
        when(mockConvertMapToJson.apply(any()))
                .thenReturn(output);

        final RunState mockRunState = mock(RunState.class);
        when(mockRunState.get(eq("Valid_RunStateJsonMapKey"), any()))
                .thenReturn(mockInput);
        when(mockRunState.isSet(eq("Valid_RunStateJsonMapKey")))
                .thenReturn(true);
        when(mockRunState.isUnset(eq("Valid_RunStateJsonStringKey")))
                .thenReturn(true);

        new ConvertJsonMapUtil(mockConvertMapToJson, mock(ConvertObjectToMap.class))
                .convertMapToJson(mockRunState,
                        "Valid_RunStateJsonMapKey",
                        "Valid_RunStateJsonStringKey");

        assertAll("",
                () -> verify(mockConvertMapToJson, times(1))
                        .apply(eq(mockInput)),
                () -> verify(mockRunState, times(1))
                        .set(eq("Valid_RunStateJsonStringKey"), eq(output))
        );
    }

}
