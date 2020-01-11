package com.github.nhojpatrick.cucumber.json.core.castto;

import com.github.nhojpatrick.cucumber.json.core.castto.exceptions.UnsupportedDataTypeConversionException;
import com.github.nhojpatrick.cucumber.json.core.castto.exceptions.UnsupportedDataTypeException;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.function.Executable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;

import static com.github.nhojpatrick.hamcrest.lang.IsToString.toStringGenerated;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

public class CastToUtilTest {

    @TestFactory
    public Collection<DynamicTest> exceptions() {

        final CastToUtil classUnderTest = new CastToUtil();

        return Arrays.asList(

                dynamicTest("Unknown", () -> {
                    final Executable testMethod = () -> classUnderTest.castTo("true", "Unknown");
                    final UnsupportedDataTypeException thrown = assertThrows(UnsupportedDataTypeException.class, testMethod);
                    assertThat(thrown.getMessage(), is(equalTo("Unsupported data type 'Unknown'.")));
                }),

                dynamicTest("Boolean invalid", () -> {
                    final Executable testMethod = () -> classUnderTest.castTo("string", "java.lang.Boolean");
                    final UnsupportedDataTypeConversionException thrown = assertThrows(UnsupportedDataTypeConversionException.class, testMethod);
                    assertThat(thrown.getMessage(), is(equalTo("Unsupported data type conversion for type 'java.lang.Boolean' from value 'string'.")));
                }),

                dynamicTest("Double invalid", () -> {
                    final Executable testMethod = () -> classUnderTest.castTo("string", "java.lang.Double");
                    final UnsupportedDataTypeConversionException thrown = assertThrows(UnsupportedDataTypeConversionException.class, testMethod);
                    assertThat(thrown.getMessage(), is(equalTo("Unsupported data type conversion for type 'java.lang.Double' from value 'string'.")));
                }),

                dynamicTest("Float invalid", () -> {
                    final Executable testMethod = () -> classUnderTest.castTo("string", "java.lang.Float");
                    final UnsupportedDataTypeConversionException thrown = assertThrows(UnsupportedDataTypeConversionException.class, testMethod);
                    assertThat(thrown.getMessage(), is(equalTo("Unsupported data type conversion for type 'java.lang.Float' from value 'string'.")));
                }),

                dynamicTest("Integer invalid", () -> {
                    final Executable testMethod = () -> classUnderTest.castTo("string", "java.lang.Integer");
                    final UnsupportedDataTypeConversionException thrown = assertThrows(UnsupportedDataTypeConversionException.class, testMethod);
                    assertThat(thrown.getMessage(), is(equalTo("Unsupported data type conversion for type 'java.lang.Integer' from value 'string'.")));
                }),

                dynamicTest("Long invalid", () -> {
                    final Executable testMethod = () -> classUnderTest.castTo("string", "java.lang.Long");
                    final UnsupportedDataTypeConversionException thrown = assertThrows(UnsupportedDataTypeConversionException.class, testMethod);
                    assertThat(thrown.getMessage(), is(equalTo("Unsupported data type conversion for type 'java.lang.Long' from value 'string'.")));
                })//,
//
//                dynamicTest("List -> <null>", () -> {
//                    final Executable testMethod = () -> isTypedList(new ArrayList(), null);
//                    final NullGenericsValueException thrown = assertThrows(NullGenericsValueException.class, testMethod);
//                    assertThat(thrown.getMessage(), is(equalTo("Null Generics Value Type.")));
//                }),
//
//                dynamicTest("Object -> <null>", () -> {
//                    final Executable testMethod = () -> isTypedList(new Object(), null);
//                    final NullGenericsValueException thrown = assertThrows(NullGenericsValueException.class, testMethod);
//                    assertThat(thrown.getMessage(), is(equalTo("Null Generics Value Type.")));
//                })

        );
    }

    @TestFactory
    public Collection<DynamicTest> castTo() {

        final CastToUtil classUnderTest = new CastToUtil();

        return Arrays.asList(

                dynamicTest("Boolean", () -> {
                    final Object actual = classUnderTest.castTo("true", "java.lang.Boolean");
                    assertAll(
                            () -> assertThat("Unexpected type", actual, is(instanceOf(Boolean.class))),
                            () -> assertThat("Unexpected value", actual, is(equalTo(Boolean.TRUE)))
                    );
                }),

                dynamicTest("Double", () -> {
                    final Object actual = classUnderTest.castTo("1234", "java.lang.Double");
                    assertAll(
                            () -> assertThat("Unexpected type", actual, is(instanceOf(Double.class))),
                            () -> assertThat("Unexpected value", actual, is(equalTo(Double.valueOf(1234))))
                    );
                }),

                dynamicTest("Float", () -> {
                    final Object actual = classUnderTest.castTo("1234", "java.lang.Float");
                    assertAll(
                            () -> assertThat("Unexpected type", actual, is(instanceOf(Float.class))),
                            () -> assertThat("Unexpected value", actual, is(equalTo(Float.valueOf(1234))))
                    );
                }),

                dynamicTest("Integer", () -> {
                    final Object actual = classUnderTest.castTo("1234", "java.lang.Integer");
                    assertAll(
                            () -> assertThat("Unexpected type", actual, is(instanceOf(Integer.class))),
                            () -> assertThat("Unexpected value", actual, is(equalTo(Integer.valueOf(1234))))
                    );
                }),

                dynamicTest("Long", () -> {
                    final Object actual = classUnderTest.castTo("1234", "java.lang.Long");
                    assertAll(
                            () -> assertThat("Unexpected type", actual, is(instanceOf(Long.class))),
                            () -> assertThat("Unexpected value", actual, is(equalTo(Long.valueOf(1234))))
                    );
                }),

                dynamicTest("Null", () -> {
                    final Object actual = classUnderTest.castTo("", "null");
                    assertAll(
                            () -> assertThat("Unexpected value", actual, is(nullValue()))
                    );
                }),

                dynamicTest("String", () -> {
                    final Object actual = classUnderTest.castTo("qwerty", "java.lang.String");
                    assertAll(
                            () -> assertThat("Unexpected type", actual, is(instanceOf(String.class))),
                            () -> assertThat("Unexpected value", actual, is(equalTo("qwerty")))
                    );
                }),

                dynamicTest("JsonObject", () -> {
                    final Object actual = classUnderTest.castTo(null, "JsonObject");
                    assertAll(
                            () -> assertThat("Unexpected type", actual, is(instanceOf(HashMap.class))),
                            () -> assertThat("Unexpected value", actual, is(toStringGenerated("{}")))
                    );
                }),

                dynamicTest("JsonArray<JsonObject>", () -> {
                    final Object actual = classUnderTest.castTo(null, "JsonArray<JsonObject>");
                    assertAll(
                            () -> assertThat("Unexpected type", actual, is(instanceOf(ArrayList.class))),
                            () -> assertThat("Unexpected value", actual, is(toStringGenerated("[]")))
                    );
                }),

                dynamicTest("JsonArray<java.lang.Boolean>", () -> {
                    final Object actual = classUnderTest.castTo(null, "JsonArray<java.lang.Boolean>");
                    assertAll(
                            () -> assertThat("Unexpected type", actual, is(instanceOf(ArrayList.class))),
                            () -> assertThat("Unexpected value", actual, is(toStringGenerated("[]")))
                    );
                }),

                dynamicTest("JsonArray<java.lang.Double>", () -> {
                    final Object actual = classUnderTest.castTo(null, "JsonArray<java.lang.Double>");
                    assertAll(
                            () -> assertThat("Unexpected type", actual, is(instanceOf(ArrayList.class))),
                            () -> assertThat("Unexpected value", actual, is(toStringGenerated("[]")))
                    );
                }),

                dynamicTest("JsonArray<java.lang.Float>", () -> {
                    final Object actual = classUnderTest.castTo(null, "JsonArray<java.lang.Float>");
                    assertAll(
                            () -> assertThat("Unexpected type", actual, is(instanceOf(ArrayList.class))),
                            () -> assertThat("Unexpected value", actual, is(toStringGenerated("[]")))
                    );
                }),

                dynamicTest("JsonArray<java.lang.Long>", () -> {
                    final Object actual = classUnderTest.castTo(null, "JsonArray<java.lang.Long>");
                    assertAll(
                            () -> assertThat("Unexpected type", actual, is(instanceOf(ArrayList.class))),
                            () -> assertThat("Unexpected value", actual, is(toStringGenerated("[]")))
                    );
                }),

                dynamicTest("JsonArray<java.lang.Integer>", () -> {
                    final Object actual = classUnderTest.castTo(null, "JsonArray<java.lang.Integer>");
                    assertAll(
                            () -> assertThat("Unexpected type", actual, is(instanceOf(ArrayList.class))),
                            () -> assertThat("Unexpected value", actual, is(toStringGenerated("[]")))
                    );
                }),

                dynamicTest("JsonArray<java.lang.String>", () -> {
                    final Object actual = classUnderTest.castTo(null, "JsonArray<java.lang.String>");
                    assertAll(
                            () -> assertThat("Unexpected type", actual, is(instanceOf(ArrayList.class))),
                            () -> assertThat("Unexpected value", actual, is(toStringGenerated("[]")))
                    );
                })

//                dynamicTest("Null Object -> <Object>", () -> {
//                    final Object obj = null;
//                    final boolean actual = isTypedList(obj, Object.class);
//                    assertThat(actual, is(equalTo(false)));
//                }),
//
//                dynamicTest("Null String -> <Object>", () -> {
//                    final String obj = null;
//                    final boolean actual = isTypedList(obj, Object.class);
//                    assertThat(actual, is(equalTo(false)));
//                }),
//
//                dynamicTest("Default Integer -> <Object>", () -> {
//                    final Integer obj = 1234;
//                    final boolean actual = isTypedList(obj, Object.class);
//                    assertThat(actual, is(equalTo(false)));
//                }),
//
//                dynamicTest("Default Object -> <Object>", () -> {
//                    final Object obj = new Object();
//                    final boolean actual = isTypedList(obj, Object.class);
//                    assertThat(actual, is(equalTo(false)));
//                }),
//
//                dynamicTest("Default String -> <Object>", () -> {
//                    final String obj = "qwertyuiop";
//                    final boolean actual = isTypedList(obj, Object.class);
//                    assertThat(actual, is(equalTo(false)));
//                }),
//
//                dynamicTest("List ArrayList<> -> <Object>", () -> {
//                    final Object obj = new ArrayList<>();
//                    final boolean actual = isTypedList(obj, Object.class);
//                    assertThat(actual, is(equalTo(true)));
//                }),
//
//                dynamicTest("List Stack<> -> <Object>", () -> {
//                    final Object obj = new Stack<>();
//                    final boolean actual = isTypedList(obj, Object.class);
//                    assertThat(actual, is(equalTo(true)));
//                })

        );
    }

}
