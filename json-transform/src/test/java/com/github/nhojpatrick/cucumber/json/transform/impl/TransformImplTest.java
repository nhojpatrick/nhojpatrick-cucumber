package com.github.nhojpatrick.cucumber.json.transform.impl;

import com.github.nhojpatrick.cucumber.json.core.exceptions.InvalidPathException;
import com.github.nhojpatrick.cucumber.json.core.exceptions.NullPathElementException;
import com.github.nhojpatrick.cucumber.json.core.transform.Transformation;
import com.github.nhojpatrick.cucumber.json.core.validation.impl.PathAttributeElementImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.function.Executable;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;
import static org.mockito.Mockito.mock;

@DisplayName("Transform Impl Tests")
public class TransformImplTest {

    @TestFactory
    @DisplayName("Validation Input")
    public Collection<DynamicTest> validation() {

        final TransformImpl classUnderTest = new TransformImpl();

        return Arrays.asList(

                dynamicTest("null key", () -> {
                    final Transformation transform = mock(Transformation.class);

                    final Executable testMethod = () -> classUnderTest.transform(null, null, transform);
                    final InvalidPathException thrown = assertThrows(InvalidPathException.class, testMethod);
                    assertAll("Checking Exception",
                            () -> assertThat(thrown.getMessage(), is(equalTo("Path is Null."))),
                            () -> assertThat(thrown.getCause(), is(nullValue()))
                    );
                })

        );
    }

    @TestFactory
    @DisplayName("getPath")
    public Collection<DynamicTest> getPath() {

        final TransformImpl classUnderTest = new TransformImpl();

        return Arrays.asList(

                dynamicTest("null CurrentPath, null PathElement", () -> {
                    final Executable testMethod = () -> classUnderTest.getPath(null, null);

                    final NullPathElementException thrown = assertThrows(NullPathElementException.class, testMethod);
                    assertAll("Checking Exception",
                            () -> assertThat(thrown.getMessage(), is(equalTo("Null Path Element."))),
                            () -> assertThat(thrown.getCause(), is(nullValue()))
                    );
                }),

                dynamicTest("null CurrentPath, Valid PathElement", () -> {
                    final String path = classUnderTest.getPath(null, new PathAttributeElementImpl("aPath"));

                    assertThat("Unexpected Path", path, is(equalTo("aPath")));
                }),

                dynamicTest("empty CurrentPath, null PathElement", () -> {
                    final Executable testMethod = () -> classUnderTest.getPath("", null);

                    final NullPathElementException thrown = assertThrows(NullPathElementException.class, testMethod);
                    assertAll("Checking Exception",
                            () -> assertThat(thrown.getMessage(), is(equalTo("Null Path Element."))),
                            () -> assertThat(thrown.getCause(), is(nullValue()))
                    );
                }),

                dynamicTest("empty CurrentPath, Valid PathElement", () -> {
                    final String path = classUnderTest.getPath("", new PathAttributeElementImpl("aPath"));

                    assertThat("Unexpected Path", path, is(equalTo("aPath")));
                }),

                dynamicTest("Valid CurrentPath, null PathElement", () -> {
                    final Executable testMethod = () -> classUnderTest.getPath("parentPath", null);

                    final NullPathElementException thrown = assertThrows(NullPathElementException.class, testMethod);
                    assertAll("Checking Exception",
                            () -> assertThat(thrown.getMessage(), is(equalTo("Null Path Element."))),
                            () -> assertThat(thrown.getCause(), is(nullValue()))
                    );
                }),

                dynamicTest("Valid CurrentPath, Valid PathElement", () -> {
                    final String path = classUnderTest.getPath("parentPath", new PathAttributeElementImpl("aPath"));

                    assertThat("Unexpected Path", path, is(equalTo("parentPath.aPath")));
                })

        );
    }

}
