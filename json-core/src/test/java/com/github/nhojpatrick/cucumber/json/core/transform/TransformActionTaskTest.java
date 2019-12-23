package com.github.nhojpatrick.cucumber.json.core.transform;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.function.Executable;

import java.util.Arrays;
import java.util.Collection;

import static com.github.nhojpatrick.hamcrest.lang.IsCompareTo.compareToObject;
import static com.github.nhojpatrick.hamcrest.lang.IsHashCode.hashCodeGenerated;
import static com.github.nhojpatrick.hamcrest.lang.IsToString.toStringGenerated;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNot.not;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TransformActionTaskTest {

    public static final String VALUE = "aValue";
    public static final String TYPE = "aType";

    @Nested
    @DisplayName("Basic")
    class basic {

        private TransformActionTask classUnderTest;
        private TransformActionTask differentInstance;

        @BeforeEach
        public void beforeEach() {
            this.classUnderTest = new TransformActionTask.Builder()
                    .withType(TYPE)
                    .withValue(VALUE)
                    .build();
            this.differentInstance = new TransformActionTask.Builder()
                    .withType("anotherType")
                    .withValue("anotherValue")
                    .build();
        }

        @Test
        public void compareToTest() {

            assertAll("compareTo",
                    () -> assertThat("should match", this.classUnderTest, is(compareToObject(0, this.classUnderTest))),
                    () -> assertThat("should match", this.classUnderTest, is(compareToObject(26, this.differentInstance)))
            );
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
                    () -> assertThat("should match", this.classUnderTest, is(toStringGenerated("TransformActionTask{type=aType, value=aValue}"))),
                    () -> assertThat("should not match", this.classUnderTest, is(not(toStringGenerated(this.differentInstance.toString())))),
                    () -> assertThat("should not match", this.classUnderTest, is(not(toStringGenerated("")))),
                    () -> assertThat("should not match", this.classUnderTest, is(not(toStringGenerated(new Object().toString())))),
                    () -> assertThat("should not match", this.classUnderTest, is(not(toStringGenerated("String"))))
            );
        }

    }

    @TestFactory
    @DisplayName("TransformActionTask tests")
    public Collection<DynamicTest> tests() {

        return Arrays.asList(

                DynamicTest.dynamicTest("TransformActionTask.Builder()", () -> {
                    final TransformActionTask classUnderTest = new TransformActionTask.Builder()
                            .withType("aType")
                            .withValue("aValue")
                            .build();
                    assertThat("should match", classUnderTest, is(toStringGenerated("TransformActionTask{type=aType, value=aValue}")));
                }),

                DynamicTest.dynamicTest("TransformActionTask.Builder(null)", () -> {
                    final Executable testMethod = () -> new TransformActionTask.Builder(null);
                    final NullPointerException thrown = assertThrows(NullPointerException.class, testMethod);
                    assertAll("Checking Exception",
                            () -> assertThat(thrown.getMessage(), is(equalTo("Builder(TransformActionTask)"))),
                            () -> assertThat(thrown.getCause(), is(nullValue()))
                    );
                }),

                DynamicTest.dynamicTest("TransformActionTask.Builder(existing)", () -> {
                    final TransformActionTask existing = new TransformActionTask.Builder()
                            .withType("aType")
                            .withValue("aValue")
                            .build();
                    final TransformActionTask classUnderTest = new TransformActionTask.Builder(existing)
                            .build();
                    assertThat("should match", classUnderTest, is(toStringGenerated("TransformActionTask{type=aType, value=aValue}")));
                })

        );
    }

    @Test
    public void basicSuccess() {

        final TransformActionTask transformActionTask = new TransformActionTask.Builder()
                .withType(TYPE)
                .withValue(VALUE)
                .build();

        assertAll("TransformActionTask.Builder.build() checks",
                () -> assertThat("Type", transformActionTask.getType(), is(equalTo(TYPE))),
                () -> assertThat("Type", transformActionTask.getValue(), is(equalTo(VALUE)))
        );
    }

}
