package com.github.nhojpatrick.cucumber.state.tests;

import com.github.nhojpatrick.cucumber.core.exceptions.EmptyKeyException;
import com.github.nhojpatrick.cucumber.core.exceptions.NullKeyException;
import com.github.nhojpatrick.cucumber.core.exceptions.NullTypeClassException;
import com.github.nhojpatrick.cucumber.core.exceptions.TypeMismatchException;
import com.github.nhojpatrick.cucumber.core.exceptions.WhitespaceKeyException;
import com.github.nhojpatrick.cucumber.state.RunState;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.function.Executable;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import static com.github.nhojpatrick.hamcrest.lang.IsThrowable.throwable;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

public class RunStateTest {

    public static final String KEY = "key";

    @Test
    public void clear()
            throws Exception {

        final RunState runState = new RunState();
        runState.set(KEY, "value");

        final String actualPre = runState.get(KEY, String.class);
        assertThat(actualPre, is(equalTo("value")));

        runState.clear(KEY);

        assertAll("Clear then check get/isSet/isUnset",
                () -> assertThat(runState.get(KEY, String.class), is(nullValue())),
                () -> assertThat(runState.isSet(KEY, String.class), is(equalTo(false))),
                () -> assertThat(runState.isUnset(KEY), is(equalTo(true)))
        );
    }

    @TestFactory
    public Collection<DynamicTest> clearExceptions() {

        return Arrays.asList(

                dynamicTest("Key - Empty String", () -> {
                    final RunState runState = new RunState();
                    final Executable testMethod = () -> runState.clear("");
                    final EmptyKeyException thrown = assertThrows(EmptyKeyException.class, testMethod);
                    assertAll("Checking Exception",
                            () -> assertThat(thrown.getMessage(), is(equalTo("Empty String Key."))),
                            () -> assertThat(thrown.getCause(), is(nullValue()))
                    );
                }),

                dynamicTest("Key - Null", () -> {
                    final RunState runState = new RunState();
                    final Executable testMethod = () -> runState.clear(null);
                    final NullKeyException thrown = assertThrows(NullKeyException.class, testMethod);
                    assertAll("Checking Exception",
                            () -> assertThat(thrown.getMessage(), is(equalTo("Null Key."))),
                            () -> assertThat(thrown.getCause(), is(nullValue()))
                    );
                }),

                dynamicTest("Key - Whitespace String", () -> {
                    final RunState runState = new RunState();
                    final Executable testMethod = () -> runState.clear("          ");
                    final WhitespaceKeyException thrown = assertThrows(WhitespaceKeyException.class, testMethod);
                    assertAll("Checking Exception",
                            () -> assertThat(thrown.getMessage(), is(equalTo("Whitespace String Key."))),
                            () -> assertThat(thrown.getCause(), is(nullValue()))
                    );
                })

        );
    }

    @Test
    public void get()
            throws Exception {

        final RunState runState = new RunState();
        runState.set(KEY, "value");

        final Map<String, Object> expected = new HashMap<>();
        expected.put(KEY, "value");

        final Map<String, Object> actual = runState.get();

        assertThat(actual, is(equalTo(expected)));
    }

    @TestFactory
    public Collection<DynamicTest> getAndSet() {

        return Arrays.asList(

                dynamicTest("Boolean", () -> {
                    final RunState runState = new RunState();
                    runState.set(KEY, true);
                    final Boolean actual = runState.get(KEY, Boolean.class);
                    assertThat(actual, is(equalTo(true)));
                }),

                dynamicTest("Integer", () -> {
                    final RunState runState = new RunState();
                    runState.set(KEY, 1234);
                    final Integer actual = runState.get(KEY, Integer.class);
                    assertThat(actual, is(equalTo(1234)));
                }),

                dynamicTest("Long", () -> {
                    final RunState runState = new RunState();
                    runState.set(KEY, 1234L);
                    final Long actual = runState.get(KEY, Long.class);
                    assertThat(actual, is(equalTo(1234L)));
                }),

                dynamicTest("Null", () -> {
                    final RunState runState = new RunState();
                    final Object expectedValue = new Object();
                    runState.set(KEY, expectedValue);
                    final Object actual = runState.get(KEY, Object.class);
                    assertThat(actual, is(equalTo(expectedValue)));
                }),

                dynamicTest("Object", () -> {
                    final RunState runState = new RunState();
                    runState.set(KEY, null);
                    final Object actual = runState.get(KEY, Object.class);
                    assertThat(actual, is(nullValue()));
                }),

                dynamicTest("String", () -> {
                    final RunState runState = new RunState();
                    runState.set(KEY, "value");
                    final String actual = runState.get(KEY, String.class);
                    assertThat(actual, is(equalTo("value")));
                }),

                dynamicTest("Override Check", () -> {
                    final RunState runState = new RunState();
                    runState.set(KEY, "first value");
                    runState.set(KEY, "second value");
                    runState.set(KEY, "third value");

                    final String actual = runState.get(KEY, String.class);
                    assertThat(actual, is(equalTo("third value")));
                })

        );
    }

    @TestFactory
    public Collection<DynamicTest> getExceptions() {

        return Arrays.asList(

                dynamicTest("Key - Empty String", () -> {
                    final RunState runState = new RunState();
                    final Executable testMethod = () -> runState.get("", String.class);
                    final EmptyKeyException thrown = assertThrows(EmptyKeyException.class, testMethod);
                    assertAll("Checking Exception",
                            () -> assertThat(thrown.getMessage(), is(equalTo("Empty String Key."))),
                            () -> assertThat(thrown.getCause(), is(nullValue()))
                    );
                }),

                dynamicTest("Key - Null", () -> {
                    final RunState runState = new RunState();
                    final Executable testMethod = () -> runState.get(null, String.class);
                    final NullKeyException thrown = assertThrows(NullKeyException.class, testMethod);
                    assertAll("Checking Exception",
                            () -> assertThat(thrown.getMessage(), is(equalTo("Null Key."))),
                            () -> assertThat(thrown.getCause(), is(nullValue()))
                    );
                }),

                dynamicTest("Key - Whitespace String", () -> {
                    final RunState runState = new RunState();
                    final Executable testMethod = () -> runState.get("          ", String.class);
                    final WhitespaceKeyException thrown = assertThrows(WhitespaceKeyException.class, testMethod);
                    assertAll("Checking Exception",
                            () -> assertThat(thrown.getMessage(), is(equalTo("Whitespace String Key."))),
                            () -> assertThat(thrown.getCause(), is(nullValue()))
                    );
                }),

                dynamicTest("Type - Null", () -> {
                    final RunState runState = new RunState();
                    final Executable testMethod = () -> runState.get(KEY, null);
                    final NullTypeClassException thrown = assertThrows(NullTypeClassException.class, testMethod);
                    assertAll("Checking Exception",
                            () -> assertThat(thrown.getMessage(), is(equalTo("Null Type Class."))),
                            () -> assertThat(thrown.getCause(), is(nullValue()))
                    );
                }),

                dynamicTest("Type - Mismatch", () -> {
                    final RunState runState = new RunState();
                    runState.set(KEY, 12345L);
                    final Executable testMethod = () -> runState.get(KEY, String.class);
                    final TypeMismatchException thrown = assertThrows(TypeMismatchException.class, testMethod);
                    assertAll("Checking Exception",
                            () -> assertThat(thrown.getMessage(), is(equalTo("Run state value does not match requested type 'class java.lang.String'."))),
                            () -> assertThat(thrown.getCause(), is(throwable(ClassCastException.class, "Cannot cast java.lang.Long to java.lang.String")))
                    );
                })

        );
    }

    @TestFactory
    public Collection<DynamicTest> isSet() {

        return Arrays.asList(

                dynamicTest("isSet - true", () -> {
                    final RunState runState = new RunState();
                    runState.set(KEY, "value");

                    final boolean actual = runState.isSet(KEY);
                    assertThat(actual, is(equalTo(true)));
                }),

                dynamicTest("isSet - false", () -> {
                    final RunState runState = new RunState();
                    runState.clear(KEY);

                    final boolean actual = runState.isSet(KEY);
                    assertThat(actual, is(equalTo(false)));
                }),

                dynamicTest("isSet - true", () -> {
                    final RunState runState = new RunState();
                    runState.set(KEY, "value");

                    final boolean actual = runState.isSet(KEY, String.class);
                    assertThat(actual, is(equalTo(true)));
                })

        );
    }

    @TestFactory
    public Collection<DynamicTest> isSetExceptions() {

        return Arrays.asList(

                dynamicTest("Key - Empty String", () -> {
                    final RunState runState = new RunState();
                    final Executable testMethod = () -> runState.isSet("");
                    final EmptyKeyException thrown = assertThrows(EmptyKeyException.class, testMethod);
                    assertAll("Checking Exception",
                            () -> assertThat(thrown.getMessage(), is(equalTo("Empty String Key."))),
                            () -> assertThat(thrown.getCause(), is(nullValue()))
                    );
                }),

                dynamicTest("Key - Null Key", () -> {
                    final RunState runState = new RunState();
                    final Executable testMethod = () -> runState.isSet(null);
                    final NullKeyException thrown = assertThrows(NullKeyException.class, testMethod);
                    assertAll("Checking Exception",
                            () -> assertThat(thrown.getMessage(), is(equalTo("Null Key."))),
                            () -> assertThat(thrown.getCause(), is(nullValue()))
                    );
                }),

                dynamicTest("Key - Whitespace String", () -> {
                    final RunState runState = new RunState();
                    final Executable testMethod = () -> runState.isSet("          ");
                    final WhitespaceKeyException thrown = assertThrows(WhitespaceKeyException.class, testMethod);
                    assertAll("Checking Exception",
                            () -> assertThat(thrown.getMessage(), is(equalTo("Whitespace String Key."))),
                            () -> assertThat(thrown.getCause(), is(nullValue()))
                    );
                }),

                dynamicTest("Key - Empty String", () -> {
                    final RunState runState = new RunState();
                    final Executable testMethod = () -> runState.isSet("", String.class);
                    final EmptyKeyException thrown = assertThrows(EmptyKeyException.class, testMethod);
                    assertAll("Checking Exception",
                            () -> assertThat(thrown.getMessage(), is(equalTo("Empty String Key."))),
                            () -> assertThat(thrown.getCause(), is(nullValue()))
                    );
                }),

                dynamicTest("Key - Null Key", () -> {
                    final RunState runState = new RunState();
                    final Executable testMethod = () -> runState.isSet(null, String.class);
                    final NullKeyException thrown = assertThrows(NullKeyException.class, testMethod);
                    assertAll("Checking Exception",
                            () -> assertThat(thrown.getMessage(), is(equalTo("Null Key."))),
                            () -> assertThat(thrown.getCause(), is(nullValue()))
                    );
                }),

                dynamicTest("Key - Whitespace String", () -> {
                    final RunState runState = new RunState();
                    final Executable testMethod = () -> runState.isSet("          ", String.class);
                    final WhitespaceKeyException thrown = assertThrows(WhitespaceKeyException.class, testMethod);
                    assertAll("Checking Exception",
                            () -> assertThat(thrown.getMessage(), is(equalTo("Whitespace String Key."))),
                            () -> assertThat(thrown.getCause(), is(nullValue()))
                    );
                }),

                dynamicTest("Type - Null", () -> {
                    final RunState runState = new RunState();
                    final Executable testMethod = () -> runState.isSet(KEY, null);
                    final NullTypeClassException thrown = assertThrows(NullTypeClassException.class, testMethod);
                    assertAll("Checking Exception",
                            () -> assertThat(thrown.getMessage(), is(equalTo("Null Type Class."))),
                            () -> assertThat(thrown.getCause(), is(nullValue()))
                    );
                }),

                dynamicTest("Type - Mismatch", () -> {
                    final RunState runState = new RunState();
                    runState.set(KEY, 12345L);
                    final Executable testMethod = () -> runState.isSet(KEY, String.class);
                    final TypeMismatchException thrown = assertThrows(TypeMismatchException.class, testMethod);
                    assertAll("Checking Exception",
                            () -> assertThat(thrown.getMessage(), is(equalTo("Run state value does not match requested type 'class java.lang.String'."))),
                            () -> assertThat(thrown.getCause(), is(throwable(ClassCastException.class, "Cannot cast java.lang.Long to java.lang.String")))
                    );
                })

        );
    }

    @TestFactory
    public Collection<DynamicTest> isUnset() {

        return Arrays.asList(

                dynamicTest("isSet - true", () -> {
                    final RunState runState = new RunState();
                    runState.set(KEY, "value");

                    final boolean actual = runState.isUnset(KEY);
                    assertThat(actual, is(equalTo(false)));
                }),

                dynamicTest("isSet - false", () -> {
                    final RunState runState = new RunState();
                    runState.clear(KEY);

                    final boolean actual = runState.isUnset(KEY);
                    assertThat(actual, is(equalTo(true)));
                })

        );
    }

    @TestFactory
    public Collection<DynamicTest> isUnsetExceptions() {

        return Arrays.asList(

                dynamicTest("Key - Empty String", () -> {
                    final RunState runState = new RunState();
                    final Executable testMethod = () -> runState.isUnset("");
                    final EmptyKeyException thrown = assertThrows(EmptyKeyException.class, testMethod);
                    assertAll("Checking Exception",
                            () -> assertThat(thrown.getMessage(), is(equalTo("Empty String Key."))),
                            () -> assertThat(thrown.getCause(), is(nullValue()))
                    );
                }),

                dynamicTest("Key - Null", () -> {
                    final RunState runState = new RunState();
                    final Executable testMethod = () -> runState.isUnset(null);
                    final NullKeyException thrown = assertThrows(NullKeyException.class, testMethod);
                    assertAll("Checking Exception",
                            () -> assertThat(thrown.getMessage(), is(equalTo("Null Key."))),
                            () -> assertThat(thrown.getCause(), is(nullValue()))
                    );
                }),

                dynamicTest("Key - Whitespace String", () -> {
                    final RunState runState = new RunState();
                    final Executable testMethod = () -> runState.isUnset("          ");
                    final WhitespaceKeyException thrown = assertThrows(WhitespaceKeyException.class, testMethod);
                    assertAll("Checking Exception",
                            () -> assertThat(thrown.getMessage(), is(equalTo("Whitespace String Key."))),
                            () -> assertThat(thrown.getCause(), is(nullValue()))
                    );
                })

        );
    }

    @TestFactory
    public Collection<DynamicTest> setExceptions() {

        return Arrays.asList(

                dynamicTest("Key - Empty String", () -> {
                    final RunState runState = new RunState();
                    final Executable testMethod = () -> runState.set("", "value");
                    final EmptyKeyException thrown = assertThrows(EmptyKeyException.class, testMethod);
                    assertAll("Checking Exception",
                            () -> assertThat(thrown.getMessage(), is(equalTo("Empty String Key."))),
                            () -> assertThat(thrown.getCause(), is(nullValue()))
                    );
                }),

                dynamicTest("Key - Null", () -> {
                    final RunState runState = new RunState();
                    final Executable testMethod = () -> runState.set(null, "value");
                    final NullKeyException thrown = assertThrows(NullKeyException.class, testMethod);
                    assertAll("Checking Exception",
                            () -> assertThat(thrown.getMessage(), is(equalTo("Null Key."))),
                            () -> assertThat(thrown.getCause(), is(nullValue()))
                    );
                }),

                dynamicTest("Key - Whitespace String", () -> {
                    final RunState runState = new RunState();
                    final Executable testMethod = () -> runState.set("          ", "value");
                    final WhitespaceKeyException thrown = assertThrows(WhitespaceKeyException.class, testMethod);
                    assertAll("Checking Exception",
                            () -> assertThat(thrown.getMessage(), is(equalTo("Whitespace String Key."))),
                            () -> assertThat(thrown.getCause(), is(nullValue()))
                    );
                })

        );
    }

    @Test
    public void toStringTest() {

        final RunState runState = new RunState();
        assertThat(runState.toString(), is(equalTo("RunState[{}]")));
    }

}
