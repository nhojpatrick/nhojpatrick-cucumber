package com.github.nhojpatrick.cucumber.json.core.validation.impl.tests;

import com.github.nhojpatrick.cucumber.json.core.validation.impl.PathAttributeElementImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.function.Executable;

import java.util.Arrays;
import java.util.Collection;

import static com.github.nhojpatrick.hamcrest.lang.IsHashCode.hashCodeGenerated;
import static com.github.nhojpatrick.hamcrest.lang.IsToString.toStringGenerated;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNot.not;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

public class PathAttributeElementImplTest {

    @Nested
    @DisplayName("Basic")
    class basic {

        private PathAttributeElementImpl classUnderTest;
        private PathAttributeElementImpl differentInstance;

        @BeforeEach
        public void beforeEach() {
            this.classUnderTest = new PathAttributeElementImpl("key");
            this.differentInstance = new PathAttributeElementImpl("another");
        }

        @Test
        public void equalsTest() {

            assertAll("equals",
                    () -> assertThat("should match", this.classUnderTest, is(equalTo(this.classUnderTest))),
                    () -> assertThat("should not match", this.classUnderTest, is(not(equalTo(this.differentInstance)))),
                    () -> assertThat("should not match", this.classUnderTest, is(not(equalTo(null)))),
                    () -> assertThat("should not match", this.classUnderTest, is(not(equalTo(new Object())))),
                    () -> assertThat("should not match", this.classUnderTest, is(not(equalTo("String"))))
            );
        }

        @Test
        public void hashCodeTest() {

            assertAll("hashCode",
                    () -> assertThat("should match", this.classUnderTest, is(hashCodeGenerated(this.classUnderTest.hashCode()))),
                    () -> assertThat("should not match", this.classUnderTest, is(not(hashCodeGenerated(this.differentInstance.hashCode())))),
                    () -> assertThat("should not match", this.classUnderTest, is(not(hashCodeGenerated(0)))),
                    () -> assertThat("should not match", this.classUnderTest, is(not(hashCodeGenerated(new Object().hashCode())))),
                    () -> assertThat("should not match", this.classUnderTest, is(not(hashCodeGenerated("String".hashCode()))))
            );
        }

        @Test
        public void toStringTest() {

            assertAll("toString",
                    () -> assertThat("should match", this.classUnderTest, is(toStringGenerated("PathAttributeElementImpl[key]"))),
                    () -> assertThat("should not match", this.classUnderTest, is(not(toStringGenerated(this.differentInstance.toString())))),
                    () -> assertThat("should not match", this.classUnderTest, is(not(toStringGenerated("")))),
                    () -> assertThat("should not match", this.classUnderTest, is(not(toStringGenerated(new Object().toString())))),
                    () -> assertThat("should not match", this.classUnderTest, is(not(toStringGenerated("String"))))
            );
        }

    }

    @TestFactory
    @DisplayName("PathAttributeElement tests")
    public Collection<DynamicTest> tests() {

        final PathAttributeElementImpl classUnderTest = new PathAttributeElementImpl("abc");

        return Arrays.asList(

                dynamicTest("getElement", () -> {
                    assertThat("should match", classUnderTest.getElement(), is(equalTo("abc")));
                }),

                dynamicTest("getElementRaw", () -> {
                    assertThat("should match", classUnderTest.getElementRaw(), is(equalTo("abc")));
                }),

                dynamicTest("getPath(null)", () -> {
                    assertThat("should match", classUnderTest.getPath(null), is(equalTo("abc")));
                }),

                dynamicTest("getPath(\"\")", () -> {
                    assertThat("should match", classUnderTest.getPath(""), is(equalTo("abc")));
                }),

                dynamicTest("getPath(\"qwerty\")", () -> {
                    assertThat("should match", classUnderTest.getPath("qwerty"), is(equalTo("qwerty.abc")));
                }),

                dynamicTest("getPath(null, false)", () -> {
                    assertThat("should match", classUnderTest.getPath(null, false), is(equalTo("abc")));
                }),

                dynamicTest("getPath(\"\", false)", () -> {
                    assertThat("should match", classUnderTest.getPath("", false), is(equalTo("abc")));
                }),

                dynamicTest("getPath(\"qwerty\", false)", () -> {
                    assertThat("should match", classUnderTest.getPath("qwerty", false), is(equalTo("qwerty.abc")));
                }),

                dynamicTest("getPath(null, true)", () -> {
                    assertThat("should match", classUnderTest.getPath(null, true), is(equalTo("abc")));
                }),

                dynamicTest("getPath(\"\", true)", () -> {
                    assertThat("should match", classUnderTest.getPath("", true), is(equalTo("abc")));
                }),

                dynamicTest("getPath(\"qwerty\", true)", () -> {
                    assertThat("should match", classUnderTest.getPath("qwerty", true), is(equalTo("qwerty.abc")));
                }),

                dynamicTest("getArrayIndex", () -> {
                    final Executable testMethod = () -> {
                        classUnderTest.getArrayIndex();
                    };
                    final NullPointerException thrown = assertThrows(NullPointerException.class, testMethod);
                    assertAll("Checking Exception",
                            () -> assertThat(thrown.getMessage(), is(nullValue())),
                            () -> assertThat(thrown.getCause(), is(nullValue()))
                    );
                }),

                dynamicTest("isArray", () -> {
                    assertThat("should match", classUnderTest.isArray(), is(equalTo(false)));
                }),

                dynamicTest("isAttribute", () -> {
                    assertThat("should match", classUnderTest.isAttribute(), is(equalTo(true)));
                })

        );
    }

}
