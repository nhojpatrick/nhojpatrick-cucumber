package com.github.nhojpatrick.cucumber.json.core.transform.utils.tests;

import com.github.nhojpatrick.cucumber.core.exceptions.NullGenericsKeyException;
import com.github.nhojpatrick.cucumber.core.exceptions.NullGenericsValueException;
import com.github.nhojpatrick.cucumber.json.core.transform.utils.MapTypeUtil;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.function.Executable;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import static com.github.nhojpatrick.cucumber.json.core.transform.utils.MapTypeUtil.isTypedMap;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

public class MapTypeUtilTest {

    @Test
    public void checkIs_StaticUtilityClass() {
        final Executable testMethod = () -> {
            new MapTypeUtil();
        };
        final AssertionError thrown = assertThrows(AssertionError.class, testMethod);
        assertAll(
                () -> assertThat(thrown.getMessage(), is(equalTo("Static utility class - cannot be instantiated."))),
                () -> assertThat(thrown.getCause(), is(nullValue()))
        );
    }

    @TestFactory
    public Collection<DynamicTest> exceptions() {

        return Arrays.asList(

                dynamicTest("Map -> <null, null>", () -> {
                    final Executable testMethod = () -> isTypedMap(new HashMap<>(), null, null);
                    final NullGenericsKeyException thrown = assertThrows(NullGenericsKeyException.class, testMethod);
                    assertThat(thrown.getMessage(), is(equalTo("Null Generics Key Type.")));
                }),

                dynamicTest("Map -> <String, null>", () -> {
                    final Executable testMethod = () -> isTypedMap(new HashMap<>(), String.class, null);
                    final NullGenericsValueException thrown = assertThrows(NullGenericsValueException.class, testMethod);
                    assertThat(thrown.getMessage(), is(equalTo("Null Generics Value Type.")));
                }),

                dynamicTest("Object -> <null, null>", () -> {
                    final Executable testMethod = () -> isTypedMap(new Object(), null, null);
                    final NullGenericsKeyException thrown = assertThrows(NullGenericsKeyException.class, testMethod);
                    assertThat(thrown.getMessage(), is(equalTo("Null Generics Key Type.")));
                }),

                dynamicTest("Object -> <String, null>", () -> {
                    final Executable testMethod = () -> isTypedMap(new Object(), String.class, null);
                    final NullGenericsValueException thrown = assertThrows(NullGenericsValueException.class, testMethod);
                    assertThat(thrown.getMessage(), is(equalTo("Null Generics Value Type.")));
                })

        );
    }

    @TestFactory
    public Collection<DynamicTest> isTypedMap_Object() {

        return Arrays.asList(

                dynamicTest("Null Integer -> <String, Object>", () -> {
                    final Integer obj = null;
                    final boolean actual = isTypedMap(obj, String.class, Object.class);
                    assertThat(actual, is(equalTo(false)));
                }),

                dynamicTest("Null Object -> <String, Object>", () -> {
                    final Object obj = null;
                    final boolean actual = isTypedMap(obj, String.class, Object.class);
                    assertThat(actual, is(equalTo(false)));
                }),

                dynamicTest("Null String -> <String, Object>", () -> {
                    final String obj = null;
                    final boolean actual = isTypedMap(obj, String.class, Object.class);
                    assertThat(actual, is(equalTo(false)));
                }),

                dynamicTest("Default Integer -> <String, Object>", () -> {
                    final Integer obj = 1234;
                    final boolean actual = isTypedMap(obj, String.class, Object.class);
                    assertThat(actual, is(equalTo(false)));
                }),

                dynamicTest("Default Object -> <String, Object>", () -> {
                    final Object obj = new Object();
                    final boolean actual = isTypedMap(obj, String.class, Object.class);
                    assertThat(actual, is(equalTo(false)));
                }),

                dynamicTest("Default Null String -> <String, Object>", () -> {
                    final String obj = "qwertyuiop";
                    final boolean actual = isTypedMap(obj, String.class, Object.class);
                    assertThat(actual, is(equalTo(false)));
                }),

                dynamicTest("Map HashMap<> -> <String, Object>", () -> {
                    final Object obj = new HashMap<>();
                    final boolean actual = isTypedMap(obj, String.class, Object.class);
                    assertThat(actual, is(equalTo(true)));
                }),

                dynamicTest("Map TreeMap<> -> <String, Object>", () -> {
                    final Object obj = new TreeMap<>();
                    final boolean actual = isTypedMap(obj, String.class, Object.class);
                    assertThat(actual, is(equalTo(true)));
                })

        );
    }

    @TestFactory
    public Collection<DynamicTest> isTypedMap_Map() {

        return Arrays.asList(

                dynamicTest("Map Null, -> <String, Object>", () -> {

                    final Map map = null;

                    final boolean actual = isTypedMap(map, String.class, Object.class);

                    assertThat(actual, is(equalTo(false)));
                }),

                dynamicTest("Map Empty, -> <String, Object>", () -> {

                    final Map map = new HashMap<>();

                    final boolean actual = isTypedMap(map, String.class, Object.class);

                    assertThat(actual, is(equalTo(true)));
                }),

                dynamicTest("Map Null, -> <String, Integer>", () -> {

                    final Map map = new HashMap<>();
                    map.put("key1", null);

                    final boolean actual = isTypedMap(map, String.class, Integer.class);

                    assertThat(actual, is(equalTo(true)));
                }),

                dynamicTest("Map Null, -> <String, Integer>", () -> {

                    final Map map = new HashMap<>();
                    map.put("key1", null);
                    map.put("key2", null);
                    map.put("key3", null);

                    final boolean actual = isTypedMap(map, String.class, Integer.class);

                    assertThat(actual, is(equalTo(true)));
                }),

                dynamicTest("Map Integers, -> <String, Integer>", () -> {

                    final Map map = new HashMap<>();
                    map.put("key1", 1);
                    map.put("key2", 2);
                    map.put("key3", null);

                    final boolean actual = isTypedMap(map, String.class, Integer.class);

                    assertThat(actual, is(equalTo(true)));
                }),

                dynamicTest("Map Integers, -> <String, Object>", () -> {

                    final Map map = new HashMap<>();
                    map.put("key1", 1);
                    map.put("key2", 2);
                    map.put("key3", null);

                    final boolean actual = isTypedMap(map, String.class, Object.class);

                    assertThat(actual, is(equalTo(true)));
                }),

                dynamicTest("Map Integers, -> <String, String>", () -> {

                    final Map map = new HashMap<>();
                    map.put("key1", 1);
                    map.put("key2", 2);
                    map.put("key3", null);

                    final boolean actual = isTypedMap(map, String.class, String.class);

                    assertThat(actual, is(equalTo(false)));
                }),

                dynamicTest("Map Mixed, -> <String, Integer>", () -> {

                    final Map map = new HashMap<>();
                    map.put("key1", 1);
                    map.put("key2", "value2");
                    map.put("key3", null);

                    final boolean actual = isTypedMap(map, String.class, Integer.class);

                    assertThat(actual, is(equalTo(false)));
                }),

                dynamicTest("Map Mixed, -> <String, Object>", () -> {

                    final Map map = new HashMap<>();
                    map.put("key1", 1);
                    map.put("key2", "value2");
                    map.put("key3", null);

                    final boolean actual = isTypedMap(map, String.class, Object.class);

                    assertThat(actual, is(equalTo(true)));
                }),

                dynamicTest("Map Mixed, -> <String, String>", () -> {

                    final Map map = new HashMap<>();
                    map.put("key1", 1);
                    map.put("key2", "value2");
                    map.put("key3", null);

                    final boolean actual = isTypedMap(map, String.class, String.class);

                    assertThat(actual, is(equalTo(false)));
                }),

                dynamicTest("Map Strings, -> <String, Integer>", () -> {

                    final Map map = new HashMap<>();
                    map.put("key1", "value1");
                    map.put("key2", "value2");
                    map.put("key3", null);

                    final boolean actual = isTypedMap(map, String.class, Integer.class);

                    assertThat(actual, is(equalTo(false)));
                }),

                dynamicTest("Map Strings, -> <String, Object>", () -> {

                    final Map map = new HashMap<>();
                    map.put("key1", "value1");
                    map.put("key2", "value2");
                    map.put("key3", null);

                    final boolean actual = isTypedMap(map, String.class, Object.class);

                    assertThat(actual, is(equalTo(true)));
                }),

                dynamicTest("Map Strings, -> <String, String>", () -> {

                    final Map map = new HashMap<>();
                    map.put("key1", "value1");
                    map.put("key2", "value2");
                    map.put("key3", null);

                    final boolean actual = isTypedMap(map, String.class, String.class);

                    assertThat(actual, is(equalTo(true)));
                })

        );
    }

}
