package com.github.nhojpatrick.cucumber.state;

import com.github.nhojpatrick.cucumber.core.exceptions.EmptyKeyException;
import com.github.nhojpatrick.cucumber.core.exceptions.NullKeyException;
import com.github.nhojpatrick.cucumber.core.exceptions.NullTypeClassException;
import com.github.nhojpatrick.cucumber.core.exceptions.TypeMismatchException;
import com.github.nhojpatrick.cucumber.core.exceptions.WhitespaceKeyException;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.function.Executable;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;

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

                DynamicTest.dynamicTest("Key - Empty String", () -> {
                    final RunState runState = new RunState();
                    final Executable testMethod = () -> runState.clear("");
                    final EmptyKeyException expectedThrown = assertThrows(EmptyKeyException.class, testMethod);
                    assertAll("Checking Exception",
                            () -> assertThat(expectedThrown.getMessage(), is(equalTo("Empty String Key."))),
                            () -> assertThat(expectedThrown.getCause(), is(nullValue()))
                    );
                }),

                DynamicTest.dynamicTest("Key - Null", () -> {
                    final RunState runState = new RunState();
                    final Executable testMethod = () -> runState.clear(null);
                    final NullKeyException expectedThrown = assertThrows(NullKeyException.class, testMethod);
                    assertAll("Checking Exception",
                            () -> assertThat(expectedThrown.getMessage(), is(equalTo("Null Key."))),
                            () -> assertThat(expectedThrown.getCause(), is(nullValue()))
                    );
                }),

                DynamicTest.dynamicTest("Key - Whitespace String", () -> {
                    final RunState runState = new RunState();
                    final Executable testMethod = () -> runState.clear("          ");
                    final WhitespaceKeyException expectedThrown = assertThrows(WhitespaceKeyException.class, testMethod);
                    assertAll("Checking Exception",
                            () -> assertThat(expectedThrown.getMessage(), is(equalTo("Whitespace String Key."))),
                            () -> assertThat(expectedThrown.getCause(), is(nullValue()))
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

                DynamicTest.dynamicTest("Boolean", () -> {
                    final RunState runState = new RunState();
                    runState.set(KEY, true);
                    final Boolean actual = runState.get(KEY, Boolean.class);
                    assertThat(actual, is(equalTo(true)));
                }),

                DynamicTest.dynamicTest("Integer", () -> {
                    final RunState runState = new RunState();
                    runState.set(KEY, 1234);
                    final Integer actual = runState.get(KEY, Integer.class);
                    assertThat(actual, is(equalTo(1234)));
                }),

                DynamicTest.dynamicTest("Long", () -> {
                    final RunState runState = new RunState();
                    runState.set(KEY, 1234L);
                    final Long actual = runState.get(KEY, Long.class);
                    assertThat(actual, is(equalTo(1234L)));
                }),

                DynamicTest.dynamicTest("Null", () -> {
                    final RunState runState = new RunState();
                    final Object expectedValue = new Object();
                    runState.set(KEY, expectedValue);
                    final Object actual = runState.get(KEY, Object.class);
                    assertThat(actual, is(equalTo(expectedValue)));
                }),

                DynamicTest.dynamicTest("Object", () -> {
                    final RunState runState = new RunState();
                    runState.set(KEY, null);
                    final Object actual = runState.get(KEY, Object.class);
                    assertThat(actual, is(nullValue()));
                }),

                DynamicTest.dynamicTest("String", () -> {
                    final RunState runState = new RunState();
                    runState.set(KEY, "value");
                    final String actual = runState.get(KEY, String.class);
                    assertThat(actual, is(equalTo("value")));
                }),

                DynamicTest.dynamicTest("Override Check", () -> {
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

                DynamicTest.dynamicTest("Key - Empty String", () -> {
                    final RunState runState = new RunState();
                    final Executable testMethod = () -> runState.get("", String.class);
                    final EmptyKeyException expectedThrown = assertThrows(EmptyKeyException.class, testMethod);
                    assertAll("Checking Exception",
                            () -> assertThat(expectedThrown.getMessage(), is(equalTo("Empty String Key."))),
                            () -> assertThat(expectedThrown.getCause(), is(nullValue()))
                    );
                }),

                DynamicTest.dynamicTest("Key - Null", () -> {
                    final RunState runState = new RunState();
                    final Executable testMethod = () -> runState.get(null, String.class);
                    final NullKeyException expectedThrown = assertThrows(NullKeyException.class, testMethod);
                    assertAll("Checking Exception",
                            () -> assertThat(expectedThrown.getMessage(), is(equalTo("Null Key."))),
                            () -> assertThat(expectedThrown.getCause(), is(nullValue()))
                    );
                }),

                DynamicTest.dynamicTest("Key - Whitespace String", () -> {
                    final RunState runState = new RunState();
                    final Executable testMethod = () -> runState.get("          ", String.class);
                    final WhitespaceKeyException expectedThrown = assertThrows(WhitespaceKeyException.class, testMethod);
                    assertAll("Checking Exception",
                            () -> assertThat(expectedThrown.getMessage(), is(equalTo("Whitespace String Key."))),
                            () -> assertThat(expectedThrown.getCause(), is(nullValue()))
                    );
                }),

                DynamicTest.dynamicTest("Type - Null", () -> {
                    final RunState runState = new RunState();
                    final Executable testMethod = () -> runState.get(KEY, null);
                    final NullTypeClassException expectedThrown = assertThrows(NullTypeClassException.class, testMethod);
                    assertAll("Checking Exception",
                            () -> assertThat(expectedThrown.getMessage(), is(equalTo("Null Type Class."))),
                            () -> assertThat(expectedThrown.getCause(), is(nullValue()))
                    );
                }),

                DynamicTest.dynamicTest("Type - Mismatch", () -> {
                    final RunState runState = new RunState();
                    runState.set(KEY, 12345L);
                    final Executable testMethod = () -> runState.get(KEY, String.class);
                    final TypeMismatchException expectedThrown = assertThrows(TypeMismatchException.class, testMethod);
                    assertAll("Checking Exception",
                            () -> assertThat(expectedThrown.getMessage(), is(equalTo("Run state value does not match requested type 'class java.lang.String'."))),
                            () -> assertThat(expectedThrown.getCause(), is(instanceOf(ClassCastException.class)))
                    );
                })

        );
    }

    @TestFactory
    public Collection<DynamicTest> isSet() {

        return Arrays.asList(

                DynamicTest.dynamicTest("isSet - true", () -> {
                    final RunState runState = new RunState();
                    runState.set(KEY, "value");

                    final boolean actual = runState.isSet(KEY);
                    assertThat(actual, is(equalTo(true)));
                }),

                DynamicTest.dynamicTest("isSet - false", () -> {
                    final RunState runState = new RunState();
                    runState.clear(KEY);

                    final boolean actual = runState.isSet(KEY);
                    assertThat(actual, is(equalTo(false)));
                }),

                DynamicTest.dynamicTest("isSet - true", () -> {
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

                DynamicTest.dynamicTest("Key - Empty String", () -> {
                    final RunState runState = new RunState();
                    final Executable testMethod = () -> runState.isSet("");
                    final EmptyKeyException expectedThrown = assertThrows(EmptyKeyException.class, testMethod);
                    assertAll("Checking Exception",
                            () -> assertThat(expectedThrown.getMessage(), is(equalTo("Empty String Key."))),
                            () -> assertThat(expectedThrown.getCause(), is(nullValue()))
                    );
                }),

                DynamicTest.dynamicTest("Key - Null Key", () -> {
                    final RunState runState = new RunState();
                    final Executable testMethod = () -> runState.isSet(null);
                    final NullKeyException expectedThrown = assertThrows(NullKeyException.class, testMethod);
                    assertAll("Checking Exception",
                            () -> assertThat(expectedThrown.getMessage(), is(equalTo("Null Key."))),
                            () -> assertThat(expectedThrown.getCause(), is(nullValue()))
                    );
                }),

                DynamicTest.dynamicTest("Key - Whitespace String", () -> {
                    final RunState runState = new RunState();
                    final Executable testMethod = () -> runState.isSet("          ");
                    final WhitespaceKeyException expectedThrown = assertThrows(WhitespaceKeyException.class, testMethod);
                    assertAll("Checking Exception",
                            () -> assertThat(expectedThrown.getMessage(), is(equalTo("Whitespace String Key."))),
                            () -> assertThat(expectedThrown.getCause(), is(nullValue()))
                    );
                }),

                DynamicTest.dynamicTest("Key - Empty String", () -> {
                    final RunState runState = new RunState();
                    final Executable testMethod = () -> runState.isSet("", String.class);
                    final EmptyKeyException expectedThrown = assertThrows(EmptyKeyException.class, testMethod);
                    assertAll("Checking Exception",
                            () -> assertThat(expectedThrown.getMessage(), is(equalTo("Empty String Key."))),
                            () -> assertThat(expectedThrown.getCause(), is(nullValue()))
                    );
                }),

                DynamicTest.dynamicTest("Key - Null Key", () -> {
                    final RunState runState = new RunState();
                    final Executable testMethod = () -> runState.isSet(null, String.class);
                    final NullKeyException expectedThrown = assertThrows(NullKeyException.class, testMethod);
                    assertAll("Checking Exception",
                            () -> assertThat(expectedThrown.getMessage(), is(equalTo("Null Key."))),
                            () -> assertThat(expectedThrown.getCause(), is(nullValue()))
                    );
                }),

                DynamicTest.dynamicTest("Key - Whitespace String", () -> {
                    final RunState runState = new RunState();
                    final Executable testMethod = () -> runState.isSet("          ", String.class);
                    final WhitespaceKeyException expectedThrown = assertThrows(WhitespaceKeyException.class, testMethod);
                    assertAll("Checking Exception",
                            () -> assertThat(expectedThrown.getMessage(), is(equalTo("Whitespace String Key."))),
                            () -> assertThat(expectedThrown.getCause(), is(nullValue()))
                    );
                }),

                DynamicTest.dynamicTest("Type - Null", () -> {
                    final RunState runState = new RunState();
                    final Executable testMethod = () -> runState.isSet(KEY, null);
                    final NullTypeClassException expectedThrown = assertThrows(NullTypeClassException.class, testMethod);
                    assertAll("Checking Exception",
                            () -> assertThat(expectedThrown.getMessage(), is(equalTo("Null Type Class."))),
                            () -> assertThat(expectedThrown.getCause(), is(nullValue()))
                    );
                }),

                DynamicTest.dynamicTest("Type - Mismatch", () -> {
                    final RunState runState = new RunState();
                    runState.set(KEY, 12345L);
                    final Executable testMethod = () -> runState.isSet(KEY, String.class);
                    final TypeMismatchException expectedThrown = assertThrows(TypeMismatchException.class, testMethod);
                    assertAll("Checking Exception",
                            () -> assertThat(expectedThrown.getMessage(), is(equalTo("Run state value does not match requested type 'class java.lang.String'."))),
                            () -> assertThat(expectedThrown.getCause(), is(instanceOf(ClassCastException.class)))
                    );
                })

        );
    }

    @TestFactory
    public Collection<DynamicTest> isUnset() {

        return Arrays.asList(

                DynamicTest.dynamicTest("isSet - true", () -> {
                    final RunState runState = new RunState();
                    runState.set(KEY, "value");

                    final boolean actual = runState.isUnset(KEY);
                    assertThat(actual, is(equalTo(false)));
                }),

                DynamicTest.dynamicTest("isSet - false", () -> {
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

                DynamicTest.dynamicTest("Key - Empty String", () -> {
                    final RunState runState = new RunState();
                    final Executable testMethod = () -> runState.isUnset("");
                    final EmptyKeyException expectedThrown = assertThrows(EmptyKeyException.class, testMethod);
                    assertAll("Checking Exception",
                            () -> assertThat(expectedThrown.getMessage(), is(equalTo("Empty String Key."))),
                            () -> assertThat(expectedThrown.getCause(), is(nullValue()))
                    );
                }),

                DynamicTest.dynamicTest("Key - Null", () -> {
                    final RunState runState = new RunState();
                    final Executable testMethod = () -> runState.isUnset(null);
                    final NullKeyException expectedThrown = assertThrows(NullKeyException.class, testMethod);
                    assertAll("Checking Exception",
                            () -> assertThat(expectedThrown.getMessage(), is(equalTo("Null Key."))),
                            () -> assertThat(expectedThrown.getCause(), is(nullValue()))
                    );
                }),

                DynamicTest.dynamicTest("Key - Whitespace String", () -> {
                    final RunState runState = new RunState();
                    final Executable testMethod = () -> runState.isUnset("          ");
                    final WhitespaceKeyException expectedThrown = assertThrows(WhitespaceKeyException.class, testMethod);
                    assertAll("Checking Exception",
                            () -> assertThat(expectedThrown.getMessage(), is(equalTo("Whitespace String Key."))),
                            () -> assertThat(expectedThrown.getCause(), is(nullValue()))
                    );
                })

        );
    }

    @TestFactory
    public Collection<DynamicTest> setExceptions() {

        return Arrays.asList(

                DynamicTest.dynamicTest("Key - Empty String", () -> {
                    final RunState runState = new RunState();
                    final Executable testMethod = () -> runState.set("", "value");
                    final EmptyKeyException expectedThrown = assertThrows(EmptyKeyException.class, testMethod);
                    assertAll("Checking Exception",
                            () -> assertThat(expectedThrown.getMessage(), is(equalTo("Empty String Key."))),
                            () -> assertThat(expectedThrown.getCause(), is(nullValue()))
                    );
                }),

                DynamicTest.dynamicTest("Key - Null", () -> {
                    final RunState runState = new RunState();
                    final Executable testMethod = () -> runState.set(null, "value");
                    final NullKeyException expectedThrown = assertThrows(NullKeyException.class, testMethod);
                    assertAll("Checking Exception",
                            () -> assertThat(expectedThrown.getMessage(), is(equalTo("Null Key."))),
                            () -> assertThat(expectedThrown.getCause(), is(nullValue()))
                    );
                }),

                DynamicTest.dynamicTest("Key - Whitespace String", () -> {
                    final RunState runState = new RunState();
                    final Executable testMethod = () -> runState.set("          ", "value");
                    final WhitespaceKeyException expectedThrown = assertThrows(WhitespaceKeyException.class, testMethod);
                    assertAll("Checking Exception",
                            () -> assertThat(expectedThrown.getMessage(), is(equalTo("Whitespace String Key."))),
                            () -> assertThat(expectedThrown.getCause(), is(nullValue()))
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
