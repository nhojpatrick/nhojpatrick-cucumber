package com.github.nhojpatrick.cucumber.json.transform.transformations.set;

import com.github.nhojpatrick.cucumber.json.core.exceptions.NullPathElementException;
import com.github.nhojpatrick.cucumber.json.transform.transformations.set.SetTransformation;
import com.github.nhojpatrick.cucumber.json.core.validation.impl.PathElementImpl;
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

public class SetTransformationTest {

    @Nested
    @DisplayName("Basic")
    class basic {

        private SetTransformation classUnderTest;
        private SetTransformation differentInstance;

        @BeforeEach
        public void beforeEach() {
            this.classUnderTest = new SetTransformation("Value");
            this.differentInstance = new SetTransformation("AnotherValue");
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
                    () -> assertThat("should match", this.classUnderTest, is(toStringGenerated("SetTransformation[Value]"))),
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

                DynamicTest.dynamicTest("null input - null key", () -> {
                    final SetTransformation classUnderTest = new SetTransformation(null);
                    final Executable testMethod = () -> classUnderTest.perform(null, null);
                    final NullPathElementException expectedThrown = assertThrows(NullPathElementException.class, testMethod);
                    assertThat(expectedThrown.getMessage(), is(equalTo("Null Path Element.")));
                }),

                DynamicTest.dynamicTest("empty input - null key", () -> {
                    final SetTransformation classUnderTest = new SetTransformation(null);
                    final Executable testMethod = () -> classUnderTest.perform(new HashMap<>(), null);
                    final NullPathElementException expectedThrown = assertThrows(NullPathElementException.class, testMethod);
                    assertThat(expectedThrown.getMessage(), is(equalTo("Null Path Element.")));
                })

        );
    }

    @TestFactory
    public Collection<DynamicTest> success() {

        return Arrays.asList(

                DynamicTest.dynamicTest("null input - key", () -> {

                    final SetTransformation classUnderTest = new SetTransformation("newValue");

                    final Map<String, Object> expected = new HashMap<>();
                    expected.put("key", "newValue");

                    final Map<String, Object> actual = classUnderTest.perform(null, new PathElementImpl("key"));

                    assertThat(actual, is(equalTo(expected)));
                }),

                DynamicTest.dynamicTest("empty input - key", () -> {

                    final SetTransformation classUnderTest = new SetTransformation("newValue");

                    final Map<String, Object> input = new HashMap<>();

                    final Map<String, Object> expected = new HashMap<>();
                    expected.put("key", "newValue");

                    final Map<String, Object> actual = classUnderTest.perform(input, new PathElementImpl("key"));

                    assertThat(actual, is(equalTo(expected)));
                }),

                DynamicTest.dynamicTest("input key->null - matching key", () -> {

                    final SetTransformation classUnderTest = new SetTransformation("newValue");

                    final Map<String, Object> input = new HashMap<>();
                    input.put("key", null);

                    final Map<String, Object> expected = new HashMap<>();
                    expected.put("key", "newValue");

                    final Map<String, Object> actual = classUnderTest.perform(input, new PathElementImpl("key"));

                    assertThat(actual, is(equalTo(expected)));
                }),

                DynamicTest.dynamicTest("input key->\"value\" - matching key", () -> {

                    final SetTransformation classUnderTest = new SetTransformation("newValue");

                    final Map<String, Object> input = new HashMap<>();
                    input.put("key", "oldValue");

                    final Map<String, Object> expected = new HashMap<>();
                    expected.put("key", "newValue");

                    final Map<String, Object> actual = classUnderTest.perform(input, new PathElementImpl("key"));

                    assertThat(actual, is(equalTo(expected)));
                })

        );
    }

}
