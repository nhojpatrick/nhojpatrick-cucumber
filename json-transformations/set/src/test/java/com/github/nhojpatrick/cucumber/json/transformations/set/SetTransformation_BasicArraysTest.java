package com.github.nhojpatrick.cucumber.json.transformations.set;

import com.github.nhojpatrick.cucumber.json.core.validation.PathElement;
import com.github.nhojpatrick.cucumber.json.core.validation.impl.PathArrayElementImpl;
import com.github.nhojpatrick.cucumber.json.core.validation.impl.PathAttributeElementImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

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
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

public class SetTransformation_BasicArraysTest {

    private static final String TYPE = "BasicArray";

    @TestFactory
    @DisplayName("Set Transformation " + TYPE + " Array Paths Tests")
    public Collection<DynamicTest> arrayPaths() {

        return Arrays.asList(

                dynamicTest("objects_array[1]", () -> {
                    final String key = "objects_array";
                    final int arrayIndex = 1;

                    final PathElement pathElement = new PathArrayElementImpl(String.format("%s[%s]", key, arrayIndex), key, arrayIndex);

                    final Map<String, Object> aObjectArray = new HashMap<>();
                    aObjectArray.put("object_array_id", "aObjectArrayId");

                    final Map<String, Object> cObjectArray = new HashMap<>();
                    cObjectArray.put("object_array_id", "cObjectArrayId");

                    final Map<String, Object> dObjectArray = new HashMap<>();
                    dObjectArray.put("object_array_id", "dObjectArrayId");

                    final Map<String, Object> expected = getMapBasicArrays();
                    expected.put(key, new ArrayList<>(Arrays.asList(
                            aObjectArray,
                            "newStringValue",
                            cObjectArray,
                            dObjectArray
                    )));

                    final Map<String, Object> actual = new SetTransformation("newStringValue")
                            .perform(pathElement, getMapBasicArrays(), null);

                    assertThat(actual, is(notNullValue()));
                    assertAll("Checking maps",
                            () -> assertThat(actual, is(equalTo(expected))),
                            () -> assertThat(actual.get(key), is(equalTo(expected.get(key))))
                    );
                }),

                dynamicTest("objects_array[5]", () -> {
                    final String key = "objects_array";
                    final int arrayIndex = 5;

                    final PathElement pathElement = new PathArrayElementImpl(String.format("%s[%s]", key, arrayIndex), key, arrayIndex);

                    final Map<String, Object> aObjectArray = new HashMap<>();
                    aObjectArray.put("object_array_id", "aObjectArrayId");

                    final Map<String, Object> bObjectArray = new HashMap<>();
                    bObjectArray.put("object_array_id", "bObjectArrayId");

                    final Map<String, Object> cObjectArray = new HashMap<>();
                    cObjectArray.put("object_array_id", "cObjectArrayId");

                    final Map<String, Object> dObjectArray = new HashMap<>();
                    dObjectArray.put("object_array_id", "dObjectArrayId");

                    final Map<String, Object> expected = getMapBasicArrays();
                    expected.put(key, new ArrayList<>(Arrays.asList(
                            aObjectArray,
                            bObjectArray,
                            cObjectArray,
                            dObjectArray,
                            null,
                            "newStringValue"
                    )));

                    final Map<String, Object> actual = new SetTransformation("newStringValue")
                            .perform(pathElement, getMapBasicArrays(), null);

                    assertThat(actual, is(notNullValue()));
                    assertAll("Checking maps",
                            () -> assertThat(actual, is(equalTo(expected))),
                            () -> assertThat(actual.get(key), is(equalTo(expected.get(key))))
                    );
                }),

                dynamicTest("objects_empty[1]", () -> {
                    final String key = "objects_empty";
                    final int arrayIndex = 1;

                    final PathElement pathElement = new PathArrayElementImpl(String.format("%s[%s]", key, arrayIndex), key, arrayIndex);

                    final Map<String, Object> expected = getMapBasicArrays();
                    expected.put(key, new ArrayList<>(Arrays.asList(
                            null,
                            "newStringValue"
                    )));

                    final Map<String, Object> actual = new SetTransformation("newStringValue")
                            .perform(pathElement, getMapBasicArrays(), null);

                    assertThat(actual, is(notNullValue()));
                    assertAll("Checking maps",
                            () -> assertThat(actual, is(equalTo(expected))),
                            () -> assertThat(actual.get(key), is(equalTo(expected.get(key))))
                    );
                }),

                dynamicTest("objects_null[1]", () -> {
                    final String key = "objects_null";
                    final int arrayIndex = 1;

                    final PathElement pathElement = new PathArrayElementImpl(String.format("%s[%s]", key, arrayIndex), key, arrayIndex);

                    final Map<String, Object> expected = getMapBasicArrays();
                    expected.put(key, new ArrayList<>(Arrays.asList(
                            null,
                            "newStringValue"
                    )));

                    final Map<String, Object> actual = new SetTransformation("newStringValue")
                            .perform(pathElement, getMapBasicArrays(), null);

                    assertThat(actual, is(notNullValue()));
                    assertAll("Checking maps",
                            () -> assertThat(actual, is(equalTo(expected))),
                            () -> assertThat(actual.get(key), is(equalTo(expected.get(key))))
                    );
                }),

                dynamicTest("primitives_array[1]", () -> {
                    final String key = "primitives_array";
                    final int arrayIndex = 1;

                    final PathElement pathElement = new PathArrayElementImpl(String.format("%s[%s]", key, arrayIndex), key, arrayIndex);

                    final Map<String, Object> expected = getMapBasicArrays();
                    expected.put(key, new ArrayList<>(Arrays.asList(
                            "aPrimitiveArray",
                            "newStringValue",
                            "cPrimitiveArray",
                            "dPrimitiveArray"
                    )));

                    final Map<String, Object> actual = new SetTransformation("newStringValue")
                            .perform(pathElement, getMapBasicArrays(), "");

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

                    final Map<String, Object> expected = getMapBasicArrays();
                    expected.put(key, new ArrayList<>(Arrays.asList(
                            "aPrimitiveArray",
                            "bPrimitiveArray",
                            "cPrimitiveArray",
                            "dPrimitiveArray",
                            null,
                            "newStringValue"
                    )));

                    final Map<String, Object> actual = new SetTransformation("newStringValue")
                            .perform(pathElement, getMapBasicArrays(), "");

                    assertThat(actual, is(notNullValue()));
                    assertAll("Checking maps",
                            () -> assertThat(actual, is(equalTo(expected))),
                            () -> assertThat(actual.get(key), is(equalTo(expected.get(key))))
                    );
                }),

                dynamicTest("primitives_empty[1]", () -> {
                    final String key = "primitives_empty";
                    final int arrayIndex = 1;

                    final PathElement pathElement = new PathArrayElementImpl(String.format("%s[%s]", key, arrayIndex), key, arrayIndex);

                    final Map<String, Object> expected = getMapBasicArrays();
                    expected.put(key, new ArrayList<>(Arrays.asList(
                            null,
                            "newStringValue"
                    )));

                    final Map<String, Object> actual = new SetTransformation("newStringValue")
                            .perform(pathElement, getMapBasicArrays(), "");

                    assertThat(actual, is(notNullValue()));
                    assertAll("Checking maps",
                            () -> assertThat(actual, is(equalTo(expected))),
                            () -> assertThat(actual.get(key), is(equalTo(expected.get(key))))
                    );
                }),

                dynamicTest("primitives_null[1]", () -> {
                    final String key = "primitives_null";
                    final int arrayIndex = 1;

                    final PathElement pathElement = new PathArrayElementImpl(String.format("%s[%s]", key, arrayIndex), key, arrayIndex);

                    final Map<String, Object> expected = getMapBasicArrays();
                    expected.put(key, new ArrayList<>(Arrays.asList(
                            null,
                            "newStringValue"
                    )));

                    final Map<String, Object> actual = new SetTransformation("newStringValue")
                            .perform(pathElement, getMapBasicArrays(), "");

                    assertThat(actual, is(notNullValue()));
                    assertAll("Checking maps",
                            () -> assertThat(actual, is(equalTo(expected))),
                            () -> assertThat(actual.get(key), is(equalTo(expected.get(key))))
                    );
                }),

                dynamicTest("unknown[1]", () -> {
                    final String key = "unknown";
                    final int arrayIndex = 1;

                    final PathElement pathElement = new PathArrayElementImpl(String.format("%s[%s]", key, arrayIndex), key, arrayIndex);

                    final Map<String, Object> expected = getMapBasicArrays();
                    expected.put(key, new ArrayList<>(Arrays.asList(
                            null,
                            "newStringValue"
                    )));

                    final Map<String, Object> actual = new SetTransformation("newStringValue")
                            .perform(pathElement, getMapBasicArrays(), "");

                    assertThat(actual, is(notNullValue()));
                    assertAll("Checking maps",
                            () -> assertThat(actual, is(equalTo(expected))),
                            () -> assertThat(actual.get(key), is(equalTo(expected.get(key))))
                    );
                })

        );
    }

    @TestFactory
    @DisplayName("Set Transformation " + TYPE + " Primitive Paths Tests")
    public Collection<DynamicTest> primitivePaths() {

        return Arrays.asList(

                dynamicTest("objects_array", () -> {
                    final String key = "objects_array";

                    final PathElement pathElement = new PathAttributeElementImpl(key);

                    final Map<String, Object> expected = getMapBasicArrays();
                    expected.put(key, "newStringValue");

                    final Map<String, Object> actual = new SetTransformation("newStringValue")
                            .perform(pathElement, getMapBasicArrays(), null);

                    assertThat(actual, is(notNullValue()));
                    assertAll("Checking maps",
                            () -> assertThat(actual, is(equalTo(expected))),
                            () -> assertThat(actual.get(key), is(equalTo(expected.get(key))))
                    );
                }),

                dynamicTest("objects_empty", () -> {
                    final String key = "objects_empty";

                    final PathElement pathElement = new PathAttributeElementImpl(key);

                    final Map<String, Object> expected = getMapBasicArrays();
                    expected.put(key, "newStringValue");

                    final Map<String, Object> actual = new SetTransformation("newStringValue")
                            .perform(pathElement, getMapBasicArrays(), null);

                    assertThat(actual, is(notNullValue()));
                    assertAll("Checking maps",
                            () -> assertThat(actual, is(equalTo(expected))),
                            () -> assertThat(actual.get(key), is(equalTo(expected.get(key))))
                    );
                }),

                dynamicTest("objects_null", () -> {
                    final String key = "objects_null";

                    final PathElement pathElement = new PathAttributeElementImpl(key);

                    final Map<String, Object> expected = getMapBasicArrays();
                    expected.put(key, "newStringValue");

                    final Map<String, Object> actual = new SetTransformation("newStringValue")
                            .perform(pathElement, getMapBasicArrays(), null);

                    assertThat(actual, is(notNullValue()));
                    assertAll("Checking maps",
                            () -> assertThat(actual, is(equalTo(expected))),
                            () -> assertThat(actual.get(key), is(equalTo(expected.get(key))))
                    );
                }),


                dynamicTest("primitives_array", () -> {
                    final String key = "primitives_array";

                    final PathElement pathElement = new PathAttributeElementImpl(key);

                    final Map<String, Object> expected = getMapBasicArrays();
                    expected.put(key, "newStringValue");

                    final Map<String, Object> actual = new SetTransformation("newStringValue")
                            .perform(pathElement, getMapBasicArrays(), null);

                    assertThat(actual, is(notNullValue()));
                    assertAll("Checking maps",
                            () -> assertThat(actual, is(equalTo(expected))),
                            () -> assertThat(actual.get(key), is(equalTo(expected.get(key))))
                    );
                }),

                dynamicTest("primitives_empty", () -> {
                    final String key = "primitives_empty";

                    final PathElement pathElement = new PathAttributeElementImpl(key);

                    final Map<String, Object> expected = getMapBasicArrays();
                    expected.put(key, "newStringValue");

                    final Map<String, Object> actual = new SetTransformation("newStringValue")
                            .perform(pathElement, getMapBasicArrays(), null);

                    assertThat(actual, is(notNullValue()));
                    assertAll("Checking maps",
                            () -> assertThat(actual, is(equalTo(expected))),
                            () -> assertThat(actual.get(key), is(equalTo(expected.get(key))))
                    );
                }),

                dynamicTest("primitives_null", () -> {
                    final String key = "primitives_null";

                    final PathElement pathElement = new PathAttributeElementImpl(key);

                    final Map<String, Object> expected = getMapBasicArrays();
                    expected.put(key, "newStringValue");

                    final Map<String, Object> actual = new SetTransformation("newStringValue")
                            .perform(pathElement, getMapBasicArrays(), null);

                    assertThat(actual, is(notNullValue()));
                    assertAll("Checking maps",
                            () -> assertThat(actual, is(equalTo(expected))),
                            () -> assertThat(actual.get(key), is(equalTo(expected.get(key))))
                    );
                }),

                dynamicTest("unknown", () -> {
                    final String key = "unknown";

                    final PathElement pathElement = new PathAttributeElementImpl(key);

                    final Map<String, Object> expected = getMapBasicArrays();
                    expected.put(key, "newStringValue");

                    final Map<String, Object> actual = new SetTransformation("newStringValue")
                            .perform(pathElement, getMapBasicArrays(), null);

                    assertThat(actual, is(notNullValue()));
                    assertAll("Checking maps",
                            () -> assertThat(actual, is(equalTo(expected))),
                            () -> assertThat(actual.get(key), is(equalTo(expected.get(key))))
                    );
                })

        );
    }

}
