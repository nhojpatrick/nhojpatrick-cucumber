package com.github.nhojpatrick.cucumber.json.transform.impl;

import com.github.nhojpatrick.cucumber.json.core.transform.Transformation;
import com.github.nhojpatrick.cucumber.json.core.validation.PathElement;
import com.github.nhojpatrick.cucumber.json.core.validation.impl.PathArrayElementImpl;
import com.github.nhojpatrick.cucumber.json.core.validation.impl.PathAttributeElementImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Supplier;

import static com.github.nhojpatrick.cucumber.json.transform.impl.TransformImpl_EmptyInput_autoTrueTest.INPUT_TYPE;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;
import static org.mockito.ArgumentMatchers.anyMap;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@DisplayName("Transform Impl " + INPUT_TYPE + " autoTrue Tests")
public class TransformImpl_EmptyInput_autoTrueTest {

    public static final String INPUT_TYPE = "Empty Input";

    private static final Supplier<Map> INPUT_SOURCE = () -> new LinkedHashMap<>();

    private static final boolean IS_PARENT_PATH_AUTO_CREATED = true;

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

                    final Map<String, Object> actual = classUnderTest.transform(key, INPUT_SOURCE.get(), transform);

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

                    final Map<String, Object> actual = classUnderTest.transform(key, INPUT_SOURCE.get(), transform);

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
    @DisplayName(INPUT_TYPE + " 2 Level Paths")
    public Collection<DynamicTest> input_2_paths_level() {

        final TransformImpl classUnderTest = new TransformImpl();

        return Arrays.asList(

                // object.object
                dynamicTest("a2Path.b2Path with " + INPUT_TYPE, () -> {
                    final String key = "a2Path.b2Path";

                    final PathAttributeElementImpl pathElement = new PathAttributeElementImpl("b2Path");

                    final Map<String, Object> a2Path = new LinkedHashMap<>();
                    a2Path.put("transform", "output");

                    final Map<String, Object> expected = new LinkedHashMap<>();
                    expected.put("a2Path", a2Path);

                    final Transformation transform = mock(Transformation.class);

                    when(transform.isParentPathAutoCreated())
                            .thenReturn(IS_PARENT_PATH_AUTO_CREATED);

                    final Map<String, Object> transformOutput = new LinkedHashMap<>();
                    transformOutput.put("transform", "output");
                    when(transform.perform(eq(pathElement), anyMap(), eq("a2Path")))
                            .thenReturn(transformOutput);

                    final Map<String, Object> actual = classUnderTest.transform(key, INPUT_SOURCE.get(), transform);

                    assertThat(actual, is(notNullValue()));
                    assertAll("Checking maps",
                            () -> assertThat(actual, is(equalTo(expected))),
                            () -> verify(transform, times(1))
                                    .perform(eq(pathElement), anyMap(), eq("a2Path"))
                    );
                }),

                // object.array
                dynamicTest("a2Path.b2Array[2] with " + INPUT_TYPE, () -> {
                    final String key = "a2Path.b2Array[2]";

                    final PathElement pathElement = new PathArrayElementImpl(String.format("%s[%s]", "b2Array", 2), "b2Array", 2);

                    final Map<String, Object> a2Path = new LinkedHashMap<>();
                    a2Path.put("transform", "output");

                    final Map<String, Object> expected = new LinkedHashMap<>();
                    expected.put("a2Path", a2Path);

                    final Transformation transform = mock(Transformation.class);

                    when(transform.isParentPathAutoCreated())
                            .thenReturn(IS_PARENT_PATH_AUTO_CREATED);

                    final Map<String, Object> transformOutput = new LinkedHashMap<>();
                    transformOutput.put("transform", "output");
                    when(transform.perform(eq(pathElement), anyMap(), eq("a2Path")))
                            .thenReturn(transformOutput);

                    final Map<String, Object> actual = classUnderTest.transform(key, INPUT_SOURCE.get(), transform);

                    assertThat(actual, is(notNullValue()));
                    assertAll("Checking maps",
                            () -> assertThat(actual, is(equalTo(expected))),
                            () -> verify(transform, times(1))
                                    .perform(eq(pathElement), anyMap(), eq("a2Path"))
                    );
                }),

                // array.object
                dynamicTest("a2Array[1].b2Path with " + INPUT_TYPE, () -> {
                    final String key = "a2Array[1].b2Path";

                    final PathElement pathElement = new PathAttributeElementImpl("b2Path");

                    final Map<String, Object> a2Path = new LinkedHashMap<>();
                    a2Path.put("transform", "output");

                    final Map<String, Object> expected = new LinkedHashMap<>();
                    expected.put("a2Array", new ArrayList<>(Arrays.asList(
                            new LinkedHashMap<>(),
                            a2Path
                    )));

                    final Transformation transform = mock(Transformation.class);

                    when(transform.isParentPathAutoCreated())
                            .thenReturn(IS_PARENT_PATH_AUTO_CREATED);

                    final Map<String, Object> transformOutput = new LinkedHashMap<>();
                    transformOutput.put("transform", "output");
                    when(transform.perform(eq(pathElement), anyMap(), eq("a2Array[1]")))
                            .thenReturn(transformOutput);

                    final Map<String, Object> actual = classUnderTest.transform(key, INPUT_SOURCE.get(), transform);

                    assertThat(actual, is(notNullValue()));
                    assertAll("Checking maps",
                            () -> assertThat(actual, is(equalTo(expected))),
                            () -> verify(transform, times(1))
                                    .perform(eq(pathElement), anyMap(), eq("a2Array[1]"))
                    );
                }),

                // array.array
                dynamicTest("a2Array[1].b2Array[2] with " + INPUT_TYPE, () -> {
                    final String key = "a2Array[1].b2Array[2]";

                    final PathElement pathElement = new PathArrayElementImpl(String.format("%s[%s]", "b2Array", 2), "b2Array", 2);

                    final Map<String, Object> a2Path = new LinkedHashMap<>();
                    a2Path.put("transform", "output");

                    final Map<String, Object> expected = new LinkedHashMap<>();
                    expected.put("a2Array", new ArrayList<>(Arrays.asList(
                            new LinkedHashMap<>(),
                            a2Path
                    )));

                    final Transformation transform = mock(Transformation.class);

                    when(transform.isParentPathAutoCreated())
                            .thenReturn(IS_PARENT_PATH_AUTO_CREATED);

                    final Map<String, Object> transformOutput = new LinkedHashMap<>();
                    transformOutput.put("transform", "output");
                    when(transform.perform(eq(pathElement), anyMap(), eq("a2Array[1]")))
                            .thenReturn(transformOutput);

                    final Map<String, Object> actual = classUnderTest.transform(key, INPUT_SOURCE.get(), transform);

                    assertThat(actual, is(notNullValue()));
                    assertAll("Checking maps",
                            () -> assertThat(actual, is(equalTo(expected))),
                            () -> verify(transform, times(1))
                                    .perform(eq(pathElement), anyMap(), eq("a2Array[1]"))
                    );
                })

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

                    final PathAttributeElementImpl pathElement = new PathAttributeElementImpl("c3Path");

                    final Map<String, Object> b3Path = new LinkedHashMap<>();
                    b3Path.put("transform", "output");

                    final Map<String, Object> a3Path = new LinkedHashMap<>();
                    a3Path.put("b3Path", b3Path);

                    final Map<String, Object> expected = new LinkedHashMap<>();
                    expected.put("a3Path", a3Path);

                    final Transformation transform = mock(Transformation.class);

                    when(transform.isParentPathAutoCreated())
                            .thenReturn(IS_PARENT_PATH_AUTO_CREATED);

                    final Map<String, Object> transformOutput = new LinkedHashMap<>();
                    transformOutput.put("transform", "output");
                    when(transform.perform(eq(pathElement), anyMap(), eq("a3Path.b3Path")))
                            .thenReturn(transformOutput);

                    final Map<String, Object> actual = classUnderTest.transform(key, INPUT_SOURCE.get(), transform);

                    assertThat(actual, is(notNullValue()));
                    assertAll("Checking maps",
                            () -> assertThat(actual, is(equalTo(expected))),
                            () -> verify(transform, times(1))
                                    .perform(eq(pathElement), anyMap(), eq("a3Path.b3Path"))
                    );
                }),

                // object.object.array
                dynamicTest("a3Path.b3Path.c3Array[3] with " + INPUT_TYPE, () -> {
                    final String key = "a3Path.b3Path.c3Array[3]";

                    final PathElement pathElement = new PathArrayElementImpl(String.format("%s[%s]", "c3Array", 3), "c3Array", 3);

                    final Map<String, Object> b3Path = new LinkedHashMap<>();
                    b3Path.put("transform", "output");

                    final Map<String, Object> a3Path = new LinkedHashMap<>();
                    a3Path.put("b3Path", b3Path);

                    final Map<String, Object> expected = new LinkedHashMap<>();
                    expected.put("a3Path", a3Path);

                    final Transformation transform = mock(Transformation.class);

                    when(transform.isParentPathAutoCreated())
                            .thenReturn(IS_PARENT_PATH_AUTO_CREATED);

                    final Map<String, Object> transformOutput = new LinkedHashMap<>();
                    transformOutput.put("transform", "output");
                    when(transform.perform(eq(pathElement), anyMap(), eq("a3Path.b3Path")))
                            .thenReturn(transformOutput);

                    final Map<String, Object> actual = classUnderTest.transform(key, INPUT_SOURCE.get(), transform);

                    assertThat(actual, is(notNullValue()));
                    assertAll("Checking maps",
                            () -> assertThat(actual, is(equalTo(expected))),
                            () -> verify(transform, times(1))
                                    .perform(eq(pathElement), anyMap(), eq("a3Path.b3Path"))
                    );
                }),

                // object.array.object
                dynamicTest("a3Path.b3Array[2].c3Path with " + INPUT_TYPE, () -> {
                    final String key = "a3Path.b3Array[2].c3Path";

                    final PathElement pathElement = new PathAttributeElementImpl("c3Path");

                    final Map<String, Object> b3Path = new LinkedHashMap<>();
                    b3Path.put("transform", "output");

                    final Map<String, Object> a3Path = new LinkedHashMap<>();
                    a3Path.put("b3Array", new ArrayList<>(Arrays.asList(
                            new LinkedHashMap<>(),
                            new LinkedHashMap<>(),
                            b3Path
                    )));

                    final Map<String, Object> expected = new LinkedHashMap<>();
                    expected.put("a3Path", a3Path);

                    final Transformation transform = mock(Transformation.class);

                    when(transform.isParentPathAutoCreated())
                            .thenReturn(IS_PARENT_PATH_AUTO_CREATED);

                    final Map<String, Object> transformOutput = new LinkedHashMap<>();
                    transformOutput.put("transform", "output");
                    when(transform.perform(eq(pathElement), anyMap(), eq("a3Path.b3Array[2]")))
                            .thenReturn(transformOutput);

                    final Map<String, Object> actual = classUnderTest.transform(key, INPUT_SOURCE.get(), transform);

                    assertThat(actual, is(notNullValue()));
                    assertAll("Checking maps",
                            () -> assertThat(actual, is(equalTo(expected))),
                            () -> verify(transform, times(1))
                                    .perform(eq(pathElement), anyMap(), eq("a3Path.b3Array[2]"))
                    );
                }),

                // object.array.array
                dynamicTest("a3Path.b3Array[2].c3Array[3] with " + INPUT_TYPE, () -> {
                    final String key = "a3Path.b3Array[2].c3Array[3]";

                    final PathElement pathElement = new PathArrayElementImpl(String.format("%s[%s]", "c3Array", 3), "c3Array", 3);

                    final Map<String, Object> b3Path = new LinkedHashMap<>();
                    b3Path.put("transform", "output");

                    final Map<String, Object> a3Path = new LinkedHashMap<>();
                    a3Path.put("b3Array", new ArrayList<>(Arrays.asList(
                            new LinkedHashMap<>(),
                            new LinkedHashMap<>(),
                            b3Path
                    )));

                    final Map<String, Object> expected = new LinkedHashMap<>();
                    expected.put("a3Path", a3Path);

                    final Transformation transform = mock(Transformation.class);

                    when(transform.isParentPathAutoCreated())
                            .thenReturn(IS_PARENT_PATH_AUTO_CREATED);

                    final Map<String, Object> transformOutput = new LinkedHashMap<>();
                    transformOutput.put("transform", "output");
                    when(transform.perform(eq(pathElement), anyMap(), eq("a3Path.b3Array[2]")))
                            .thenReturn(transformOutput);

                    final Map<String, Object> actual = classUnderTest.transform(key, INPUT_SOURCE.get(), transform);

                    assertThat(actual, is(notNullValue()));
                    assertAll("Checking maps",
                            () -> assertThat(actual, is(equalTo(expected))),
                            () -> verify(transform, times(1))
                                    .perform(eq(pathElement), anyMap(), eq("a3Path.b3Array[2]"))
                    );
                }),

                // array.object.object
                dynamicTest("a3Array[1].b3Path.c3Path with " + INPUT_TYPE, () -> {
                    final String key = "a3Array[1].b3Path.c3Path";

                    final PathElement pathElement = new PathAttributeElementImpl("c3Path");

                    final Map<String, Object> b3Path = new LinkedHashMap<>();
                    b3Path.put("transform", "output");

                    final Map<String, Object> a3Path = new LinkedHashMap<>();
                    a3Path.put("b3Path", b3Path);

                    final Map<String, Object> expected = new LinkedHashMap<>();
                    expected.put("a3Array", new ArrayList<>(Arrays.asList(
                            new LinkedHashMap<>(),
                            a3Path
                    )));

                    final Transformation transform = mock(Transformation.class);

                    when(transform.isParentPathAutoCreated())
                            .thenReturn(IS_PARENT_PATH_AUTO_CREATED);

                    final Map<String, Object> transformOutput = new LinkedHashMap<>();
                    transformOutput.put("transform", "output");
                    when(transform.perform(eq(pathElement), anyMap(), eq("a3Array[1].b3Path")))
                            .thenReturn(transformOutput);

                    final Map<String, Object> actual = classUnderTest.transform(key, INPUT_SOURCE.get(), transform);

                    assertThat(actual, is(notNullValue()));
                    assertAll("Checking maps",
                            () -> assertThat(actual, is(equalTo(expected))),
                            () -> verify(transform, times(1))
                                    .perform(eq(pathElement), anyMap(), eq("a3Array[1].b3Path"))
                    );
                }),

                // array.object.array
                dynamicTest("a3Array[1].b3Path.c3Array[3] with " + INPUT_TYPE, () -> {
                    final String key = "a3Array[1].b3Path.c3Array[3]";

                    final PathElement pathElement = new PathArrayElementImpl(String.format("%s[%s]", "c3Array", 3), "c3Array", 3);

                    final Map<String, Object> b3Path = new LinkedHashMap<>();
                    b3Path.put("transform", "output");

                    final Map<String, Object> a3Path = new LinkedHashMap<>();
                    a3Path.put("b3Path", b3Path);

                    final Map<String, Object> expected = new LinkedHashMap<>();
                    expected.put("a3Array", new ArrayList<>(Arrays.asList(
                            new LinkedHashMap<>(),
                            a3Path
                    )));

                    final Transformation transform = mock(Transformation.class);

                    when(transform.isParentPathAutoCreated())
                            .thenReturn(IS_PARENT_PATH_AUTO_CREATED);

                    final Map<String, Object> transformOutput = new LinkedHashMap<>();
                    transformOutput.put("transform", "output");
                    when(transform.perform(eq(pathElement), anyMap(), eq("a3Array[1].b3Path")))
                            .thenReturn(transformOutput);

                    final Map<String, Object> actual = classUnderTest.transform(key, INPUT_SOURCE.get(), transform);

                    assertThat(actual, is(notNullValue()));
                    assertAll("Checking maps",
                            () -> assertThat(actual, is(equalTo(expected))),
                            () -> verify(transform, times(1))
                                    .perform(eq(pathElement), anyMap(), eq("a3Array[1].b3Path"))
                    );
                }),

                // array.array.object
                dynamicTest("a3Array[1].b3Array[2].c3Path with " + INPUT_TYPE, () -> {
                    final String key = "a3Array[1].b3Array[2].c3Path";

                    final PathElement pathElement = new PathAttributeElementImpl("c3Path");

                    final Map<String, Object> b3Path = new LinkedHashMap<>();
                    b3Path.put("transform", "output");

                    final Map<String, Object> a3Path = new LinkedHashMap<>();
                    a3Path.put("b3Array", new ArrayList<>(Arrays.asList(
                            new LinkedHashMap<>(),
                            new LinkedHashMap<>(),
                            b3Path
                    )));

                    final Map<String, Object> expected = new LinkedHashMap<>();
                    expected.put("a3Array", new ArrayList<>(Arrays.asList(
                            new LinkedHashMap<>(),
                            a3Path
                    )));

                    final Transformation transform = mock(Transformation.class);

                    when(transform.isParentPathAutoCreated())
                            .thenReturn(IS_PARENT_PATH_AUTO_CREATED);

                    final Map<String, Object> transformOutput = new LinkedHashMap<>();
                    transformOutput.put("transform", "output");
                    when(transform.perform(eq(pathElement), anyMap(), eq("a3Array[1].b3Array[2]")))
                            .thenReturn(transformOutput);

                    final Map<String, Object> actual = classUnderTest.transform(key, INPUT_SOURCE.get(), transform);

                    assertThat(actual, is(notNullValue()));
                    assertAll("Checking maps",
                            () -> assertThat(actual, is(equalTo(expected))),
                            () -> verify(transform, times(1))
                                    .perform(eq(pathElement), anyMap(), eq("a3Array[1].b3Array[2]"))
                    );
                }),

                // array.array.array
                dynamicTest("a3Array[1].b3Array[2].c3Array[3] with " + INPUT_TYPE, () -> {
                    final String key = "a3Array[1].b3Array[2].c3Array[3]";

                    final PathElement pathElement = new PathArrayElementImpl(String.format("%s[%s]", "c3Array", 3), "c3Array", 3);

                    final Map<String, Object> b3Path = new LinkedHashMap<>();
                    b3Path.put("transform", "output");

                    final Map<String, Object> a3Path = new LinkedHashMap<>();
                    a3Path.put("b3Array", new ArrayList<>(Arrays.asList(
                            new LinkedHashMap<>(),
                            new LinkedHashMap<>(),
                            b3Path
                    )));

                    final Map<String, Object> expected = new LinkedHashMap<>();
                    expected.put("a3Array", new ArrayList<>(Arrays.asList(
                            new LinkedHashMap<>(),
                            a3Path
                    )));

                    final Transformation transform = mock(Transformation.class);

                    when(transform.isParentPathAutoCreated())
                            .thenReturn(IS_PARENT_PATH_AUTO_CREATED);

                    final Map<String, Object> transformOutput = new LinkedHashMap<>();
                    transformOutput.put("transform", "output");
                    when(transform.perform(eq(pathElement), anyMap(), eq("a3Array[1].b3Array[2]")))
                            .thenReturn(transformOutput);

                    final Map<String, Object> actual = classUnderTest.transform(key, INPUT_SOURCE.get(), transform);

                    assertThat(actual, is(notNullValue()));
                    assertAll("Checking maps",
                            () -> assertThat(actual, is(equalTo(expected))),
                            () -> verify(transform, times(1))
                                    .perform(eq(pathElement), anyMap(), eq("a3Array[1].b3Array[2]"))
                    );
                })

        );
    }

}
