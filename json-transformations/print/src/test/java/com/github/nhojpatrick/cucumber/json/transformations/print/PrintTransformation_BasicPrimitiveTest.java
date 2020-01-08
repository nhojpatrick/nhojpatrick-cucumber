package com.github.nhojpatrick.cucumber.json.transformations.print;

import com.github.nhojpatrick.cucumber.json.core.validation.impl.PathArrayElementImpl;
import com.github.nhojpatrick.cucumber.json.core.validation.impl.PathElementImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.function.Executable;

import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.Optional;

import static com.github.nhojpatrick.cucumber.json.transformations.print.PrintTransformationTest.getInMemoryAppender;
import static com.github.nhojpatrick.cucumber.testing.internal.objects.TestingInternalObjectsConstants.getMapBasicPrimitives;
import static com.github.nhojpatrick.hamcrest.optionals.IsOptional.optionalContains;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PrintTransformation_BasicPrimitiveTest {

    private static final String TYPE = "BasicPrimitive";

    @TestFactory
    @DisplayName("PrintTransformation " + TYPE + " Array Paths Tests")
    public Collection<DynamicTest> arrayPaths() {

        return Arrays.asList(

                DynamicTest.dynamicTest("objects_array", () -> {
                    final String key = "objects_array";

                    final Executable testMethod = () -> new PrintTransformation()
                            .perform(new PathElementImpl(key), getMapBasicPrimitives(), null);
                    final UnsupportedOperationException thrown = assertThrows(UnsupportedOperationException.class, testMethod);
                    assertAll("Checking Exception",
                            () -> assertThat(thrown.getMessage(), is(equalTo("PrintTransformation FIXME !containsKey"))),
                            () -> assertThat(thrown.getCause(), is(nullValue()))
                    );
                }),

                DynamicTest.dynamicTest("objects_array[1]", () -> {
                    final String key = "objects_array";
                    final int arrayIndex = 1;

                    final PathArrayElementImpl pathElement = new PathArrayElementImpl(String.format("%s[%s]", key, arrayIndex), key, arrayIndex);
                    final Executable testMethod = () -> new PrintTransformation()
                            .perform(pathElement, getMapBasicPrimitives(), null);
                    final UnsupportedOperationException thrown = assertThrows(UnsupportedOperationException.class, testMethod);
                    assertAll("Checking Exception",
                            () -> assertThat(thrown.getMessage(), is(equalTo("PrintTransformation FIXME !containsKey"))),
                            () -> assertThat(thrown.getCause(), is(nullValue()))
                    );
                }),

                DynamicTest.dynamicTest("objects_array[5]", () -> {
                    final String key = "objects_array";
                    final int arrayIndex = 5;

                    final PathArrayElementImpl pathElement = new PathArrayElementImpl(String.format("%s[%s]", key, arrayIndex), key, arrayIndex);
                    final Executable testMethod = () -> new PrintTransformation()
                            .perform(pathElement, getMapBasicPrimitives(), null);
                    final UnsupportedOperationException thrown = assertThrows(UnsupportedOperationException.class, testMethod);
                    assertAll("Checking Exception",
                            () -> assertThat(thrown.getMessage(), is(equalTo("PrintTransformation FIXME !containsKey"))),
                            () -> assertThat(thrown.getCause(), is(nullValue()))
                    );
                }),

                DynamicTest.dynamicTest("primitive", () -> {
                    final String key = "primitive";

                    final Executable testMethod = () -> new PrintTransformation()
                            .perform(new PathElementImpl(key), getMapBasicPrimitives(), null);
                    final UnsupportedOperationException thrown = assertThrows(UnsupportedOperationException.class, testMethod);
                    assertAll("Checking Exception",
                            () -> assertThat(thrown.getMessage(), is(equalTo("PrintTransformation FIXME !containsKey"))),
                            () -> assertThat(thrown.getCause(), is(nullValue()))
                    );
                }),

                DynamicTest.dynamicTest("primitive[1]", () -> {
                    final String key = "primitive";
                    final int arrayIndex = 1;

                    final PathArrayElementImpl pathElement = new PathArrayElementImpl(String.format("%s[%s]", key, arrayIndex), key, arrayIndex);
                    final Executable testMethod = () -> new PrintTransformation()
                            .perform(pathElement, getMapBasicPrimitives(), null);
                    final UnsupportedOperationException thrown = assertThrows(UnsupportedOperationException.class, testMethod);
                    assertAll("Checking Exception",
                            () -> assertThat(thrown.getMessage(), is(equalTo("PrintTransformation FIXME !containsKey"))),
                            () -> assertThat(thrown.getCause(), is(nullValue()))
                    );
                }),

                DynamicTest.dynamicTest("primitive[5]", () -> {
                    final String key = "primitive";
                    final int arrayIndex = 5;

                    final PathArrayElementImpl pathElement = new PathArrayElementImpl(String.format("%s[%s]", key, arrayIndex), key, arrayIndex);
                    final Executable testMethod = () -> new PrintTransformation()
                            .perform(pathElement, getMapBasicPrimitives(), null);
                    final UnsupportedOperationException thrown = assertThrows(UnsupportedOperationException.class, testMethod);
                    assertAll("Checking Exception",
                            () -> assertThat(thrown.getMessage(), is(equalTo("PrintTransformation FIXME !containsKey"))),
                            () -> assertThat(thrown.getCause(), is(nullValue()))
                    );
                }),

                DynamicTest.dynamicTest("primitives_array", () -> {
                    final String key = "primitives_array";

                    final Executable testMethod = () -> new PrintTransformation()
                            .perform(new PathElementImpl(key), getMapBasicPrimitives(), null);
                    final UnsupportedOperationException thrown = assertThrows(UnsupportedOperationException.class, testMethod);
                    assertAll("Checking Exception",
                            () -> assertThat(thrown.getMessage(), is(equalTo("PrintTransformation FIXME !containsKey"))),
                            () -> assertThat(thrown.getCause(), is(nullValue()))
                    );
                }),

                DynamicTest.dynamicTest("primitives_array[1]", () -> {
                    final String key = "primitives_array";
                    final int arrayIndex = 1;

                    final PathArrayElementImpl pathElement = new PathArrayElementImpl(String.format("%s[%s]", key, arrayIndex), key, arrayIndex);
                    final Executable testMethod = () -> new PrintTransformation()
                            .perform(pathElement, getMapBasicPrimitives(), null);
                    final UnsupportedOperationException thrown = assertThrows(UnsupportedOperationException.class, testMethod);
                    assertAll("Checking Exception",
                            () -> assertThat(thrown.getMessage(), is(equalTo("PrintTransformation FIXME !containsKey"))),
                            () -> assertThat(thrown.getCause(), is(nullValue()))
                    );
                }),

                DynamicTest.dynamicTest("primitives_array[5]", () -> {
                    final String key = "primitives_array";
                    final int arrayIndex = 5;

                    final PathArrayElementImpl pathElement = new PathArrayElementImpl(String.format("%s[%s]", key, arrayIndex), key, arrayIndex);
                    final Executable testMethod = () -> new PrintTransformation()
                            .perform(pathElement, getMapBasicPrimitives(), null);
                    final UnsupportedOperationException thrown = assertThrows(UnsupportedOperationException.class, testMethod);
                    assertAll("Checking Exception",
                            () -> assertThat(thrown.getMessage(), is(equalTo("PrintTransformation FIXME !containsKey"))),
                            () -> assertThat(thrown.getCause(), is(nullValue()))
                    );
                }),

                DynamicTest.dynamicTest("unknown", () -> {
                    final String key = "unknown";

                    final Executable testMethod = () -> new PrintTransformation()
                            .perform(new PathElementImpl(key), getMapBasicPrimitives(), null);
                    final UnsupportedOperationException thrown = assertThrows(UnsupportedOperationException.class, testMethod);
                    assertAll("Checking Exception",
                            () -> assertThat(thrown.getMessage(), is(equalTo("PrintTransformation FIXME !containsKey"))),
                            () -> assertThat(thrown.getCause(), is(nullValue()))
                    );
                }),

                DynamicTest.dynamicTest("unknown[1]", () -> {
                    final String key = "unknown";
                    final int arrayIndex = 1;

                    final PathArrayElementImpl pathElement = new PathArrayElementImpl(String.format("%s[%s]", key, arrayIndex), key, arrayIndex);
                    final Executable testMethod = () -> new PrintTransformation()
                            .perform(pathElement, getMapBasicPrimitives(), null);
                    final UnsupportedOperationException thrown = assertThrows(UnsupportedOperationException.class, testMethod);
                    assertAll("Checking Exception",
                            () -> assertThat(thrown.getMessage(), is(equalTo("PrintTransformation FIXME !containsKey"))),
                            () -> assertThat(thrown.getCause(), is(nullValue()))
                    );
                })

        );
    }

    @TestFactory
    @DisplayName("PrintTransformation " + TYPE + " Primitive Paths Tests")
    public Collection<DynamicTest> primitivePaths() {

        return Arrays.asList(

                DynamicTest.dynamicTest("a_boolean", () -> {
                    final String key = "a_boolean";

                    final Map<String, Object> expected = getMapBasicPrimitives();

                    final Map<String, Object> actual = new PrintTransformation()
                            .perform(new PathElementImpl(key), getMapBasicPrimitives(), null);

                    assertThat(actual, is(notNullValue()));
                    assertAll("Checking maps",
                            () -> assertThat(actual, is(equalTo(expected))),
                            () -> assertThat(actual.get(key), is(equalTo(expected.get(key)))),
                            () -> {
                                final String prefix = "PrintTransformation \"" + key + "\"";
                                final String expectedMsg = prefix + "=\"true\"";
                                final Optional<String> message = getInMemoryAppender()
                                        .getMessages()
                                        .stream()
                                        .filter(p -> p.startsWith(prefix))
                                        .findFirst();
                                assertThat(message, optionalContains(expectedMsg));
                            }
                    );
                }),

                DynamicTest.dynamicTest("a_float", () -> {
                    final String key = "a_float";

                    final Map<String, Object> expected = getMapBasicPrimitives();

                    final Map<String, Object> actual = new PrintTransformation()
                            .perform(new PathElementImpl(key), getMapBasicPrimitives(), null);

                    assertThat(actual, is(notNullValue()));
                    assertAll("Checking maps",
                            () -> assertThat(actual, is(equalTo(expected))),
                            () -> assertThat(actual.get(key), is(equalTo(expected.get(key)))),
                            () -> {
                                final String prefix = "PrintTransformation \"" + key + "\"";
                                final String expectedMsg = prefix + "=\"12.34\"";
                                final Optional<String> message = getInMemoryAppender()
                                        .getMessages()
                                        .stream()
                                        .filter(p -> p.startsWith(prefix))
                                        .findFirst();
                                assertThat(message, optionalContains(expectedMsg));
                            }
                    );
                }),

                DynamicTest.dynamicTest("a_integer", () -> {
                    final String key = "a_integer";

                    final Map<String, Object> expected = getMapBasicPrimitives();

                    final Map<String, Object> actual = new PrintTransformation()
                            .perform(new PathElementImpl(key), getMapBasicPrimitives(), null);

                    assertThat(actual, is(notNullValue()));
                    assertAll("Checking maps",
                            () -> assertThat(actual, is(equalTo(expected))),
                            () -> assertThat(actual.get(key), is(equalTo(expected.get(key)))),
                            () -> {
                                final String prefix = "PrintTransformation \"" + key + "\"";
                                final String expectedMsg = prefix + "=\"1234\"";
                                final Optional<String> message = getInMemoryAppender()
                                        .getMessages()
                                        .stream()
                                        .filter(p -> p.startsWith(prefix))
                                        .findFirst();
                                assertThat(message, optionalContains(expectedMsg));
                            }
                    );
                }),

                DynamicTest.dynamicTest("a_null", () -> {
                    final String key = "a_null";

                    final Map<String, Object> expected = getMapBasicPrimitives();

                    final Map<String, Object> actual = new PrintTransformation()
                            .perform(new PathElementImpl(key), getMapBasicPrimitives(), null);

                    assertThat(actual, is(notNullValue()));
                    assertAll("Checking maps",
                            () -> assertThat(actual, is(equalTo(expected))),
                            () -> assertThat(actual.get(key), is(equalTo(expected.get(key)))),
                            () -> {
                                final String prefix = "PrintTransformation \"" + key + "\"";
                                final String expectedMsg = prefix + "=\"null\"";
                                final Optional<String> message = getInMemoryAppender()
                                        .getMessages()
                                        .stream()
                                        .filter(p -> p.startsWith(prefix))
                                        .findFirst();
                                assertThat(message, optionalContains(expectedMsg));
                            }
                    );
                }),

                DynamicTest.dynamicTest("a_object", () -> {
                    final String key = "a_object";

                    final Map<String, Object> expected = getMapBasicPrimitives();

                    final Map<String, Object> actual = new PrintTransformation()
                            .perform(new PathElementImpl(key), getMapBasicPrimitives(), null);

                    assertThat(actual, is(notNullValue()));
                    assertAll("Checking maps",
                            () -> assertThat(actual, is(equalTo(expected))),
                            () -> assertThat(actual.get(key), is(equalTo(expected.get(key)))),
                            () -> {
                                final String prefix = "PrintTransformation \"" + key + "\"";
                                final String expectedMsg = prefix + "=\"{}\"";
                                final Optional<String> message = getInMemoryAppender()
                                        .getMessages()
                                        .stream()
                                        .filter(p -> p.startsWith(prefix))
                                        .findFirst();
                                assertThat(message, optionalContains(expectedMsg));
                            }
                    );
                }),

                DynamicTest.dynamicTest("a_string", () -> {
                    final String key = "a_string";

                    final Map<String, Object> expected = getMapBasicPrimitives();

                    final Map<String, Object> actual = new PrintTransformation()
                            .perform(new PathElementImpl(key), getMapBasicPrimitives(), null);

                    assertThat(actual, is(notNullValue()));
                    assertAll("Checking maps",
                            () -> assertThat(actual, is(equalTo(expected))),
                            () -> assertThat(actual.get(key), is(equalTo(expected.get(key)))),
                            () -> {
                                final String prefix = "PrintTransformation \"" + key + "\"";
                                final String expectedMsg = prefix + "=\"aValue\"";
                                final Optional<String> message = getInMemoryAppender()
                                        .getMessages()
                                        .stream()
                                        .filter(p -> p.startsWith(prefix))
                                        .findFirst();
                                assertThat(message, optionalContains(expectedMsg));
                            }
                    );
                }),

                DynamicTest.dynamicTest("unknown", () -> {
                    final String key = "unknown";

                    final Executable testMethod = () -> new PrintTransformation()
                            .perform(new PathElementImpl(key), getMapBasicPrimitives(), null);
                    final UnsupportedOperationException thrown = assertThrows(UnsupportedOperationException.class, testMethod);
                    assertAll("Checking Exception",
                            () -> assertThat(thrown.getMessage(), is(equalTo("PrintTransformation FIXME !containsKey"))),
                            () -> assertThat(thrown.getCause(), is(nullValue()))
                    );
                })

        );
    }

}
