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
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

import static com.github.nhojpatrick.cucumber.json.transform.impl.TransformImpl_MatchedInput_autoTrueTest.INPUT_TYPE;
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

/**
 * Should be identical to TransformImpl_MatchedInput_autoTrueTest, apart from.
 * <p>
 * private static final boolean IS_PARENT_PATH_AUTO_CREATED = false;
 * </p>
 */
@DisplayName("Transform Impl " + INPUT_TYPE + " autoFalse Tests")
public class TransformImpl_MatchedInput_autoFalseTest {

    public static final String INPUT_TYPE = "Matched Input";

    private static final boolean IS_PARENT_PATH_AUTO_CREATED = false;

    @TestFactory
    @DisplayName(INPUT_TYPE + " 1 Level Path")
    public Collection<DynamicTest> input_1_path_level() {

        final Supplier<Map> inputSource = () -> {
            final Map<String, Object> parent = new LinkedHashMap<>();

            parent.put("a1Array", new ArrayList<>(Arrays.asList(
                    new LinkedHashMap<String, Object>(),
                    new LinkedHashMap<String, Object>()
            )));
            parent.put("a1Path", new LinkedHashMap<String, Object>());

            return parent;
        };

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

                    final Map<String, Object> actual = classUnderTest.transform(key, inputSource.get(), transform);

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

                    final Map<String, Object> actual = classUnderTest.transform(key, inputSource.get(), transform);

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

        final Supplier<Map> inputSource = () -> {

            final LinkedHashMap<String, Object> a2Path = new LinkedHashMap<>();
            a2Path.put("a2Path_b2Array", new ArrayList<>(Arrays.asList(
                    new LinkedHashMap<String, Object>(),
                    new LinkedHashMap<String, Object>(),
                    new LinkedHashMap<String, Object>()
            )));
            a2Path.put("a2Path_b2Path", new LinkedHashMap<>());

            final Map<String, Object> parent = new LinkedHashMap<>();

            parent.put("a2Array", new ArrayList<>(Arrays.asList(
                    new LinkedHashMap<String, Object>(),
                    new LinkedHashMap<String, Object>()
            )));
            parent.put("a2Path", a2Path);

            return parent;
        };

        final TransformImpl classUnderTest = new TransformImpl();

        return Arrays.asList(

                // object.object
                dynamicTest("a2Path.a2Path_b2Path with " + INPUT_TYPE, () -> {
                    final String key = "a2Path.a2Path_b2Path";

                    final PathElement pathElement = new PathAttributeElementImpl("a2Path_b2Path");

                    final Map<String, Object> output = new LinkedHashMap<>();
                    output.put("transform", "output");

                    final Map<String, Object> expected = inputSource.get();
                    expected.put("a2Path", output);

                    final Transformation transform = mock(Transformation.class);

                    when(transform.isParentPathAutoCreated())
                            .thenReturn(IS_PARENT_PATH_AUTO_CREATED);

                    final Map<String, Object> transformOutput = new LinkedHashMap<>();
                    transformOutput.put("transform", "output");
                    when(transform.perform(eq(pathElement), anyMap(), eq("a2Path")))
                            .thenReturn(transformOutput);

                    final Map<String, Object> actual = classUnderTest.transform(key, inputSource.get(), transform);

                    assertThat(actual, is(notNullValue()));
                    assertAll("Checking maps",
                            () -> assertThat(actual, is(equalTo(expected))),
                            () -> verify(transform, times(1))
                                    .perform(eq(pathElement), anyMap(), eq("a2Path"))
                    );
                }),

                // object.array
                dynamicTest("a2Path.a2Path_b2Array[2] with " + INPUT_TYPE, () -> {
                    final String key = "a2Path.a2Path_b2Array[2]";

                    final PathElement pathElement = new PathArrayElementImpl(String.format("%s[%s]", "a2Path_b2Array", 2), "a2Path_b2Array", 2);

                    final Map<String, Object> output = new LinkedHashMap<>();
                    output.put("transform", "output");

                    final Map<String, Object> expected = inputSource.get();
                    expected.put("a2Path", output);

                    final Transformation transform = mock(Transformation.class);

                    when(transform.isParentPathAutoCreated())
                            .thenReturn(IS_PARENT_PATH_AUTO_CREATED);

                    final Map<String, Object> transformOutput = new LinkedHashMap<>();
                    transformOutput.put("transform", "output");
                    when(transform.perform(eq(pathElement), anyMap(), eq("a2Path")))
                            .thenReturn(transformOutput);

                    final Map<String, Object> actual = classUnderTest.transform(key, inputSource.get(), transform);

                    assertThat(actual, is(notNullValue()));
                    assertAll("Checking maps",
                            () -> assertThat(actual, is(equalTo(expected))),
                            () -> verify(transform, times(1))
                                    .perform(eq(pathElement), anyMap(), eq("a2Path"))
                    );
                }),

                // array.object
                dynamicTest("a2Array[1].a2Array1_b2Path with " + INPUT_TYPE, () -> {
                    final String key = "a2Array[1].a2Array1_b2Path";

                    final PathElement pathElement = new PathAttributeElementImpl("a2Array1_b2Path");

                    final Map<String, Object> output = new LinkedHashMap<>();
                    output.put("transform", "output");

                    final Map<String, Object> expected = inputSource.get();
                    expected.put("a2Array", new ArrayList<>(Arrays.asList(
                            new LinkedHashMap<>(),
                            output
                    )));

                    final Transformation transform = mock(Transformation.class);

                    when(transform.isParentPathAutoCreated())
                            .thenReturn(IS_PARENT_PATH_AUTO_CREATED);

                    final Map<String, Object> transformOutput = new LinkedHashMap<>();
                    transformOutput.put("transform", "output");
                    when(transform.perform(eq(pathElement), anyMap(), eq("a2Array[1]")))
                            .thenReturn(transformOutput);

                    final Map<String, Object> actual = classUnderTest.transform(key, inputSource.get(), transform);

                    assertThat(actual, is(notNullValue()));
                    assertAll("Checking maps",
                            () -> assertThat(actual, is(equalTo(expected))),
                            () -> verify(transform, times(1))
                                    .perform(eq(pathElement), anyMap(), eq("a2Array[1]"))
                    );
                }),

                // array.array
                dynamicTest("a2Array[1].a2Array1_b2Array[2] with " + INPUT_TYPE, () -> {
                    final String key = "a2Array[1].a2Array1_b2Array[2]";

                    final PathElement pathElement = new PathArrayElementImpl(String.format("%s[%s]", "a2Array1_b2Array", 2), "a2Array1_b2Array", 2);

                    final Map<String, Object> output = new LinkedHashMap<>();
                    output.put("transform", "output");

                    final Map<String, Object> expected = inputSource.get();
                    expected.put("a2Array", new ArrayList<>(Arrays.asList(
                            new LinkedHashMap<>(),
                            output
                    )));

                    final Transformation transform = mock(Transformation.class);

                    when(transform.isParentPathAutoCreated())
                            .thenReturn(IS_PARENT_PATH_AUTO_CREATED);

                    final Map<String, Object> transformOutput = new LinkedHashMap<>();
                    transformOutput.put("transform", "output");
                    when(transform.perform(eq(pathElement), anyMap(), eq("a2Array[1]")))
                            .thenReturn(transformOutput);

                    final Map<String, Object> actual = classUnderTest.transform(key, inputSource.get(), transform);

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

        final Supplier<Map> inputSource = () -> {
            final Map<String, Object> parent = new LinkedHashMap<>();

            final LinkedHashMap<String, Object> b3PathChild = new LinkedHashMap<>();
            b3PathChild.put("a3Path_b3Path_c3Array", new ArrayList<>(Arrays.asList(
                    new LinkedHashMap<String, Object>(),
                    new LinkedHashMap<String, Object>(),
                    new LinkedHashMap<String, Object>()
            )));
            b3PathChild.put("a3Path_b3Path_c3Array", new LinkedHashMap<>());

            final LinkedHashMap<String, Object> b3Array_idx2 = new LinkedHashMap<>();
            b3Array_idx2.put("a3Path_b3Array2_c3Path", new LinkedHashMap<>());

            final LinkedHashMap<String, Object> a3PathChild = new LinkedHashMap<>();
            a3PathChild.put("a3Path_b3Array", new ArrayList<>(Arrays.asList(
                    new LinkedHashMap<String, Object>(),
                    new LinkedHashMap<String, Object>(),
                    b3Array_idx2
            )));
            a3PathChild.put("a3Path_b3Path", b3PathChild);

            final LinkedHashMap<String, Object> c3Array_idx3 = new LinkedHashMap<>();

            final LinkedHashMap<String, Object> a3Array_idx1 = new LinkedHashMap<>();
            a3Array_idx1.put("a3Array1_b3Array", new ArrayList<>(Arrays.asList(
                    new LinkedHashMap<String, Object>(),
                    new LinkedHashMap<String, Object>(),
                    c3Array_idx3
            )));
            a3Array_idx1.put("a3Array1_b3Path", new LinkedHashMap<>());

            parent.put("a3Array", new ArrayList<>(Arrays.asList(
                    new LinkedHashMap<String, Object>(),
                    a3Array_idx1
            )));
            parent.put("a3Path", a3PathChild);

            return parent;
        };

        final TransformImpl classUnderTest = new TransformImpl();

        return Arrays.asList(

                // object.object.object
                dynamicTest("a3Path.a3Path_b3Path.a3Path_b3Path_c3Path with " + INPUT_TYPE, () -> {
                    final String key = "a3Path.a3Path_b3Path.a3Path_b3Path_c3Path";

                    final PathElement pathElement = new PathAttributeElementImpl("a3Path_b3Path_c3Path");

                    final Map<String, Object> output = new LinkedHashMap<>();
                    output.put("transform", "output");

                    final Map<String, Object> expected = inputSource.get();
                    final Map<String, Object> a3Path = (Map<String, Object>) expected.get("a3Path");
                    a3Path.put("a3Path_b3Path", output);

                    final Transformation transform = mock(Transformation.class);

                    when(transform.isParentPathAutoCreated())
                            .thenReturn(IS_PARENT_PATH_AUTO_CREATED);

                    final Map<String, Object> transformOutput = new LinkedHashMap<>();
                    transformOutput.put("transform", "output");
                    when(transform.perform(eq(pathElement), anyMap(), eq("a3Path.a3Path_b3Path")))
                            .thenReturn(transformOutput);

                    final Map<String, Object> actual = classUnderTest.transform(key, inputSource.get(), transform);

                    assertThat(actual, is(notNullValue()));
                    assertAll("Checking maps",
                            () -> assertThat(actual, is(equalTo(expected))),
                            () -> verify(transform, times(1))
                                    .perform(eq(pathElement), anyMap(), eq("a3Path.a3Path_b3Path"))
                    );
                }),

                // object.object.array
                dynamicTest("a3Path.a3Path_b3Path.a3Path_b3Path_c3Array[3] with " + INPUT_TYPE, () -> {
                    final String key = "a3Path.a3Path_b3Path.a3Path_b3Path_c3Array[3]";

                    final PathElement pathElement = new PathArrayElementImpl(String.format("%s[%s]", "a3Path_b3Path_c3Array", 3), "a3Path_b3Path_c3Array", 3);

                    final Map<String, Object> output = new LinkedHashMap<>();
                    output.put("transform", "output");

                    final Map<String, Object> expected = inputSource.get();
                    final Map<String, Object> a3Path = (Map<String, Object>) expected.get("a3Path");
                    a3Path.put("a3Path_b3Path", output);

                    final Transformation transform = mock(Transformation.class);

                    when(transform.isParentPathAutoCreated())
                            .thenReturn(IS_PARENT_PATH_AUTO_CREATED);

                    final Map<String, Object> transformOutput = new LinkedHashMap<>();
                    transformOutput.put("transform", "output");
                    when(transform.perform(eq(pathElement), anyMap(), eq("a3Path.a3Path_b3Path")))
                            .thenReturn(transformOutput);

                    final Map<String, Object> actual = classUnderTest.transform(key, inputSource.get(), transform);

                    assertThat(actual, is(notNullValue()));
                    assertAll("Checking maps",
                            () -> assertThat(actual, is(equalTo(expected))),
                            () -> verify(transform, times(1))
                                    .perform(eq(pathElement), anyMap(), eq("a3Path.a3Path_b3Path"))
                    );
                }),

                // object.array.object
                dynamicTest("a3Path.a3Path_b3Array[2].a3Path_b3Array2_c3Path with " + INPUT_TYPE, () -> {
                    final String key = "a3Path.a3Path_b3Array[2].a3Path_b3Array2_c3Path";

                    final PathElement pathElement = new PathAttributeElementImpl("a3Path_b3Array2_c3Path");

                    final Map<String, Object> output = new LinkedHashMap<>();
                    output.put("transform", "output");

                    final Map<String, Object> expected = inputSource.get();
                    final Map<String, Object> a3Path = (Map<String, Object>) expected.get("a3Path");
                    a3Path.put("a3Path_b3Array", new ArrayList<>(Arrays.asList(
                            new LinkedHashMap<>(),
                            new LinkedHashMap<>(),
                            output
                    )));

                    final Transformation transform = mock(Transformation.class);

                    when(transform.isParentPathAutoCreated())
                            .thenReturn(IS_PARENT_PATH_AUTO_CREATED);

                    final Map<String, Object> transformOutput = new LinkedHashMap<>();
                    transformOutput.put("transform", "output");
                    when(transform.perform(eq(pathElement), anyMap(), eq("a3Path.a3Path_b3Array[2]")))
                            .thenReturn(transformOutput);

                    final Map<String, Object> actual = classUnderTest.transform(key, inputSource.get(), transform);

                    assertThat(actual, is(notNullValue()));
                    assertAll("Checking maps",
                            () -> assertThat(actual, is(equalTo(expected))),
                            () -> verify(transform, times(1))
                                    .perform(eq(pathElement), anyMap(), eq("a3Path.a3Path_b3Array[2]"))
                    );
                }),

                // object.array.array
                dynamicTest("a3Path.a3Path_b3Array[2].a3Path_b3Array2_c3Array[3] with " + INPUT_TYPE, () -> {
                    final String key = "a3Path.a3Path_b3Array[2].a3Path_b3Array2_c3Array[3]";

                    final PathElement pathElement = new PathArrayElementImpl(String.format("%s[%s]", "a3Path_b3Array2_c3Array", 3), "a3Path_b3Array2_c3Array", 3);

                    final Map<String, Object> output = new LinkedHashMap<>();
                    output.put("transform", "output");

                    final Map<String, Object> expected = inputSource.get();
                    final Map<String, Object> a3Path = (Map<String, Object>) expected.get("a3Path");
                    a3Path.put("a3Path_b3Array", new ArrayList<>(Arrays.asList(
                            new LinkedHashMap<>(),
                            new LinkedHashMap<>(),
                            output
                    )));

                    final Transformation transform = mock(Transformation.class);

                    when(transform.isParentPathAutoCreated())
                            .thenReturn(IS_PARENT_PATH_AUTO_CREATED);

                    final Map<String, Object> transformOutput = new LinkedHashMap<>();
                    transformOutput.put("transform", "output");
                    when(transform.perform(eq(pathElement), anyMap(), eq("a3Path.a3Path_b3Array[2]")))
                            .thenReturn(transformOutput);

                    final Map<String, Object> actual = classUnderTest.transform(key, inputSource.get(), transform);

                    assertThat(actual, is(notNullValue()));
                    assertAll("Checking maps",
                            () -> assertThat(actual, is(equalTo(expected))),
                            () -> verify(transform, times(1))
                                    .perform(eq(pathElement), anyMap(), eq("a3Path.a3Path_b3Array[2]"))
                    );
                }),

                // array.object.object
                dynamicTest("a3Array[1].a3Array1_b3Path.a3Array1_b3Path_c3Path with " + INPUT_TYPE, () -> {
                    final String key = "a3Array[1].a3Array1_b3Path.a3Array1_b3Path_c3Path";

                    final PathElement pathElement = new PathAttributeElementImpl("a3Array1_b3Path_c3Path");

                    final Map<String, Object> output = new LinkedHashMap<>();
                    output.put("transform", "output");

                    final Map<String, Object> expected = inputSource.get();
                    final List<Map<String, Object>> a3Array = (List<Map<String, Object>>) expected.get("a3Array");
                    final Map<String, Object> a3Array1 = a3Array.get(1);
                    a3Array1.put("a3Array1_b3Path", output);

                    final Transformation transform = mock(Transformation.class);

                    when(transform.isParentPathAutoCreated())
                            .thenReturn(IS_PARENT_PATH_AUTO_CREATED);

                    final Map<String, Object> transformOutput = new LinkedHashMap<>();
                    transformOutput.put("transform", "output");
                    when(transform.perform(eq(pathElement), anyMap(), eq("a3Array[1].a3Array1_b3Path")))
                            .thenReturn(transformOutput);

                    final Map<String, Object> actual = classUnderTest.transform(key, inputSource.get(), transform);

                    assertThat(actual, is(notNullValue()));
                    assertAll("Checking maps",
                            () -> assertThat(actual, is(equalTo(expected))),
                            () -> verify(transform, times(1))
                                    .perform(eq(pathElement), anyMap(), eq("a3Array[1].a3Array1_b3Path"))
                    );
                }),

                // array.object.array
                dynamicTest("a3Array[1].a3Array1_b3Path.a3Array1_b3Path_c3Array[3] with " + INPUT_TYPE, () -> {
                    final String key = "a3Array[1].a3Array1_b3Path.a3Array1_b3Path_c3Array[3]";

                    final PathElement pathElement = new PathArrayElementImpl(String.format("%s[%s]", "a3Array1_b3Path_c3Array", 3), "a3Array1_b3Path_c3Array", 3);

                    final Map<String, Object> output = new LinkedHashMap<>();
                    output.put("transform", "output");

                    final Map<String, Object> expected = inputSource.get();
                    final List<Map<String, Object>> a3Array = (List<Map<String, Object>>) expected.get("a3Array");
                    final Map<String, Object> a3Array1 = a3Array.get(1);
                    a3Array1.put("a3Array1_b3Path", output);

                    final Transformation transform = mock(Transformation.class);

                    when(transform.isParentPathAutoCreated())
                            .thenReturn(IS_PARENT_PATH_AUTO_CREATED);

                    final Map<String, Object> transformOutput = new LinkedHashMap<>();
                    transformOutput.put("transform", "output");
                    when(transform.perform(eq(pathElement), anyMap(), eq("a3Array[1].a3Array1_b3Path")))
                            .thenReturn(transformOutput);

                    final Map<String, Object> actual = classUnderTest.transform(key, inputSource.get(), transform);

                    assertThat(actual, is(notNullValue()));
                    assertAll("Checking maps",
                            () -> assertThat(actual, is(equalTo(expected))),
                            () -> verify(transform, times(1))
                                    .perform(eq(pathElement), anyMap(), eq("a3Array[1].a3Array1_b3Path"))
                    );
                }),

                // array.array.object
                dynamicTest("a3Array[1].a3Array1_b3Array[2].a3Array1_b3Array2_c3Path with " + INPUT_TYPE, () -> {
                    final String key = "a3Array[1].a3Array1_b3Array[2].a3Array1_b3Array2_c3Path";

                    final PathElement pathElement = new PathAttributeElementImpl("a3Array1_b3Array2_c3Path");

                    final Map<String, Object> output = new LinkedHashMap<>();
                    output.put("transform", "output");

                    final Map<String, Object> expected = inputSource.get();
                    final List<Map<String, Object>> a3Array = (List<Map<String, Object>>) expected.get("a3Array");
                    final Map<String, Object> a3Array1 = a3Array.get(1);
                    a3Array1.put("a3Array1_b3Array", new ArrayList<>(Arrays.asList(
                            new LinkedHashMap<>(),
                            new LinkedHashMap<>(),
                            output
                    )));

                    final Transformation transform = mock(Transformation.class);

                    when(transform.isParentPathAutoCreated())
                            .thenReturn(IS_PARENT_PATH_AUTO_CREATED);

                    final Map<String, Object> transformOutput = new LinkedHashMap<>();
                    transformOutput.put("transform", "output");
                    when(transform.perform(eq(pathElement), anyMap(), eq("a3Array[1].a3Array1_b3Array[2]")))
                            .thenReturn(transformOutput);

                    final Map<String, Object> actual = classUnderTest.transform(key, inputSource.get(), transform);

                    assertThat(actual, is(notNullValue()));
                    assertAll("Checking maps",
                            () -> assertThat(actual, is(equalTo(expected))),
                            () -> verify(transform, times(1))
                                    .perform(eq(pathElement), anyMap(), eq("a3Array[1].a3Array1_b3Array[2]"))
                    );
                }),

                // array.array.array
                dynamicTest("a3Array[1].a3Array1_b3Array[2].a3Array1_b3Array2_c3Array[3] with " + INPUT_TYPE, () -> {
                    final String key = "a3Array[1].a3Array1_b3Array[2].a3Array1_b3Array2_c3Array[3]";

                    final PathElement pathElement = new PathArrayElementImpl(String.format("%s[%s]", "a3Array1_b3Array2_c3Array", 3), "a3Array1_b3Array2_c3Array", 3);

                    final Map<String, Object> output = new LinkedHashMap<>();
                    output.put("transform", "output");

                    final Map<String, Object> expected = inputSource.get();
                    final List<Map<String, Object>> a3Array = (List<Map<String, Object>>) expected.get("a3Array");
                    final Map<String, Object> a3Array1 = a3Array.get(1);
                    a3Array1.put("a3Array1_b3Array", new ArrayList<>(Arrays.asList(
                            new LinkedHashMap<>(),
                            new LinkedHashMap<>(),
                            output
                    )));

                    final Transformation transform = mock(Transformation.class);

                    when(transform.isParentPathAutoCreated())
                            .thenReturn(IS_PARENT_PATH_AUTO_CREATED);

                    final Map<String, Object> transformOutput = new LinkedHashMap<>();
                    transformOutput.put("transform", "output");
                    when(transform.perform(eq(pathElement), anyMap(), eq("a3Array[1].a3Array1_b3Array[2]")))
                            .thenReturn(transformOutput);

                    final Map<String, Object> actual = classUnderTest.transform(key, inputSource.get(), transform);

                    assertThat(actual, is(notNullValue()));
                    assertAll("Checking maps",
                            () -> assertThat(actual, is(equalTo(expected))),
                            () -> verify(transform, times(1))
                                    .perform(eq(pathElement), anyMap(), eq("a3Array[1].a3Array1_b3Array[2]"))
                    );
                })

        );
    }

}
