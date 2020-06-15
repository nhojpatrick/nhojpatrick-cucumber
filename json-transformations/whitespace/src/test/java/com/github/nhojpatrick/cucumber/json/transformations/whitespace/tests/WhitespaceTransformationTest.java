package com.github.nhojpatrick.cucumber.json.transformations.whitespace.tests;

import com.github.nhojpatrick.cucumber.json.core.exceptions.NullPathElementException;
import com.github.nhojpatrick.cucumber.json.core.transform.Transformation;
import com.github.nhojpatrick.cucumber.json.transformations.whitespace.WhitespaceTransformation;
import com.github.nhojpatrick.cucumber.json.transformations.whitespace.exceptions.WhitespacePrefixException;
import com.github.nhojpatrick.cucumber.json.transformations.whitespace.exceptions.WhitespaceSuffixException;
import com.github.nhojpatrick.cucumber.json.transformations.whitespace.exceptions.WhitespaceTransformationArgumentException;
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

public class WhitespaceTransformationTest {

    @Nested
    @DisplayName("Basic")
    class basic {

        private Transformation classUnderTest;
        private Transformation differentInstance;

        @BeforeEach
        public void beforeEach()
                throws WhitespaceTransformationArgumentException {

            this.classUnderTest = new WhitespaceTransformation(1, 2);
            this.differentInstance = new WhitespaceTransformation(2, 1);
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
                    () -> assertThat("should match", this.classUnderTest, is(toStringGenerated("WhitespaceTransformation[1,2]"))),
                    () -> assertThat("should not match", this.classUnderTest, is(not(toStringGenerated(this.differentInstance.toString())))),
                    () -> assertThat("should not match", this.classUnderTest, is(not(toStringGenerated("")))),
                    () -> assertThat("should not match", this.classUnderTest, is(not(toStringGenerated(new Object().toString())))),
                    () -> assertThat("should not match", this.classUnderTest, is(not(toStringGenerated("String"))))
            );
        }

    }

    @TestFactory
    public Collection<DynamicTest> constructor() {

        return Arrays.asList(

                dynamicTest("negative prefix", () -> {
                    final Executable testMethod = () -> {
                        new WhitespaceTransformation(-1, 0);
                    };
                    final WhitespacePrefixException thrown = assertThrows(WhitespacePrefixException.class, testMethod);
                    assertAll("Checking Exception",
                            () -> assertThat(thrown.getMessage(), is(equalTo("Whitespace prefix must be positive but was -1."))),
                            () -> assertThat(thrown.getCause(), is(nullValue()))
                    );
                }),

                dynamicTest("negative suffix", () -> {
                    final Executable testMethod = () -> {
                        new WhitespaceTransformation(0, -1);
                    };
                    final WhitespaceSuffixException thrown = assertThrows(WhitespaceSuffixException.class, testMethod);
                    assertAll("Checking Exception",
                            () -> assertThat(thrown.getMessage(), is(equalTo("Whitespace suffix must be positive but was -1."))),
                            () -> assertThat(thrown.getCause(), is(nullValue()))
                    );
                })

        );
    }

    @Test
    public void isParentPathAutoCreatedTest()
            throws WhitespaceTransformationArgumentException {

        final Transformation classUnderTest = new WhitespaceTransformation(0, 0);
        assertThat("Unexpected Parent Path Auto Creation", classUnderTest.isParentPathAutoCreated(), is(equalTo(false)));
    }

    @TestFactory
    public Collection<DynamicTest> perform() {

        return Arrays.asList(

                dynamicTest("null path", () -> {
                    final Transformation classUnderTest = new WhitespaceTransformation(0, 0);
                    final Executable testMethod = () -> classUnderTest.perform(null, null, null);
                    final NullPathElementException thrown = assertThrows(NullPathElementException.class, testMethod);
                    assertAll("Checking Exception",
                            () -> assertThat(thrown.getMessage(), is(equalTo("Null Path Element."))),
                            () -> assertThat(thrown.getCause(), is(nullValue()))
                    );
                })

        );
    }

    @TestFactory
    public Collection<DynamicTest> successPad() {

        return Arrays.asList(

                dynamicTest("null pad(1, 2)", () -> {

                    final WhitespaceTransformation classUnderTest = new WhitespaceTransformation(0, 0);

                    final String expected = "   ";

                    final String actual = classUnderTest.pad(null, 1, 2);

                    assertThat(actual, is(equalTo(expected)));
                }),

                dynamicTest("\"\" pad(1, 2)", () -> {

                    final WhitespaceTransformation classUnderTest = new WhitespaceTransformation(0, 0);

                    final String expected = "   ";

                    final String actual = classUnderTest.pad("", 1, 2);

                    assertThat(actual, is(equalTo(expected)));
                }),

                dynamicTest("\" \" pad(1, 2)", () -> {

                    final WhitespaceTransformation classUnderTest = new WhitespaceTransformation(0, 0);

                    final String expected = "    ";

                    final String actual = classUnderTest.pad(" ", 1, 2);

                    assertThat(actual, is(equalTo(expected)));
                }),

                dynamicTest("\"a\" pad(1, 2)", () -> {

                    final WhitespaceTransformation classUnderTest = new WhitespaceTransformation(0, 0);

                    final String expected = " a  ";

                    final String actual = classUnderTest.pad("a", 1, 2);

                    assertThat(actual, is(equalTo(expected)));
                }),

                dynamicTest("\" a \" pad(1, 2)", () -> {

                    final WhitespaceTransformation classUnderTest = new WhitespaceTransformation(0, 0);

                    final String expected = "  a   ";

                    final String actual = classUnderTest.pad(" a ", 1, 2);

                    assertThat(actual, is(equalTo(expected)));
                })

        );
    }

}
