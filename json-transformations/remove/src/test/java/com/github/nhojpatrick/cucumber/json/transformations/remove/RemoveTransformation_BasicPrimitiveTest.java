package com.github.nhojpatrick.cucumber.json.transformations.remove;

import com.github.nhojpatrick.cucumber.json.core.validation.impl.PathArrayElementImpl;
import com.github.nhojpatrick.cucumber.json.core.validation.impl.PathAttributeElementImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.util.Arrays;
import java.util.Collection;
import java.util.Map;

import static com.github.nhojpatrick.cucumber.testing.internal.objects.TestingInternalObjectsConstants.getMapBasicPrimitives;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.jupiter.api.Assertions.assertAll;

public class RemoveTransformation_BasicPrimitiveTest {

    private static final String TYPE = "BasicPrimitive";

    @TestFactory
    @DisplayName("Remove Transformation " + TYPE + " Array Paths Tests")
    public Collection<DynamicTest> arrayPaths() {

        return Arrays.asList(

                DynamicTest.dynamicTest("objects_array", () -> {
                    final String key = "objects_array";

                    final Map<String, Object> expected = getMapBasicPrimitives();

                    final Map<String, Object> actual = new RemoveTransformation()
                            .perform(new PathAttributeElementImpl(key), getMapBasicPrimitives(), null);

                    assertThat(actual, is(notNullValue()));
                    assertAll("Checking maps",
                            () -> assertThat(actual, is(equalTo(expected))),
                            () -> assertThat(actual.get(key), is(equalTo(expected.get(key))))
                    );
                }),

                DynamicTest.dynamicTest("objects_array[1]", () -> {
                    final String key = "objects_array";
                    final int arrayIndex = 1;

                    final Map<String, Object> expected = getMapBasicPrimitives();

                    final PathArrayElementImpl pathElement = new PathArrayElementImpl(String.format("%s[%s]", key, arrayIndex), key, arrayIndex);
                    final Map<String, Object> actual = new RemoveTransformation()
                            .perform(pathElement, getMapBasicPrimitives(), null);

                    assertThat(actual, is(notNullValue()));
                    assertAll("Checking maps",
                            () -> assertThat(actual, is(equalTo(expected))),
                            () -> assertThat(actual.get(key), is(equalTo(expected.get(key))))
                    );
                }),

                DynamicTest.dynamicTest("objects_array[5]", () -> {
                    final String key = "objects_array";
                    final int arrayIndex = 5;

                    final Map<String, Object> expected = getMapBasicPrimitives();

                    final PathArrayElementImpl pathElement = new PathArrayElementImpl(String.format("%s[%s]", key, arrayIndex), key, arrayIndex);
                    final Map<String, Object> actual = new RemoveTransformation()
                            .perform(pathElement, getMapBasicPrimitives(), null);

                    assertThat(actual, is(notNullValue()));
                    assertAll("Checking maps",
                            () -> assertThat(actual, is(equalTo(expected))),
                            () -> assertThat(actual.get(key), is(equalTo(expected.get(key))))
                    );
                }),

                DynamicTest.dynamicTest("primitive", () -> {
                    final String key = "primitive";

                    final Map<String, Object> expected = getMapBasicPrimitives();
                    expected.remove(key);

                    final Map<String, Object> actual = new RemoveTransformation()
                            .perform(new PathAttributeElementImpl(key), getMapBasicPrimitives(), null);

                    assertThat(actual, is(notNullValue()));
                    assertAll("Checking maps",
                            () -> assertThat(actual, is(equalTo(expected))),
                            () -> assertThat(actual.get(key), is(equalTo(expected.get(key))))
                    );
                }),

                DynamicTest.dynamicTest("primitive[1]", () -> {
                    final String key = "primitive";
                    final int arrayIndex = 1;

                    final Map<String, Object> expected = getMapBasicPrimitives();

                    final PathArrayElementImpl pathElement = new PathArrayElementImpl(String.format("%s[%s]", key, arrayIndex), key, arrayIndex);
                    final Map<String, Object> actual = new RemoveTransformation()
                            .perform(pathElement, getMapBasicPrimitives(), null);

                    assertThat(actual, is(notNullValue()));
                    assertAll("Checking maps",
                            () -> assertThat(actual, is(equalTo(expected))),
                            () -> assertThat(actual.get(key), is(equalTo(expected.get(key))))
                    );
                }),

                DynamicTest.dynamicTest("primitive[5]", () -> {
                    final String key = "primitive";
                    final int arrayIndex = 5;

                    final Map<String, Object> expected = getMapBasicPrimitives();

                    final PathArrayElementImpl pathElement = new PathArrayElementImpl(String.format("%s[%s]", key, arrayIndex), key, arrayIndex);
                    final Map<String, Object> actual = new RemoveTransformation()
                            .perform(pathElement, getMapBasicPrimitives(), null);

                    assertThat(actual, is(notNullValue()));
                    assertAll("Checking maps",
                            () -> assertThat(actual, is(equalTo(expected))),
                            () -> assertThat(actual.get(key), is(equalTo(expected.get(key))))
                    );
                }),

                DynamicTest.dynamicTest("primitives_array", () -> {
                    final String key = "primitives_array";

                    final Map<String, Object> expected = getMapBasicPrimitives();

                    final Map<String, Object> actual = new RemoveTransformation()
                            .perform(new PathAttributeElementImpl(key), getMapBasicPrimitives(), null);

                    assertThat(actual, is(notNullValue()));
                    assertAll("Checking maps",
                            () -> assertThat(actual, is(equalTo(expected))),
                            () -> assertThat(actual.get(key), is(equalTo(expected.get(key))))
                    );
                }),

                DynamicTest.dynamicTest("primitives_array[1]", () -> {
                    final String key = "primitives_array";
                    final int arrayIndex = 1;

                    final Map<String, Object> expected = getMapBasicPrimitives();

                    final PathArrayElementImpl pathElement = new PathArrayElementImpl(String.format("%s[%s]", key, arrayIndex), key, arrayIndex);
                    final Map<String, Object> actual = new RemoveTransformation()
                            .perform(pathElement, getMapBasicPrimitives(), null);

                    assertThat(actual, is(notNullValue()));
                    assertAll("Checking maps",
                            () -> assertThat(actual, is(equalTo(expected))),
                            () -> assertThat(actual.get(key), is(equalTo(expected.get(key))))
                    );
                }),

                DynamicTest.dynamicTest("primitives_array[5]", () -> {
                    final String key = "primitives_array";
                    final int arrayIndex = 5;

                    final Map<String, Object> expected = getMapBasicPrimitives();

                    final PathArrayElementImpl pathElement = new PathArrayElementImpl(String.format("%s[%s]", key, arrayIndex), key, arrayIndex);
                    final Map<String, Object> actual = new RemoveTransformation()
                            .perform(pathElement, getMapBasicPrimitives(), null);

                    assertThat(actual, is(notNullValue()));
                    assertAll("Checking maps",
                            () -> assertThat(actual, is(equalTo(expected))),
                            () -> assertThat(actual.get(key), is(equalTo(expected.get(key))))
                    );
                }),

                DynamicTest.dynamicTest("unknown", () -> {
                    final String key = "unknown";

                    final Map<String, Object> expected = getMapBasicPrimitives();

                    final Map<String, Object> actual = new RemoveTransformation()
                            .perform(new PathAttributeElementImpl(key), getMapBasicPrimitives(), null);

                    assertThat(actual, is(notNullValue()));
                    assertAll("Checking maps",
                            () -> assertThat(actual, is(equalTo(expected))),
                            () -> assertThat(actual.get(key), is(equalTo(expected.get(key))))
                    );
                }),

                DynamicTest.dynamicTest("unknown[1]", () -> {
                    final String key = "unknown";
                    final int arrayIndex = 1;

                    final Map<String, Object> expected = getMapBasicPrimitives();

                    final PathArrayElementImpl pathElement = new PathArrayElementImpl(String.format("%s[%s]", key, arrayIndex), key, arrayIndex);
                    final Map<String, Object> actual = new RemoveTransformation()
                            .perform(pathElement, getMapBasicPrimitives(), null);

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

                DynamicTest.dynamicTest("a_boolean", () -> {
                    final String key = "a_boolean";

                    final Map<String, Object> expected = getMapBasicPrimitives();
                    expected.remove(key);

                    final Map<String, Object> actual = new RemoveTransformation()
                            .perform(new PathAttributeElementImpl(key), getMapBasicPrimitives(), null);

                    assertThat(actual, is(notNullValue()));
                    assertAll("Checking maps",
                            () -> assertThat(actual, is(equalTo(expected))),
                            () -> assertThat(actual.get(key), is(equalTo(expected.get(key))))
                    );
                }),

                DynamicTest.dynamicTest("a_float", () -> {
                    final String key = "a_float";

                    final Map<String, Object> expected = getMapBasicPrimitives();
                    expected.remove(key);

                    final Map<String, Object> actual = new RemoveTransformation()
                            .perform(new PathAttributeElementImpl(key), getMapBasicPrimitives(), null);

                    assertThat(actual, is(notNullValue()));
                    assertAll("Checking maps",
                            () -> assertThat(actual, is(equalTo(expected))),
                            () -> assertThat(actual.get(key), is(equalTo(expected.get(key))))
                    );
                }),

                DynamicTest.dynamicTest("a_integer", () -> {
                    final String key = "a_integer";

                    final Map<String, Object> expected = getMapBasicPrimitives();
                    expected.remove(key);

                    final Map<String, Object> actual = new RemoveTransformation()
                            .perform(new PathAttributeElementImpl(key), getMapBasicPrimitives(), null);

                    assertThat(actual, is(notNullValue()));
                    assertAll("Checking maps",
                            () -> assertThat(actual, is(equalTo(expected))),
                            () -> assertThat(actual.get(key), is(equalTo(expected.get(key))))
                    );
                }),

                DynamicTest.dynamicTest("a_null", () -> {
                    final String key = "a_null";

                    final Map<String, Object> expected = getMapBasicPrimitives();
                    expected.remove(key);

                    final Map<String, Object> actual = new RemoveTransformation()
                            .perform(new PathAttributeElementImpl(key), getMapBasicPrimitives(), null);

                    assertThat(actual, is(notNullValue()));
                    assertAll("Checking maps",
                            () -> assertThat(actual, is(equalTo(expected))),
                            () -> assertThat(actual.get(key), is(equalTo(expected.get(key))))
                    );
                }),

                DynamicTest.dynamicTest("a_object", () -> {
                    final String key = "a_object";

                    final Map<String, Object> expected = getMapBasicPrimitives();
                    expected.remove(key);

                    final Map<String, Object> actual = new RemoveTransformation()
                            .perform(new PathAttributeElementImpl(key), getMapBasicPrimitives(), null);

                    assertThat(actual, is(notNullValue()));
                    assertAll("Checking maps",
                            () -> assertThat(actual, is(equalTo(expected))),
                            () -> assertThat(actual.get(key), is(equalTo(expected.get(key))))
                    );
                }),

                DynamicTest.dynamicTest("a_string", () -> {
                    final String key = "a_string";

                    final Map<String, Object> expected = getMapBasicPrimitives();
                    expected.remove(key);

                    final Map<String, Object> actual = new RemoveTransformation()
                            .perform(new PathAttributeElementImpl(key), getMapBasicPrimitives(), null);

                    assertThat(actual, is(notNullValue()));
                    assertAll("Checking maps",
                            () -> assertThat(actual, is(equalTo(expected))),
                            () -> assertThat(actual.get(key), is(equalTo(expected.get(key))))
                    );
                }),

                DynamicTest.dynamicTest("unknown", () -> {
                    final String key = "unknown";

                    final Map<String, Object> expected = getMapBasicPrimitives();

                    final Map<String, Object> actual = new RemoveTransformation()
                            .perform(new PathAttributeElementImpl(key), getMapBasicPrimitives(), null);

                    assertThat(actual, is(notNullValue()));
                    assertAll("Checking maps",
                            () -> assertThat(actual, is(equalTo(expected))),
                            () -> assertThat(actual.get(key), is(equalTo(expected.get(key))))
                    );
                })

        );
    }

}
