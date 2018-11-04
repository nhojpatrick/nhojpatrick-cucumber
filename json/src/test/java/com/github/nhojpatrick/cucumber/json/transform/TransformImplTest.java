package com.github.nhojpatrick.cucumber.json.transform;

import com.github.nhojpatrick.cucumber.json.transform.transformations.RemoveTransformation;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.TestFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;

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

}
