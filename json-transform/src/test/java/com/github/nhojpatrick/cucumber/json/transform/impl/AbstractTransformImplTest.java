package com.github.nhojpatrick.cucumber.json.transform.impl;

import com.github.nhojpatrick.cucumber.core.exceptions.IllegalKeyException;
import com.github.nhojpatrick.cucumber.json.core.exceptions.IllegalPathOperationException;
import com.github.nhojpatrick.cucumber.json.core.transform.Transformation;
import com.github.nhojpatrick.cucumber.json.core.validation.PathElement;
import org.junit.jupiter.api.function.Executable;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Supplier;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyMap;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public abstract class AbstractTransformImplTest {

    public static Transformation getMockTransformation(final boolean isParentPathAutoCreated) {

        final Transformation transform = mock(Transformation.class);

        when(transform.isParentPathAutoCreated())
                .thenReturn(isParentPathAutoCreated);

        final Map<String, Object> transformOutput = new LinkedHashMap<>();
        transformOutput.put("transform", "output");

        return transform;
    }

    public static Transformation getMockTransformation(final boolean isParentPathAutoCreated,
                                                       final PathElement pathElement,
                                                       final String currentPath)
            throws IllegalKeyException,
            IllegalPathOperationException {

        final Transformation transform = mock(Transformation.class);

        when(transform.isParentPathAutoCreated())
                .thenReturn(isParentPathAutoCreated);

        final Map<String, Object> transformOutput = new LinkedHashMap<>();
        transformOutput.put("transform", "output");

        when(transform.perform(eq(pathElement), anyMap(), eq(currentPath)))
                .thenReturn(transformOutput);

        return transform;
    }

    public static void verifyExceptionThrown(final Supplier<Map> inputSource,
                                             final TransformImpl classUnderTest,
                                             final Transformation transform,
                                             final String key,
                                             final String thrownMessage) {

        final Executable testMethod = () -> classUnderTest.transform(key, inputSource.get(), transform);

        final IllegalPathOperationException thrown = assertThrows(IllegalPathOperationException.class, testMethod);
        assertAll("Checking Exception",
                () -> assertThat(thrown.getMessage(), is(equalTo(thrownMessage))),
                () -> assertThat(thrown.getCause(), is(nullValue()))
        );
        assertAll("Verify transform mock wasn't called",
                () -> verify(transform, never())
                        .perform(any(), anyMap(), anyString())
        );
    }

}
