package com.github.nhojpatrick.cucumber.json.transform.impl.tests;

import com.github.nhojpatrick.cucumber.json.core.exceptions.IllegalPathOperationException;
import com.github.nhojpatrick.cucumber.json.core.transform.Transformation;
import com.github.nhojpatrick.cucumber.json.core.validation.PathElement;
import com.github.nhojpatrick.cucumber.json.core.validation.impl.PathArrayElementImpl;
import com.github.nhojpatrick.cucumber.json.core.validation.impl.PathAttributeElementImpl;
import com.github.nhojpatrick.cucumber.json.transform.impl.TransformImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.function.Executable;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

import static com.github.nhojpatrick.cucumber.json.transform.impl.tests.TransformImpl_Empty_autoTrueTest.INPUT_TYPE;
import static com.github.nhojpatrick.cucumber.json.transform.impl.tests.TransformImpl_InputSource.INPUT_SOURCE_EMPTY;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyMap;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@DisplayName("Transform Impl " + INPUT_TYPE + " autoFalse Tests")
public class TransformImpl_Empty_autoFalseTest
        extends AbstractTransformImplTest {

    public static final String INPUT_TYPE = "Empty Input";

    private static final boolean IS_PARENT_PATH_AUTO_CREATED = false;

    @TestFactory
    @DisplayName(INPUT_TYPE + " 1 Level Path")
    public Collection<DynamicTest> input_1_path_level() {

        final TransformImpl classUnderTest = new TransformImpl();

        return Arrays.asList(

                // object
                dynamicTest("a1Path with " + INPUT_TYPE, () -> {
                    final String key = "a1Path";

                    final PathAttributeElementImpl pathElement = new PathAttributeElementImpl("a1Path");

                    final Map<String, Object> expected = new LinkedHashMap<>();
                    expected.put("transform", "output");

                    final Transformation transform = mock(Transformation.class);

                    when(transform.isParentPathAutoCreated())
                            .thenReturn(IS_PARENT_PATH_AUTO_CREATED);

                    final Map<String, Object> transformOutput = new LinkedHashMap<>();
                    transformOutput.put("transform", "output");
                    when(transform.perform(eq(pathElement), anyMap(), eq("")))
                            .thenReturn(transformOutput);

                    final Map<String, Object> actual = classUnderTest.transform(key, INPUT_SOURCE_EMPTY.get(), transform);

                    assertThat(actual, is(notNullValue()));
                    assertAll("Checking maps",
                            () -> assertThat(actual, is(equalTo(expected))),
                            () -> verify(transform, times(1))
                                    .perform(eq(pathElement), anyMap(), eq(""))
                    );
                }),

                // array
                dynamicTest("a1Array[1] with " + INPUT_TYPE, () -> {
                    final String key = "a1Array[1]";

                    final PathElement pathElement = new PathArrayElementImpl(String.format("%s[%s]", "a1Array", 1), "a1Array", 1);

                    final Map<String, Object> expected = new LinkedHashMap<>();
                    expected.put("transform", "output");

                    final Transformation transform = mock(Transformation.class);

                    when(transform.isParentPathAutoCreated())
                            .thenReturn(IS_PARENT_PATH_AUTO_CREATED);

                    final Map<String, Object> transformOutput = new LinkedHashMap<>();
                    transformOutput.put("transform", "output");
                    when(transform.perform(eq(pathElement), anyMap(), eq("")))
                            .thenReturn(transformOutput);

                    final Map<String, Object> actual = classUnderTest.transform(key, INPUT_SOURCE_EMPTY.get(), transform);

                    assertThat(actual, is(notNullValue()));
                    assertAll("Checking maps",
                            () -> assertThat(actual, is(equalTo(expected))),
                            () -> verify(transform, times(1))
                                    .perform(eq(pathElement), anyMap(), eq(""))
                    );
                })

        );
    }

    @TestFactory
    @DisplayName(INPUT_TYPE + " 2 Level Arrays")
    public Collection<DynamicTest> level_2_arrays() {

        final TransformImpl classUnderTest = new TransformImpl();

        return Arrays.asList(

                // array.array
                dynamicTest("a2Array[0].b2Array[0] with " + INPUT_TYPE, () -> {
                    final String key = "a2Array[0].b2Array[0]";

                    final Transformation transform = mock(Transformation.class);

                    when(transform.isParentPathAutoCreated())
                            .thenReturn(IS_PARENT_PATH_AUTO_CREATED);

                    final Executable testMethod = () -> classUnderTest.transform(key, INPUT_SOURCE_EMPTY.get(), transform);

                    final IllegalPathOperationException thrown = assertThrows(IllegalPathOperationException.class, testMethod);
                    assertAll("Checking Exception",
                            () -> assertThat(thrown.getMessage(), is(equalTo(String.format(
                                    "Path '%s' does not existing and automatic creation disabled by transformation.",
                                    "a2Array"
                            )))),
                            () -> assertThat(thrown.getCause(), is(nullValue()))
                    );
                    assertAll("Verify transform mock wasn't called",
                            () -> verify(transform, never())
                                    .perform(any(), anyMap(), anyString())
                    );
                }),

                // array.array
                dynamicTest("a2Array[0].b2Array[1] with " + INPUT_TYPE, () -> {
                    final String key = "a2Array[0].b2Array[1]";

                    final Transformation transform = mock(Transformation.class);

                    when(transform.isParentPathAutoCreated())
                            .thenReturn(IS_PARENT_PATH_AUTO_CREATED);

                    final Executable testMethod = () -> classUnderTest.transform(key, INPUT_SOURCE_EMPTY.get(), transform);

                    final IllegalPathOperationException thrown = assertThrows(IllegalPathOperationException.class, testMethod);
                    assertAll("Checking Exception",
                            () -> assertThat(thrown.getMessage(), is(equalTo(String.format(
                                    "Path '%s' does not existing and automatic creation disabled by transformation.",
                                    "a2Array"
                            )))),
                            () -> assertThat(thrown.getCause(), is(nullValue()))
                    );
                    assertAll("Verify transform mock wasn't called",
                            () -> verify(transform, never())
                                    .perform(any(), anyMap(), anyString())
                    );
                }),

                // array.array
                dynamicTest("a2Array[0].b2Array[2] with " + INPUT_TYPE, () -> {
                    final String key = "a2Array[0].b2Array[2]";

                    final Transformation transform = mock(Transformation.class);

                    when(transform.isParentPathAutoCreated())
                            .thenReturn(IS_PARENT_PATH_AUTO_CREATED);

                    final Executable testMethod = () -> classUnderTest.transform(key, INPUT_SOURCE_EMPTY.get(), transform);

                    final IllegalPathOperationException thrown = assertThrows(IllegalPathOperationException.class, testMethod);
                    assertAll("Checking Exception",
                            () -> assertThat(thrown.getMessage(), is(equalTo(String.format(
                                    "Path '%s' does not existing and automatic creation disabled by transformation.",
                                    "a2Array"
                            )))),
                            () -> assertThat(thrown.getCause(), is(nullValue()))
                    );
                    assertAll("Verify transform mock wasn't called",
                            () -> verify(transform, never())
                                    .perform(any(), anyMap(), anyString())
                    );
                }),

                // array.array
                dynamicTest("a2Array[1].b2Array[0] with " + INPUT_TYPE, () -> {
                    final String key = "a2Array[1].b2Array[0]";

                    final Transformation transform = mock(Transformation.class);

                    when(transform.isParentPathAutoCreated())
                            .thenReturn(IS_PARENT_PATH_AUTO_CREATED);

                    final Executable testMethod = () -> classUnderTest.transform(key, INPUT_SOURCE_EMPTY.get(), transform);

                    final IllegalPathOperationException thrown = assertThrows(IllegalPathOperationException.class, testMethod);
                    assertAll("Checking Exception",
                            () -> assertThat(thrown.getMessage(), is(equalTo(String.format(
                                    "Path '%s' does not existing and automatic creation disabled by transformation.",
                                    "a2Array"
                            )))),
                            () -> assertThat(thrown.getCause(), is(nullValue()))
                    );
                    assertAll("Verify transform mock wasn't called",
                            () -> verify(transform, never())
                                    .perform(any(), anyMap(), anyString())
                    );
                }),

                // array.array
                dynamicTest("a2Array[1].b2Array[1] with " + INPUT_TYPE, () -> {
                    final String key = "a2Array[1].b2Array[1]";

                    final Transformation transform = mock(Transformation.class);

                    when(transform.isParentPathAutoCreated())
                            .thenReturn(IS_PARENT_PATH_AUTO_CREATED);

                    final Executable testMethod = () -> classUnderTest.transform(key, INPUT_SOURCE_EMPTY.get(), transform);

                    final IllegalPathOperationException thrown = assertThrows(IllegalPathOperationException.class, testMethod);
                    assertAll("Checking Exception",
                            () -> assertThat(thrown.getMessage(), is(equalTo(String.format(
                                    "Path '%s' does not existing and automatic creation disabled by transformation.",
                                    "a2Array"
                            )))),
                            () -> assertThat(thrown.getCause(), is(nullValue()))
                    );
                    assertAll("Verify transform mock wasn't called",
                            () -> verify(transform, never())
                                    .perform(any(), anyMap(), anyString())
                    );
                }),

                // array.array
                dynamicTest("a2Array[1].b2Array[2] with " + INPUT_TYPE, () -> {
                    final String key = "a2Array[1].b2Array[2]";

                    final Transformation transform = mock(Transformation.class);

                    when(transform.isParentPathAutoCreated())
                            .thenReturn(IS_PARENT_PATH_AUTO_CREATED);

                    final Executable testMethod = () -> classUnderTest.transform(key, INPUT_SOURCE_EMPTY.get(), transform);

                    final IllegalPathOperationException thrown = assertThrows(IllegalPathOperationException.class, testMethod);
                    assertAll("Checking Exception",
                            () -> assertThat(thrown.getMessage(), is(equalTo(String.format(
                                    "Path '%s' does not existing and automatic creation disabled by transformation.",
                                    "a2Array"
                            )))),
                            () -> assertThat(thrown.getCause(), is(nullValue()))
                    );
                    assertAll("Verify transform mock wasn't called",
                            () -> verify(transform, never())
                                    .perform(any(), anyMap(), anyString())
                    );
                }),

                // array.array
                dynamicTest("a2Array[2].b2Array[0] with " + INPUT_TYPE, () -> {
                    final String key = "a2Array[2].b2Array[0]";

                    final Transformation transform = mock(Transformation.class);

                    when(transform.isParentPathAutoCreated())
                            .thenReturn(IS_PARENT_PATH_AUTO_CREATED);

                    final Executable testMethod = () -> classUnderTest.transform(key, INPUT_SOURCE_EMPTY.get(), transform);

                    final IllegalPathOperationException thrown = assertThrows(IllegalPathOperationException.class, testMethod);
                    assertAll("Checking Exception",
                            () -> assertThat(thrown.getMessage(), is(equalTo(String.format(
                                    "Path '%s' does not existing and automatic creation disabled by transformation.",
                                    "a2Array"
                            )))),
                            () -> assertThat(thrown.getCause(), is(nullValue()))
                    );
                    assertAll("Verify transform mock wasn't called",
                            () -> verify(transform, never())
                                    .perform(any(), anyMap(), anyString())
                    );
                }),

                // array.array
                dynamicTest("a2Array[2].b2Array[1] with " + INPUT_TYPE, () -> {
                    final String key = "a2Array[2].b2Array[1]";

                    final Transformation transform = mock(Transformation.class);

                    when(transform.isParentPathAutoCreated())
                            .thenReturn(IS_PARENT_PATH_AUTO_CREATED);

                    final Executable testMethod = () -> classUnderTest.transform(key, INPUT_SOURCE_EMPTY.get(), transform);

                    final IllegalPathOperationException thrown = assertThrows(IllegalPathOperationException.class, testMethod);
                    assertAll("Checking Exception",
                            () -> assertThat(thrown.getMessage(), is(equalTo(String.format(
                                    "Path '%s' does not existing and automatic creation disabled by transformation.",
                                    "a2Array"
                            )))),
                            () -> assertThat(thrown.getCause(), is(nullValue()))
                    );
                    assertAll("Verify transform mock wasn't called",
                            () -> verify(transform, never())
                                    .perform(any(), anyMap(), anyString())
                    );
                }),

                // array.array
                dynamicTest("a2Array[2].b2Array[2] with " + INPUT_TYPE, () -> {
                    final String key = "a2Array[2].b2Array[2]";

                    final Transformation transform = mock(Transformation.class);

                    when(transform.isParentPathAutoCreated())
                            .thenReturn(IS_PARENT_PATH_AUTO_CREATED);

                    final Executable testMethod = () -> classUnderTest.transform(key, INPUT_SOURCE_EMPTY.get(), transform);

                    final IllegalPathOperationException thrown = assertThrows(IllegalPathOperationException.class, testMethod);
                    assertAll("Checking Exception",
                            () -> assertThat(thrown.getMessage(), is(equalTo(String.format(
                                    "Path '%s' does not existing and automatic creation disabled by transformation.",
                                    "a2Array"
                            )))),
                            () -> assertThat(thrown.getCause(), is(nullValue()))
                    );
                    assertAll("Verify transform mock wasn't called",
                            () -> verify(transform, never())
                                    .perform(any(), anyMap(), anyString())
                    );
                }),

                // array.object
                dynamicTest("a2Array[0].b2Path with " + INPUT_TYPE, () -> {
                    final String key = "a2Array[0].b2Path";

                    final Transformation transform = mock(Transformation.class);

                    when(transform.isParentPathAutoCreated())
                            .thenReturn(IS_PARENT_PATH_AUTO_CREATED);

                    final Executable testMethod = () -> classUnderTest.transform(key, INPUT_SOURCE_EMPTY.get(), transform);

                    final IllegalPathOperationException thrown = assertThrows(IllegalPathOperationException.class, testMethod);
                    assertAll("Checking Exception",
                            () -> assertThat(thrown.getMessage(), is(equalTo(String.format(
                                    "Path '%s' does not existing and automatic creation disabled by transformation.",
                                    "a2Array"
                            )))),
                            () -> assertThat(thrown.getCause(), is(nullValue()))
                    );
                    assertAll("Verify transform mock wasn't called",
                            () -> verify(transform, never())
                                    .perform(any(), anyMap(), anyString())
                    );
                }),

                // array.object
                dynamicTest("a2Array[1].b2Path with " + INPUT_TYPE, () -> {
                    final String key = "a2Array[1].b2Path";

                    final Transformation transform = mock(Transformation.class);

                    when(transform.isParentPathAutoCreated())
                            .thenReturn(IS_PARENT_PATH_AUTO_CREATED);

                    final Executable testMethod = () -> classUnderTest.transform(key, INPUT_SOURCE_EMPTY.get(), transform);

                    final IllegalPathOperationException thrown = assertThrows(IllegalPathOperationException.class, testMethod);
                    assertAll("Checking Exception",
                            () -> assertThat(thrown.getMessage(), is(equalTo(String.format(
                                    "Path '%s' does not existing and automatic creation disabled by transformation.",
                                    "a2Array"
                            )))),
                            () -> assertThat(thrown.getCause(), is(nullValue()))
                    );
                    assertAll("Verify transform mock wasn't called",
                            () -> verify(transform, never())
                                    .perform(any(), anyMap(), anyString())
                    );
                }),

                // array.object
                dynamicTest("a2Array[2].b2Path with " + INPUT_TYPE, () -> {
                    final String key = "a2Array[2].b2Path";

                    final Transformation transform = mock(Transformation.class);

                    when(transform.isParentPathAutoCreated())
                            .thenReturn(IS_PARENT_PATH_AUTO_CREATED);

                    final Executable testMethod = () -> classUnderTest.transform(key, INPUT_SOURCE_EMPTY.get(), transform);

                    final IllegalPathOperationException thrown = assertThrows(IllegalPathOperationException.class, testMethod);
                    assertAll("Checking Exception",
                            () -> assertThat(thrown.getMessage(), is(equalTo(String.format(
                                    "Path '%s' does not existing and automatic creation disabled by transformation.",
                                    "a2Array"
                            )))),
                            () -> assertThat(thrown.getCause(), is(nullValue()))
                    );
                    assertAll("Verify transform mock wasn't called",
                            () -> verify(transform, never())
                                    .perform(any(), anyMap(), anyString())
                    );
                })

        );
    }

    @TestFactory
    @DisplayName(INPUT_TYPE + " 2 Level Null")
    public Collection<DynamicTest> level_2_null() {

        return Arrays.asList(
        );
    }

    @TestFactory
    @DisplayName(INPUT_TYPE + " 2 Level Paths")
    public Collection<DynamicTest> level_2_paths() {

        final TransformImpl classUnderTest = new TransformImpl();

        return Arrays.asList(

                // object.array
                dynamicTest("a2Path.b2Array[0] with " + INPUT_TYPE, () -> {
                    final String key = "a2Path.b2Array[0]";

                    final Transformation transform = mock(Transformation.class);

                    when(transform.isParentPathAutoCreated())
                            .thenReturn(IS_PARENT_PATH_AUTO_CREATED);

                    final Executable testMethod = () -> classUnderTest.transform(key, INPUT_SOURCE_EMPTY.get(), transform);

                    final IllegalPathOperationException thrown = assertThrows(IllegalPathOperationException.class, testMethod);
                    assertAll("Checking Exception",
                            () -> assertThat(thrown.getMessage(), is(equalTo(String.format(
                                    "Path '%s' does not existing and automatic creation disabled by transformation.",
                                    "a2Path"
                            )))),
                            () -> assertThat(thrown.getCause(), is(nullValue()))
                    );
                    assertAll("Verify transform mock wasn't called",
                            () -> verify(transform, never())
                                    .perform(any(), anyMap(), anyString())
                    );
                }),

                // object.array
                dynamicTest("a2Path.b2Array[1] with " + INPUT_TYPE, () -> {
                    final String key = "a2Path.b2Array[1]";

                    final Transformation transform = mock(Transformation.class);

                    when(transform.isParentPathAutoCreated())
                            .thenReturn(IS_PARENT_PATH_AUTO_CREATED);

                    final Executable testMethod = () -> classUnderTest.transform(key, INPUT_SOURCE_EMPTY.get(), transform);

                    final IllegalPathOperationException thrown = assertThrows(IllegalPathOperationException.class, testMethod);
                    assertAll("Checking Exception",
                            () -> assertThat(thrown.getMessage(), is(equalTo(String.format(
                                    "Path '%s' does not existing and automatic creation disabled by transformation.",
                                    "a2Path"
                            )))),
                            () -> assertThat(thrown.getCause(), is(nullValue()))
                    );
                    assertAll("Verify transform mock wasn't called",
                            () -> verify(transform, never())
                                    .perform(any(), anyMap(), anyString())
                    );
                }),

                // object.array
                dynamicTest("a2Path.b2Array[2] with " + INPUT_TYPE, () -> {
                    final String key = "a2Path.b2Array[2]";

                    final Transformation transform = mock(Transformation.class);

                    when(transform.isParentPathAutoCreated())
                            .thenReturn(IS_PARENT_PATH_AUTO_CREATED);

                    final Executable testMethod = () -> classUnderTest.transform(key, INPUT_SOURCE_EMPTY.get(), transform);

                    final IllegalPathOperationException thrown = assertThrows(IllegalPathOperationException.class, testMethod);
                    assertAll("Checking Exception",
                            () -> assertThat(thrown.getMessage(), is(equalTo(String.format(
                                    "Path '%s' does not existing and automatic creation disabled by transformation.",
                                    "a2Path"
                            )))),
                            () -> assertThat(thrown.getCause(), is(nullValue()))
                    );
                    assertAll("Verify transform mock wasn't called",
                            () -> verify(transform, never())
                                    .perform(any(), anyMap(), anyString())
                    );
                }),

                // object.object
                dynamicTest("a2Path.b2Path with " + INPUT_TYPE, () -> {
                    final String key = "a2Path.b2Path";

                    final Transformation transform = mock(Transformation.class);

                    when(transform.isParentPathAutoCreated())
                            .thenReturn(IS_PARENT_PATH_AUTO_CREATED);

                    final Executable testMethod = () -> classUnderTest.transform(key, INPUT_SOURCE_EMPTY.get(), transform);

                    final IllegalPathOperationException thrown = assertThrows(IllegalPathOperationException.class, testMethod);
                    assertAll("Checking Exception",
                            () -> assertThat(thrown.getMessage(), is(equalTo(String.format(
                                    "Path '%s' does not existing and automatic creation disabled by transformation.",
                                    "a2Path"
                            )))),
                            () -> assertThat(thrown.getCause(), is(nullValue()))
                    );
                    assertAll("Verify transform mock wasn't called",
                            () -> verify(transform, never())
                                    .perform(any(), anyMap(), anyString())
                    );
                })

        );
    }

    @TestFactory
    @DisplayName(INPUT_TYPE + " 2 Level Primitive")
    public Collection<DynamicTest> level_2_primitives() {

        return Arrays.asList(
        );
    }

    @TestFactory
    @DisplayName(INPUT_TYPE + " 3 Level Paths")
    public Collection<DynamicTest> input_3_paths_level() {

        final TransformImpl classUnderTest = new TransformImpl();

        return Arrays.asList(

                // object.object.object
                dynamicTest("a3Path.b3Path.c3Path with " + INPUT_TYPE, () -> {
                    final String key = "a3Path.b3Path.c3Path";

                    final Transformation transform = mock(Transformation.class);

                    when(transform.isParentPathAutoCreated())
                            .thenReturn(IS_PARENT_PATH_AUTO_CREATED);

                    final Executable testMethod = () -> classUnderTest.transform(key, INPUT_SOURCE_EMPTY.get(), transform);

                    final IllegalPathOperationException thrown = assertThrows(IllegalPathOperationException.class, testMethod);
                    assertAll("Checking Exception",
                            () -> assertThat(thrown.getMessage(), is(equalTo(String.format(
                                    "Path '%s' does not existing and automatic creation disabled by transformation.",
                                    "a3Path"
                            )))),
                            () -> assertThat(thrown.getCause(), is(nullValue()))
                    );
                    assertAll("Verify transform mock wasn't called",
                            () -> verify(transform, never())
                                    .perform(any(), anyMap(), anyString())
                    );
                }),

                // object.object.array
                dynamicTest("a3Path.b3Path.c3Array[3] with " + INPUT_TYPE, () -> {
                    final String key = "a3Path.b3Path.c3Array[3]";

                    final Transformation transform = mock(Transformation.class);

                    when(transform.isParentPathAutoCreated())
                            .thenReturn(IS_PARENT_PATH_AUTO_CREATED);

                    final Executable testMethod = () -> classUnderTest.transform(key, INPUT_SOURCE_EMPTY.get(), transform);

                    final IllegalPathOperationException thrown = assertThrows(IllegalPathOperationException.class, testMethod);
                    assertAll("Checking Exception",
                            () -> assertThat(thrown.getMessage(), is(equalTo(String.format(
                                    "Path '%s' does not existing and automatic creation disabled by transformation.",
                                    "a3Path"
                            )))),
                            () -> assertThat(thrown.getCause(), is(nullValue()))
                    );
                    assertAll("Verify transform mock wasn't called",
                            () -> verify(transform, never())
                                    .perform(any(), anyMap(), anyString())
                    );
                }),

                // object.array.object
                dynamicTest("a3Path.b3Array[2].c3Path with " + INPUT_TYPE, () -> {
                    final String key = "a3Path.b3Array[2].c3Path";

                    final Transformation transform = mock(Transformation.class);

                    when(transform.isParentPathAutoCreated())
                            .thenReturn(IS_PARENT_PATH_AUTO_CREATED);

                    final Executable testMethod = () -> classUnderTest.transform(key, INPUT_SOURCE_EMPTY.get(), transform);

                    final IllegalPathOperationException thrown = assertThrows(IllegalPathOperationException.class, testMethod);
                    assertAll("Checking Exception",
                            () -> assertThat(thrown.getMessage(), is(equalTo(String.format(
                                    "Path '%s' does not existing and automatic creation disabled by transformation.",
                                    "a3Path"
                            )))),
                            () -> assertThat(thrown.getCause(), is(nullValue()))
                    );
                    assertAll("Verify transform mock wasn't called",
                            () -> verify(transform, never())
                                    .perform(any(), anyMap(), anyString())
                    );
                }),

                // object.array.array
                dynamicTest("a3Path.b3Array[2].c3Array[3] with " + INPUT_TYPE, () -> {
                    final String key = "a3Path.b3Array[2].c3Array[3]";

                    final Transformation transform = mock(Transformation.class);

                    when(transform.isParentPathAutoCreated())
                            .thenReturn(IS_PARENT_PATH_AUTO_CREATED);

                    final Executable testMethod = () -> classUnderTest.transform(key, INPUT_SOURCE_EMPTY.get(), transform);

                    final IllegalPathOperationException thrown = assertThrows(IllegalPathOperationException.class, testMethod);
                    assertAll("Checking Exception",
                            () -> assertThat(thrown.getMessage(), is(equalTo(String.format(
                                    "Path '%s' does not existing and automatic creation disabled by transformation.",
                                    "a3Path"
                            )))),
                            () -> assertThat(thrown.getCause(), is(nullValue()))
                    );
                    assertAll("Verify transform mock wasn't called",
                            () -> verify(transform, never())
                                    .perform(any(), anyMap(), anyString())
                    );
                }),

                // array.object.object
                dynamicTest("a3ArrayObjects[1].b3Path.c3Path with " + INPUT_TYPE, () -> {
                    final String key = "a3ArrayObjects[1].b3Path.c3Path";

                    final Transformation transform = mock(Transformation.class);

                    when(transform.isParentPathAutoCreated())
                            .thenReturn(IS_PARENT_PATH_AUTO_CREATED);

                    final Executable testMethod = () -> classUnderTest.transform(key, INPUT_SOURCE_EMPTY.get(), transform);

                    final IllegalPathOperationException thrown = assertThrows(IllegalPathOperationException.class, testMethod);
                    assertAll("Checking Exception",
                            () -> assertThat(thrown.getMessage(), is(equalTo(String.format(
                                    "Path '%s' does not existing and automatic creation disabled by transformation.",
                                    "a3ArrayObjects"
                            )))),
                            () -> assertThat(thrown.getCause(), is(nullValue()))
                    );
                    assertAll("Verify transform mock wasn't called",
                            () -> verify(transform, never())
                                    .perform(any(), anyMap(), anyString())
                    );
                }),

                // array.object.array
                dynamicTest("a3ArrayObjects[1].b3Path.c3Array[3] with " + INPUT_TYPE, () -> {
                    final String key = "a3ArrayObjects[1].b3Path.c3Array[3]";

                    final Transformation transform = mock(Transformation.class);

                    when(transform.isParentPathAutoCreated())
                            .thenReturn(IS_PARENT_PATH_AUTO_CREATED);

                    final Executable testMethod = () -> classUnderTest.transform(key, INPUT_SOURCE_EMPTY.get(), transform);

                    final IllegalPathOperationException thrown = assertThrows(IllegalPathOperationException.class, testMethod);
                    assertAll("Checking Exception",
                            () -> assertThat(thrown.getMessage(), is(equalTo(String.format(
                                    "Path '%s' does not existing and automatic creation disabled by transformation.",
                                    "a3ArrayObjects"
                            )))),
                            () -> assertThat(thrown.getCause(), is(nullValue()))
                    );
                    assertAll("Verify transform mock wasn't called",
                            () -> verify(transform, never())
                                    .perform(any(), anyMap(), anyString())
                    );
                }),

                // array.array.object
                dynamicTest("a3ArrayObjects[1].b3Array[2].c3Path with " + INPUT_TYPE, () -> {
                    final String key = "a3ArrayObjects[1].b3Array[2].c3Path";

                    final Transformation transform = mock(Transformation.class);

                    when(transform.isParentPathAutoCreated())
                            .thenReturn(IS_PARENT_PATH_AUTO_CREATED);

                    final Executable testMethod = () -> classUnderTest.transform(key, INPUT_SOURCE_EMPTY.get(), transform);

                    final IllegalPathOperationException thrown = assertThrows(IllegalPathOperationException.class, testMethod);
                    assertAll("Checking Exception",
                            () -> assertThat(thrown.getMessage(), is(equalTo(String.format(
                                    "Path '%s' does not existing and automatic creation disabled by transformation.",
                                    "a3ArrayObjects"
                            )))),
                            () -> assertThat(thrown.getCause(), is(nullValue()))
                    );
                    assertAll("Verify transform mock wasn't called",
                            () -> verify(transform, never())
                                    .perform(any(), anyMap(), anyString())
                    );
                }),

                // array.array.array
                dynamicTest("a3ArrayObjects[1].b3Array[2].c3Array[3] with " + INPUT_TYPE, () -> {
                    final String key = "a3ArrayObjects[1].b3Array[2].c3Array[3]";

                    final Transformation transform = mock(Transformation.class);

                    when(transform.isParentPathAutoCreated())
                            .thenReturn(IS_PARENT_PATH_AUTO_CREATED);

                    final Executable testMethod = () -> classUnderTest.transform(key, INPUT_SOURCE_EMPTY.get(), transform);

                    final IllegalPathOperationException thrown = assertThrows(IllegalPathOperationException.class, testMethod);
                    assertAll("Checking Exception",
                            () -> assertThat(thrown.getMessage(), is(equalTo(String.format(
                                    "Path '%s' does not existing and automatic creation disabled by transformation.",
                                    "a3ArrayObjects"
                            )))),
                            () -> assertThat(thrown.getCause(), is(nullValue()))
                    );
                    assertAll("Verify transform mock wasn't called",
                            () -> verify(transform, never())
                                    .perform(any(), anyMap(), anyString())
                    );
                })

        );
    }

}
