package com.github.nhojpatrick.cucumber.json.transform;

import com.github.nhojpatrick.cucumber.json.core.exceptions.IllegalPathOperationException;
import com.github.nhojpatrick.cucumber.json.transform.transformations.RemoveTransformation;
import com.github.nhojpatrick.cucumber.json.transform.transformations.SetTransformation;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.function.Executable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("Transform Impl Test")
public class TransformImplTest {

    @Nested
    @DisplayName("Transform Impl Remove Test")
    class RemoveTransformationTest {

        @TestFactory
        public Collection<DynamicTest> level0Basic() {

            final RemoveTransformation removeTransformation = new RemoveTransformation();

            final TransformImpl classUnderTest = new TransformImpl();

            return Arrays.asList(

                    DynamicTest.dynamicTest("map null", () -> {
                        final Map<String, Object> input = null;

                        final Map<String, Object> expected = new HashMap<>();

                        final Map<String, Object> actual = classUnderTest.transform(input, "var", removeTransformation);
                        assertThat(actual, is(equalTo(expected)));
                    }),

                    DynamicTest.dynamicTest("map empty", () -> {
                        final Map<String, Object> input = new HashMap<>();

                        final Map<String, Object> expected = new HashMap<>();

                        final Map<String, Object> actual = classUnderTest.transform(input, "var", removeTransformation);
                        assertThat(actual, is(equalTo(expected)));
                    }),

                    DynamicTest.dynamicTest("var attribute", () -> {
                        final Map<String, Object> input = new HashMap<>();
                        input.put("var", "oldValue");

                        final Map<String, Object> expected = new HashMap<>();

                        final Map<String, Object> actual = classUnderTest.transform(input, "var", removeTransformation);
                        assertThat(actual, is(equalTo(expected)));
                    }),

                    DynamicTest.dynamicTest("var list", () -> {
                        final Map<String, Object> inputVar1 = new HashMap<>();
                        inputVar1.put("var", "oldValue");
                        final List<Map<String, Object>> inputVar = new ArrayList<>();
                        inputVar.add(inputVar1);
                        final Map<String, Object> input = new HashMap<>();
                        input.put("var", inputVar);

                        final Map<String, Object> expected = new HashMap<>();

                        final Map<String, Object> actual = classUnderTest.transform(input, "var", removeTransformation);
                        assertThat(actual, is(equalTo(expected)));
                    }),

                    DynamicTest.dynamicTest("var object", () -> {
                        final Map<String, Object> inputVar = new HashMap<>();
                        inputVar.put("var", "oldValue");
                        final Map<String, Object> input = new HashMap<>();
                        input.put("var", inputVar);

                        final Map<String, Object> expected = new HashMap<>();

                        final Map<String, Object> actual = classUnderTest.transform(input, "var", removeTransformation);
                        assertThat(actual, is(equalTo(expected)));
                    })

            );
        }

        @TestFactory
        public Collection<DynamicTest> level1Basic() {

            final RemoveTransformation removeTransformation = new RemoveTransformation();

            final TransformImpl classUnderTest = new TransformImpl();

            return Arrays.asList(

                    DynamicTest.dynamicTest("input null - ()", () -> {
                        final Map<String, Object> input = null;

                        final Map<String, Object> expectedLevel0 = new HashMap<>();
                        final Map<String, Object> expected = new HashMap<>();
                        expected.put("level0", expectedLevel0);

                        final Map<String, Object> actual = classUnderTest.transform(input, "level0.var", removeTransformation);
                        assertThat(actual, is(equalTo(expected)));
                    }),

                    DynamicTest.dynamicTest("input empty map - ()", () -> {
                        final Map<String, Object> input = new HashMap<>();

                        final Map<String, Object> expectedLevel0 = new HashMap<>();
                        final Map<String, Object> expected = new HashMap<>();
                        expected.put("level0", expectedLevel0);

                        final Map<String, Object> actual = classUnderTest.transform(input, "level0.var", removeTransformation);
                        assertThat(actual, is(equalTo(expected)));
                    }),

                    DynamicTest.dynamicTest("input override - ()", () -> {
                        final Map<String, Object> inputLevel0 = new HashMap<>();
                        inputLevel0.put("var", "oldValue");
                        final Map<String, Object> input = new HashMap<>();
                        input.put("level0", inputLevel0);

                        final Map<String, Object> expectedLevel0 = new HashMap<>();
                        final Map<String, Object> expected = new HashMap<>();
                        expected.put("level0", expectedLevel0);

                        final Map<String, Object> actual = classUnderTest.transform(input, "level0.var", removeTransformation);
                        assertThat(actual, is(equalTo(expected)));
                    })

            );
        }

        @TestFactory
        public Collection<DynamicTest> level2Basic() {

            final RemoveTransformation removeTransformation = new RemoveTransformation();

            final TransformImpl classUnderTest = new TransformImpl();

            return Arrays.asList(

                    DynamicTest.dynamicTest("input null - ()", () -> {
                        final Map<String, Object> input = null;

                        final Map<String, Object> expectedLevel1 = new HashMap<>();
                        final Map<String, Object> expectedLevel0 = new HashMap<>();
                        expectedLevel0.put("level1", expectedLevel1);
                        final Map<String, Object> expected = new HashMap<>();
                        expected.put("level0", expectedLevel0);

                        final Map<String, Object> actual = classUnderTest.transform(input, "level0.level1.var", removeTransformation);
                        assertThat(actual, is(equalTo(expected)));
                    }),

                    DynamicTest.dynamicTest("input empty map - ()", () -> {
                        final Map<String, Object> input = new HashMap<>();

                        final Map<String, Object> expectedLevel1 = new HashMap<>();
                        final Map<String, Object> expectedLevel0 = new HashMap<>();
                        expectedLevel0.put("level1", expectedLevel1);
                        final Map<String, Object> expected = new HashMap<>();
                        expected.put("level0", expectedLevel0);

                        final Map<String, Object> actual = classUnderTest.transform(input, "level0.level1.var", removeTransformation);
                        assertThat(actual, is(equalTo(expected)));
                    }),

                    DynamicTest.dynamicTest("input override - ()", () -> {
                        final Map<String, Object> inputLevel1 = new HashMap<>();
                        final Map<String, Object> inputLevel0 = new HashMap<>();
                        inputLevel0.put("level1", inputLevel1);
                        final Map<String, Object> input = new HashMap<>();
                        input.put("level0", inputLevel0);

                        final Map<String, Object> expectedLevel1 = new HashMap<>();
                        final Map<String, Object> expectedLevel0 = new HashMap<>();
                        expectedLevel0.put("level1", expectedLevel1);
                        final Map<String, Object> expected = new HashMap<>();
                        expected.put("level0", expectedLevel0);

                        final Map<String, Object> actual = classUnderTest.transform(input, "level0.level1.var", removeTransformation);
                        assertThat(actual, is(equalTo(expected)));
                    })

            );
        }

        @TestFactory
        public Collection<DynamicTest> level3Basic() {

            final RemoveTransformation removeTransformation = new RemoveTransformation();

            final TransformImpl classUnderTest = new TransformImpl();

            return Arrays.asList(

                    DynamicTest.dynamicTest("input null - ()", () -> {
                        final Map<String, Object> input = null;

                        final Map<String, Object> expectedLevel2 = new HashMap<>();
                        final Map<String, Object> expectedLevel1 = new HashMap<>();
                        expectedLevel1.put("level2", expectedLevel2);
                        final Map<String, Object> expectedLevel0 = new HashMap<>();
                        expectedLevel0.put("level1", expectedLevel1);
                        final Map<String, Object> expected = new HashMap<>();
                        expected.put("level0", expectedLevel0);

                        final Map<String, Object> actual = classUnderTest.transform(input, "level0.level1.level2.var", removeTransformation);
                        assertThat(actual, is(equalTo(expected)));
                    }),

                    DynamicTest.dynamicTest("input empty map - ()", () -> {
                        final Map<String, Object> input = new HashMap<>();

                        final Map<String, Object> expectedLevel2 = new HashMap<>();
                        final Map<String, Object> expectedLevel1 = new HashMap<>();
                        expectedLevel1.put("level2", expectedLevel2);
                        final Map<String, Object> expectedLevel0 = new HashMap<>();
                        expectedLevel0.put("level1", expectedLevel1);
                        final Map<String, Object> expected = new HashMap<>();
                        expected.put("level0", expectedLevel0);

                        final Map<String, Object> actual = classUnderTest.transform(input, "level0.level1.level2.var", removeTransformation);
                        assertThat(actual, is(equalTo(expected)));
                    }),

                    DynamicTest.dynamicTest("input override - ()", () -> {
                        final Map<String, Object> inputLevel2 = new HashMap<>();
                        final Map<String, Object> inputLevel1 = new HashMap<>();
                        inputLevel1.put("level2", inputLevel2);
                        final Map<String, Object> inputLevel0 = new HashMap<>();
                        inputLevel0.put("level1", inputLevel1);
                        final Map<String, Object> input = new HashMap<>();
                        input.put("level0", inputLevel0);

                        final Map<String, Object> expectedLevel2 = new HashMap<>();
                        final Map<String, Object> expectedLevel1 = new HashMap<>();
                        expectedLevel1.put("level2", expectedLevel2);
                        final Map<String, Object> expectedLevel0 = new HashMap<>();
                        expectedLevel0.put("level1", expectedLevel1);
                        final Map<String, Object> expected = new HashMap<>();
                        expected.put("level0", expectedLevel0);

                        final Map<String, Object> actual = classUnderTest.transform(input, "level0.level1.level2.var", removeTransformation);
                        assertThat(actual, is(equalTo(expected)));
                    })

            );
        }

    }

    @Nested
    @DisplayName("Transform Impl Set Test")
    class SetTransformationTest {

        @TestFactory
        public Collection<DynamicTest> level0Basic() {

            final SetTransformation setType0 = new SetTransformation(1234);
            final SetTransformation setType1 = new SetTransformation("qwerty");

            final TransformImpl classUnderTest = new TransformImpl();

            return Arrays.asList(

                    DynamicTest.dynamicTest("input null - type0", () -> {
                        final Map<String, Object> input = null;

                        final Map<String, Object> expected = new HashMap<>();
                        expected.put("var", 1234);

                        final Map<String, Object> actual = classUnderTest.transform(input, "var", setType0);
                        assertThat(actual, is(equalTo(expected)));
                    }),

                    DynamicTest.dynamicTest("input null - type1", () -> {
                        final Map<String, Object> input = null;

                        final Map<String, Object> expected = new HashMap<>();
                        expected.put("var", "qwerty");

                        final Map<String, Object> actual = classUnderTest.transform(input, "var", setType1);
                        assertThat(actual, is(equalTo(expected)));
                    }),

                    DynamicTest.dynamicTest("input empty map - type0", () -> {
                        final Map<String, Object> input = new HashMap<>();

                        final Map<String, Object> expected = new HashMap<>();
                        expected.put("var", 1234);

                        final Map<String, Object> actual = classUnderTest.transform(input, "var", setType0);
                        assertThat(actual, is(equalTo(expected)));
                    }),

                    DynamicTest.dynamicTest("input empty map - type1", () -> {
                        final Map<String, Object> input = new HashMap<>();

                        final Map<String, Object> expected = new HashMap<>();
                        expected.put("var", "qwerty");

                        final Map<String, Object> actual = classUnderTest.transform(input, "var", setType1);
                        assertThat(actual, is(equalTo(expected)));
                    }),

                    DynamicTest.dynamicTest("input override - type0", () -> {
                        final Map<String, Object> input = new HashMap<>();
                        input.put("var", "oldValue");

                        final Map<String, Object> expected = new HashMap<>();
                        expected.put("var", 1234);

                        final Map<String, Object> actual = classUnderTest.transform(input, "var", setType0);
                        assertThat(actual, is(equalTo(expected)));
                    }),

                    DynamicTest.dynamicTest("input override - type1", () -> {
                        final Map<String, Object> input = new HashMap<>();
                        input.put("var", "oldValue");

                        final Map<String, Object> expected = new HashMap<>();
                        expected.put("var", "qwerty");

                        final Map<String, Object> actual = classUnderTest.transform(input, "var", setType1);
                        assertThat(actual, is(equalTo(expected)));
                    })

            );
        }

        @TestFactory
        public Collection<DynamicTest> level1Basic() {

            final SetTransformation setType0 = new SetTransformation(1234);
            final SetTransformation setType1 = new SetTransformation("qwerty");

            final TransformImpl classUnderTest = new TransformImpl();

            return Arrays.asList(

                    DynamicTest.dynamicTest("input null - type0", () -> {
                        final Map<String, Object> input = null;

                        final Map<String, Object> expectedLevel0 = new HashMap<>();
                        expectedLevel0.put("var", 1234);
                        final Map<String, Object> expected = new HashMap<>();
                        expected.put("level0", expectedLevel0);

                        final Map<String, Object> actual = classUnderTest.transform(input, "level0.var", setType0);
                        assertThat(actual, is(equalTo(expected)));
                    }),

                    DynamicTest.dynamicTest("input null - type1", () -> {
                        final Map<String, Object> input = null;

                        final Map<String, Object> expectedLevel0 = new HashMap<>();
                        expectedLevel0.put("var", "qwerty");
                        final Map<String, Object> expected = new HashMap<>();
                        expected.put("level0", expectedLevel0);

                        final Map<String, Object> actual = classUnderTest.transform(input, "level0.var", setType1);
                        assertThat(actual, is(equalTo(expected)));
                    }),

                    DynamicTest.dynamicTest("input empty map - type0", () -> {
                        final Map<String, Object> input = new HashMap<>();

                        final Map<String, Object> expectedLevel0 = new HashMap<>();
                        expectedLevel0.put("var", 1234);
                        final Map<String, Object> expected = new HashMap<>();
                        expected.put("level0", expectedLevel0);

                        final Map<String, Object> actual = classUnderTest.transform(input, "level0.var", setType0);
                        assertThat(actual, is(equalTo(expected)));
                    }),

                    DynamicTest.dynamicTest("input empty map - type1", () -> {
                        final Map<String, Object> input = new HashMap<>();

                        final Map<String, Object> expectedLevel0 = new HashMap<>();
                        expectedLevel0.put("var", "qwerty");
                        final Map<String, Object> expected = new HashMap<>();
                        expected.put("level0", expectedLevel0);

                        final Map<String, Object> actual = classUnderTest.transform(input, "level0.var", setType1);
                        assertThat(actual, is(equalTo(expected)));
                    }),

                    DynamicTest.dynamicTest("input override - type0", () -> {
                        final Map<String, Object> inputLevel0 = new HashMap<>();
                        inputLevel0.put("var", "oldValue");
                        final Map<String, Object> input = new HashMap<>();
                        input.put("level0", inputLevel0);

                        final Map<String, Object> expectedLevel0 = new HashMap<>();
                        expectedLevel0.put("var", 1234);
                        final Map<String, Object> expected = new HashMap<>();
                        expected.put("level0", expectedLevel0);

                        final Map<String, Object> actual = classUnderTest.transform(input, "level0.var", setType0);
                        assertThat(actual, is(equalTo(expected)));
                    }),

                    DynamicTest.dynamicTest("input override - type1", () -> {
                        final Map<String, Object> inputLevel0 = new HashMap<>();
                        inputLevel0.put("var", "oldValue");
                        final Map<String, Object> input = new HashMap<>();
                        input.put("level0", inputLevel0);

                        final Map<String, Object> expectedLevel0 = new HashMap<>();
                        expectedLevel0.put("var", "qwerty");
                        final Map<String, Object> expected = new HashMap<>();
                        expected.put("level0", expectedLevel0);

                        final Map<String, Object> actual = classUnderTest.transform(input, "level0.var", setType1);
                        assertThat(actual, is(equalTo(expected)));
                    }),

                    DynamicTest.dynamicTest("input override - level1 not object", () -> {
                        final Map<String, Object> input = new HashMap<>();
                        input.put("level0", "attribute");

                        final Map<String, Object> expectedLevel0 = new HashMap<>();
                        expectedLevel0.put("var", "qwerty");
                        final Map<String, Object> expected = new HashMap<>();
                        expected.put("level0", expectedLevel0);

                        final Executable testMethod = () -> classUnderTest.transform(input, "level0.var", setType1);
                        final IllegalPathOperationException expectedThrown = assertThrows(IllegalPathOperationException.class, testMethod);
                        assertThat(expectedThrown.getMessage(), is(equalTo("Unable to convert primative to object, at path 'level0'.")));
                    })

            );
        }

        @TestFactory
        public Collection<DynamicTest> level2Basic() {

            final SetTransformation setType0 = new SetTransformation(1234);
            final SetTransformation setType1 = new SetTransformation("qwerty");

            final TransformImpl classUnderTest = new TransformImpl();

            return Arrays.asList(

                    DynamicTest.dynamicTest("input null - type0", () -> {
                        final Map<String, Object> input = null;

                        final Map<String, Object> expectedLevel1 = new HashMap<>();
                        expectedLevel1.put("var", 1234);
                        final Map<String, Object> expectedLevel0 = new HashMap<>();
                        expectedLevel0.put("level1", expectedLevel1);
                        final Map<String, Object> expected = new HashMap<>();
                        expected.put("level0", expectedLevel0);

                        final Map<String, Object> actual = classUnderTest.transform(input, "level0.level1.var", setType0);
                        assertThat(actual, is(equalTo(expected)));
                    }),

                    DynamicTest.dynamicTest("input null - type1", () -> {
                        final Map<String, Object> input = null;

                        final Map<String, Object> expectedLevel1 = new HashMap<>();
                        expectedLevel1.put("var", "qwerty");
                        final Map<String, Object> expectedLevel0 = new HashMap<>();
                        expectedLevel0.put("level1", expectedLevel1);
                        final Map<String, Object> expected = new HashMap<>();
                        expected.put("level0", expectedLevel0);

                        final Map<String, Object> actual = classUnderTest.transform(input, "level0.level1.var", setType1);
                        assertThat(actual, is(equalTo(expected)));
                    }),

                    DynamicTest.dynamicTest("input empty map - type0", () -> {
                        final Map<String, Object> input = new HashMap<>();

                        final Map<String, Object> expectedLevel1 = new HashMap<>();
                        expectedLevel1.put("var", 1234);
                        final Map<String, Object> expectedLevel0 = new HashMap<>();
                        expectedLevel0.put("level1", expectedLevel1);
                        final Map<String, Object> expected = new HashMap<>();
                        expected.put("level0", expectedLevel0);

                        final Map<String, Object> actual = classUnderTest.transform(input, "level0.level1.var", setType0);
                        assertThat(actual, is(equalTo(expected)));
                    }),

                    DynamicTest.dynamicTest("input empty map - type1", () -> {
                        final Map<String, Object> input = new HashMap<>();

                        final Map<String, Object> expectedLevel1 = new HashMap<>();
                        expectedLevel1.put("var", "qwerty");
                        final Map<String, Object> expectedLevel0 = new HashMap<>();
                        expectedLevel0.put("level1", expectedLevel1);
                        final Map<String, Object> expected = new HashMap<>();
                        expected.put("level0", expectedLevel0);

                        final Map<String, Object> actual = classUnderTest.transform(input, "level0.level1.var", setType1);
                        assertThat(actual, is(equalTo(expected)));
                    }),

                    DynamicTest.dynamicTest("input override - type0", () -> {
                        final Map<String, Object> inputLevel1 = new HashMap<>();
                        inputLevel1.put("var", "oldValue");
                        final Map<String, Object> inputLevel0 = new HashMap<>();
                        inputLevel0.put("level1", inputLevel1);
                        final Map<String, Object> input = new HashMap<>();
                        input.put("level0", inputLevel0);

                        final Map<String, Object> expectedLevel1 = new HashMap<>();
                        expectedLevel1.put("var", 1234);
                        final Map<String, Object> expectedLevel0 = new HashMap<>();
                        expectedLevel0.put("level1", expectedLevel1);
                        final Map<String, Object> expected = new HashMap<>();
                        expected.put("level0", expectedLevel0);

                        final Map<String, Object> actual = classUnderTest.transform(input, "level0.level1.var", setType0);
                        assertThat(actual, is(equalTo(expected)));
                    }),

                    DynamicTest.dynamicTest("input override - type1", () -> {
                        final Map<String, Object> inputLevel1 = new HashMap<>();
                        inputLevel1.put("var", "oldValue");
                        final Map<String, Object> inputLevel0 = new HashMap<>();
                        inputLevel0.put("level1", inputLevel1);
                        final Map<String, Object> input = new HashMap<>();
                        input.put("level0", inputLevel0);

                        final Map<String, Object> expectedLevel1 = new HashMap<>();
                        expectedLevel1.put("var", "qwerty");
                        final Map<String, Object> expectedLevel0 = new HashMap<>();
                        expectedLevel0.put("level1", expectedLevel1);
                        final Map<String, Object> expected = new HashMap<>();
                        expected.put("level0", expectedLevel0);

                        final Map<String, Object> actual = classUnderTest.transform(input, "level0.level1.var", setType1);
                        assertThat(actual, is(equalTo(expected)));
                    })

            );
        }

        @TestFactory
        public Collection<DynamicTest> level3Basic() {

            final SetTransformation setType0 = new SetTransformation(1234);
            final SetTransformation setType1 = new SetTransformation("qwerty");

            final TransformImpl classUnderTest = new TransformImpl();

            return Arrays.asList(

                    DynamicTest.dynamicTest("input null - type0", () -> {
                        final Map<String, Object> input = null;

                        final Map<String, Object> expectedLevel2 = new HashMap<>();
                        expectedLevel2.put("var", 1234);
                        final Map<String, Object> expectedLevel1 = new HashMap<>();
                        expectedLevel1.put("level2", expectedLevel2);
                        final Map<String, Object> expectedLevel0 = new HashMap<>();
                        expectedLevel0.put("level1", expectedLevel1);
                        final Map<String, Object> expected = new HashMap<>();
                        expected.put("level0", expectedLevel0);

                        final Map<String, Object> actual = classUnderTest.transform(input, "level0.level1.level2.var", setType0);
                        assertThat(actual, is(equalTo(expected)));
                    }),

                    DynamicTest.dynamicTest("input null - type1", () -> {
                        final Map<String, Object> input = null;

                        final Map<String, Object> expectedLevel2 = new HashMap<>();
                        expectedLevel2.put("var", "qwerty");
                        final Map<String, Object> expectedLevel1 = new HashMap<>();
                        expectedLevel1.put("level2", expectedLevel2);
                        final Map<String, Object> expectedLevel0 = new HashMap<>();
                        expectedLevel0.put("level1", expectedLevel1);
                        final Map<String, Object> expected = new HashMap<>();
                        expected.put("level0", expectedLevel0);

                        final Map<String, Object> actual = classUnderTest.transform(input, "level0.level1.level2.var", setType1);
                        assertThat(actual, is(equalTo(expected)));
                    }),

                    DynamicTest.dynamicTest("input empty map - type0", () -> {
                        final Map<String, Object> input = new HashMap<>();

                        final Map<String, Object> expectedLevel2 = new HashMap<>();
                        expectedLevel2.put("var", 1234);
                        final Map<String, Object> expectedLevel1 = new HashMap<>();
                        expectedLevel1.put("level2", expectedLevel2);
                        final Map<String, Object> expectedLevel0 = new HashMap<>();
                        expectedLevel0.put("level1", expectedLevel1);
                        final Map<String, Object> expected = new HashMap<>();
                        expected.put("level0", expectedLevel0);

                        final Map<String, Object> actual = classUnderTest.transform(input, "level0.level1.level2.var", setType0);
                        assertThat(actual, is(equalTo(expected)));
                    }),

                    DynamicTest.dynamicTest("input empty map - type1", () -> {
                        final Map<String, Object> input = new HashMap<>();

                        final Map<String, Object> expectedLevel2 = new HashMap<>();
                        expectedLevel2.put("var", "qwerty");
                        final Map<String, Object> expectedLevel1 = new HashMap<>();
                        expectedLevel1.put("level2", expectedLevel2);
                        final Map<String, Object> expectedLevel0 = new HashMap<>();
                        expectedLevel0.put("level1", expectedLevel1);
                        final Map<String, Object> expected = new HashMap<>();
                        expected.put("level0", expectedLevel0);

                        final Map<String, Object> actual = classUnderTest.transform(input, "level0.level1.level2.var", setType1);
                        assertThat(actual, is(equalTo(expected)));
                    }),

                    DynamicTest.dynamicTest("input override - type0", () -> {
                        final Map<String, Object> inputLevel2 = new HashMap<>();
                        inputLevel2.put("var", "oldValue");
                        final Map<String, Object> inputLevel1 = new HashMap<>();
                        inputLevel1.put("level2", inputLevel2);
                        final Map<String, Object> inputLevel0 = new HashMap<>();
                        inputLevel0.put("level1", inputLevel1);
                        final Map<String, Object> input = new HashMap<>();
                        input.put("level0", inputLevel0);

                        final Map<String, Object> expectedLevel2 = new HashMap<>();
                        expectedLevel2.put("var", 1234);
                        final Map<String, Object> expectedLevel1 = new HashMap<>();
                        expectedLevel1.put("level2", expectedLevel2);
                        final Map<String, Object> expectedLevel0 = new HashMap<>();
                        expectedLevel0.put("level1", expectedLevel1);
                        final Map<String, Object> expected = new HashMap<>();
                        expected.put("level0", expectedLevel0);

                        final Map<String, Object> actual = classUnderTest.transform(input, "level0.level1.level2.var", setType0);
                        assertThat(actual, is(equalTo(expected)));
                    }),

                    DynamicTest.dynamicTest("input override - type1", () -> {
                        final Map<String, Object> inputLevel2 = new HashMap<>();
                        inputLevel2.put("var", "oldValue");
                        final Map<String, Object> inputLevel1 = new HashMap<>();
                        inputLevel1.put("level2", inputLevel2);
                        final Map<String, Object> inputLevel0 = new HashMap<>();
                        inputLevel0.put("level1", inputLevel1);
                        final Map<String, Object> input = new HashMap<>();
                        input.put("level0", inputLevel0);

                        final Map<String, Object> expectedLevel2 = new HashMap<>();
                        expectedLevel2.put("var", "qwerty");
                        final Map<String, Object> expectedLevel1 = new HashMap<>();
                        expectedLevel1.put("level2", expectedLevel2);
                        final Map<String, Object> expectedLevel0 = new HashMap<>();
                        expectedLevel0.put("level1", expectedLevel1);
                        final Map<String, Object> expected = new HashMap<>();
                        expected.put("level0", expectedLevel0);

                        final Map<String, Object> actual = classUnderTest.transform(input, "level0.level1.level2.var", setType1);
                        assertThat(actual, is(equalTo(expected)));
                    })

            );
        }

    }

}
