package com.github.nhojpatrick.cucumber.json.transformations.remove;

import com.github.nhojpatrick.cucumber.json.core.validation.PathElement;
import com.github.nhojpatrick.cucumber.json.core.validation.impl.PathArrayElementImpl;
import com.github.nhojpatrick.cucumber.json.core.validation.impl.PathAttributeElementImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.util.Arrays;
import java.util.Collection;
import java.util.Map;

import static com.github.nhojpatrick.cucumber.testing.internal.objects.legacy2.Legacy2TestingInternalObjectsConstants.getLegacy2MapBasicAttributes;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

public class RemoveTransformation_BasicAttributesTest {

    private static final String TYPE = "BasicAttribute";

    @TestFactory
    @DisplayName("Remove Transformation " + TYPE + " Array Paths Tests")
    public Collection<DynamicTest> arrayPaths() {

        return Arrays.asList(

                dynamicTest("objects_array", () -> {
                    final String key = "objects_array";

                    final PathElement pathElement = new PathAttributeElementImpl(key);

                    final Map<String, Object> expected = getLegacy2MapBasicAttributes();

                    final Map<String, Object> actual = new RemoveTransformation()
                            .perform(pathElement, getLegacy2MapBasicAttributes(), null);

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

                    final Map<String, Object> expected = getLegacy2MapBasicAttributes();

                    final Map<String, Object> actual = new RemoveTransformation()
                            .perform(pathElement, getLegacy2MapBasicAttributes(), null);

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

                    final Map<String, Object> expected = getLegacy2MapBasicAttributes();

                    final Map<String, Object> actual = new RemoveTransformation()
                            .perform(pathElement, getLegacy2MapBasicAttributes(), null);

                    assertThat(actual, is(notNullValue()));
                    assertAll("Checking maps",
                            () -> assertThat(actual, is(equalTo(expected))),
                            () -> assertThat(actual.get(key), is(equalTo(expected.get(key))))
                    );
                }),

                dynamicTest("primitive", () -> {
                    final String key = "primitive";

                    final PathElement pathElement = new PathAttributeElementImpl(key);

                    final Map<String, Object> expected = getLegacy2MapBasicAttributes();
                    expected.remove(key);

                    final Map<String, Object> actual = new RemoveTransformation()
                            .perform(pathElement, getLegacy2MapBasicAttributes(), null);

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

                    final Map<String, Object> expected = getLegacy2MapBasicAttributes();

                    final Map<String, Object> actual = new RemoveTransformation()
                            .perform(pathElement, getLegacy2MapBasicAttributes(), null);

                    assertThat(actual, is(notNullValue()));
                    assertAll("Checking maps",
                            () -> assertThat(actual, is(equalTo(expected))),
                            () -> assertThat(actual.get(key), is(equalTo(expected.get(key))))
                    );
                }),

                dynamicTest("primitive[5]", () -> {
                    final String key = "primitive";
                    final int arrayIndex = 5;

                    final PathElement pathElement = new PathArrayElementImpl(String.format("%s[%s]", key, arrayIndex), key, arrayIndex);

                    final Map<String, Object> expected = getLegacy2MapBasicAttributes();

                    final Map<String, Object> actual = new RemoveTransformation()
                            .perform(pathElement, getLegacy2MapBasicAttributes(), null);

                    assertThat(actual, is(notNullValue()));
                    assertAll("Checking maps",
                            () -> assertThat(actual, is(equalTo(expected))),
                            () -> assertThat(actual.get(key), is(equalTo(expected.get(key))))
                    );
                }),

                dynamicTest("primitives_array", () -> {
                    final String key = "primitives_array";

                    final PathElement pathElement = new PathAttributeElementImpl(key);

                    final Map<String, Object> expected = getLegacy2MapBasicAttributes();

                    final Map<String, Object> actual = new RemoveTransformation()
                            .perform(pathElement, getLegacy2MapBasicAttributes(), null);

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

                    final Map<String, Object> expected = getLegacy2MapBasicAttributes();

                    final Map<String, Object> actual = new RemoveTransformation()
                            .perform(pathElement, getLegacy2MapBasicAttributes(), null);

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

                    final Map<String, Object> expected = getLegacy2MapBasicAttributes();

                    final Map<String, Object> actual = new RemoveTransformation()
                            .perform(pathElement, getLegacy2MapBasicAttributes(), null);

                    assertThat(actual, is(notNullValue()));
                    assertAll("Checking maps",
                            () -> assertThat(actual, is(equalTo(expected))),
                            () -> assertThat(actual.get(key), is(equalTo(expected.get(key))))
                    );
                }),

                dynamicTest("unknown", () -> {
                    final String key = "unknown";

                    final PathElement pathElement = new PathAttributeElementImpl(key);

                    final Map<String, Object> expected = getLegacy2MapBasicAttributes();

                    final Map<String, Object> actual = new RemoveTransformation()
                            .perform(pathElement, getLegacy2MapBasicAttributes(), null);

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

                    final Map<String, Object> expected = getLegacy2MapBasicAttributes();

                    final Map<String, Object> actual = new RemoveTransformation()
                            .perform(pathElement, getLegacy2MapBasicAttributes(), null);

                    assertThat(actual, is(notNullValue()));
                    assertAll("Checking maps",
                            () -> assertThat(actual, is(equalTo(expected))),
                            () -> assertThat(actual.get(key), is(equalTo(expected.get(key))))
                    );
                })

        );
    }

    @TestFactory
    @DisplayName("Remove Transformation " + TYPE + " Primitive Paths Tests")
    public Collection<DynamicTest> primitivePaths() {

        return Arrays.asList(

                dynamicTest("a_boolean", () -> {
                    final String key = "a_boolean";

                    final PathElement pathElement = new PathAttributeElementImpl(key);

                    final Map<String, Object> expected = getLegacy2MapBasicAttributes();
                    expected.remove(key);

                    final Map<String, Object> actual = new RemoveTransformation()
                            .perform(pathElement, getLegacy2MapBasicAttributes(), null);

                    assertThat(actual, is(notNullValue()));
                    assertAll("Checking maps",
                            () -> assertThat(actual, is(equalTo(expected))),
                            () -> assertThat(actual.get(key), is(equalTo(expected.get(key))))
                    );
                }),

                dynamicTest("a_float", () -> {
                    final String key = "a_float";

                    final PathElement pathElement = new PathAttributeElementImpl(key);

                    final Map<String, Object> expected = getLegacy2MapBasicAttributes();
                    expected.remove(key);

                    final Map<String, Object> actual = new RemoveTransformation()
                            .perform(pathElement, getLegacy2MapBasicAttributes(), null);

                    assertThat(actual, is(notNullValue()));
                    assertAll("Checking maps",
                            () -> assertThat(actual, is(equalTo(expected))),
                            () -> assertThat(actual.get(key), is(equalTo(expected.get(key))))
                    );
                }),

                dynamicTest("a_integer", () -> {
                    final String key = "a_integer";

                    final PathElement pathElement = new PathAttributeElementImpl(key);

                    final Map<String, Object> expected = getLegacy2MapBasicAttributes();
                    expected.remove(key);

                    final Map<String, Object> actual = new RemoveTransformation()
                            .perform(pathElement, getLegacy2MapBasicAttributes(), null);

                    assertThat(actual, is(notNullValue()));
                    assertAll("Checking maps",
                            () -> assertThat(actual, is(equalTo(expected))),
                            () -> assertThat(actual.get(key), is(equalTo(expected.get(key))))
                    );
                }),

                dynamicTest("a_null", () -> {
                    final String key = "a_null";

                    final PathElement pathElement = new PathAttributeElementImpl(key);

                    final Map<String, Object> expected = getLegacy2MapBasicAttributes();
                    expected.remove(key);

                    final Map<String, Object> actual = new RemoveTransformation()
                            .perform(pathElement, getLegacy2MapBasicAttributes(), null);

                    assertThat(actual, is(notNullValue()));
                    assertAll("Checking maps",
                            () -> assertThat(actual, is(equalTo(expected))),
                            () -> assertThat(actual.get(key), is(equalTo(expected.get(key))))
                    );
                }),

                dynamicTest("a_object", () -> {
                    final String key = "a_object";

                    final PathElement pathElement = new PathAttributeElementImpl(key);

                    final Map<String, Object> expected = getLegacy2MapBasicAttributes();
                    expected.remove(key);

                    final Map<String, Object> actual = new RemoveTransformation()
                            .perform(pathElement, getLegacy2MapBasicAttributes(), null);

                    assertThat(actual, is(notNullValue()));
                    assertAll("Checking maps",
                            () -> assertThat(actual, is(equalTo(expected))),
                            () -> assertThat(actual.get(key), is(equalTo(expected.get(key))))
                    );
                }),

                dynamicTest("a_string", () -> {
                    final String key = "a_string";

                    final PathElement pathElement = new PathAttributeElementImpl(key);

                    final Map<String, Object> expected = getLegacy2MapBasicAttributes();
                    expected.remove(key);

                    final Map<String, Object> actual = new RemoveTransformation()
                            .perform(pathElement, getLegacy2MapBasicAttributes(), null);

                    assertThat(actual, is(notNullValue()));
                    assertAll("Checking maps",
                            () -> assertThat(actual, is(equalTo(expected))),
                            () -> assertThat(actual.get(key), is(equalTo(expected.get(key))))
                    );
                }),

                dynamicTest("unknown", () -> {
                    final String key = "unknown";

                    final PathElement pathElement = new PathAttributeElementImpl(key);

                    final Map<String, Object> expected = getLegacy2MapBasicAttributes();

                    final Map<String, Object> actual = new RemoveTransformation()
                            .perform(pathElement, getLegacy2MapBasicAttributes(), null);

                    assertThat(actual, is(notNullValue()));
                    assertAll("Checking maps",
                            () -> assertThat(actual, is(equalTo(expected))),
                            () -> assertThat(actual.get(key), is(equalTo(expected.get(key))))
                    );
                })

        );
    }

}
