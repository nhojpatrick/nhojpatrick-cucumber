package com.github.nhojpatrick.cucumber.json.transform.transformations.whitespace;

import com.github.nhojpatrick.cucumber.json.core.exceptions.NullPathElementException;
import com.github.nhojpatrick.cucumber.json.core.validation.impl.PathElementImpl;
import com.github.nhojpatrick.cucumber.json.transform.transformations.whitespace.exceptions.WhitespacePrefixException;
import com.github.nhojpatrick.cucumber.json.transform.transformations.whitespace.exceptions.WhitespaceSuffixException;
import com.github.nhojpatrick.cucumber.json.transform.transformations.whitespace.exceptions.WhitespaceTransformationArgumentException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.function.Executable;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import static com.github.nhojpatrick.hamcrest.lang.IsHashCode.hashCodeGenerated;
import static com.github.nhojpatrick.hamcrest.lang.IsToString.toStringGenerated;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNot.not;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class WhitespaceTransformationTest {

    @Nested
    @DisplayName("Basic")
    class basic {

        private WhitespaceTransformation classUnderTest;
        private WhitespaceTransformation differentInstance;

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
    public Collection<DynamicTest> exceptions() {

        return Arrays.asList(

                DynamicTest.dynamicTest("negative prefix", () -> {
                    final Executable testMethod = () -> {
                        new WhitespaceTransformation(-1, 0);
                    };
                    final WhitespacePrefixException expectedThrown = assertThrows(WhitespacePrefixException.class, testMethod);
                    assertThat(expectedThrown.getMessage(), is(equalTo("Whitespace prefix must be positive but was -1.")));
                }),

                DynamicTest.dynamicTest("negative suffix", () -> {
                    final Executable testMethod = () -> {
                        new WhitespaceTransformation(0, -1);
                    };
                    final WhitespaceSuffixException expectedThrown = assertThrows(WhitespaceSuffixException.class, testMethod);
                    assertThat(expectedThrown.getMessage(), is(equalTo("Whitespace suffix must be positive but was -1.")));
                }),

                DynamicTest.dynamicTest("null key", () -> {
                    final WhitespaceTransformation classUnderTest = new WhitespaceTransformation(0, 0);
                    final Executable testMethod = () -> classUnderTest.perform(null, null);
                    final NullPathElementException expectedThrown = assertThrows(NullPathElementException.class, testMethod);
                    assertThat(expectedThrown.getMessage(), is(equalTo("Null Path Element.")));
                })

        );
    }

    @TestFactory
    public Collection<DynamicTest> success_pad() {

        return Arrays.asList(

                DynamicTest.dynamicTest("null pad(1, 2)", () -> {

                    final WhitespaceTransformation classUnderTest = new WhitespaceTransformation(0, 0);

                    final String expected = "   ";

                    final String actual = classUnderTest.pad(null, 1, 2);

                    assertThat(actual, is(equalTo(expected)));
                }),

                DynamicTest.dynamicTest("\"\" pad(1, 2)", () -> {

                    final WhitespaceTransformation classUnderTest = new WhitespaceTransformation(0, 0);

                    final String expected = "   ";

                    final String actual = classUnderTest.pad("", 1, 2);

                    assertThat(actual, is(equalTo(expected)));
                }),

                DynamicTest.dynamicTest("\" \" pad(1, 2)", () -> {

                    final WhitespaceTransformation classUnderTest = new WhitespaceTransformation(0, 0);

                    final String expected = "    ";

                    final String actual = classUnderTest.pad(" ", 1, 2);

                    assertThat(actual, is(equalTo(expected)));
                }),

                DynamicTest.dynamicTest("\"a\" pad(1, 2)", () -> {

                    final WhitespaceTransformation classUnderTest = new WhitespaceTransformation(0, 0);

                    final String expected = " a  ";

                    final String actual = classUnderTest.pad("a", 1, 2);

                    assertThat(actual, is(equalTo(expected)));
                }),

                DynamicTest.dynamicTest("\" a \" pad(1, 2)", () -> {

                    final WhitespaceTransformation classUnderTest = new WhitespaceTransformation(0, 0);

                    final String expected = "  a   ";

                    final String actual = classUnderTest.pad(" a ", 1, 2);

                    assertThat(actual, is(equalTo(expected)));
                })

        );
    }

    @TestFactory
    public Collection<DynamicTest> success_perform() {

        return Arrays.asList(

                DynamicTest.dynamicTest("null input", () -> {

                    final WhitespaceTransformation classUnderTest = new WhitespaceTransformation(0, 0);

                    final Map<String, Object> expected = new HashMap<>();
                    expected.put("key", "");

                    final Map<String, Object> actual = classUnderTest.perform(null, new PathElementImpl("key"));

                    assertThat(actual, is(equalTo(expected)));
                }),

                DynamicTest.dynamicTest("empty input", () -> {

                    final WhitespaceTransformation classUnderTest = new WhitespaceTransformation(0, 0);

                    final Map<String, Object> input = new HashMap<>();

                    final Map<String, Object> expected = new HashMap<>();
                    expected.put("key", "");

                    final Map<String, Object> actual = classUnderTest.perform(input, new PathElementImpl("key"));

                    assertThat(actual, is(equalTo(expected)));
                }),

                DynamicTest.dynamicTest("input key->null - matching key", () -> {

                    final WhitespaceTransformation classUnderTest = new WhitespaceTransformation(2, 2);

                    final Map<String, Object> input = new HashMap<>();
                    input.put("key", null);

                    final Map<String, Object> expected = new HashMap<>();
                    expected.put("key", "    ");

                    final Map<String, Object> actual = classUnderTest.perform(input, new PathElementImpl("key"));

                    assertThat(actual, is(equalTo(expected)));
                }),

                DynamicTest.dynamicTest("input key->1 - matching key", () -> {

                    final WhitespaceTransformation classUnderTest = new WhitespaceTransformation(3, 3);

                    final Map<String, Object> input = new HashMap<>();
                    input.put("key", 1);

                    final Map<String, Object> expected = new HashMap<>();
                    expected.put("key", "   1   ");

                    final Map<String, Object> actual = classUnderTest.perform(input, new PathElementImpl("key"));

                    assertThat(actual, is(equalTo(expected)));
                }),

                DynamicTest.dynamicTest("input key->true - matching key", () -> {

                    final WhitespaceTransformation classUnderTest = new WhitespaceTransformation(3, 3);

                    final Map<String, Object> input = new HashMap<>();
                    input.put("key", true);

                    final Map<String, Object> expected = new HashMap<>();
                    expected.put("key", "   true   ");

                    final Map<String, Object> actual = classUnderTest.perform(input, new PathElementImpl("key"));

                    assertThat(actual, is(equalTo(expected)));
                }),

                DynamicTest.dynamicTest("input key->\"value\" - matching key - prefix 0, suffix 0", () -> {

                    final WhitespaceTransformation classUnderTest = new WhitespaceTransformation(0, 0);

                    final Map<String, Object> input = new HashMap<>();
                    input.put("key", "value");

                    final Map<String, Object> expected = new HashMap<>();
                    expected.put("key", "value");

                    final Map<String, Object> actual = classUnderTest.perform(input, new PathElementImpl("key"));

                    assertThat(actual, is(equalTo(expected)));
                }),

                DynamicTest.dynamicTest("input key->\"value\" - matching key - prefix 0, suffix 1", () -> {

                    final WhitespaceTransformation classUnderTest = new WhitespaceTransformation(0, 1);

                    final Map<String, Object> input = new HashMap<>();
                    input.put("key", "value");

                    final Map<String, Object> expected = new HashMap<>();
                    expected.put("key", "value ");

                    final Map<String, Object> actual = classUnderTest.perform(input, new PathElementImpl("key"));

                    assertThat(actual, is(equalTo(expected)));
                }),

                DynamicTest.dynamicTest("input key->\"value\" - matching key - prefix 1, suffix 0", () -> {

                    final WhitespaceTransformation classUnderTest = new WhitespaceTransformation(1, 0);

                    final Map<String, Object> input = new HashMap<>();
                    input.put("key", "value");

                    final Map<String, Object> expected = new HashMap<>();
                    expected.put("key", " value");

                    final Map<String, Object> actual = classUnderTest.perform(input, new PathElementImpl("key"));

                    assertThat(actual, is(equalTo(expected)));
                }),

                DynamicTest.dynamicTest("input key->\"value\" - matching key - prefix 1, suffix 1", () -> {

                    final WhitespaceTransformation classUnderTest = new WhitespaceTransformation(1, 1);

                    final Map<String, Object> input = new HashMap<>();
                    input.put("key", "value");

                    final Map<String, Object> expected = new HashMap<>();
                    expected.put("key", " value ");

                    final Map<String, Object> actual = classUnderTest.perform(input, new PathElementImpl("key"));

                    assertThat(actual, is(equalTo(expected)));
                })

        );
    }

}
