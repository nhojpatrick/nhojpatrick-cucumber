package com.github.nhojpatrick.cucumber.json.core.validation.impl;

import com.github.nhojpatrick.cucumber.json.core.transform.Transformation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static com.github.nhojpatrick.hamcrest.lang.IsHashCode.hashCodeGenerated;
import static com.github.nhojpatrick.hamcrest.lang.IsToString.toStringGenerated;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNot.not;
import static org.junit.jupiter.api.Assertions.assertAll;

public class PathArrayElementImplTest {


    @Nested
    @DisplayName("Basic")
    class basic {

        private PathArrayElementImpl classUnderTest;
        private PathArrayElementImpl differentInstance;

        @BeforeEach
        public void beforeEach() {
            this.classUnderTest = new PathArrayElementImpl("key[2]", "key", 2);
            this.differentInstance = new PathArrayElementImpl("another[3]", "another", 3);
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
                    () -> assertThat("should match", this.classUnderTest, is(toStringGenerated("PathArrayElementImpl[key,2]"))),
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

        private PathArrayElementImpl classUnderTest;

        @BeforeEach
        public void beforeEach() {
            this.classUnderTest = new PathArrayElementImpl("key[2]", "key", 2);
        }

        @Test
        public void getArrayIndexTest() {

            assertThat("should match", this.classUnderTest.getArrayIndex(), is(equalTo(2)));
        }

        @Test
        public void getElementTest() {

            assertThat("should match", this.classUnderTest.getElement(), is(equalTo("key")));
        }

        @Test
        public void getElementRawTest() {

            assertThat("should match", this.classUnderTest.getElementRaw(), is(equalTo("key[2]")));
        }

        @Test
        public void isArrayElementTest() {

            assertThat("should match", this.classUnderTest.isArrayElement(), is(equalTo(true)));
        }

    }

}
