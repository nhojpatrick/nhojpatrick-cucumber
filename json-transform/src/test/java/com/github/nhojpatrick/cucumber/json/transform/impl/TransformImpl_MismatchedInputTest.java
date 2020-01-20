package com.github.nhojpatrick.cucumber.json.transform.impl;

import com.github.nhojpatrick.cucumber.json.core.exceptions.IllegalPathOperationException;
import com.github.nhojpatrick.cucumber.json.core.transform.Transformation;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.function.Executable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Supplier;

import static com.github.nhojpatrick.cucumber.json.transform.impl.TransformImpl_MismatchedInputTest.INPUT_TYPE;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyMap;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

@DisplayName("Transform Impl " + INPUT_TYPE + "Tests")
public class TransformImpl_MismatchedInputTest {

    public static final String INPUT_TYPE = "Mismatched Input";

    @TestFactory
    @DisplayName(INPUT_TYPE + " 2 Level Paths")
    public Collection<DynamicTest> input_2_paths_level() {

        final Supplier<Map> inputSource = () -> {
            final Map<String, Object> parent = new LinkedHashMap<>();

            parent.put("a2ArrayObjects", new ArrayList<>(Arrays.asList(
                    new LinkedHashMap<String, Object>(),
                    new LinkedHashMap<String, Object>()
            )));
            parent.put("a2ArrayPrimitives", Arrays.asList(
                    "a2PrimitiveArray0",
                    "a2PrimitiveArray1"
            ));
            parent.put("a2Path", new LinkedHashMap<>());
            parent.put("a2Primitive", "aPrimitive");

            return parent;
        };

        final TransformImpl classUnderTest = new TransformImpl();

        return Arrays.asList(

                dynamicTest("a2ArrayObjects.anything with " + INPUT_TYPE, () -> {
                    final String key = "a2ArrayObjects.anything";

                    final Transformation transform = mock(Transformation.class);

                    final Executable testMethod = () -> classUnderTest.transform(key, inputSource.get(), transform);

                    final IllegalPathOperationException thrown = assertThrows(IllegalPathOperationException.class, testMethod);
                    assertAll("Checking Exception",
                            () -> assertThat(thrown.getMessage(), is(equalTo(String.format(
                                    "Unable to convert array to object, at path '%s'.",
                                    "a2ArrayObjects"
                            )))),
                            () -> assertThat(thrown.getCause(), is(nullValue()))
                    );
                    assertAll("Verify transform mock wasn't called",
                            () -> verify(transform, never())
                                    .perform(any(), anyMap(), anyString())
                    );
                }),

                dynamicTest("a2ArrayPrimitives.anything with " + INPUT_TYPE, () -> {
                    final String key = "a2ArrayPrimitives.anything";

                    final Transformation transform = mock(Transformation.class);

                    final Executable testMethod = () -> classUnderTest.transform(key, inputSource.get(), transform);

                    final IllegalPathOperationException thrown = assertThrows(IllegalPathOperationException.class, testMethod);
                    assertAll("Checking Exception",
                            () -> assertThat(thrown.getMessage(), is(equalTo(String.format(
                                    "Unable to convert array to object, at path '%s'.",
                                    "a2ArrayPrimitives"
                            )))),
                            () -> assertThat(thrown.getCause(), is(nullValue()))
                    );
                    assertAll("Verify transform mock wasn't called",
                            () -> verify(transform, never())
                                    .perform(any(), anyMap(), anyString())
                    );
                }),

                dynamicTest("a2ArrayPrimitives[1].anything with " + INPUT_TYPE, () -> {
                    final String key = "a2ArrayPrimitives[1].anything";

                    final Transformation transform = mock(Transformation.class);

                    final Executable testMethod = () -> classUnderTest.transform(key, inputSource.get(), transform);

                    final IllegalPathOperationException thrown = assertThrows(IllegalPathOperationException.class, testMethod);
                    assertAll("Checking Exception",
                            () -> assertThat(thrown.getMessage(), is(equalTo(String.format(
                                    "Unable to convert primative array to object array, at path '%s'.",
                                    "a2ArrayPrimitives"
                            )))),
                            () -> assertThat(thrown.getCause(), is(nullValue()))
                    );
                    assertAll("Verify transform mock wasn't called",
                            () -> verify(transform, never())
                                    .perform(any(), anyMap(), anyString())
                    );
                }),

                dynamicTest("a2Path[1].anything with " + INPUT_TYPE, () -> {
                    final String key = "a2Path[1].anything";

                    final Transformation transform = mock(Transformation.class);

                    final Executable testMethod = () -> classUnderTest.transform(key, inputSource.get(), transform);

                    final IllegalPathOperationException thrown = assertThrows(IllegalPathOperationException.class, testMethod);
                    assertAll("Checking Exception",
                            () -> assertThat(thrown.getMessage(), is(equalTo(String.format(
                                    "Unable to convert object to array, at path '%s'.",
                                    "a2Path"
                            )))),
                            () -> assertThat(thrown.getCause(), is(nullValue()))
                    );
                    assertAll("Verify transform mock wasn't called",
                            () -> verify(transform, never())
                                    .perform(any(), anyMap(), anyString())
                    );
                }),

                dynamicTest("a2Primitive.anything with " + INPUT_TYPE, () -> {
                    final String key = "a2Primitive.anything";

                    final Transformation transform = mock(Transformation.class);

                    final Executable testMethod = () -> classUnderTest.transform(key, inputSource.get(), transform);

                    final IllegalPathOperationException thrown = assertThrows(IllegalPathOperationException.class, testMethod);
                    assertAll("Checking Exception",
                            () -> assertThat(thrown.getMessage(), is(equalTo(String.format(
                                    "Unable to convert primative to object, at path '%s'.",
                                    "a2Primitive"
                            )))),
                            () -> assertThat(thrown.getCause(), is(nullValue()))
                    );
                    assertAll("Verify transform mock wasn't called",
                            () -> verify(transform, never())
                                    .perform(any(), anyMap(), anyString())
                    );
                }),

                dynamicTest("a2Primitive[1].anything with " + INPUT_TYPE, () -> {
                    final String key = "a2Primitive[1].anything";

                    final Transformation transform = mock(Transformation.class);

                    final Executable testMethod = () -> classUnderTest.transform(key, inputSource.get(), transform);

                    final IllegalPathOperationException thrown = assertThrows(IllegalPathOperationException.class, testMethod);
                    assertAll("Checking Exception",
                            () -> assertThat(thrown.getMessage(), is(equalTo(String.format(
                                    "Unable to convert primative to array, at path '%s'.",
                                    "a2Primitive"
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
