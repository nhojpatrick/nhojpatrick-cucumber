package com.github.nhojpatrick.cucumber.json.transformations.print.tests;

import com.github.nhojpatrick.cucumber.json.core.exceptions.IllegalPathOperationException;
import com.github.nhojpatrick.cucumber.json.core.validation.PathElement;
import com.github.nhojpatrick.cucumber.json.core.validation.impl.PathArrayElementImpl;
import com.github.nhojpatrick.cucumber.json.core.validation.impl.PathAttributeElementImpl;
import com.github.nhojpatrick.cucumber.json.transformations.print.PrintTransformation;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.function.Executable;

import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.Optional;

import static com.github.nhojpatrick.cucumber.json.transformations.print.tests.PrintTransformationTest.getInMemoryAppender;
import static com.github.nhojpatrick.cucumber.testing.internal.objects.TestingInternalObjectsConstants.getMapBasicAttributes;
import static com.github.nhojpatrick.hamcrest.optionals.IsOptional.optionalContains;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

public class PrintTransformation_BasicAttributesTest {

    private static final String TYPE = "BasicAttribute";

    @TestFactory
    @DisplayName("Print Transformation " + TYPE + " Array Paths Tests")
    public Collection<DynamicTest> arrayPaths() {

        return Arrays.asList(

                dynamicTest("a_boolean[1]", () -> {
                    final String key = "a_boolean";
                    final int arrayIndex = 1;

                    final PathElement pathElement = new PathArrayElementImpl(String.format("%s[%s]", key, arrayIndex), key, arrayIndex);

                    final Executable testMethod = () -> new PrintTransformation()
                            .perform(pathElement, getMapBasicAttributes(), null);

                    final IllegalPathOperationException thrown = assertThrows(IllegalPathOperationException.class, testMethod);
                    assertAll("Checking Exception",
                            () -> assertThat(thrown.getMessage(), is(equalTo(String.format(
                                    "Unable to print path '%s', as is not Array.",
                                    key
                            )))),
                            () -> assertThat(thrown.getCause(), is(nullValue()))
                    );
                }),

                dynamicTest("a_float[1]", () -> {
                    final String key = "a_float";
                    final int arrayIndex = 1;

                    final PathElement pathElement = new PathArrayElementImpl(String.format("%s[%s]", key, arrayIndex), key, arrayIndex);

                    final Executable testMethod = () -> new PrintTransformation()
                            .perform(pathElement, getMapBasicAttributes(), null);

                    final IllegalPathOperationException thrown = assertThrows(IllegalPathOperationException.class, testMethod);
                    assertAll("Checking Exception",
                            () -> assertThat(thrown.getMessage(), is(equalTo(String.format(
                                    "Unable to print path '%s', as is not Array.",
                                    key
                            )))),
                            () -> assertThat(thrown.getCause(), is(nullValue()))
                    );
                }),

                dynamicTest("a_integer[1]", () -> {
                    final String key = "a_integer";
                    final int arrayIndex = 1;

                    final PathElement pathElement = new PathArrayElementImpl(String.format("%s[%s]", key, arrayIndex), key, arrayIndex);

                    final Executable testMethod = () -> new PrintTransformation()
                            .perform(pathElement, getMapBasicAttributes(), null);

                    final IllegalPathOperationException thrown = assertThrows(IllegalPathOperationException.class, testMethod);
                    assertAll("Checking Exception",
                            () -> assertThat(thrown.getMessage(), is(equalTo(String.format(
                                    "Unable to print path '%s', as is not Array.",
                                    key
                            )))),
                            () -> assertThat(thrown.getCause(), is(nullValue()))
                    );
                }),

                dynamicTest("a_null[1]", () -> {
                    final String key = "a_null";
                    final int arrayIndex = 1;

                    final PathElement pathElement = new PathArrayElementImpl(String.format("%s[%s]", key, arrayIndex), key, arrayIndex);

                    final Executable testMethod = () -> new PrintTransformation()
                            .perform(pathElement, getMapBasicAttributes(), null);

                    final IllegalPathOperationException thrown = assertThrows(IllegalPathOperationException.class, testMethod);
                    assertAll("Checking Exception",
                            () -> assertThat(thrown.getMessage(), is(equalTo(String.format(
                                    "Unable to print path '%s', as is not Array.",
                                    key
                            )))),
                            () -> assertThat(thrown.getCause(), is(nullValue()))
                    );
                }),

                dynamicTest("a_object_empty[1]", () -> {
                    final String key = "a_object_empty";
                    final int arrayIndex = 1;

                    final PathElement pathElement = new PathArrayElementImpl(String.format("%s[%s]", key, arrayIndex), key, arrayIndex);

                    final Executable testMethod = () -> new PrintTransformation()
                            .perform(pathElement, getMapBasicAttributes(), null);

                    final IllegalPathOperationException thrown = assertThrows(IllegalPathOperationException.class, testMethod);
                    assertAll("Checking Exception",
                            () -> assertThat(thrown.getMessage(), is(equalTo(String.format(
                                    "Unable to print path '%s', as is not Array.",
                                    key
                            )))),
                            () -> assertThat(thrown.getCause(), is(nullValue()))
                    );
                }),

                dynamicTest("a_string[1]", () -> {
                    final String key = "a_string";
                    final int arrayIndex = 1;

                    final PathElement pathElement = new PathArrayElementImpl(String.format("%s[%s]", key, arrayIndex), key, arrayIndex);

                    final Executable testMethod = () -> new PrintTransformation()
                            .perform(pathElement, getMapBasicAttributes(), null);

                    final IllegalPathOperationException thrown = assertThrows(IllegalPathOperationException.class, testMethod);
                    assertAll("Checking Exception",
                            () -> assertThat(thrown.getMessage(), is(equalTo(String.format(
                                    "Unable to print path '%s', as is not Array.",
                                    key
                            )))),
                            () -> assertThat(thrown.getCause(), is(nullValue()))
                    );
                }),

                dynamicTest("z_unknown[1]", () -> {
                    final String key = "z_unknown";
                    final int arrayIndex = 1;

                    final PathElement pathElement = new PathArrayElementImpl(String.format("%s[%s]", key, arrayIndex), key, arrayIndex);

                    final Executable testMethod = () -> new PrintTransformation()
                            .perform(pathElement, getMapBasicAttributes(), null);

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

                dynamicTest("a_boolean", () -> {
                    final String key = "a_boolean";

                    final PathElement pathElement = new PathAttributeElementImpl(key);

                    final Map<String, Object> expected = getMapBasicAttributes();

                    final Map<String, Object> actual = new PrintTransformation()
                            .perform(pathElement, getMapBasicAttributes(), null);

                    assertThat(actual, is(notNullValue()));
                    assertAll("Checking maps",
                            () -> assertThat(actual, is(equalTo(expected))),
                            () -> assertThat(actual.get(key), is(equalTo(expected.get(key)))),
                            () -> {
                                final String prefix = "Printing Path '" + key + "' Value ";
                                final String expectedMsg = prefix + "'true'";
                                final Optional<String> message = getInMemoryAppender()
                                        .getMessages()
                                        .stream()
                                        .filter(p -> p.startsWith(prefix))
                                        .findFirst();
                                assertThat(message, optionalContains(expectedMsg));
                            }
                    );
                }),

                dynamicTest("a_float", () -> {
                    final String key = "a_float";

                    final PathElement pathElement = new PathAttributeElementImpl(key);

                    final Map<String, Object> expected = getMapBasicAttributes();

                    final Map<String, Object> actual = new PrintTransformation()
                            .perform(pathElement, getMapBasicAttributes(), null);

                    assertThat(actual, is(notNullValue()));
                    assertAll("Checking maps",
                            () -> assertThat(actual, is(equalTo(expected))),
                            () -> assertThat(actual.get(key), is(equalTo(expected.get(key)))),
                            () -> {
                                final String prefix = "Printing Path '" + key + "' Value ";
                                final String expectedMsg = prefix + "'12.34'";
                                final Optional<String> message = getInMemoryAppender()
                                        .getMessages()
                                        .stream()
                                        .filter(p -> p.startsWith(prefix))
                                        .findFirst();
                                assertThat(message, optionalContains(expectedMsg));
                            }
                    );
                }),

                dynamicTest("a_integer", () -> {
                    final String key = "a_integer";

                    final PathElement pathElement = new PathAttributeElementImpl(key);

                    final Map<String, Object> expected = getMapBasicAttributes();

                    final Map<String, Object> actual = new PrintTransformation()
                            .perform(pathElement, getMapBasicAttributes(), null);

                    assertThat(actual, is(notNullValue()));
                    assertAll("Checking maps",
                            () -> assertThat(actual, is(equalTo(expected))),
                            () -> assertThat(actual.get(key), is(equalTo(expected.get(key)))),
                            () -> {
                                final String prefix = "Printing Path '" + key + "' Value ";
                                final String expectedMsg = prefix + "'1234'";
                                final Optional<String> message = getInMemoryAppender()
                                        .getMessages()
                                        .stream()
                                        .filter(p -> p.startsWith(prefix))
                                        .findFirst();
                                assertThat(message, optionalContains(expectedMsg));
                            }
                    );
                }),

                dynamicTest("a_null", () -> {
                    final String key = "a_null";

                    final PathElement pathElement = new PathAttributeElementImpl(key);

                    final Map<String, Object> expected = getMapBasicAttributes();

                    final Map<String, Object> actual = new PrintTransformation()
                            .perform(pathElement, getMapBasicAttributes(), null);

                    assertThat(actual, is(notNullValue()));
                    assertAll("Checking maps",
                            () -> assertThat(actual, is(equalTo(expected))),
                            () -> assertThat(actual.get(key), is(equalTo(expected.get(key)))),
                            () -> {
                                final String prefix = "Printing Path '" + key + "' Value ";
                                final String expectedMsg = prefix + "'null'";
                                final Optional<String> message = getInMemoryAppender()
                                        .getMessages()
                                        .stream()
                                        .filter(p -> p.startsWith(prefix))
                                        .findFirst();
                                assertThat(message, optionalContains(expectedMsg));
                            }
                    );
                }),

                dynamicTest("a_object_empty", () -> {
                    final String key = "a_object_empty";

                    final PathElement pathElement = new PathAttributeElementImpl(key);

                    final Map<String, Object> expected = getMapBasicAttributes();

                    final Map<String, Object> actual = new PrintTransformation()
                            .perform(pathElement, getMapBasicAttributes(), null);

                    assertThat(actual, is(notNullValue()));
                    assertAll("Checking maps",
                            () -> assertThat(actual, is(equalTo(expected))),
                            () -> assertThat(actual.get(key), is(equalTo(expected.get(key)))),
                            () -> {
                                final String prefix = "Printing Path '" + key + "' Value ";
                                final String expectedMsg = prefix + "'{}'";
                                final Optional<String> message = getInMemoryAppender()
                                        .getMessages()
                                        .stream()
                                        .filter(p -> p.startsWith(prefix))
                                        .findFirst();
                                assertThat(message, optionalContains(expectedMsg));
                            }
                    );
                }),

                dynamicTest("a_string", () -> {
                    final String key = "a_string";

                    final PathElement pathElement = new PathAttributeElementImpl(key);

                    final Map<String, Object> expected = getMapBasicAttributes();

                    final Map<String, Object> actual = new PrintTransformation()
                            .perform(pathElement, getMapBasicAttributes(), null);

                    assertThat(actual, is(notNullValue()));
                    assertAll("Checking maps",
                            () -> assertThat(actual, is(equalTo(expected))),
                            () -> assertThat(actual.get(key), is(equalTo(expected.get(key)))),
                            () -> {
                                final String prefix = "Printing Path '" + key + "' Value ";
                                final String expectedMsg = prefix + "'aValue'";
                                final Optional<String> message = getInMemoryAppender()
                                        .getMessages()
                                        .stream()
                                        .filter(p -> p.startsWith(prefix))
                                        .findFirst();
                                assertThat(message, optionalContains(expectedMsg));
                            }
                    );
                }),

                dynamicTest("z_unknown", () -> {
                    final String key = "z_unknown";

                    final PathElement pathElement = new PathAttributeElementImpl(key);

                    final Executable testMethod = () -> new PrintTransformation()
                            .perform(pathElement, getMapBasicAttributes(), null);

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
