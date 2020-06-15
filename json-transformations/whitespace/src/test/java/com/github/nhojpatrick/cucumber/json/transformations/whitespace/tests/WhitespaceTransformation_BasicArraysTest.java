package com.github.nhojpatrick.cucumber.json.transformations.whitespace.tests;

import com.github.nhojpatrick.cucumber.json.core.exceptions.IllegalPathOperationException;
import com.github.nhojpatrick.cucumber.json.core.validation.PathElement;
import com.github.nhojpatrick.cucumber.json.core.validation.impl.PathArrayElementImpl;
import com.github.nhojpatrick.cucumber.json.core.validation.impl.PathAttributeElementImpl;
import com.github.nhojpatrick.cucumber.json.transformations.whitespace.WhitespaceTransformation;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.function.Executable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;

import static com.github.nhojpatrick.cucumber.testing.internal.objects.TestingInternalObjectsConstants.getMapBasicArrays;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

public class WhitespaceTransformation_BasicArraysTest {

    private static final String TYPE = "BasicArray";

    @TestFactory
    @DisplayName("Whitespace Transformation " + TYPE + " Array Paths Tests")
    public Collection<DynamicTest> arrayPaths() {

        return Arrays.asList(

                dynamicTest("objects_array[1]", () -> {
                    final String key = "objects_array";
                    final int arrayIndex = 1;

                    final PathElement pathElement = new PathArrayElementImpl(String.format("%s[%s]", key, arrayIndex), key, arrayIndex);

                    final Executable testMethod = () -> new WhitespaceTransformation(1, 2)
                            .perform(pathElement, getMapBasicArrays(), null);

                    final IllegalPathOperationException thrown = assertThrows(IllegalPathOperationException.class, testMethod);
                    assertAll("Checking Exception",
                            () -> assertThat(thrown.getMessage(), is(equalTo(String.format(
                                    "Unable to whitespace JsonObject, at path '%s[%s]'.",
                                    key,
                                    arrayIndex
                            )))),
                            () -> assertThat(thrown.getCause(), is(nullValue()))
                    );
                }),

                dynamicTest("objects_array[5]", () -> {
                    final String key = "objects_array";
                    final int arrayIndex = 5;

                    final PathElement pathElement = new PathArrayElementImpl(String.format("%s[%s]", key, arrayIndex), key, arrayIndex);

                    final Executable testMethod = () -> new WhitespaceTransformation(1, 2)
                            .perform(pathElement, getMapBasicArrays(), null);

                    final IllegalPathOperationException thrown = assertThrows(IllegalPathOperationException.class, testMethod);
                    assertAll("Checking Exception",
                            () -> assertThat(thrown.getMessage(), is(equalTo(String.format(
                                    "Unable to whitespace path '%s[%s]', beyond index of '%s'.",
                                    key,
                                    arrayIndex,
                                    3
                            )))),
                            () -> assertThat(thrown.getCause(), is(nullValue()))
                    );
                }),

                dynamicTest("objects_empty[1]", () -> {
                    final String key = "objects_empty";
                    final int arrayIndex = 1;

                    final PathElement pathElement = new PathArrayElementImpl(String.format("%s[%s]", key, arrayIndex), key, arrayIndex);

                    final Executable testMethod = () -> new WhitespaceTransformation(1, 2)
                            .perform(pathElement, getMapBasicArrays(), null);

                    final IllegalPathOperationException thrown = assertThrows(IllegalPathOperationException.class, testMethod);
                    assertAll("Checking Exception",
                            () -> assertThat(thrown.getMessage(), is(equalTo(String.format(
                                    "Unable to whitespace path '%s', as array is empty.",
                                    key
                            )))),
                            () -> assertThat(thrown.getCause(), is(nullValue()))
                    );
                }),

                dynamicTest("objects_null[1]", () -> {
                    final String key = "objects_null";
                    final int arrayIndex = 1;

                    final PathElement pathElement = new PathArrayElementImpl(String.format("%s[%s]", key, arrayIndex), key, arrayIndex);

                    final Executable testMethod = () -> new WhitespaceTransformation(1, 2)
                            .perform(pathElement, getMapBasicArrays(), null);

                    final IllegalPathOperationException thrown = assertThrows(IllegalPathOperationException.class, testMethod);
                    assertAll("Checking Exception",
                            () -> assertThat(thrown.getMessage(), is(equalTo(String.format(
                                    "Unable to whitespace 'null' value, at path '%s'.",
                                    key
                            )))),
                            () -> assertThat(thrown.getCause(), is(nullValue()))
                    );
                }),

                dynamicTest("primitives_array[1]", () -> {
                    final String key = "primitives_array";
                    final int arrayIndex = 1;

                    final PathElement pathElement = new PathArrayElementImpl(String.format("%s[%s]", key, arrayIndex), key, arrayIndex);

                    final Map<String, Object> expected = getMapBasicArrays();
                    expected.put(key, new ArrayList<>(Arrays.asList(
                            "aPrimitiveArray",
                            " bPrimitiveArray  ",
                            "cPrimitiveArray",
                            "dPrimitiveArray"
                    )));

                    final Map<String, Object> actual = new WhitespaceTransformation(1, 2)
                            .perform(pathElement, getMapBasicArrays(), null);

                    assertThat(actual, is(notNullValue()));
                    assertAll("Checking maps",
                            () -> assertThat(actual, is(equalTo(expected))),
                            () -> assertThat(actual.get(key), is(equalTo(expected.get(key))))
                    );
                }),

                dynamicTest("primitives_array[5]", () -> {
                    final String key = "primitives_array";
                    final int arrayIndex = 5;

                    final PathElement pathElement = new PathArrayElementImpl(String.format("%s[%s]", key, arrayIndex), key, arrayIndex);

                    final Executable testMethod = () -> new WhitespaceTransformation(1, 2)
                            .perform(pathElement, getMapBasicArrays(), null);

                    final IllegalPathOperationException thrown = assertThrows(IllegalPathOperationException.class, testMethod);
                    assertAll("Checking Exception",
                            () -> assertThat(thrown.getMessage(), is(equalTo(String.format(
                                    "Unable to whitespace path '%s[%s]', beyond index of '%s'.",
                                    key,
                                    arrayIndex,
                                    3
                            )))),
                            () -> assertThat(thrown.getCause(), is(nullValue()))
                    );
                }),

                dynamicTest("primitives_empty[1]", () -> {
                    final String key = "primitives_empty";
                    final int arrayIndex = 1;

                    final PathElement pathElement = new PathArrayElementImpl(String.format("%s[%s]", key, arrayIndex), key, arrayIndex);

                    final Executable testMethod = () -> new WhitespaceTransformation(1, 2)
                            .perform(pathElement, getMapBasicArrays(), null);

                    final IllegalPathOperationException thrown = assertThrows(IllegalPathOperationException.class, testMethod);
                    assertAll("Checking Exception",
                            () -> assertThat(thrown.getMessage(), is(equalTo(String.format(
                                    "Unable to whitespace path '%s', as array is empty.",
                                    key
                            )))),
                            () -> assertThat(thrown.getCause(), is(nullValue()))
                    );
                }),

                dynamicTest("primitives_null[1]", () -> {
                    final String key = "primitives_null";
                    final int arrayIndex = 1;

                    final PathElement pathElement = new PathArrayElementImpl(String.format("%s[%s]", key, arrayIndex), key, arrayIndex);

                    final Executable testMethod = () -> new WhitespaceTransformation(1, 2)
                            .perform(pathElement, getMapBasicArrays(), null);

                    final IllegalPathOperationException thrown = assertThrows(IllegalPathOperationException.class, testMethod);
                    assertAll("Checking Exception",
                            () -> assertThat(thrown.getMessage(), is(equalTo(String.format(
                                    "Unable to whitespace 'null' value, at path '%s'.",
                                    key
                            )))),
                            () -> assertThat(thrown.getCause(), is(nullValue()))
                    );
                }),

                dynamicTest("unknown[1]", () -> {
                    final String key = "unknown";
                    final int arrayIndex = 1;

                    final PathElement pathElement = new PathArrayElementImpl(String.format("%s[%s]", key, arrayIndex), key, arrayIndex);

                    final Executable testMethod = () -> new WhitespaceTransformation(1, 2)
                            .perform(pathElement, getMapBasicArrays(), null);

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
    @DisplayName("Whitespace Transformation " + TYPE + " Primitive Paths Tests")
    public Collection<DynamicTest> primitivePaths() {

        return Arrays.asList(

                dynamicTest("objects_array", () -> {
                    final String key = "objects_array";

                    final PathElement pathElement = new PathAttributeElementImpl(key);

                    final Executable testMethod = () -> new WhitespaceTransformation(1, 2)
                            .perform(pathElement, getMapBasicArrays(), null);

                    final IllegalPathOperationException thrown = assertThrows(IllegalPathOperationException.class, testMethod);
                    assertAll("Checking Exception",
                            () -> assertThat(thrown.getMessage(), is(equalTo(String.format(
                                    "Unable to whitespace JsonArray<>, at path '%s'.",
                                    key
                            )))),
                            () -> assertThat(thrown.getCause(), is(nullValue()))
                    );
                }),

                dynamicTest("objects_empty", () -> {
                    final String key = "objects_empty";

                    final PathElement pathElement = new PathAttributeElementImpl(key);

                    final Executable testMethod = () -> new WhitespaceTransformation(1, 2)
                            .perform(pathElement, getMapBasicArrays(), null);

                    final IllegalPathOperationException thrown = assertThrows(IllegalPathOperationException.class, testMethod);
                    assertAll("Checking Exception",
                            () -> assertThat(thrown.getMessage(), is(equalTo(String.format(
                                    "Unable to whitespace JsonArray<>, at path '%s'.",
                                    key
                            )))),
                            () -> assertThat(thrown.getCause(), is(nullValue()))
                    );
                }),

                dynamicTest("objects_null", () -> {
                    final String key = "objects_null";

                    final PathElement pathElement = new PathAttributeElementImpl(key);

                    final Executable testMethod = () -> new WhitespaceTransformation(1, 2)
                            .perform(pathElement, getMapBasicArrays(), null);

                    final IllegalPathOperationException thrown = assertThrows(IllegalPathOperationException.class, testMethod);
                    assertAll("Checking Exception",
                            () -> assertThat(thrown.getMessage(), is(equalTo(String.format(
                                    "Unable to whitespace 'null' value, at path '%s'.",
                                    key
                            )))),
                            () -> assertThat(thrown.getCause(), is(nullValue()))
                    );
                }),

                dynamicTest("primitives_array", () -> {
                    final String key = "primitives_array";

                    final PathElement pathElement = new PathAttributeElementImpl(key);

                    final Executable testMethod = () -> new WhitespaceTransformation(1, 2)
                            .perform(pathElement, getMapBasicArrays(), null);

                    final IllegalPathOperationException thrown = assertThrows(IllegalPathOperationException.class, testMethod);
                    assertAll("Checking Exception",
                            () -> assertThat(thrown.getMessage(), is(equalTo(String.format(
                                    "Unable to whitespace JsonArray<>, at path '%s'.",
                                    key
                            )))),
                            () -> assertThat(thrown.getCause(), is(nullValue()))
                    );
                }),

                dynamicTest("primitives_empty", () -> {
                    final String key = "primitives_empty";

                    final PathElement pathElement = new PathAttributeElementImpl(key);

                    final Executable testMethod = () -> new WhitespaceTransformation(1, 2)
                            .perform(pathElement, getMapBasicArrays(), null);

                    final IllegalPathOperationException thrown = assertThrows(IllegalPathOperationException.class, testMethod);
                    assertAll("Checking Exception",
                            () -> assertThat(thrown.getMessage(), is(equalTo(String.format(
                                    "Unable to whitespace JsonArray<>, at path '%s'.",
                                    key
                            )))),
                            () -> assertThat(thrown.getCause(), is(nullValue()))
                    );
                }),

                dynamicTest("primitives_null", () -> {
                    final String key = "primitives_null";

                    final PathElement pathElement = new PathAttributeElementImpl(key);

                    final Executable testMethod = () -> new WhitespaceTransformation(1, 2)
                            .perform(pathElement, getMapBasicArrays(), null);

                    final IllegalPathOperationException thrown = assertThrows(IllegalPathOperationException.class, testMethod);
                    assertAll("Checking Exception",
                            () -> assertThat(thrown.getMessage(), is(equalTo(String.format(
                                    "Unable to whitespace 'null' value, at path '%s'.",
                                    key
                            )))),
                            () -> assertThat(thrown.getCause(), is(nullValue()))
                    );
                }),

                dynamicTest("unknown", () -> {
                    final String key = "unknown";

                    final PathElement pathElement = new PathAttributeElementImpl(key);

                    final Executable testMethod = () -> new WhitespaceTransformation(1, 2)
                            .perform(pathElement, getMapBasicArrays(), null);

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
