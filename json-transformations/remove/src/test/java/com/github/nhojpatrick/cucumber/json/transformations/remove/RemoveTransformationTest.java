package com.github.nhojpatrick.cucumber.json.transformations.remove;

import com.github.nhojpatrick.cucumber.json.core.exceptions.NullPathElementException;
import com.github.nhojpatrick.cucumber.json.core.transform.Transformation;
import com.github.nhojpatrick.cucumber.json.core.validation.impl.PathArrayElementImpl;
import com.github.nhojpatrick.cucumber.json.core.validation.impl.PathElementImpl;
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
import java.util.List;
import java.util.Map;

import static com.github.nhojpatrick.cucumber.testing.internal.objects.TestingConstants.getBasicJsonMap;
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

public class RemoveTransformationTest {

    @Nested
    @DisplayName("Basic")
    class basic {

        private Transformation classUnderTest;
        private Transformation differentInstance;

        @BeforeEach
        public void beforeEach() {
            this.classUnderTest = new RemoveTransformation();
            this.differentInstance = new RemoveTransformation();
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
                    () -> assertThat("should match", this.classUnderTest, is(toStringGenerated("RemoveTransformation[]"))),
                    () -> assertThat("should match", this.classUnderTest, is(toStringGenerated(this.differentInstance.toString()))),
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
                    final Transformation classUnderTest = new RemoveTransformation();
                    final Executable testMethod = () -> classUnderTest.perform(null, null, null);
                    final NullPathElementException thrown = assertThrows(NullPathElementException.class, testMethod);
                    assertAll("Checking Exception",
                            () -> assertThat(thrown.getMessage(), is(equalTo("Null Path Element."))),
                            () -> assertThat(thrown.getCause(), is(nullValue()))
                    );
                }),

                DynamicTest.dynamicTest("empty input - null key", () -> {
                    final Transformation classUnderTest = new RemoveTransformation();
                    final Executable testMethod = () -> classUnderTest.perform(new HashMap<>(), null, null);
                    final NullPathElementException thrown = assertThrows(NullPathElementException.class, testMethod);
                    assertAll("Checking Exception",
                            () -> assertThat(thrown.getMessage(), is(equalTo("Null Path Element."))),
                            () -> assertThat(thrown.getCause(), is(nullValue()))
                    );
                })

        );
    }

    @TestFactory
    public Collection<DynamicTest> success() {

        return Arrays.asList(

                DynamicTest.dynamicTest("null input", () -> {

                    final String key = "key";

                    final Map<String, Object> input = null;

                    final Map<String, Object> expected = new HashMap<>();

                    final Transformation classUnderTest = new RemoveTransformation();

                    final Map<String, Object> actual = classUnderTest.perform(input, new PathElementImpl(key), null);

                    assertThat(actual, is(notNullValue()));
                    assertAll("Checking maps",
                            () -> assertThat(actual, is(equalTo(expected))),
                            () -> assertThat(actual.get(key), is(equalTo(expected.get(key))))
                    );
                }),

                DynamicTest.dynamicTest("empty input", () -> {

                    final String key = "key";

                    final Map<String, Object> input = new HashMap<>();

                    final Map<String, Object> expected = new HashMap<>();

                    final Transformation classUnderTest = new RemoveTransformation();

                    final Map<String, Object> actual = classUnderTest.perform(input, new PathElementImpl(key), null);

                    assertThat(actual, is(notNullValue()));
                    assertAll("Checking maps",
                            () -> assertThat(actual, is(equalTo(expected))),
                            () -> assertThat(actual.get(key), is(equalTo(expected.get(key))))
                    );
                }),

                DynamicTest.dynamicTest("path key keyArray", () -> {

                    final String key = "keyArray";

                    final Map<String, Object> input = new HashMap<>(getBasicJsonMap());

                    final Map<String, Object> expected = new HashMap<>(getBasicJsonMap());
                    expected.remove(key);

                    final Transformation classUnderTest = new RemoveTransformation();

                    final Map<String, Object> actual = classUnderTest.perform(input, new PathElementImpl(key), null);

                    assertThat(actual, is(notNullValue()));
                    assertAll("Checking maps",
                            () -> assertThat(actual, is(equalTo(expected))),
                            () -> assertThat(actual.get(key), is(equalTo(expected.get(key))))
                    );
                }),

                DynamicTest.dynamicTest("path key keyBoolean", () -> {

                    final String key = "keyBoolean";

                    final Map<String, Object> input = new HashMap<>(getBasicJsonMap());

                    final Map<String, Object> expected = new HashMap<>(getBasicJsonMap());
                    expected.remove(key);

                    final Transformation classUnderTest = new RemoveTransformation();

                    final Map<String, Object> actual = classUnderTest.perform(input, new PathElementImpl(key), null);

                    assertThat(actual, is(notNullValue()));
                    assertAll("Checking maps",
                            () -> assertThat(actual, is(equalTo(expected))),
                            () -> assertThat(actual.get(key), is(equalTo(expected.get(key))))
                    );
                }),

                DynamicTest.dynamicTest("path key keyDouble", () -> {

                    final String key = "keyDouble";

                    final Map<String, Object> input = new HashMap<>(getBasicJsonMap());

                    final Map<String, Object> expected = new HashMap<>(getBasicJsonMap());
                    expected.remove(key);

                    final Transformation classUnderTest = new RemoveTransformation();

                    final Map<String, Object> actual = classUnderTest.perform(input, new PathElementImpl(key), null);

                    assertThat(actual, is(notNullValue()));
                    assertAll("Checking maps",
                            () -> assertThat(actual, is(equalTo(expected))),
                            () -> assertThat(actual.get(key), is(equalTo(expected.get(key))))
                    );
                }),

                DynamicTest.dynamicTest("path key keyFloat", () -> {

                    final String key = "keyFloat";

                    final Map<String, Object> input = new HashMap<>(getBasicJsonMap());

                    final Map<String, Object> expected = new HashMap<>(getBasicJsonMap());
                    expected.remove(key);

                    final Transformation classUnderTest = new RemoveTransformation();

                    final Map<String, Object> actual = classUnderTest.perform(input, new PathElementImpl(key), null);

                    assertThat(actual, is(notNullValue()));
                    assertAll("Checking maps",
                            () -> assertThat(actual, is(equalTo(expected))),
                            () -> assertThat(actual.get(key), is(equalTo(expected.get(key))))
                    );
                }),

                DynamicTest.dynamicTest("path key keyInteger", () -> {

                    final String key = "keyInteger";

                    final Map<String, Object> input = new HashMap<>(getBasicJsonMap());

                    final Map<String, Object> expected = new HashMap<>(getBasicJsonMap());
                    expected.remove(key);

                    final Transformation classUnderTest = new RemoveTransformation();

                    final Map<String, Object> actual = classUnderTest.perform(input, new PathElementImpl(key), null);

                    assertThat(actual, is(notNullValue()));
                    assertAll("Checking maps",
                            () -> assertThat(actual, is(equalTo(expected))),
                            () -> assertThat(actual.get(key), is(equalTo(expected.get(key))))
                    );
                }),

                DynamicTest.dynamicTest("path key keyLong", () -> {

                    final String key = "keyLong";

                    final Map<String, Object> input = new HashMap<>(getBasicJsonMap());

                    final Map<String, Object> expected = new HashMap<>(getBasicJsonMap());
                    expected.remove(key);

                    final Transformation classUnderTest = new RemoveTransformation();

                    final Map<String, Object> actual = classUnderTest.perform(input, new PathElementImpl(key), null);

                    assertThat(actual, is(notNullValue()));
                    assertAll("Checking maps",
                            () -> assertThat(actual, is(equalTo(expected))),
                            () -> assertThat(actual.get(key), is(equalTo(expected.get(key))))
                    );
                }),

                DynamicTest.dynamicTest("path key keyMap", () -> {

                    final String key = "keyMap";

                    final Map<String, Object> input = new HashMap<>(getBasicJsonMap());

                    final Map<String, Object> expected = new HashMap<>(getBasicJsonMap());
                    expected.remove(key);

                    final Transformation classUnderTest = new RemoveTransformation();

                    final Map<String, Object> actual = classUnderTest.perform(input, new PathElementImpl(key), null);

                    assertThat(actual, is(notNullValue()));
                    assertAll("Checking maps",
                            () -> assertThat(actual, is(equalTo(expected))),
                            () -> assertThat(actual.get(key), is(equalTo(expected.get(key))))
                    );
                }),

                DynamicTest.dynamicTest("path key keyNull", () -> {

                    final String key = "keyNull";

                    final Map<String, Object> input = new HashMap<>(getBasicJsonMap());

                    final Map<String, Object> expected = new HashMap<>(getBasicJsonMap());
                    expected.remove(key);

                    final Transformation classUnderTest = new RemoveTransformation();

                    final Map<String, Object> actual = classUnderTest.perform(input, new PathElementImpl(key), null);

                    assertThat(actual, is(notNullValue()));
                    assertAll("Checking maps",
                            () -> assertThat(actual, is(equalTo(expected))),
                            () -> assertThat(actual.get(key), is(equalTo(expected.get(key))))
                    );
                }),

                DynamicTest.dynamicTest("path key keyString", () -> {

                    final String key = "keyString";

                    final Map<String, Object> input = new HashMap<>(getBasicJsonMap());

                    final Map<String, Object> expected = new HashMap<>(getBasicJsonMap());
                    expected.remove(key);

                    final Transformation classUnderTest = new RemoveTransformation();

                    final Map<String, Object> actual = classUnderTest.perform(input, new PathElementImpl(key), null);

                    assertThat(actual, is(notNullValue()));
                    assertAll("Checking maps",
                            () -> assertThat(actual, is(equalTo(expected))),
                            () -> assertThat(actual.get(key), is(equalTo(expected.get(key))))
                    );
                })

        );
    }

    @TestFactory
    public Collection<DynamicTest> successList() {

        return Arrays.asList(

                DynamicTest.dynamicTest("null input", () -> {

                    final String key = "key";
                    final int arrayIndex = 1;

                    final Map<String, Object> input = null;

                    final Map<String, Object> expected = new HashMap<>();
                    final List<Object> keyArray = new ArrayList<>();
                    keyArray.add(null);
                    expected.put(key, keyArray);

                    final Transformation classUnderTest = new RemoveTransformation();

                    final Map<String, Object> actual = classUnderTest.perform(input, new PathArrayElementImpl(String.format("%s[%s]", key, arrayIndex), key, arrayIndex), null);

                    assertThat(actual, is(notNullValue()));
                    assertAll("Checking maps",
                            () -> assertThat(actual, is(equalTo(expected))),
                            () -> assertThat(actual.get(key), is(equalTo(expected.get(key))))
                    );
                }),

                DynamicTest.dynamicTest("empty input", () -> {

                    final String key = "key";
                    final int arrayIndex = 1;

                    final Map<String, Object> input = new HashMap<>();

                    final Map<String, Object> expected = new HashMap<>();
                    final List<Object> keyArray = new ArrayList<>();
                    keyArray.add(null);
                    expected.put(key, keyArray);

                    final Transformation classUnderTest = new RemoveTransformation();

                    final Map<String, Object> actual = classUnderTest.perform(input, new PathArrayElementImpl(String.format("%s[%s]", key, arrayIndex), key, arrayIndex), null);

                    assertThat(actual, is(notNullValue()));
                    assertAll("Checking maps",
                            () -> assertThat(actual, is(equalTo(expected))),
                            () -> assertThat(actual.get(key), is(equalTo(expected.get(key))))
                    );
                }),

                DynamicTest.dynamicTest("path key keyArray[1]", () -> {

                    final String key = "keyArray";
                    final int arrayIndex = 1;

                    final Map<String, Object> input = new HashMap<>(getBasicJsonMap());

                    final Map<String, Object> expected = new HashMap<>(getBasicJsonMap());

                    expected.put(key, new ArrayList<>(Arrays.asList(
                            new ArrayList<>(Arrays.asList("aList")),
                            new ArrayList<>(Arrays.asList("cList")),
                            new ArrayList<>(Arrays.asList("dList"))
                    )));

                    final Transformation classUnderTest = new RemoveTransformation();

                    final Map<String, Object> actual = classUnderTest.perform(input, new PathArrayElementImpl(String.format("%s[%s]", key, arrayIndex), key, arrayIndex), null);

                    assertThat(actual, is(notNullValue()));
                    assertAll("Checking maps",
                            () -> assertThat(actual, is(equalTo(expected))),
                            () -> assertThat(actual.get(key), is(equalTo(expected.get(key))))
                    );
                }),

                DynamicTest.dynamicTest("path key keyArray[5]", () -> {

                    final String key = "keyArray";
                    final int arrayIndex = 5;

                    final Map<String, Object> input = new HashMap<>(getBasicJsonMap());

                    final Map<String, Object> expected = new HashMap<>(getBasicJsonMap());
                    expected.put(key, new ArrayList<>(Arrays.asList(
                            new ArrayList<>(Arrays.asList("aList")),
                            new ArrayList<>(Arrays.asList("bList")),
                            new ArrayList<>(Arrays.asList("cList")),
                            new ArrayList<>(Arrays.asList("dList")),
                            null
                    )));

                    final Transformation classUnderTest = new RemoveTransformation();

                    final Map<String, Object> actual = classUnderTest.perform(input, new PathArrayElementImpl(String.format("%s[%s]", key, arrayIndex), key, arrayIndex), null);

                    assertThat(actual, is(notNullValue()));
                    assertAll("Checking maps",
                            () -> assertThat(actual, is(equalTo(expected))),
                            () -> assertThat(actual.get(key), is(equalTo(expected.get(key))))
                    );
                }),

                DynamicTest.dynamicTest("path key keyBooleanArray[1]", () -> {

                    final String key = "keyBooleanArray";
                    final int arrayIndex = 1;

                    final Map<String, Object> input = new HashMap<>(getBasicJsonMap());

                    final Map<String, Object> expected = new HashMap<>(getBasicJsonMap());
                    expected.put(key, new ArrayList<>(Arrays.asList(true, true, false)));

                    final Transformation classUnderTest = new RemoveTransformation();

                    final Map<String, Object> actual = classUnderTest.perform(input, new PathArrayElementImpl(String.format("%s[%s]", key, arrayIndex), key, arrayIndex), null);

                    assertThat(actual, is(notNullValue()));
                    assertAll("Checking maps",
                            () -> assertThat(actual, is(equalTo(expected))),
                            () -> assertThat(actual.get(key), is(equalTo(expected.get(key))))
                    );
                }),

                DynamicTest.dynamicTest("path key keyBooleanArray[5]", () -> {

                    final String key = "keyBooleanArray";
                    final int arrayIndex = 5;

                    final Map<String, Object> input = new HashMap<>(getBasicJsonMap());

                    final Map<String, Object> expected = new HashMap<>(getBasicJsonMap());
                    expected.put(key, new ArrayList<>(Arrays.asList(true, false, true, false, null)));

                    final Transformation classUnderTest = new RemoveTransformation();

                    final Map<String, Object> actual = classUnderTest.perform(input, new PathArrayElementImpl(String.format("%s[%s]", key, arrayIndex), key, arrayIndex), null);

                    assertThat(actual, is(notNullValue()));
                    assertAll("Checking maps",
                            () -> assertThat(actual, is(equalTo(expected))),
                            () -> assertThat(actual.get(key), is(equalTo(expected.get(key))))
                    );
                }),

                DynamicTest.dynamicTest("path key keyDoubleArray[1]", () -> {

                    final String key = "keyDoubleArray";
                    final int arrayIndex = 1;

                    final Map<String, Object> input = new HashMap<>(getBasicJsonMap());

                    final Map<String, Object> expected = new HashMap<>(getBasicJsonMap());
                    expected.put(key, new ArrayList<>(Arrays.asList(12.34d, 34.56d, 45.67d)));

                    final Transformation classUnderTest = new RemoveTransformation();

                    final Map<String, Object> actual = classUnderTest.perform(input, new PathArrayElementImpl(String.format("%s[%s]", key, arrayIndex), key, arrayIndex), null);

                    assertThat(actual, is(notNullValue()));
                    assertAll("Checking maps",
                            () -> assertThat(actual, is(equalTo(expected))),
                            () -> assertThat(actual.get(key), is(equalTo(expected.get(key))))
                    );
                }),

                DynamicTest.dynamicTest("path key keyDoubleArray[5]", () -> {

                    final String key = "keyDoubleArray";
                    final int arrayIndex = 5;

                    final Map<String, Object> input = new HashMap<>(getBasicJsonMap());

                    final Map<String, Object> expected = new HashMap<>(getBasicJsonMap());
                    expected.put(key, new ArrayList<>(Arrays.asList(12.34d, 23.45d, 34.56d, 45.67d, null)));

                    final Transformation classUnderTest = new RemoveTransformation();

                    final Map<String, Object> actual = classUnderTest.perform(input, new PathArrayElementImpl(String.format("%s[%s]", key, arrayIndex), key, arrayIndex), null);

                    assertThat(actual, is(notNullValue()));
                    assertAll("Checking maps",
                            () -> assertThat(actual, is(equalTo(expected))),
                            () -> assertThat(actual.get(key), is(equalTo(expected.get(key))))
                    );
                }),

                DynamicTest.dynamicTest("path key keyFloatArray[1]", () -> {

                    final String key = "keyFloatArray";
                    final int arrayIndex = 1;

                    final Map<String, Object> input = new HashMap<>(getBasicJsonMap());

                    final Map<String, Object> expected = new HashMap<>(getBasicJsonMap());
                    expected.put(key, new ArrayList<>(Arrays.asList(12.34f, 34.56f, 45.67f)));

                    final Transformation classUnderTest = new RemoveTransformation();

                    final Map<String, Object> actual = classUnderTest.perform(input, new PathArrayElementImpl(String.format("%s[%s]", key, arrayIndex), key, arrayIndex), null);

                    assertThat(actual, is(notNullValue()));
                    assertAll("Checking maps",
                            () -> assertThat(actual, is(equalTo(expected))),
                            () -> assertThat(actual.get(key), is(equalTo(expected.get(key))))
                    );
                }),

                DynamicTest.dynamicTest("path key keyFloatArray[5]", () -> {

                    final String key = "keyFloatArray";
                    final int arrayIndex = 5;

                    final Map<String, Object> input = new HashMap<>(getBasicJsonMap());

                    final Map<String, Object> expected = new HashMap<>(getBasicJsonMap());
                    expected.put(key, new ArrayList<>(Arrays.asList(12.34f, 23.45f, 34.56f, 45.67f, null)));

                    final Transformation classUnderTest = new RemoveTransformation();

                    final Map<String, Object> actual = classUnderTest.perform(input, new PathArrayElementImpl(String.format("%s[%s]", key, arrayIndex), key, arrayIndex), null);

                    assertThat(actual, is(notNullValue()));
                    assertAll("Checking maps",
                            () -> assertThat(actual, is(equalTo(expected))),
                            () -> assertThat(actual.get(key), is(equalTo(expected.get(key))))
                    );
                }),

                DynamicTest.dynamicTest("path key keyIntegerArray[1]", () -> {

                    final String key = "keyIntegerArray";
                    final int arrayIndex = 1;

                    final Map<String, Object> input = new HashMap<>(getBasicJsonMap());

                    final Map<String, Object> expected = new HashMap<>(getBasicJsonMap());
                    expected.put(key, new ArrayList<>(Arrays.asList(1234, 3456, 4567)));

                    final Transformation classUnderTest = new RemoveTransformation();

                    final Map<String, Object> actual = classUnderTest.perform(input, new PathArrayElementImpl(String.format("%s[%s]", key, arrayIndex), key, arrayIndex), null);

                    assertThat(actual, is(notNullValue()));
                    assertAll("Checking maps",
                            () -> assertThat(actual, is(equalTo(expected))),
                            () -> assertThat(actual.get(key), is(equalTo(expected.get(key))))
                    );
                }),

                DynamicTest.dynamicTest("path key keyIntegerArray[5]", () -> {

                    final String key = "keyIntegerArray";
                    final int arrayIndex = 5;

                    final Map<String, Object> input = new HashMap<>(getBasicJsonMap());

                    final Map<String, Object> expected = new HashMap<>(getBasicJsonMap());
                    expected.put(key, new ArrayList<>(Arrays.asList(1234, 2345, 3456, 4567, null)));

                    final Transformation classUnderTest = new RemoveTransformation();

                    final Map<String, Object> actual = classUnderTest.perform(input, new PathArrayElementImpl(String.format("%s[%s]", key, arrayIndex), key, arrayIndex), null);

                    assertThat(actual, is(notNullValue()));
                    assertAll("Checking maps",
                            () -> assertThat(actual, is(equalTo(expected))),
                            () -> assertThat(actual.get(key), is(equalTo(expected.get(key))))
                    );
                }),

                DynamicTest.dynamicTest("path key keyLongArray[1]", () -> {

                    final String key = "keyLongArray";
                    final int arrayIndex = 1;

                    final Map<String, Object> input = new HashMap<>(getBasicJsonMap());

                    final Map<String, Object> expected = new HashMap<>(getBasicJsonMap());
                    expected.put(key, new ArrayList<>(Arrays.asList(1234L, 3456L, 4567L)));

                    final Transformation classUnderTest = new RemoveTransformation();

                    final Map<String, Object> actual = classUnderTest.perform(input, new PathArrayElementImpl(String.format("%s[%s]", key, arrayIndex), key, arrayIndex), null);

                    assertThat(actual, is(notNullValue()));
                    assertAll("Checking maps",
                            () -> assertThat(actual, is(equalTo(expected))),
                            () -> assertThat(actual.get(key), is(equalTo(expected.get(key))))
                    );
                }),

                DynamicTest.dynamicTest("path key keyLongArray[5]", () -> {

                    final String key = "keyLongArray";
                    final int arrayIndex = 5;

                    final Map<String, Object> input = new HashMap<>(getBasicJsonMap());

                    final Map<String, Object> expected = new HashMap<>(getBasicJsonMap());
                    expected.put(key, new ArrayList<>(Arrays.asList(1234L, 2345L, 3456L, 4567L, null)));

                    final Transformation classUnderTest = new RemoveTransformation();

                    final Map<String, Object> actual = classUnderTest.perform(input, new PathArrayElementImpl(String.format("%s[%s]", key, arrayIndex), key, arrayIndex), null);

                    assertThat(actual, is(notNullValue()));
                    assertAll("Checking maps",
                            () -> assertThat(actual, is(equalTo(expected))),
                            () -> assertThat(actual.get(key), is(equalTo(expected.get(key))))
                    );
                }),

                DynamicTest.dynamicTest("path key keyMapArray[1]", () -> {

                    final String key = "keyMapArray";
                    final int arrayIndex = 1;

                    final Map<String, Object> input = new HashMap<>(getBasicJsonMap());

                    final Map<String, Object> map1 = new HashMap<>();
                    map1.put("aMap", 1923);
                    final Map<String, Object> map3 = new HashMap<>();
                    map3.put("cMap", 3945);
                    final Map<String, Object> map4 = new HashMap<>();
                    map4.put("dMap", 4956);
                    final Map<String, Object> expected = new HashMap<>(getBasicJsonMap());
                    expected.put(key, new ArrayList<>(Arrays.asList(map1, map3, map4)));

                    final Transformation classUnderTest = new RemoveTransformation();

                    final Map<String, Object> actual = classUnderTest.perform(input, new PathArrayElementImpl(String.format("%s[%s]", key, arrayIndex), key, arrayIndex), null);

                    assertThat(actual, is(notNullValue()));
                    assertAll("Checking maps",
                            () -> assertThat(actual, is(equalTo(expected))),
                            () -> assertThat(actual.get(key), is(equalTo(expected.get(key))))
                    );
                }),

                DynamicTest.dynamicTest("path key keyMapArray[5]", () -> {

                    final String key = "keyMapArray";
                    final int arrayIndex = 5;

                    final Map<String, Object> input = new HashMap<>(getBasicJsonMap());

                    final Map<String, Object> map1 = new HashMap<>();
                    map1.put("aMap", 1923);
                    final Map<String, Object> map2 = new HashMap<>();
                    map2.put("bMap", 2934);
                    final Map<String, Object> map3 = new HashMap<>();
                    map3.put("cMap", 3945);
                    final Map<String, Object> map4 = new HashMap<>();
                    map4.put("dMap", 4956);
                    final Map<String, Object> expected = new HashMap<>(getBasicJsonMap());
                    expected.put(key, new ArrayList<>(Arrays.asList(map1, map2, map3, map4, null)));

                    final Transformation classUnderTest = new RemoveTransformation();

                    final Map<String, Object> actual = classUnderTest.perform(input, new PathArrayElementImpl(String.format("%s[%s]", key, arrayIndex), key, arrayIndex), null);

                    assertThat(actual, is(notNullValue()));
                    assertAll("Checking maps",
                            () -> assertThat(actual, is(equalTo(expected))),
                            () -> assertThat(actual.get(key), is(equalTo(expected.get(key))))
                    );
                }),

                DynamicTest.dynamicTest("path key keyNull[1]", () -> {

                    final String key = "keyNull";
                    final int arrayIndex = 1;

                    final Map<String, Object> input = new HashMap<>(getBasicJsonMap());

                    final Map<String, Object> expected = new HashMap<>(getBasicJsonMap());
                    final List<Object> keyArray = new ArrayList<>();
                    keyArray.add(null);
                    expected.put(key, keyArray);

                    final Transformation classUnderTest = new RemoveTransformation();

                    final Map<String, Object> actual = classUnderTest.perform(input, new PathArrayElementImpl(String.format("%s[%s]", key, arrayIndex), key, arrayIndex), null);

                    assertThat(actual, is(notNullValue()));
                    assertAll("Checking maps",
                            () -> assertThat(actual, is(equalTo(expected))),
                            () -> assertThat(actual.get(key), is(equalTo(expected.get(key))))
                    );
                }),

                DynamicTest.dynamicTest("path key keyNull[5]", () -> {

                    final String key = "keyNull";
                    final int arrayIndex = 5;

                    final Map<String, Object> input = new HashMap<>(getBasicJsonMap());

                    final Map<String, Object> expected = new HashMap<>(getBasicJsonMap());
                    final List<Object> keyArray = new ArrayList<>();
                    keyArray.add(null);
                    keyArray.add(null);
                    keyArray.add(null);
                    keyArray.add(null);
                    keyArray.add(null);
                    expected.put(key, keyArray);

                    final Transformation classUnderTest = new RemoveTransformation();

                    final Map<String, Object> actual = classUnderTest.perform(input, new PathArrayElementImpl(String.format("%s[%s]", key, arrayIndex), key, arrayIndex), null);

                    assertThat(actual, is(notNullValue()));
                    assertAll("Checking maps",
                            () -> assertThat(actual, is(equalTo(expected))),
                            () -> assertThat(actual.get(key), is(equalTo(expected.get(key))))
                    );
                }),

                DynamicTest.dynamicTest("path key keyStringArray[1]", () -> {

                    final String key = "keyStringArray";
                    final int arrayIndex = 1;

                    final Map<String, Object> input = new HashMap<>(getBasicJsonMap());

                    final Map<String, Object> expected = new HashMap<>(getBasicJsonMap());
                    expected.put(key, new ArrayList<>(Arrays.asList("aString", "cString", "dString")));

                    final Transformation classUnderTest = new RemoveTransformation();

                    final Map<String, Object> actual = classUnderTest.perform(input, new PathArrayElementImpl(String.format("%s[%s]", key, arrayIndex), key, arrayIndex), null);

                    assertThat(actual, is(notNullValue()));
                    assertAll("Checking maps",
                            () -> assertThat(actual, is(equalTo(expected))),
                            () -> assertThat(actual.get(key), is(equalTo(expected.get(key))))
                    );
                }),

                DynamicTest.dynamicTest("path key keyStringArray[5]", () -> {

                    final String key = "keyStringArray";
                    final int arrayIndex = 5;

                    final Map<String, Object> input = new HashMap<>(getBasicJsonMap());

                    final Map<String, Object> expected = new HashMap<>(getBasicJsonMap());
                    expected.put(key, new ArrayList<>(Arrays.asList("aString", "bString", "cString", "dString", null)));

                    final Transformation classUnderTest = new RemoveTransformation();

                    final Map<String, Object> actual = classUnderTest.perform(input, new PathArrayElementImpl(String.format("%s[%s]", key, arrayIndex), key, arrayIndex), null);

                    assertThat(actual, is(notNullValue()));
                    assertAll("Checking maps",
                            () -> assertThat(actual, is(equalTo(expected))),
                            () -> assertThat(actual.get(key), is(equalTo(expected.get(key))))
                    );
                })

        );
    }

}
