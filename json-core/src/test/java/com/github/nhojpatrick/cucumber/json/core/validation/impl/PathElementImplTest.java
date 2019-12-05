package com.github.nhojpatrick.cucumber.json.core.validation.impl;

import com.github.nhojpatrick.cucumber.core.exceptions.EmptyKeyException;
import com.github.nhojpatrick.cucumber.json.core.transform.Transformation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.api.parallel.Execution;

import static com.github.nhojpatrick.hamcrest.lang.IsHashCode.hashCodeGenerated;
import static com.github.nhojpatrick.hamcrest.lang.IsToString.toStringGenerated;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNot.not;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PathElementImplTest {


    @Nested
    @DisplayName("Basic")
    class basic {

        private PathElementImpl classUnderTest;
        private PathElementImpl differentInstance;

        @BeforeEach
        public void beforeEach() {
            this.classUnderTest = new PathElementImpl("key");
            this.differentInstance = new PathElementImpl("another");
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
                    () -> assertThat("should match", this.classUnderTest, is(toStringGenerated("PathElementImpl[key]"))),
                    () -> assertThat("should not match", this.classUnderTest, is(not(toStringGenerated(this.differentInstance.toString())))),
                    () -> assertThat("should not match", this.classUnderTest, is(not(toStringGenerated("")))),
                    () -> assertThat("should not match", this.classUnderTest, is(not(toStringGenerated(new Object().toString())))),
                    () -> assertThat("should not match", this.classUnderTest, is(not(toStringGenerated("String"))))
            );
        }

    }

    @Nested
    @DisplayName("AbstractPathElement")
    class abstractPathElement {

        private PathElementImpl classUnderTest;

        @BeforeEach
        public void beforeEach() {
            this.classUnderTest = new PathElementImpl("key");
        }

        @Test
        public void getArrayIndexTest() {

            final Executable testMethod = () -> {
                this.classUnderTest.getArrayIndex();
            };
            final NullPointerException expectedThrown = assertThrows(NullPointerException.class, testMethod);
            assertAll("Checking Exception",
                    () -> assertThat(expectedThrown.getMessage(), is(nullValue())),
                    () -> assertThat(expectedThrown.getCause(), is(nullValue()))
            );
        }

        @Test
        public void getElementTest() {

            assertThat("should match", this.classUnderTest.getElement(), is(equalTo("key")));
        }

        @Test
        public void getElementRawTest() {

            assertThat("should match", this.classUnderTest.getElementRaw(), is(equalTo("key")));
        }

        @Test
        public void isArrayElementTest() {

            assertThat("should match", this.classUnderTest.isArrayElement(), is(equalTo(false)));
        }

    }

}
