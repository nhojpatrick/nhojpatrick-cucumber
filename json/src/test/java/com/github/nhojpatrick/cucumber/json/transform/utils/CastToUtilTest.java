package com.github.nhojpatrick.cucumber.json.transform.utils;

import com.github.nhojpatrick.cucumber.json.exceptions.UnsupportedDataTypeConversionException;
import com.github.nhojpatrick.cucumber.json.exceptions.UnsupportedDataTypeException;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.function.Executable;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CastToUtilTest {

    @TestFactory
    public Collection<DynamicTest> exceptions() {

        final CastToUtil classUnderTest = new CastToUtil();

        return Arrays.asList(

                DynamicTest.dynamicTest("Unknown", () -> {
                    final Executable testMethod = () -> classUnderTest.castTo("true", "Unknown");
                    final UnsupportedDataTypeException expectedThrown = assertThrows(UnsupportedDataTypeException.class, testMethod);
                    assertThat(expectedThrown.getMessage(), is(equalTo("Unsupported data type 'Unknown'.")));
                }),

                DynamicTest.dynamicTest("Boolean invalid", () -> {
                    final Executable testMethod = () -> classUnderTest.castTo("string", "java.lang.Boolean");
                    final UnsupportedDataTypeConversionException expectedThrown = assertThrows(UnsupportedDataTypeConversionException.class, testMethod);
                    assertThat(expectedThrown.getMessage(), is(equalTo("Unsupported data type conversion for type 'java.lang.Boolean' from value 'string'.")));
                }),

                DynamicTest.dynamicTest("Double invalid", () -> {
                    final Executable testMethod = () -> classUnderTest.castTo("string", "java.lang.Double");
                    final UnsupportedDataTypeConversionException expectedThrown = assertThrows(UnsupportedDataTypeConversionException.class, testMethod);
                    assertThat(expectedThrown.getMessage(), is(equalTo("Unsupported data type conversion for type 'java.lang.Double' from value 'string'.")));
                }),

                DynamicTest.dynamicTest("Float invalid", () -> {
                    final Executable testMethod = () -> classUnderTest.castTo("string", "java.lang.Float");
                    final UnsupportedDataTypeConversionException expectedThrown = assertThrows(UnsupportedDataTypeConversionException.class, testMethod);
                    assertThat(expectedThrown.getMessage(), is(equalTo("Unsupported data type conversion for type 'java.lang.Float' from value 'string'.")));
                }),

                DynamicTest.dynamicTest("Integer invalid", () -> {
                    final Executable testMethod = () -> classUnderTest.castTo("string", "java.lang.Integer");
                    final UnsupportedDataTypeConversionException expectedThrown = assertThrows(UnsupportedDataTypeConversionException.class, testMethod);
                    assertThat(expectedThrown.getMessage(), is(equalTo("Unsupported data type conversion for type 'java.lang.Integer' from value 'string'.")));
                }),

                DynamicTest.dynamicTest("Long invalid", () -> {
                    final Executable testMethod = () -> classUnderTest.castTo("string", "java.lang.Long");
                    final UnsupportedDataTypeConversionException expectedThrown = assertThrows(UnsupportedDataTypeConversionException.class, testMethod);
                    assertThat(expectedThrown.getMessage(), is(equalTo("Unsupported data type conversion for type 'java.lang.Long' from value 'string'.")));
                })//,
//
//                DynamicTest.dynamicTest("List -> <null>", () -> {
//                    final Executable testMethod = () -> isTypedList(new ArrayList(), null);
//                    final NullGenericsValueException expectedThrown = assertThrows(NullGenericsValueException.class, testMethod);
//                    assertThat(expectedThrown.getMessage(), is(equalTo("Null Generics Value Type.")));
//                }),
//
//                DynamicTest.dynamicTest("Object -> <null>", () -> {
//                    final Executable testMethod = () -> isTypedList(new Object(), null);
//                    final NullGenericsValueException expectedThrown = assertThrows(NullGenericsValueException.class, testMethod);
//                    assertThat(expectedThrown.getMessage(), is(equalTo("Null Generics Value Type.")));
//                })

        );
    }

    @TestFactory
    public Collection<DynamicTest> castTo() {

        final CastToUtil classUnderTest = new CastToUtil();

        return Arrays.asList(

                DynamicTest.dynamicTest("Boolean", () -> {
                    final Object actual = classUnderTest.castTo("true", "java.lang.Boolean");
                    assertAll(
                            () -> assertThat("Unexpected type", actual, is(instanceOf(Boolean.class))),
                            () -> assertThat("Unexpected value", actual, is(equalTo(Boolean.TRUE)))
                    );
                }),

                DynamicTest.dynamicTest("Double", () -> {
                    final Object actual = classUnderTest.castTo("1234", "java.lang.Double");
                    assertAll(
                            () -> assertThat("Unexpected type", actual, is(instanceOf(Double.class))),
                            () -> assertThat("Unexpected value", actual, is(equalTo(Double.valueOf(1234))))
                    );
                }),

                DynamicTest.dynamicTest("Float", () -> {
                    final Object actual = classUnderTest.castTo("1234", "java.lang.Float");
                    assertAll(
                            () -> assertThat("Unexpected type", actual, is(instanceOf(Float.class))),
                            () -> assertThat("Unexpected value", actual, is(equalTo(Float.valueOf(1234))))
                    );
                }),

                DynamicTest.dynamicTest("Integer", () -> {
                    final Object actual = classUnderTest.castTo("1234", "java.lang.Integer");
                    assertAll(
                            () -> assertThat("Unexpected type", actual, is(instanceOf(Integer.class))),
                            () -> assertThat("Unexpected value", actual, is(equalTo(Integer.valueOf(1234))))
                    );
                }),

                DynamicTest.dynamicTest("Long", () -> {
                    final Object actual = classUnderTest.castTo("1234", "java.lang.Long");
                    assertAll(
                            () -> assertThat("Unexpected type", actual, is(instanceOf(Long.class))),
                            () -> assertThat("Unexpected value", actual, is(equalTo(Long.valueOf(1234))))
                    );
                }),

                DynamicTest.dynamicTest("Null", () -> {
                    final Object actual = classUnderTest.castTo("", "null");
                    assertAll(
                            () -> assertThat("Unexpected value", actual, is(nullValue()))
                    );
                }),

                DynamicTest.dynamicTest("String", () -> {
                    final Object actual = classUnderTest.castTo("qwerty", "java.lang.String");
                    assertAll(
                            () -> assertThat("Unexpected type", actual, is(instanceOf(String.class))),
                            () -> assertThat("Unexpected value", actual, is(equalTo("qwerty")))
                    );
                })

//                DynamicTest.dynamicTest("Null Object -> <Object>", () -> {
//                    final Object obj = null;
//                    final boolean actual = isTypedList(obj, Object.class);
//                    assertThat(actual, is(equalTo(false)));
//                }),
//
//                DynamicTest.dynamicTest("Null String -> <Object>", () -> {
//                    final String obj = null;
//                    final boolean actual = isTypedList(obj, Object.class);
//                    assertThat(actual, is(equalTo(false)));
//                }),
//
//                DynamicTest.dynamicTest("Default Integer -> <Object>", () -> {
//                    final Integer obj = 1234;
//                    final boolean actual = isTypedList(obj, Object.class);
//                    assertThat(actual, is(equalTo(false)));
//                }),
//
//                DynamicTest.dynamicTest("Default Object -> <Object>", () -> {
//                    final Object obj = new Object();
//                    final boolean actual = isTypedList(obj, Object.class);
//                    assertThat(actual, is(equalTo(false)));
//                }),
//
//                DynamicTest.dynamicTest("Default String -> <Object>", () -> {
//                    final String obj = "qwertyuiop";
//                    final boolean actual = isTypedList(obj, Object.class);
//                    assertThat(actual, is(equalTo(false)));
//                }),
//
//                DynamicTest.dynamicTest("List ArrayList<> -> <Object>", () -> {
//                    final Object obj = new ArrayList<>();
//                    final boolean actual = isTypedList(obj, Object.class);
//                    assertThat(actual, is(equalTo(true)));
//                }),
//
//                DynamicTest.dynamicTest("List Stack<> -> <Object>", () -> {
//                    final Object obj = new Stack<>();
//                    final boolean actual = isTypedList(obj, Object.class);
//                    assertThat(actual, is(equalTo(true)));
//                })

        );
    }

}
