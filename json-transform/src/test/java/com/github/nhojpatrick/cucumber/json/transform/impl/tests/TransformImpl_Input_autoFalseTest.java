package com.github.nhojpatrick.cucumber.json.transform.impl.tests;

import com.github.nhojpatrick.cucumber.json.core.transform.Transformation;
import com.github.nhojpatrick.cucumber.json.core.validation.PathElement;
import com.github.nhojpatrick.cucumber.json.core.validation.impl.PathAttributeElementImpl;
import com.github.nhojpatrick.cucumber.json.transform.impl.TransformImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static com.github.nhojpatrick.cucumber.json.transform.impl.tests.TransformImpl_InputSource.INPUT_SOURCE_LEVEL2;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;
import static org.mockito.ArgumentMatchers.anyMap;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 * Should have same test parths as TransformImpl_Input_autoFalseTest, with this change.
 * <p>
 * private static final boolean IS_PARENT_PATH_AUTO_CREATED = false;
 * </p>
 */
@DisplayName("Transform Impl Input autoFalse Tests")
public class TransformImpl_Input_autoFalseTest
        extends AbstractTransformImplTest {

    private static final boolean IS_PARENT_PATH_AUTO_CREATED = false;

    @TestFactory
    @DisplayName("Input 2 Level Arrays")
    public Collection<DynamicTest> level_2_arrays() {

        final TransformImpl classUnderTest = new TransformImpl();

        return Arrays.asList(

                dynamicTest("a2ArrayEmpty[1].a2ArrayEmpty1_unknown", () -> {
                    final String key = "a2ArrayEmpty[1].a2ArrayEmpty1_unknown";

                    final Transformation transform = getMockTransformation(IS_PARENT_PATH_AUTO_CREATED);

                    verifyExceptionThrown(INPUT_SOURCE_LEVEL2, classUnderTest, transform, key, String.format(
                            "Path '%s', as array is empty, automatic creation disabled by transformation.",
                            "a2ArrayEmpty"
                    ));
                }),

                dynamicTest("a2ArrayObjects[0].a2ArrayObjects_knownKey", () -> {
                    final String key = "a2ArrayObjects[0].a2ArrayObjects_knownKey";

                    final PathElement pathElement = new PathAttributeElementImpl("a2ArrayObjects_knownKey");

                    final Transformation transform = getMockTransformation(IS_PARENT_PATH_AUTO_CREATED, pathElement, "a2ArrayObjects[0]");

                    final Map<String, Object> expected = INPUT_SOURCE_LEVEL2.get();

                    final Map<String, Object> a2ArrayObjects0 = new LinkedHashMap<>();
                    a2ArrayObjects0.put("transform", "output");

                    final List<Map<String, Object>> a2ArrayObjects = (List<Map<String, Object>>) expected.get("a2ArrayObjects");
                    a2ArrayObjects.set(0, a2ArrayObjects0);

                    final Map<String, Object> actual = classUnderTest.transform(key, INPUT_SOURCE_LEVEL2.get(), transform);

                    assertThat(actual, is(notNullValue()));
                    assertAll("Checking maps",
                            () -> assertThat(actual, is(equalTo(expected))),
                            () -> verify(transform, times(1))
                                    .perform(eq(pathElement), anyMap(), eq("a2ArrayObjects[0]"))
                    );
                }),

                dynamicTest("a2ArrayObjects[0].a2ArrayObjects_unknownKey", () -> {
                    final String key = "a2ArrayObjects[0].a2ArrayObjects_unknownKey";

                    final PathElement pathElement = new PathAttributeElementImpl("a2ArrayObjects_unknownKey");

                    final Transformation transform = getMockTransformation(IS_PARENT_PATH_AUTO_CREATED, pathElement, "a2ArrayObjects[0]");

                    final Map<String, Object> expected = INPUT_SOURCE_LEVEL2.get();

                    final Map<String, Object> a2ArrayObjects0 = new LinkedHashMap<>();
                    a2ArrayObjects0.put("transform", "output");

                    final List<Map<String, Object>> a2ArrayObjects = (List<Map<String, Object>>) expected.get("a2ArrayObjects");
                    a2ArrayObjects.set(0, a2ArrayObjects0);

                    final Map<String, Object> actual = classUnderTest.transform(key, INPUT_SOURCE_LEVEL2.get(), transform);

                    assertThat(actual, is(notNullValue()));
                    assertAll("Checking maps",
                            () -> assertThat(actual, is(equalTo(expected))),
                            () -> verify(transform, times(1))
                                    .perform(eq(pathElement), anyMap(), eq("a2ArrayObjects[0]"))
                    );
                }),

                dynamicTest("a2ArrayObjects[1].a2ArrayObjects_knownKey", () -> {
                    final String key = "a2ArrayObjects[1].a2ArrayObjects_knownKey";

                    final PathElement pathElement = new PathAttributeElementImpl("a2ArrayObjects_knownKey");

                    final Transformation transform = getMockTransformation(IS_PARENT_PATH_AUTO_CREATED, pathElement, "a2ArrayObjects[1]");

                    final Map<String, Object> expected = INPUT_SOURCE_LEVEL2.get();

                    final Map<String, Object> a2ArrayObjects1 = new LinkedHashMap<>();
                    a2ArrayObjects1.put("transform", "output");

                    final List<Map<String, Object>> a2ArrayObjects = (List<Map<String, Object>>) expected.get("a2ArrayObjects");
                    a2ArrayObjects.set(1, a2ArrayObjects1);

                    final Map<String, Object> actual = classUnderTest.transform(key, INPUT_SOURCE_LEVEL2.get(), transform);

                    assertThat(actual, is(notNullValue()));
                    assertAll("Checking maps",
                            () -> assertThat(actual, is(equalTo(expected))),
                            () -> verify(transform, times(1))
                                    .perform(eq(pathElement), anyMap(), eq("a2ArrayObjects[1]"))
                    );
                }),

                dynamicTest("a2ArrayObjects[1].a2ArrayObjects_unknownKey", () -> {
                    final String key = "a2ArrayObjects[1].a2ArrayObjects_unknownKey";

                    final PathElement pathElement = new PathAttributeElementImpl("a2ArrayObjects_unknownKey");

                    final Transformation transform = getMockTransformation(IS_PARENT_PATH_AUTO_CREATED, pathElement, "a2ArrayObjects[1]");

                    final Map<String, Object> expected = INPUT_SOURCE_LEVEL2.get();

                    final Map<String, Object> a2ArrayObjects1 = new LinkedHashMap<>();
                    a2ArrayObjects1.put("transform", "output");

                    final List<Map<String, Object>> a2ArrayObjects = (List<Map<String, Object>>) expected.get("a2ArrayObjects");
                    a2ArrayObjects.set(1, a2ArrayObjects1);

                    final Map<String, Object> actual = classUnderTest.transform(key, INPUT_SOURCE_LEVEL2.get(), transform);

                    assertThat(actual, is(notNullValue()));
                    assertAll("Checking maps",
                            () -> assertThat(actual, is(equalTo(expected))),
                            () -> verify(transform, times(1))
                                    .perform(eq(pathElement), anyMap(), eq("a2ArrayObjects[1]"))
                    );
                }),

                dynamicTest("a2ArrayObjects[2].a2ArrayObjects2_knownKey", () -> {
                    final String key = "a2ArrayObjects[2].a2ArrayObjects2_knownKey";

                    final Transformation transform = getMockTransformation(IS_PARENT_PATH_AUTO_CREATED);

                    verifyExceptionThrown(INPUT_SOURCE_LEVEL2, classUnderTest, transform, key, String.format(
                            "AutoConvert 'null' value to object disabled, at path '%s[%s]'.",
                            "a2ArrayObjects",
                            2
                    ));
                }),

                dynamicTest("a2ArrayObjects[2].a2ArrayObjects2_unknownKey", () -> {
                    final String key = "a2ArrayObjects[2].a2ArrayObjects2_unknownKey";

                    final Transformation transform = getMockTransformation(IS_PARENT_PATH_AUTO_CREATED);

                    verifyExceptionThrown(INPUT_SOURCE_LEVEL2, classUnderTest, transform, key, String.format(
                            "AutoConvert 'null' value to object disabled, at path '%s[%s]'.",
                            "a2ArrayObjects",
                            2
                    ));
                }),

                dynamicTest("a2ArrayObjects[3].a2ArrayObjects2_knownKey", () -> {
                    final String key = "a2ArrayObjects[3].a2ArrayObjects2_knownKey";

                    final Transformation transform = getMockTransformation(IS_PARENT_PATH_AUTO_CREATED);

                    verifyExceptionThrown(INPUT_SOURCE_LEVEL2, classUnderTest, transform, key, String.format(
                            "Path '%s[%s]', beyond index of '%s', automatic creation disabled by transformation.",
                            "a2ArrayObjects",
                            3,
                            2
                    ));
                }),

                dynamicTest("a2ArrayObjects[3].a2ArrayObjects2_unknownKey", () -> {
                    final String key = "a2ArrayObjects[3].a2ArrayObjects2_unknownKey";

                    final Transformation transform = getMockTransformation(IS_PARENT_PATH_AUTO_CREATED);

                    verifyExceptionThrown(INPUT_SOURCE_LEVEL2, classUnderTest, transform, key, String.format(
                            "Path '%s[%s]', beyond index of '%s', automatic creation disabled by transformation.",
                            "a2ArrayObjects",
                            3,
                            2
                    ));
                }),

                dynamicTest("a2ArrayPrimitives[0].a2ArrayPrimitives_unknown", () -> {
                    final String key = "a2ArrayPrimitives[0].a2ArrayPrimitives_unknown";

                    final Transformation transform = getMockTransformation(IS_PARENT_PATH_AUTO_CREATED);

                    verifyExceptionThrown(INPUT_SOURCE_LEVEL2, classUnderTest, transform, key, String.format(
                            "Unable to convert primative array to object array, at path '%s'.",
                            "a2ArrayPrimitives"
                    ));
                }),

                dynamicTest("a2ArrayPrimitives[1].a2ArrayPrimitives_unknown", () -> {
                    final String key = "a2ArrayPrimitives[1].a2ArrayPrimitives_unknown";

                    final Transformation transform = getMockTransformation(IS_PARENT_PATH_AUTO_CREATED);

                    verifyExceptionThrown(INPUT_SOURCE_LEVEL2, classUnderTest, transform, key, String.format(
                            "Unable to convert primative array to object array, at path '%s'.",
                            "a2ArrayPrimitives"
                    ));
                }),

                dynamicTest("a2ArrayPrimitives[2].a2ArrayPrimitives_unknown", () -> {
                    final String key = "a2ArrayPrimitives[2].a2ArrayPrimitives_unknown";

                    final Transformation transform = getMockTransformation(IS_PARENT_PATH_AUTO_CREATED);

                    verifyExceptionThrown(INPUT_SOURCE_LEVEL2, classUnderTest, transform, key, String.format(
                            "Unable to convert primative array to object array, at path '%s'.",
                            "a2ArrayPrimitives"
                    ));
                })

        );
    }

    @TestFactory
    @DisplayName("Input 2 Level Null")
    public Collection<DynamicTest> level_2_null() {

        final TransformImpl classUnderTest = new TransformImpl();

        return Arrays.asList(

                dynamicTest("a2Null.b2Array[0]", () -> {
                    final String key = "a2Null.b2Array[0]";

                    final Transformation transform = getMockTransformation(IS_PARENT_PATH_AUTO_CREATED);

                    verifyExceptionThrown(INPUT_SOURCE_LEVEL2, classUnderTest, transform, key, String.format(
                            "AutoConvert 'null' value to object disabled, at path '%s'.",
                            "a2Null"
                    ));
                }),

                dynamicTest("a2Null.b2Array[1]", () -> {
                    final String key = "a2Null.b2Array[1]";

                    final Transformation transform = getMockTransformation(IS_PARENT_PATH_AUTO_CREATED);

                    verifyExceptionThrown(INPUT_SOURCE_LEVEL2, classUnderTest, transform, key, String.format(
                            "AutoConvert 'null' value to object disabled, at path '%s'.",
                            "a2Null"
                    ));
                }),

                dynamicTest("a2Null.b2Path", () -> {
                    final String key = "a2Null.b2Path";

                    final Transformation transform = getMockTransformation(IS_PARENT_PATH_AUTO_CREATED);

                    verifyExceptionThrown(INPUT_SOURCE_LEVEL2, classUnderTest, transform, key, String.format(
                            "AutoConvert 'null' value to object disabled, at path '%s'.",
                            "a2Null"
                    ));
                }),

                dynamicTest("a2Null[0].b2Array[0]", () -> {
                    final String key = "a2Null[0].b2Array[0]";

                    final Transformation transform = getMockTransformation(IS_PARENT_PATH_AUTO_CREATED);

                    verifyExceptionThrown(INPUT_SOURCE_LEVEL2, classUnderTest, transform, key, String.format(
                            "AutoConvert 'null' value to array disabled, at path '%s'.",
                            "a2Null"
                    ));
                }),

                dynamicTest("a2Null[1].b2Array[1]", () -> {
                    final String key = "a2Null[1].b2Array[1]";

                    final Transformation transform = getMockTransformation(IS_PARENT_PATH_AUTO_CREATED);

                    verifyExceptionThrown(INPUT_SOURCE_LEVEL2, classUnderTest, transform, key, String.format(
                            "AutoConvert 'null' value to array disabled, at path '%s'.",
                            "a2Null"
                    ));
                }),

                dynamicTest("a2Null[0].b2Path", () -> {
                    final String key = "a2Null[0].b2Path";

                    final Transformation transform = getMockTransformation(IS_PARENT_PATH_AUTO_CREATED);

                    verifyExceptionThrown(INPUT_SOURCE_LEVEL2, classUnderTest, transform, key, String.format(
                            "AutoConvert 'null' value to array disabled, at path '%s'.",
                            "a2Null"
                    ));
                }),

                dynamicTest("a2Null[1].b2Path", () -> {
                    final String key = "a2Null[1].b2Path";

                    final Transformation transform = getMockTransformation(IS_PARENT_PATH_AUTO_CREATED);

                    verifyExceptionThrown(INPUT_SOURCE_LEVEL2, classUnderTest, transform, key, String.format(
                            "AutoConvert 'null' value to array disabled, at path '%s'.",
                            "a2Null"
                    ));
                })

        );
    }

    @TestFactory
    @DisplayName("Input 2 Level Paths")
    public Collection<DynamicTest> level_2_paths() {

        final TransformImpl classUnderTest = new TransformImpl();

        return Arrays.asList(

                dynamicTest("a2PathEmpty[1].a2PathEmpty_unknown", () -> {
                    final String key = "a2PathEmpty[1].a2PathEmpty_unknown";

                    final Transformation transform = getMockTransformation(IS_PARENT_PATH_AUTO_CREATED);

                    verifyExceptionThrown(INPUT_SOURCE_LEVEL2, classUnderTest, transform, key, String.format(
                            "Unable to convert object to array, at path '%s'.",
                            "a2PathEmpty"
                    ));
                }),

                dynamicTest("a2PathObject[1].a2PathObject_unknown", () -> {
                    final String key = "a2PathObject[1].a2PathObject_unknown";

                    final Transformation transform = getMockTransformation(IS_PARENT_PATH_AUTO_CREATED);

                    verifyExceptionThrown(INPUT_SOURCE_LEVEL2, classUnderTest, transform, key, String.format(
                            "Unable to convert object to array, at path '%s'.",
                            "a2PathObject"
                    ));
                }),

                dynamicTest("a2ArrayEmpty.a2_known", () -> {
                    final String key = "a2ArrayEmpty.a2_known";

                    final Transformation transform = getMockTransformation(IS_PARENT_PATH_AUTO_CREATED);

                    verifyExceptionThrown(INPUT_SOURCE_LEVEL2, classUnderTest, transform, key, String.format(
                            "Unable to convert array to object, at path '%s'.",
                            "a2ArrayEmpty"
                    ));
                }),

                dynamicTest("a2ArrayObjects.a2_known", () -> {
                    final String key = "a2ArrayObjects.a2_known";

                    final Transformation transform = getMockTransformation(IS_PARENT_PATH_AUTO_CREATED);

                    verifyExceptionThrown(INPUT_SOURCE_LEVEL2, classUnderTest, transform, key, String.format(
                            "Unable to convert array to object, at path '%s'.",
                            "a2ArrayObjects"
                    ));
                }),

                dynamicTest("a2ArrayPrimitives.a2_known", () -> {
                    final String key = "a2ArrayPrimitives.a2_known";

                    final Transformation transform = getMockTransformation(IS_PARENT_PATH_AUTO_CREATED);

                    verifyExceptionThrown(INPUT_SOURCE_LEVEL2, classUnderTest, transform, key, String.format(
                            "Unable to convert array to object, at path '%s'.",
                            "a2ArrayPrimitives"
                    ));
                }),

                dynamicTest("a2Path.a2_known", () -> {
                    final String key = "a2Path.a2_known";

                    final Transformation transform = getMockTransformation(IS_PARENT_PATH_AUTO_CREATED);

                    verifyExceptionThrown(INPUT_SOURCE_LEVEL2, classUnderTest, transform, key, String.format(
                            "Path '%s' does not existing and automatic creation disabled by transformation.",
                            "a2Path"
                    ));
                })

        );
    }

    @TestFactory
    @DisplayName("Input 2 Level Primitive")
    public Collection<DynamicTest> level_2_primitive() {

        final TransformImpl classUnderTest = new TransformImpl();

        return Arrays.asList(

                dynamicTest("a2Primitive[1].does_not_matter", () -> {
                    final String key = "a2Primitive[1].does_not_matter";

                    final Transformation transform = getMockTransformation(IS_PARENT_PATH_AUTO_CREATED);

                    verifyExceptionThrown(INPUT_SOURCE_LEVEL2, classUnderTest, transform, key, String.format(
                            "Unable to convert primative to array, at path '%s'.",
                            "a2Primitive"
                    ));
                }),

                dynamicTest("a2Primitive.does_not_matter", () -> {
                    final String key = "a2Primitive.does_not_matter";

                    final Transformation transform = getMockTransformation(IS_PARENT_PATH_AUTO_CREATED);

                    verifyExceptionThrown(INPUT_SOURCE_LEVEL2, classUnderTest, transform, key, String.format(
                            "Unable to convert primative to object, at path '%s'.",
                            "a2Primitive"
                    ));
                })

        );
    }

    @TestFactory
    @DisplayName("Input 2 Level Unknown")
    public Collection<DynamicTest> level_2_unknown() {

        final TransformImpl classUnderTest = new TransformImpl();

        return Arrays.asList(

                dynamicTest("a2Unknown[1].b2Unknown", () -> {
                    final String key = "a2Unknown[1].b2Unknown";

                    final Transformation transform = getMockTransformation(IS_PARENT_PATH_AUTO_CREATED);

                    verifyExceptionThrown(INPUT_SOURCE_LEVEL2, classUnderTest, transform, key, String.format(
                            "Path '%s' does not existing and automatic creation disabled by transformation.",
                            "a2Unknown"
                    ));
                }),

                dynamicTest("a2Unknown.b2Unknown", () -> {
                    final String key = "a2Unknown.b2Unknown";

                    final Transformation transform = getMockTransformation(IS_PARENT_PATH_AUTO_CREATED);

                    verifyExceptionThrown(INPUT_SOURCE_LEVEL2, classUnderTest, transform, key, String.format(
                            "Path '%s' does not existing and automatic creation disabled by transformation.",
                            "a2Unknown"
                    ));
                })

        );
    }

}
