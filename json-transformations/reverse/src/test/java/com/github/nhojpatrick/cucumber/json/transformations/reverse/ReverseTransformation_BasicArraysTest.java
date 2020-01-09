package com.github.nhojpatrick.cucumber.json.transformations.reverse;

import com.github.nhojpatrick.cucumber.json.core.exceptions.IllegalPathOperationException;
import com.github.nhojpatrick.cucumber.json.core.validation.impl.PathArrayElementImpl;
import com.github.nhojpatrick.cucumber.json.core.validation.impl.PathElementImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.function.Executable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import static com.github.nhojpatrick.cucumber.testing.internal.objects.TestingInternalObjectsConstants.getMapBasicArrays;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ReverseTransformation_BasicArraysTest {

    private static final String TYPE = "BasicArray";

    @TestFactory
    @DisplayName("Reverse Transformation " + TYPE + " Array Paths Tests")
    public Collection<DynamicTest> arrayPaths() {

        return Arrays.asList(

                DynamicTest.dynamicTest("objects_array", () -> {
                    final String key = "objects_array";

                    final Map<String, Object> expected = getMapBasicArrays();

                    final Map<String, Object> aObjectArray = new HashMap<>();
                    aObjectArray.put("object_array_id", "aObjectArrayId");

                    final Map<String, Object> bObjectArray = new HashMap<>();
                    bObjectArray.put("object_array_id", "bObjectArrayId");

                    final Map<String, Object> cObjectArray = new HashMap<>();
                    cObjectArray.put("object_array_id", "cObjectArrayId");

                    final Map<String, Object> dObjectArray = new HashMap<>();
                    dObjectArray.put("object_array_id", "dObjectArrayId");

                    expected.put(key, new ArrayList<>(Arrays.asList(
                            dObjectArray,
                            cObjectArray,
                            bObjectArray,
                            aObjectArray
                    )));

                    final Map<String, Object> actual = new ReverseTransformation()
                            .perform(new PathElementImpl(key), getMapBasicArrays(), null);

                    assertThat(actual, is(notNullValue()));
                    assertAll("Checking maps",
                            () -> assertThat(actual, is(equalTo(expected))),
                            () -> assertThat(actual.get(key), is(equalTo(expected.get(key))))
                    );
                }),

                DynamicTest.dynamicTest("objects_array[1]", () -> {
                    final String key = "objects_array";
                    final int arrayIndex = 1;

                    final PathArrayElementImpl pathElement = new PathArrayElementImpl(String.format("%s[%s]", key, arrayIndex), key, arrayIndex);
                    final Executable testMethod = () -> new ReverseTransformation()
                            .perform(pathElement, getMapBasicArrays(), "objects_array[1]");

                    final IllegalPathOperationException thrown = assertThrows(IllegalPathOperationException.class, testMethod);
                    assertAll("Checking Exception",
                            () -> assertThat(thrown.getMessage(), is(equalTo("Unable to reverse JsonObject, at path 'objects_array[1]'."))),
                            () -> assertThat(thrown.getCause(), is(nullValue()))
                    );
                }),

                DynamicTest.dynamicTest("objects_array[5]", () -> {
                    final String key = "objects_array";
                    final int arrayIndex = 5;

                    final Map<String, Object> expected = getMapBasicArrays();

                    final Map<String, Object> aObjectArray = new HashMap<>();
                    aObjectArray.put("object_array_id", "aObjectArrayId");

                    final Map<String, Object> bObjectArray = new HashMap<>();
                    bObjectArray.put("object_array_id", "bObjectArrayId");

                    final Map<String, Object> cObjectArray = new HashMap<>();
                    cObjectArray.put("object_array_id", "cObjectArrayId");

                    final Map<String, Object> dObjectArray = new HashMap<>();
                    dObjectArray.put("object_array_id", "dObjectArrayId");

                    expected.put(key, new ArrayList<>(Arrays.asList(
                            aObjectArray,
                            bObjectArray,
                            cObjectArray,
                            dObjectArray,
                            null,
                            null
                    )));

                    final PathArrayElementImpl pathElement = new PathArrayElementImpl(String.format("%s[%s]", key, arrayIndex), key, arrayIndex);
                    final Map<String, Object> actual = new ReverseTransformation()
                            .perform(pathElement, getMapBasicArrays(), null);

                    assertThat(actual, is(notNullValue()));
                    assertAll("Checking maps",
                            () -> assertThat(actual, is(equalTo(expected))),
                            () -> assertThat(actual.get(key), is(equalTo(expected.get(key))))
                    );
                }),

                DynamicTest.dynamicTest("primitive", () -> {
                    final String key = "primitive";

                    final Map<String, Object> expected = getMapBasicArrays();
                    expected.put(key, "evitimirPa");

                    final Map<String, Object> actual = new ReverseTransformation()
                            .perform(new PathElementImpl(key), getMapBasicArrays(), null);

                    assertThat(actual, is(notNullValue()));
                    assertAll("Checking maps",
                            () -> assertThat(actual, is(equalTo(expected))),
                            () -> assertThat(actual.get(key), is(equalTo(expected.get(key))))
                    );
                }),

                DynamicTest.dynamicTest("primitive[1]", () -> {
                    final String key = "primitive";
                    final int arrayIndex = 1;

                    final PathArrayElementImpl pathElement = new PathArrayElementImpl(String.format("%s[%s]", key, arrayIndex), key, arrayIndex);
                    final Executable testMethod = () -> new ReverseTransformation()
                            .perform(pathElement, getMapBasicArrays(), null);

                    final IllegalPathOperationException thrown = assertThrows(IllegalPathOperationException.class, testMethod);
                    assertAll("Checking Exception",
                            () -> assertThat(thrown.getMessage(), is(equalTo(String.format(
                                    "Unable to reverse path '%s', as is not Array.",
                                    key
                            )))),
                            () -> assertThat(thrown.getCause(), is(nullValue()))
                    );
                }),

                DynamicTest.dynamicTest("primitive[5]", () -> {
                    final String key = "primitive";
                    final int arrayIndex = 5;

                    final PathArrayElementImpl pathElement = new PathArrayElementImpl(String.format("%s[%s]", key, arrayIndex), key, arrayIndex);
                    final Executable testMethod = () -> new ReverseTransformation()
                            .perform(pathElement, getMapBasicArrays(), null);

                    final IllegalPathOperationException thrown = assertThrows(IllegalPathOperationException.class, testMethod);
                    assertAll("Checking Exception",
                            () -> assertThat(thrown.getMessage(), is(equalTo(String.format(
                                    "Unable to reverse path '%s', as is not Array.",
                                    key
                            )))),
                            () -> assertThat(thrown.getCause(), is(nullValue()))
                    );
                }),

                DynamicTest.dynamicTest("primitives_array", () -> {
                    final String key = "primitives_array";

                    final Map<String, Object> expected = getMapBasicArrays();
                    expected.put(key, new ArrayList<>(Arrays.asList(
                            "dPrimitiveArray",
                            "cPrimitiveArray",
                            "bPrimitiveArray",
                            "aPrimitiveArray"
                    )));

                    final Map<String, Object> actual = new ReverseTransformation()
                            .perform(new PathElementImpl(key), getMapBasicArrays(), null);

                    assertThat(actual, is(notNullValue()));
                    assertAll("Checking maps",
                            () -> assertThat(actual, is(equalTo(expected))),
                            () -> assertThat(actual.get(key), is(equalTo(expected.get(key))))
                    );
                }),

                DynamicTest.dynamicTest("primitives_array[1]", () -> {
                    final String key = "primitives_array";
                    final int arrayIndex = 1;

                    final Map<String, Object> expected = getMapBasicArrays();
                    expected.put(key, new ArrayList<>(Arrays.asList(
                            "aPrimitiveArray",
                            "yarrAevitimirPb",
                            "cPrimitiveArray",
                            "dPrimitiveArray"
                    )));

                    final PathArrayElementImpl pathElement = new PathArrayElementImpl(String.format("%s[%s]", key, arrayIndex), key, arrayIndex);
                    final Map<String, Object> actual = new ReverseTransformation()
                            .perform(pathElement, getMapBasicArrays(), null);

                    assertThat(actual, is(notNullValue()));
                    assertAll("Checking maps",
                            () -> assertThat(actual, is(equalTo(expected))),
                            () -> assertThat(actual.get(key), is(equalTo(expected.get(key))))
                    );
                }),

                DynamicTest.dynamicTest("primitives_array[5]", () -> {
                    final String key = "primitives_array";
                    final int arrayIndex = 5;

                    final Map<String, Object> expected = getMapBasicArrays();
                    expected.put(key, new ArrayList<>(Arrays.asList(
                            "aPrimitiveArray",
                            "bPrimitiveArray",
                            "cPrimitiveArray",
                            "dPrimitiveArray",
                            null,
                            null
                    )));

                    final PathArrayElementImpl pathElement = new PathArrayElementImpl(String.format("%s[%s]", key, arrayIndex), key, arrayIndex);
                    final Map<String, Object> actual = new ReverseTransformation()
                            .perform(pathElement, getMapBasicArrays(), null);

                    assertThat(actual, is(notNullValue()));
                    assertAll("Checking maps",
                            () -> assertThat(actual, is(equalTo(expected))),
                            () -> assertThat(actual.get(key), is(equalTo(expected.get(key))))
                    );
                }),

                DynamicTest.dynamicTest("unknown", () -> {
                    final String key = "unknown";

                    final Map<String, Object> expected = getMapBasicArrays();

                    final Map<String, Object> actual = new ReverseTransformation()
                            .perform(new PathElementImpl(key), getMapBasicArrays(), null);

                    assertThat(actual, is(notNullValue()));
                    assertAll("Checking maps",
                            () -> assertThat(actual, is(equalTo(expected))),
                            () -> assertThat(actual.get(key), is(equalTo(expected.get(key))))
                    );
                }),

                DynamicTest.dynamicTest("unknown[1]", () -> {
                    final String key = "unknown";
                    final int arrayIndex = 1;

                    final Map<String, Object> expected = getMapBasicArrays();

                    final PathArrayElementImpl pathElement = new PathArrayElementImpl(String.format("%s[%s]", key, arrayIndex), key, arrayIndex);
                    final Map<String, Object> actual = new ReverseTransformation()
                            .perform(pathElement, getMapBasicArrays(), null);

                    assertThat(actual, is(notNullValue()));
                    assertAll("Checking maps",
                            () -> assertThat(actual, is(equalTo(expected))),
                            () -> assertThat(actual.get(key), is(equalTo(expected.get(key))))
                    );
                })

        );
    }

    @TestFactory
    @DisplayName("Reverse Transformation " + TYPE + " Primitive Paths Tests")
    public Collection<DynamicTest> primitivePaths() {

        return Arrays.asList(

                DynamicTest.dynamicTest("a_boolean", () -> {
                    final String key = "a_boolean";

                    final Map<String, Object> expected = getMapBasicArrays();

                    final Map<String, Object> actual = new ReverseTransformation()
                            .perform(new PathElementImpl(key), getMapBasicArrays(), null);

                    assertThat(actual, is(notNullValue()));
                    assertAll("Checking maps",
                            () -> assertThat(actual, is(equalTo(expected))),
                            () -> assertThat(actual.get(key), is(equalTo(expected.get(key))))
                    );
                }),

                DynamicTest.dynamicTest("a_float", () -> {
                    final String key = "a_float";

                    final Map<String, Object> expected = getMapBasicArrays();

                    final Map<String, Object> actual = new ReverseTransformation()
                            .perform(new PathElementImpl(key), getMapBasicArrays(), null);

                    assertThat(actual, is(notNullValue()));
                    assertAll("Checking maps",
                            () -> assertThat(actual, is(equalTo(expected))),
                            () -> assertThat(actual.get(key), is(equalTo(expected.get(key))))
                    );
                }),

                DynamicTest.dynamicTest("a_integer", () -> {
                    final String key = "a_integer";

                    final Map<String, Object> expected = getMapBasicArrays();

                    final Map<String, Object> actual = new ReverseTransformation()
                            .perform(new PathElementImpl(key), getMapBasicArrays(), null);

                    assertThat(actual, is(notNullValue()));
                    assertAll("Checking maps",
                            () -> assertThat(actual, is(equalTo(expected))),
                            () -> assertThat(actual.get(key), is(equalTo(expected.get(key))))
                    );
                }),

                DynamicTest.dynamicTest("a_null", () -> {
                    final String key = "a_null";

                    final Map<String, Object> expected = getMapBasicArrays();

                    final Map<String, Object> actual = new ReverseTransformation()
                            .perform(new PathElementImpl(key), getMapBasicArrays(), null);

                    assertThat(actual, is(notNullValue()));
                    assertAll("Checking maps",
                            () -> assertThat(actual, is(equalTo(expected))),
                            () -> assertThat(actual.get(key), is(equalTo(expected.get(key))))
                    );
                }),

                DynamicTest.dynamicTest("a_object", () -> {
                    final String key = "a_object";

                    final Map<String, Object> expected = getMapBasicArrays();

                    final Map<String, Object> actual = new ReverseTransformation()
                            .perform(new PathElementImpl(key), getMapBasicArrays(), null);

                    assertThat(actual, is(notNullValue()));
                    assertAll("Checking maps",
                            () -> assertThat(actual, is(equalTo(expected))),
                            () -> assertThat(actual.get(key), is(equalTo(expected.get(key))))
                    );
                }),

                DynamicTest.dynamicTest("a_string", () -> {
                    final String key = "a_string";

                    final Map<String, Object> expected = getMapBasicArrays();

                    final Map<String, Object> actual = new ReverseTransformation()
                            .perform(new PathElementImpl(key), getMapBasicArrays(), null);

                    assertThat(actual, is(notNullValue()));
                    assertAll("Checking maps",
                            () -> assertThat(actual, is(equalTo(expected))),
                            () -> assertThat(actual.get(key), is(equalTo(expected.get(key))))
                    );
                }),

                DynamicTest.dynamicTest("unknown", () -> {
                    final String key = "unknown";

                    final Map<String, Object> expected = getMapBasicArrays();

                    final Map<String, Object> actual = new ReverseTransformation()
                            .perform(new PathElementImpl(key), getMapBasicArrays(), null);

                    assertThat(actual, is(notNullValue()));
                    assertAll("Checking maps",
                            () -> assertThat(actual, is(equalTo(expected))),
                            () -> assertThat(actual.get(key), is(equalTo(expected.get(key))))
                    );
                })

        );
    }

}
