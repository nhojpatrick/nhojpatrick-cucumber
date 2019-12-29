package com.github.nhojpatrick.cucumber.json.transformations.set;

import com.github.nhojpatrick.cucumber.json.core.transform.Transformation;
import com.github.nhojpatrick.cucumber.json.core.transform.TransformationService;
import com.github.nhojpatrick.cucumber.json.core.transform.utils.CastToUtil;
import com.github.nhojpatrick.cucumber.json.jodabeans.transform.TransformActionTask;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.function.Executable;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ServiceLoader;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import static com.github.nhojpatrick.hamcrest.collections.IsList.listWithSize;
import static com.github.nhojpatrick.hamcrest.lang.IsHashCode.hashCodeGenerated;
import static com.github.nhojpatrick.hamcrest.lang.IsToString.toStringGenerated;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNot.not;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SetTransformationServiceTest {

    @Nested
    @DisplayName("Basic")
    class basic {

        private SetTransformation classUnderTest;

        @BeforeEach
        public void beforeEach() {
            this.classUnderTest = new SetTransformation(null);
        }

        @Test
        public void equalsTest() {

            assertAll("equals",
                    () -> assertThat("should match", this.classUnderTest, is(equalTo(this.classUnderTest))),
                    () -> assertThat("should not match", this.classUnderTest, is(not(equalTo(null)))),
                    () -> assertThat("should not match", this.classUnderTest, is(not(equalTo(new Object())))),
                    () -> assertThat("should not match", this.classUnderTest, is(not(equalTo("String"))))
            );
        }

        @Test
        public void hashCodeTest() {

            assertAll("hashCode",
                    () -> assertThat("should match", this.classUnderTest, is(hashCodeGenerated(this.classUnderTest.hashCode()))),
                    () -> assertThat("should not match", this.classUnderTest, is(not(hashCodeGenerated(0)))),
                    () -> assertThat("should not match", this.classUnderTest, is(not(hashCodeGenerated(new Object().hashCode())))),
                    () -> assertThat("should not match", this.classUnderTest, is(not(hashCodeGenerated("String".hashCode()))))
            );
        }

        @Test
        public void toStringTest() {

            assertAll("toString",
                    () -> assertThat("should match", this.classUnderTest, is(toStringGenerated("SetTransformation[<null>]"))),
                    () -> assertThat("should not match", this.classUnderTest, is(not(toStringGenerated("")))),
                    () -> assertThat("should not match", this.classUnderTest, is(not(toStringGenerated(new Object().toString())))),
                    () -> assertThat("should not match", this.classUnderTest, is(not(toStringGenerated("String"))))
            );
        }

    }

    @Nested
    @DisplayName("ServiceLoader")
    class ServiceLoaderTest {

        @Test
        @DisplayName("ServiceLoader.load")
        public void load() {

            final ServiceLoader<TransformationService> serviceLoader = ServiceLoader.load(TransformationService.class);

            assertThat("Unexpected service loaded", serviceLoader, is(notNullValue()));

            // Java9+ START
            // Java9+ REPLACEMENT final List<TransformationService> services = serviceLoader.stream()
            final Iterator<TransformationService> serviceLoaderIterator = serviceLoader.iterator();
            final Iterable<TransformationService> serviceLoaderIterable = () -> serviceLoaderIterator;
            final Stream<TransformationService> serviceLoaderStream = StreamSupport.stream(serviceLoaderIterable.spliterator(), false);
            final List<TransformationService> services = serviceLoaderStream
                    // Java9+ END
                    .collect(Collectors.toList());
            assertThat("Unexpected service loaded", services, is(notNullValue()));
            assertThat("Unexpected service loaded", services, is(listWithSize(1)));
        }

    }

    private SetTransformationService classUnderTest;

    @BeforeEach
    public void beforeEach() {
        this.classUnderTest = new SetTransformationService();
    }

    @Test
    public void getAction() {

        final String result = this.classUnderTest.getAction();

        assertThat("Unexpected Action", result, is(equalTo(SetTransformationService.ACTION)));
    }

    @TestFactory
    public Collection<DynamicTest> resolve() {

        return Arrays.asList(

                DynamicTest.dynamicTest("null TransformActionTask", () -> {

                    final Executable testMethod = () -> this.classUnderTest.resolve(null);
                    final NullPointerException thrown = assertThrows(NullPointerException.class, testMethod);
                    assertAll("Checking Exception",
                            () -> assertThat(thrown.getMessage(), is(equalTo("TransformActionTask"))),
                            () -> assertThat(thrown.getCause(), is(nullValue()))
                    );
                }),

                DynamicTest.dynamicTest("empty TransformActionTask", () -> {

                    final TransformActionTask transformActionTask = new TransformActionTask.Builder()
                            .build();

                    final Executable testMethod = () -> this.classUnderTest.resolve(transformActionTask);
                    final NullPointerException thrown = assertThrows(NullPointerException.class, testMethod);
                    assertAll("Checking Exception",
                            () -> assertThat(thrown.getMessage(), is(equalTo("TransformActionTask.getType()"))),
                            () -> assertThat(thrown.getCause(), is(nullValue()))
                    );
                }),

                DynamicTest.dynamicTest("basic input", () -> {

                    final TransformActionTask transformActionTask = new TransformActionTask.Builder()
                            .withType("java.lang.String")
                            .withValue("aString")
                            .build();
                    final Object value = new CastToUtil()
                            .castTo(transformActionTask.getValue(), transformActionTask.getType());

                    final Transformation actual = this.classUnderTest.resolve(transformActionTask);

                    assertThat(actual, is(equalTo(new SetTransformation(value))));
                })

        );
    }

}
