package com.github.nhojpatrick.cucumber.json.transformations.reverse;

import com.github.nhojpatrick.cucumber.json.core.exceptions.IllegalPathOperationException;
import com.github.nhojpatrick.cucumber.json.core.exceptions.NullPathElementException;
import com.github.nhojpatrick.cucumber.json.core.transform.Transformation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.function.Executable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;

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

public class ReverseTransformationTest {

    @Nested
    @DisplayName("Basic")
    class basic {

        private Transformation classUnderTest;
        private Transformation differentInstance;

        @BeforeEach
        public void beforeEach() {

            this.classUnderTest = new ReverseTransformation();
            this.differentInstance = new ReverseTransformation();
        }

        @Test
        public void equalsTest() {

            assertAll("equals",
                    () -> assertThat("should match", this.classUnderTest, is(equalTo(this.classUnderTest))),
                    () -> assertThat("should match", this.classUnderTest, is(equalTo(this.differentInstance))),
                    () -> assertThat("should not match", this.classUnderTest, is(not(equalTo(null)))),
                    () -> assertThat("should not match", this.classUnderTest, is(not(equalTo(new Object())))),
                    () -> assertThat("should not match", this.classUnderTest, is(not(equalTo("String"))))
            );
        }

        @Test
        public void hashCodeTest() {

            assertAll("hashCode",
                    () -> assertThat("should match", this.classUnderTest, is(hashCodeGenerated(this.classUnderTest.hashCode()))),
                    () -> assertThat("should match", this.classUnderTest, is(hashCodeGenerated(this.differentInstance.hashCode()))),
                    () -> assertThat("should not match", this.classUnderTest, is(not(hashCodeGenerated(0)))),
                    () -> assertThat("should not match", this.classUnderTest, is(not(hashCodeGenerated(new Object().hashCode())))),
                    () -> assertThat("should not match", this.classUnderTest, is(not(hashCodeGenerated("String".hashCode()))))
            );
        }

        @Test
        public void toStringTest() {

            assertAll("toString",
                    () -> assertThat("should match", this.classUnderTest, is(toStringGenerated("ReverseTransformation[]"))),
                    () -> assertThat("should match", this.classUnderTest, is(toStringGenerated(this.differentInstance.toString()))),
                    () -> assertThat("should not match", this.classUnderTest, is(not(toStringGenerated("")))),
                    () -> assertThat("should not match", this.classUnderTest, is(not(toStringGenerated(new Object().toString())))),
                    () -> assertThat("should not match", this.classUnderTest, is(not(toStringGenerated("String"))))
            );
        }

    }

    @Test
    public void isParentPathAutoCreatedTest() {

        final Transformation classUnderTest = new ReverseTransformation();
        assertThat("Unexpected Parent Path Auto Creation", classUnderTest.isParentPathAutoCreated(), is(equalTo(true)));
    }

    @TestFactory
    public Collection<DynamicTest> exceptions() {

        return Arrays.asList(

                dynamicTest("null path", () -> {
                    final Transformation classUnderTest = new ReverseTransformation();
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
    public Collection<DynamicTest> reverse() {

        return Arrays.asList(

                dynamicTest("null reverse()", () -> {

                    final ReverseTransformation classUnderTest = new ReverseTransformation();

                    final String expected = null;

                    final String actual = classUnderTest.reverse(null, null);

                    assertThat(actual, is(equalTo(expected)));
                }),

                dynamicTest("List reverse()", () -> {
                    final Executable testMethod = () -> new ReverseTransformation()
                            .reverse("aPath", new ArrayList<>());
                    final IllegalPathOperationException thrown = assertThrows(IllegalPathOperationException.class, testMethod);
                    assertAll("Checking Exception",
                            () -> assertThat(thrown.getMessage(), is(equalTo("Unable to reverse JsonArray<>, at path 'aPath'."))),
                            () -> assertThat(thrown.getCause(), is(nullValue()))
                    );
                }),

                dynamicTest("Map reverse()", () -> {
                    final Executable testMethod = () -> new ReverseTransformation()
                            .reverse("aPath", new HashMap<>());
                    final IllegalPathOperationException thrown = assertThrows(IllegalPathOperationException.class, testMethod);
                    assertAll("Checking Exception",
                            () -> assertThat(thrown.getMessage(), is(equalTo("Unable to reverse JsonObject, at path 'aPath'."))),
                            () -> assertThat(thrown.getCause(), is(nullValue()))
                    );
                }),

                dynamicTest("\"\" reverse()", () -> {

                    final ReverseTransformation classUnderTest = new ReverseTransformation();

                    final String expected = "";

                    final String actual = classUnderTest.reverse(null, "");

                    assertThat(actual, is(equalTo(expected)));
                }),

                dynamicTest("\"qwerty\" reverse()", () -> {

                    final ReverseTransformation classUnderTest = new ReverseTransformation();

                    final String expected = "ytrewq";

                    final String actual = classUnderTest.reverse(null, "qwerty");

                    assertThat(actual, is(equalTo(expected)));
                })

        );
    }

}
