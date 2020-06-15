package com.github.nhojpatrick.cucumber.json.transformations.reverse.tests;

import com.github.nhojpatrick.cucumber.json.core.exceptions.IllegalPathOperationException;
import com.github.nhojpatrick.cucumber.json.core.validation.PathElement;
import com.github.nhojpatrick.cucumber.json.core.validation.impl.PathArrayElementImpl;
import com.github.nhojpatrick.cucumber.json.core.validation.impl.PathAttributeElementImpl;
import com.github.nhojpatrick.cucumber.json.transformations.reverse.ReverseTransformation;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.function.Executable;

import java.util.Arrays;
import java.util.Collection;
import java.util.Map;

import static com.github.nhojpatrick.cucumber.testing.internal.objects.TestingInternalObjectsConstants.getMapBasicAttributes;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

public class ReverseTransformation_BasicAttributesTest {

    private static final String TYPE = "BasicAttribute";

    @TestFactory
    @DisplayName("Reverse Transformation " + TYPE + " Array Paths Tests")
    public Collection<DynamicTest> arrayPaths() {

        return Arrays.asList(

                dynamicTest("a_boolean[1]", () -> {
                    final String key = "a_boolean";
                    final int arrayIndex = 1;

                    final PathElement pathElement = new PathArrayElementImpl(String.format("%s[%s]", key, arrayIndex), key, arrayIndex);

                    final Executable testMethod = () -> new ReverseTransformation()
                            .perform(pathElement, getMapBasicAttributes(), null);

                    final IllegalPathOperationException thrown = assertThrows(IllegalPathOperationException.class, testMethod);
                    assertAll("Checking Exception",
                            () -> assertThat(thrown.getMessage(), is(equalTo(String.format(
                                    "Unable to reverse path '%s', as is not Array.",
                                    key
                            )))),
                            () -> assertThat(thrown.getCause(), is(nullValue()))
                    );
                }),

                dynamicTest("a_float[1]", () -> {
                    final String key = "a_float";
                    final int arrayIndex = 1;

                    final PathElement pathElement = new PathArrayElementImpl(String.format("%s[%s]", key, arrayIndex), key, arrayIndex);

                    final Executable testMethod = () -> new ReverseTransformation()
                            .perform(pathElement, getMapBasicAttributes(), null);

                    final IllegalPathOperationException thrown = assertThrows(IllegalPathOperationException.class, testMethod);
                    assertAll("Checking Exception",
                            () -> assertThat(thrown.getMessage(), is(equalTo(String.format(
                                    "Unable to reverse path '%s', as is not Array.",
                                    key
                            )))),
                            () -> assertThat(thrown.getCause(), is(nullValue()))
                    );
                }),

                dynamicTest("a_integer[1]", () -> {
                    final String key = "a_integer";
                    final int arrayIndex = 1;

                    final PathElement pathElement = new PathArrayElementImpl(String.format("%s[%s]", key, arrayIndex), key, arrayIndex);

                    final Executable testMethod = () -> new ReverseTransformation()
                            .perform(pathElement, getMapBasicAttributes(), null);

                    final IllegalPathOperationException thrown = assertThrows(IllegalPathOperationException.class, testMethod);
                    assertAll("Checking Exception",
                            () -> assertThat(thrown.getMessage(), is(equalTo(String.format(
                                    "Unable to reverse path '%s', as is not Array.",
                                    key
                            )))),
                            () -> assertThat(thrown.getCause(), is(nullValue()))
                    );
                }),

                dynamicTest("a_null[1]", () -> {
                    final String key = "a_null";
                    final int arrayIndex = 1;

                    final PathElement pathElement = new PathArrayElementImpl(String.format("%s[%s]", key, arrayIndex), key, arrayIndex);

                    final Executable testMethod = () -> new ReverseTransformation()
                            .perform(pathElement, getMapBasicAttributes(), null);

                    final IllegalPathOperationException thrown = assertThrows(IllegalPathOperationException.class, testMethod);
                    assertAll("Checking Exception",
                            () -> assertThat(thrown.getMessage(), is(equalTo(String.format(
                                    "Unable to reverse 'null' value, at path '%s'.",
                                    key
                            )))),
                            () -> assertThat(thrown.getCause(), is(nullValue()))
                    );
                }),

                dynamicTest("a_object_empty[1]", () -> {
                    final String key = "a_object_empty";
                    final int arrayIndex = 1;

                    final PathElement pathElement = new PathArrayElementImpl(String.format("%s[%s]", key, arrayIndex), key, arrayIndex);

                    final Executable testMethod = () -> new ReverseTransformation()
                            .perform(pathElement, getMapBasicAttributes(), null);

                    final IllegalPathOperationException thrown = assertThrows(IllegalPathOperationException.class, testMethod);
                    assertAll("Checking Exception",
                            () -> assertThat(thrown.getMessage(), is(equalTo(String.format(
                                    "Unable to reverse path '%s', as is not Array.",
                                    key
                            )))),
                            () -> assertThat(thrown.getCause(), is(nullValue()))
                    );
                }),

                dynamicTest("a_string[1]", () -> {
                    final String key = "a_string";
                    final int arrayIndex = 1;

                    final PathElement pathElement = new PathArrayElementImpl(String.format("%s[%s]", key, arrayIndex), key, arrayIndex);

                    final Executable testMethod = () -> new ReverseTransformation()
                            .perform(pathElement, getMapBasicAttributes(), null);

                    final IllegalPathOperationException thrown = assertThrows(IllegalPathOperationException.class, testMethod);
                    assertAll("Checking Exception",
                            () -> assertThat(thrown.getMessage(), is(equalTo(String.format(
                                    "Unable to reverse path '%s', as is not Array.",
                                    key
                            )))),
                            () -> assertThat(thrown.getCause(), is(nullValue()))
                    );
                }),

                dynamicTest("z_unknown[1]", () -> {
                    final String key = "z_unknown";
                    final int arrayIndex = 1;

                    final PathElement pathElement = new PathArrayElementImpl(String.format("%s[%s]", key, arrayIndex), key, arrayIndex);

                    final Executable testMethod = () -> new ReverseTransformation()
                            .perform(pathElement, getMapBasicAttributes(), null);

                    final IllegalPathOperationException thrown = assertThrows(IllegalPathOperationException.class, testMethod);
                    assertAll("Checking Exception",
                            () -> assertThat(thrown.getMessage(), is(equalTo(String.format(
                                    "Path does not exist at '%s'.",
                                    key
                            )))),
                            () -> assertThat(thrown.getCause(), is(nullValue()))
                    );
                })

        );
    }

    @TestFactory
    @DisplayName("Reverse Transformation " + TYPE + " Primitive Paths Tests")
    public Collection<DynamicTest> primitivePaths() {

        return Arrays.asList(

                dynamicTest("a_boolean", () -> {
                    final String key = "a_boolean";

                    final PathElement pathElement = new PathAttributeElementImpl(key);

                    final Map<String, Object> expected = getMapBasicAttributes();
                    expected.put(key, "eurt");

                    final Map<String, Object> actual = new ReverseTransformation()
                            .perform(pathElement, getMapBasicAttributes(), null);

                    assertThat(actual, is(notNullValue()));
                    assertAll("Checking maps",
                            () -> assertThat(actual, is(equalTo(expected))),
                            () -> assertThat(actual.get(key), is(equalTo(expected.get(key))))
                    );
                }),

                dynamicTest("a_float", () -> {
                    final String key = "a_float";

                    final PathElement pathElement = new PathAttributeElementImpl(key);

                    final Map<String, Object> expected = getMapBasicAttributes();
                    expected.put(key, "43.21");

                    final Map<String, Object> actual = new ReverseTransformation()
                            .perform(pathElement, getMapBasicAttributes(), null);

                    assertThat(actual, is(notNullValue()));
                    assertAll("Checking maps",
                            () -> assertThat(actual, is(equalTo(expected))),
                            () -> assertThat(actual.get(key), is(equalTo(expected.get(key))))
                    );
                }),

                dynamicTest("a_integer", () -> {
                    final String key = "a_integer";

                    final PathElement pathElement = new PathAttributeElementImpl(key);

                    final Map<String, Object> expected = getMapBasicAttributes();
                    expected.put(key, "4321");

                    final Map<String, Object> actual = new ReverseTransformation()
                            .perform(pathElement, getMapBasicAttributes(), null);

                    assertThat(actual, is(notNullValue()));
                    assertAll("Checking maps",
                            () -> assertThat(actual, is(equalTo(expected))),
                            () -> assertThat(actual.get(key), is(equalTo(expected.get(key))))
                    );
                }),

                dynamicTest("a_null", () -> {
                    final String key = "a_null";

                    final PathElement pathElement = new PathAttributeElementImpl(key);

                    final Executable testMethod = () -> new ReverseTransformation()
                            .perform(pathElement, getMapBasicAttributes(), null);

                    final IllegalPathOperationException thrown = assertThrows(IllegalPathOperationException.class, testMethod);
                    assertAll("Checking Exception",
                            () -> assertThat(thrown.getMessage(), is(equalTo(String.format(
                                    "Unable to reverse 'null' value, at path '%s'.",
                                    key
                            )))),
                            () -> assertThat(thrown.getCause(), is(nullValue()))
                    );
                }),

                dynamicTest("a_object_empty", () -> {
                    final String key = "a_object_empty";

                    final PathElement pathElement = new PathAttributeElementImpl(key);

                    final Executable testMethod = () -> new ReverseTransformation()
                            .perform(pathElement, getMapBasicAttributes(), null);

                    final IllegalPathOperationException thrown = assertThrows(IllegalPathOperationException.class, testMethod);
                    assertAll("Checking Exception",
                            () -> assertThat(thrown.getMessage(), is(equalTo(String.format(
                                    "Unable to reverse JsonObject, at path '%s'.",
                                    key
                            )))),
                            () -> assertThat(thrown.getCause(), is(nullValue()))
                    );
                }),

                dynamicTest("a_string", () -> {
                    final String key = "a_string";

                    final PathElement pathElement = new PathAttributeElementImpl(key);

                    final Map<String, Object> expected = getMapBasicAttributes();
                    expected.put(key, "eulaVa");

                    final Map<String, Object> actual = new ReverseTransformation()
                            .perform(pathElement, getMapBasicAttributes(), null);

                    assertThat(actual, is(notNullValue()));
                    assertAll("Checking maps",
                            () -> assertThat(actual, is(equalTo(expected))),
                            () -> assertThat(actual.get(key), is(equalTo(expected.get(key))))
                    );
                }),

                dynamicTest("z_unknown", () -> {
                    final String key = "z_unknown";

                    final PathElement pathElement = new PathAttributeElementImpl(key);

                    final Executable testMethod = () -> new ReverseTransformation()
                            .perform(pathElement, getMapBasicAttributes(), null);

                    final IllegalPathOperationException thrown = assertThrows(IllegalPathOperationException.class, testMethod);
                    assertAll("Checking Exception",
                            () -> assertThat(thrown.getMessage(), is(equalTo(String.format(
                                    "Path does not exist at '%s'.",
                                    key
                            )))),
                            () -> assertThat(thrown.getCause(), is(nullValue()))
                    );
                })

        );
    }

}
