package com.github.nhojpatrick.cucumber.json.transformations.print;

import com.github.nhojpatrick.cucumber.json.core.exceptions.IllegalPathOperationException;
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
import static com.github.nhojpatrick.cucumber.testing.internal.objects.TestingInternalObjectsConstants.getMapBasicArrays;
import static com.github.nhojpatrick.hamcrest.optionals.IsOptional.optionalContains;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PrintTransformation_BasicArraysTest {

    private static final String TYPE = "BasicArray";

    @TestFactory
    @DisplayName("Print Transformation " + TYPE + " Array Paths Tests")
    public Collection<DynamicTest> arrayPaths() {

        return Arrays.asList(

                DynamicTest.dynamicTest("objects_array", () -> {
                    final String key = "objects_array";

                    final Map<String, Object> expected = getMapBasicArrays();

                    final Map<String, Object> actual = new PrintTransformation()
                            .perform(new PathElementImpl(key), getMapBasicArrays(), null);

                    assertThat(actual, is(notNullValue()));
                    assertAll("Checking maps",
                            () -> assertThat(actual, is(equalTo(expected))),
                            () -> assertThat(actual.get(key), is(equalTo(expected.get(key)))),
                            () -> {
                                final String prefix = "Printing Path '" + key + "' Value ";
                                final String expectedMsg = prefix + "'[{object_array_id=aObjectArrayId}, {object_array_id=bObjectArrayId}, {object_array_id=cObjectArrayId}, {object_array_id=dObjectArrayId}]'";
                                final Optional<String> message = getInMemoryAppender()
                                        .getMessages()
                                        .stream()
                                        .filter(p -> p.startsWith(prefix))
                                        .findFirst();
                                assertThat(message, optionalContains(expectedMsg));
                            }
                    );
                }),

                DynamicTest.dynamicTest("objects_array[1]", () -> {
                    final String key = "objects_array";
                    final int arrayIndex = 1;

                    final Map<String, Object> expected = getMapBasicArrays();

                    final PathArrayElementImpl pathElement = new PathArrayElementImpl(String.format("%s[%s]", key, arrayIndex), key, arrayIndex);
                    final Map<String, Object> actual = new PrintTransformation()
                            .perform(pathElement, getMapBasicArrays(), null);

                    assertThat(actual, is(notNullValue()));
                    assertAll("Checking maps",
                            () -> assertThat(actual, is(equalTo(expected))),
                            () -> assertThat(actual.get(key), is(equalTo(expected.get(key)))),
                            () -> {
                                final String prefix = "Printing Path '" + key + "[" + arrayIndex + "]' Value ";
                                final String expectedMsg = prefix + "'{object_array_id=bObjectArrayId}'";
                                final Optional<String> message = getInMemoryAppender()
                                        .getMessages()
                                        .stream()
                                        .filter(p -> p.startsWith(prefix))
                                        .findFirst();
                                assertThat(message, optionalContains(expectedMsg));
                            }
                    );
                }),

                DynamicTest.dynamicTest("objects_array[5]", () -> {
                    final String key = "objects_array";
                    final int arrayIndex = 5;

                    final PathArrayElementImpl pathElement = new PathArrayElementImpl(String.format("%s[%s]", key, arrayIndex), key, arrayIndex);
                    final Executable testMethod = () -> new PrintTransformation()
                            .perform(pathElement, getMapBasicArrays(), null);
                    final IllegalPathOperationException thrown = assertThrows(IllegalPathOperationException.class, testMethod);
                    assertAll("Checking Exception",
                            () -> assertThat(thrown.getMessage(), is(equalTo(String.format(
                                    "Unable to print path '%s', beyond index of '%s'.",
                                    key,
                                    3
                            )))),
                            () -> assertThat(thrown.getCause(), is(nullValue()))
                    );
                }),

                DynamicTest.dynamicTest("primitive", () -> {
                    final String key = "primitive";

                    final Map<String, Object> expected = getMapBasicArrays();

                    final Map<String, Object> actual = new PrintTransformation()
                            .perform(new PathElementImpl(key), getMapBasicArrays(), null);

                    assertThat(actual, is(notNullValue()));
                    assertAll("Checking maps",
                            () -> assertThat(actual, is(equalTo(expected))),
                            () -> assertThat(actual.get(key), is(equalTo(expected.get(key)))),
                            () -> {
                                final String prefix = "Printing Path '" + key + "' Value ";
                                final String expectedMsg = prefix + "'aPrimitive'";
                                final Optional<String> message = getInMemoryAppender()
                                        .getMessages()
                                        .stream()
                                        .filter(p -> p.startsWith(prefix))
                                        .findFirst();
                                assertThat(message, optionalContains(expectedMsg));
                            }
                    );
                }),

                DynamicTest.dynamicTest("primitive[1]", () -> {
                    final String key = "primitive";
                    final int arrayIndex = 1;

                    final PathArrayElementImpl pathElement = new PathArrayElementImpl(String.format("%s[%s]", key, arrayIndex), key, arrayIndex);
                    final Executable testMethod = () -> new PrintTransformation()
                            .perform(pathElement, getMapBasicArrays(), null);

                    final IllegalPathOperationException thrown = assertThrows(IllegalPathOperationException.class, testMethod);
                    assertAll("Checking Exception",
                            () -> assertThat(thrown.getMessage(), is(equalTo(String.format(
                                    "Unable to print path '%s', as is not Array.",
                                    key
                            )))),
                            () -> assertThat(thrown.getCause(), is(nullValue()))
                    );
                }),

                DynamicTest.dynamicTest("primitive[5]", () -> {
                    final String key = "primitive";
                    final int arrayIndex = 5;

                    final PathArrayElementImpl pathElement = new PathArrayElementImpl(String.format("%s[%s]", key, arrayIndex), key, arrayIndex);
                    final Executable testMethod = () -> new PrintTransformation()
                            .perform(pathElement, getMapBasicArrays(), null);
                    final IllegalPathOperationException thrown = assertThrows(IllegalPathOperationException.class, testMethod);
                    assertAll("Checking Exception",
                            () -> assertThat(thrown.getMessage(), is(equalTo(String.format(
                                    "Unable to print path '%s', as is not Array.",
                                    key
                            )))),
                            () -> assertThat(thrown.getCause(), is(nullValue()))
                    );
                }),

                DynamicTest.dynamicTest("primitives_array", () -> {
                    final String key = "primitives_array";

                    final Map<String, Object> expected = getMapBasicArrays();

                    final Map<String, Object> actual = new PrintTransformation()
                            .perform(new PathElementImpl(key), getMapBasicArrays(), null);

                    assertThat(actual, is(notNullValue()));
                    assertAll("Checking maps",
                            () -> assertThat(actual, is(equalTo(expected))),
                            () -> assertThat(actual.get(key), is(equalTo(expected.get(key)))),
                            () -> {
                                final String prefix = "Printing Path '" + key + "' Value ";
                                final String expectedMsg = prefix + "'[aPrimitiveArray, bPrimitiveArray, cPrimitiveArray, dPrimitiveArray]'";
                                final Optional<String> message = getInMemoryAppender()
                                        .getMessages()
                                        .stream()
                                        .filter(p -> p.startsWith(prefix))
                                        .findFirst();
                                assertThat(message, optionalContains(expectedMsg));
                            }
                    );
                }),

                DynamicTest.dynamicTest("primitives_array[1]", () -> {
                    final String key = "primitives_array";
                    final int arrayIndex = 1;

                    final Map<String, Object> expected = getMapBasicArrays();

                    final PathArrayElementImpl pathElement = new PathArrayElementImpl(String.format("%s[%s]", key, arrayIndex), key, arrayIndex);
                    final Map<String, Object> actual = new PrintTransformation()
                            .perform(pathElement, getMapBasicArrays(), null);

                    assertThat(actual, is(notNullValue()));
                    assertAll("Checking maps",
                            () -> assertThat(actual, is(equalTo(expected))),
                            () -> assertThat(actual.get(key), is(equalTo(expected.get(key)))),
                            () -> {
                                final String prefix = "Printing Path '" + key + "[" + arrayIndex + "]' Value ";
                                final String expectedMsg = prefix + "'bPrimitiveArray'";
                                final Optional<String> message = getInMemoryAppender()
                                        .getMessages()
                                        .stream()
                                        .filter(p -> p.startsWith(prefix))
                                        .findFirst();
                                assertThat(message, optionalContains(expectedMsg));
                            }
                    );
                }),

                DynamicTest.dynamicTest("primitives_array[5]", () -> {
                    final String key = "primitives_array";
                    final int arrayIndex = 5;

                    final PathArrayElementImpl pathElement = new PathArrayElementImpl(String.format("%s[%s]", key, arrayIndex), key, arrayIndex);
                    final Executable testMethod = () -> new PrintTransformation()
                            .perform(pathElement, getMapBasicArrays(), null);
                    final IllegalPathOperationException thrown = assertThrows(IllegalPathOperationException.class, testMethod);
                    assertAll("Checking Exception",
                            () -> assertThat(thrown.getMessage(), is(equalTo(String.format(
                                    "Unable to print path '%s', beyond index of '%s'.",
                                    key,
                                    3
                            )))),
                            () -> assertThat(thrown.getCause(), is(nullValue()))
                    );
                }),

                DynamicTest.dynamicTest("unknown", () -> {
                    final String key = "unknown";

                    final Executable testMethod = () -> new PrintTransformation()
                            .perform(new PathElementImpl(key), getMapBasicArrays(), null);
                    final IllegalPathOperationException thrown = assertThrows(IllegalPathOperationException.class, testMethod);
                    assertAll("Checking Exception",
                            () -> assertThat(thrown.getMessage(), is(equalTo(String.format(
                                    "Unable to print path '%s', does not exist.",
                                    key
                            )))),
                            () -> assertThat(thrown.getCause(), is(nullValue()))
                    );
                }),

                DynamicTest.dynamicTest("unknown[1]", () -> {
                    final String key = "unknown";
                    final int arrayIndex = 1;

                    final PathArrayElementImpl pathElement = new PathArrayElementImpl(String.format("%s[%s]", key, arrayIndex), key, arrayIndex);
                    final Executable testMethod = () -> new PrintTransformation()
                            .perform(pathElement, getMapBasicArrays(), null);
                    final IllegalPathOperationException thrown = assertThrows(IllegalPathOperationException.class, testMethod);
                    assertAll("Checking Exception",
                            () -> assertThat(thrown.getMessage(), is(equalTo(String.format(
                                    "Unable to print path '%s', does not exist.",
                                    key
                            )))),
                            () -> assertThat(thrown.getCause(), is(nullValue()))
                    );
                })

        );
    }

    @TestFactory
    @DisplayName("Print Transformation " + TYPE + " Primitive Paths Tests")
    public Collection<DynamicTest> primitivePaths() {

        return Arrays.asList(

                DynamicTest.dynamicTest("a_boolean", () -> {
                    final String key = "a_boolean";

                    final Executable testMethod = () -> new PrintTransformation()
                            .perform(new PathElementImpl(key), getMapBasicArrays(), null);
                    final IllegalPathOperationException thrown = assertThrows(IllegalPathOperationException.class, testMethod);
                    assertAll("Checking Exception",
                            () -> assertThat(thrown.getMessage(), is(equalTo(String.format(
                                    "Unable to print path '%s', does not exist.",
                                    key
                            )))),
                            () -> assertThat(thrown.getCause(), is(nullValue()))
                    );
                }),

                DynamicTest.dynamicTest("a_float", () -> {
                    final String key = "a_float";

                    final Executable testMethod = () -> new PrintTransformation()
                            .perform(new PathElementImpl(key), getMapBasicArrays(), null);
                    final IllegalPathOperationException thrown = assertThrows(IllegalPathOperationException.class, testMethod);
                    assertAll("Checking Exception",
                            () -> assertThat(thrown.getMessage(), is(equalTo(String.format(
                                    "Unable to print path '%s', does not exist.",
                                    key
                            )))),
                            () -> assertThat(thrown.getCause(), is(nullValue()))
                    );
                }),

                DynamicTest.dynamicTest("a_integer", () -> {
                    final String key = "a_integer";

                    final Executable testMethod = () -> new PrintTransformation()
                            .perform(new PathElementImpl(key), getMapBasicArrays(), null);
                    final IllegalPathOperationException thrown = assertThrows(IllegalPathOperationException.class, testMethod);
                    assertAll("Checking Exception",
                            () -> assertThat(thrown.getMessage(), is(equalTo(String.format(
                                    "Unable to print path '%s', does not exist.",
                                    key
                            )))),
                            () -> assertThat(thrown.getCause(), is(nullValue()))
                    );
                }),

                DynamicTest.dynamicTest("a_null", () -> {
                    final String key = "a_null";

                    final Executable testMethod = () -> new PrintTransformation()
                            .perform(new PathElementImpl(key), getMapBasicArrays(), null);
                    final IllegalPathOperationException thrown = assertThrows(IllegalPathOperationException.class, testMethod);
                    assertAll("Checking Exception",
                            () -> assertThat(thrown.getMessage(), is(equalTo(String.format(
                                    "Unable to print path '%s', does not exist.",
                                    key
                            )))),
                            () -> assertThat(thrown.getCause(), is(nullValue()))
                    );
                }),

                DynamicTest.dynamicTest("a_object", () -> {
                    final String key = "a_object";

                    final Executable testMethod = () -> new PrintTransformation()
                            .perform(new PathElementImpl(key), getMapBasicArrays(), null);
                    final IllegalPathOperationException thrown = assertThrows(IllegalPathOperationException.class, testMethod);
                    assertAll("Checking Exception",
                            () -> assertThat(thrown.getMessage(), is(equalTo(String.format(
                                    "Unable to print path '%s', does not exist.",
                                    key
                            )))),
                            () -> assertThat(thrown.getCause(), is(nullValue()))
                    );
                }),

                DynamicTest.dynamicTest("a_string", () -> {
                    final String key = "a_string";

                    final Executable testMethod = () -> new PrintTransformation()
                            .perform(new PathElementImpl(key), getMapBasicArrays(), null);
                    final IllegalPathOperationException thrown = assertThrows(IllegalPathOperationException.class, testMethod);
                    assertAll("Checking Exception",
                            () -> assertThat(thrown.getMessage(), is(equalTo(String.format(
                                    "Unable to print path '%s', does not exist.",
                                    key
                            )))),
                            () -> assertThat(thrown.getCause(), is(nullValue()))
                    );
                }),

                DynamicTest.dynamicTest("unknown", () -> {
                    final String key = "unknown";

                    final Executable testMethod = () -> new PrintTransformation()
                            .perform(new PathElementImpl(key), getMapBasicArrays(), null);
                    final IllegalPathOperationException thrown = assertThrows(IllegalPathOperationException.class, testMethod);
                    assertAll("Checking Exception",
                            () -> assertThat(thrown.getMessage(), is(equalTo(String.format(
                                    "Unable to print path '%s', does not exist.",
                                    key
                            )))),
                            () -> assertThat(thrown.getCause(), is(nullValue()))
                    );
                })

        );
    }

}
