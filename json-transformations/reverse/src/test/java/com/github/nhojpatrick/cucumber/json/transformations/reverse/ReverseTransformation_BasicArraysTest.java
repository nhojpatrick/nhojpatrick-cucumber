package com.github.nhojpatrick.cucumber.json.transformations.reverse;

import com.github.nhojpatrick.cucumber.json.core.exceptions.IllegalPathOperationException;
import com.github.nhojpatrick.cucumber.json.core.validation.PathElement;
import com.github.nhojpatrick.cucumber.json.core.validation.impl.PathArrayElementImpl;
import com.github.nhojpatrick.cucumber.json.core.validation.impl.PathAttributeElementImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.function.Executable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import static com.github.nhojpatrick.cucumber.testing.internal.objects.legacy2.Legacy2TestingInternalObjectsConstants.getLegacy2MapBasicArrays;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

public class ReverseTransformation_BasicArraysTest {

    private static final String TYPE = "BasicArray";

    @TestFactory
    @DisplayName("Reverse Transformation " + TYPE + " Array Paths Tests")
    public Collection<DynamicTest> arrayPaths() {

        return Arrays.asList(

                dynamicTest("objects_array", () -> {
                    final String key = "objects_array";

                    final PathElement pathElement = new PathAttributeElementImpl(key);

                    final Map<String, Object> expected = getLegacy2MapBasicArrays();

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
                            .perform(pathElement, getLegacy2MapBasicArrays(), null);

                    assertThat(actual, is(notNullValue()));
                    assertAll("Checking maps",
                            () -> assertThat(actual, is(equalTo(expected))),
                            () -> assertThat(actual.get(key), is(equalTo(expected.get(key))))
                    );
                }),

                dynamicTest("objects_array[1]", () -> {
                    final String key = "objects_array";
                    final int arrayIndex = 1;

                    final PathElement pathElement = new PathArrayElementImpl(String.format("%s[%s]", key, arrayIndex), key, arrayIndex);

                    final Executable testMethod = () -> new ReverseTransformation()
                            .perform(pathElement, getLegacy2MapBasicArrays(), "objects_array[1]");

                    final IllegalPathOperationException thrown = assertThrows(IllegalPathOperationException.class, testMethod);
                    assertAll("Checking Exception",
                            () -> assertThat(thrown.getMessage(), is(equalTo("Unable to reverse JsonObject, at path 'objects_array[1]'."))),
                            () -> assertThat(thrown.getCause(), is(nullValue()))
                    );
                }),

                dynamicTest("objects_array[5]", () -> {
                    final String key = "objects_array";
                    final int arrayIndex = 5;

                    final PathElement pathElement = new PathArrayElementImpl(String.format("%s[%s]", key, arrayIndex), key, arrayIndex);

                    final Map<String, Object> expected = getLegacy2MapBasicArrays();

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

                    final Map<String, Object> actual = new ReverseTransformation()
                            .perform(pathElement, getLegacy2MapBasicArrays(), null);

                    assertThat(actual, is(notNullValue()));
                    assertAll("Checking maps",
                            () -> assertThat(actual, is(equalTo(expected))),
                            () -> assertThat(actual.get(key), is(equalTo(expected.get(key))))
                    );
                }),

                dynamicTest("primitive", () -> {
                    final String key = "primitive";

                    final PathElement pathElement = new PathAttributeElementImpl(key);

                    final Map<String, Object> expected = getLegacy2MapBasicArrays();
                    expected.put(key, "evitimirPa");

                    final Map<String, Object> actual = new ReverseTransformation()
                            .perform(pathElement, getLegacy2MapBasicArrays(), null);

                    assertThat(actual, is(notNullValue()));
                    assertAll("Checking maps",
                            () -> assertThat(actual, is(equalTo(expected))),
                            () -> assertThat(actual.get(key), is(equalTo(expected.get(key))))
                    );
                }),

                dynamicTest("primitive[1]", () -> {
                    final String key = "primitive";
                    final int arrayIndex = 1;

                    final PathElement pathElement = new PathArrayElementImpl(String.format("%s[%s]", key, arrayIndex), key, arrayIndex);

                    final Executable testMethod = () -> new ReverseTransformation()
                            .perform(pathElement, getLegacy2MapBasicArrays(), null);

                    final IllegalPathOperationException thrown = assertThrows(IllegalPathOperationException.class, testMethod);
                    assertAll("Checking Exception",
                            () -> assertThat(thrown.getMessage(), is(equalTo(String.format(
                                    "Unable to reverse path '%s[%s]', as is not Array.",
                                    key,
                                    arrayIndex
                            )))),
                            () -> assertThat(thrown.getCause(), is(nullValue()))
                    );
                }),

                dynamicTest("primitive[5]", () -> {
                    final String key = "primitive";
                    final int arrayIndex = 5;

                    final PathElement pathElement = new PathArrayElementImpl(String.format("%s[%s]", key, arrayIndex), key, arrayIndex);

                    final Executable testMethod = () -> new ReverseTransformation()
                            .perform(pathElement, getLegacy2MapBasicArrays(), null);

                    final IllegalPathOperationException thrown = assertThrows(IllegalPathOperationException.class, testMethod);
                    assertAll("Checking Exception",
                            () -> assertThat(thrown.getMessage(), is(equalTo(String.format(
                                    "Unable to reverse path '%s[%s]', as is not Array.",
                                    key,
                                    arrayIndex
                            )))),
                            () -> assertThat(thrown.getCause(), is(nullValue()))
                    );
                }),

                dynamicTest("primitives_array", () -> {
                    final String key = "primitives_array";

                    final PathElement pathElement = new PathAttributeElementImpl(key);

                    final Map<String, Object> expected = getLegacy2MapBasicArrays();
                    expected.put(key, new ArrayList<>(Arrays.asList(
                            "dPrimitiveArray",
                            "cPrimitiveArray",
                            "bPrimitiveArray",
                            "aPrimitiveArray"
                    )));

                    final Map<String, Object> actual = new ReverseTransformation()
                            .perform(pathElement, getLegacy2MapBasicArrays(), null);

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

                    final Map<String, Object> expected = getLegacy2MapBasicArrays();
                    expected.put(key, new ArrayList<>(Arrays.asList(
                            "aPrimitiveArray",
                            "yarrAevitimirPb",
                            "cPrimitiveArray",
                            "dPrimitiveArray"
                    )));

                    final Map<String, Object> actual = new ReverseTransformation()
                            .perform(pathElement, getLegacy2MapBasicArrays(), null);

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

                    final Map<String, Object> expected = getLegacy2MapBasicArrays();
                    expected.put(key, new ArrayList<>(Arrays.asList(
                            "aPrimitiveArray",
                            "bPrimitiveArray",
                            "cPrimitiveArray",
                            "dPrimitiveArray",
                            null,
                            null
                    )));

                    final Map<String, Object> actual = new ReverseTransformation()
                            .perform(pathElement, getLegacy2MapBasicArrays(), null);

                    assertThat(actual, is(notNullValue()));
                    assertAll("Checking maps",
                            () -> assertThat(actual, is(equalTo(expected))),
                            () -> assertThat(actual.get(key), is(equalTo(expected.get(key))))
                    );
                }),

                dynamicTest("unknown", () -> {
                    final String key = "unknown";

                    final PathElement pathElement = new PathAttributeElementImpl(key);

                    final Map<String, Object> expected = getLegacy2MapBasicArrays();

                    final Map<String, Object> actual = new ReverseTransformation()
                            .perform(pathElement, getLegacy2MapBasicArrays(), null);

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

                    final Map<String, Object> expected = getLegacy2MapBasicArrays();

                    final Map<String, Object> actual = new ReverseTransformation()
                            .perform(pathElement, getLegacy2MapBasicArrays(), null);

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

                dynamicTest("a_boolean", () -> {
                    final String key = "a_boolean";

                    final PathElement pathElement = new PathAttributeElementImpl(key);

                    final Map<String, Object> expected = getLegacy2MapBasicArrays();

                    final Map<String, Object> actual = new ReverseTransformation()
                            .perform(pathElement, getLegacy2MapBasicArrays(), null);

                    assertThat(actual, is(notNullValue()));
                    assertAll("Checking maps",
                            () -> assertThat(actual, is(equalTo(expected))),
                            () -> assertThat(actual.get(key), is(equalTo(expected.get(key))))
                    );
                }),

                dynamicTest("a_float", () -> {
                    final String key = "a_float";

                    final PathElement pathElement = new PathAttributeElementImpl(key);

                    final Map<String, Object> expected = getLegacy2MapBasicArrays();

                    final Map<String, Object> actual = new ReverseTransformation()
                            .perform(pathElement, getLegacy2MapBasicArrays(), null);

                    assertThat(actual, is(notNullValue()));
                    assertAll("Checking maps",
                            () -> assertThat(actual, is(equalTo(expected))),
                            () -> assertThat(actual.get(key), is(equalTo(expected.get(key))))
                    );
                }),

                dynamicTest("a_integer", () -> {
                    final String key = "a_integer";

                    final PathElement pathElement = new PathAttributeElementImpl(key);

                    final Map<String, Object> expected = getLegacy2MapBasicArrays();

                    final Map<String, Object> actual = new ReverseTransformation()
                            .perform(pathElement, getLegacy2MapBasicArrays(), null);

                    assertThat(actual, is(notNullValue()));
                    assertAll("Checking maps",
                            () -> assertThat(actual, is(equalTo(expected))),
                            () -> assertThat(actual.get(key), is(equalTo(expected.get(key))))
                    );
                }),

                dynamicTest("a_null", () -> {
                    final String key = "a_null";

                    final PathElement pathElement = new PathAttributeElementImpl(key);

                    final Map<String, Object> expected = getLegacy2MapBasicArrays();

                    final Map<String, Object> actual = new ReverseTransformation()
                            .perform(pathElement, getLegacy2MapBasicArrays(), null);

                    assertThat(actual, is(notNullValue()));
                    assertAll("Checking maps",
                            () -> assertThat(actual, is(equalTo(expected))),
                            () -> assertThat(actual.get(key), is(equalTo(expected.get(key))))
                    );
                }),

                dynamicTest("a_object", () -> {
                    final String key = "a_object";

                    final PathElement pathElement = new PathAttributeElementImpl(key);

                    final Map<String, Object> expected = getLegacy2MapBasicArrays();

                    final Map<String, Object> actual = new ReverseTransformation()
                            .perform(pathElement, getLegacy2MapBasicArrays(), null);

                    assertThat(actual, is(notNullValue()));
                    assertAll("Checking maps",
                            () -> assertThat(actual, is(equalTo(expected))),
                            () -> assertThat(actual.get(key), is(equalTo(expected.get(key))))
                    );
                }),

                dynamicTest("a_string", () -> {
                    final String key = "a_string";

                    final PathElement pathElement = new PathAttributeElementImpl(key);

                    final Map<String, Object> expected = getLegacy2MapBasicArrays();

                    final Map<String, Object> actual = new ReverseTransformation()
                            .perform(pathElement, getLegacy2MapBasicArrays(), null);

                    assertThat(actual, is(notNullValue()));
                    assertAll("Checking maps",
                            () -> assertThat(actual, is(equalTo(expected))),
                            () -> assertThat(actual.get(key), is(equalTo(expected.get(key))))
                    );
                }),

                dynamicTest("unknown", () -> {
                    final String key = "unknown";

                    final PathElement pathElement = new PathAttributeElementImpl(key);

                    final Map<String, Object> expected = getLegacy2MapBasicArrays();

                    final Map<String, Object> actual = new ReverseTransformation()
                            .perform(pathElement, getLegacy2MapBasicArrays(), null);

                    assertThat(actual, is(notNullValue()));
                    assertAll("Checking maps",
                            () -> assertThat(actual, is(equalTo(expected))),
                            () -> assertThat(actual.get(key), is(equalTo(expected.get(key))))
                    );
                })

        );
    }

}
