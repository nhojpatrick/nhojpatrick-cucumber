package com.github.nhojpatrick.cucumber.json.map.impl;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.github.nhojpatrick.cucumber.json.map.impl.ConvertMapToJsonTest.shuffle;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;

public class ConvertMapToJson_FormattedTest {

    private static final String FORMAT = "Formatted";
    private static final boolean FORMATTING = true;

    @TestFactory
    @DisplayName("Array Json " + FORMAT)
    public Collection<DynamicTest> array() {

        return Arrays.asList(

                DynamicTest.dynamicTest(FORMAT + " Array Boolean Input", () -> {
                    final Map<String, Object> jsonMapRaw = new HashMap();
                    final List<Boolean> arrayBoolean = new ArrayList<>();
                    arrayBoolean.add(true);
                    arrayBoolean.add(false);
                    arrayBoolean.add(true);
                    arrayBoolean.add(false);
                    jsonMapRaw.put("arrayBoolean", arrayBoolean);
                    final Map<String, Object> jsonMap = shuffle(jsonMapRaw);
                    final String json = new ConvertMapToJson(FORMATTING)
                            .apply(jsonMap);
                    final String expected = String.format("{\n  %s\n}",
                            "\"arrayBoolean\" : [ true, false, true, false ]"
                    );
                    assertThat("Unexpected conversion", json, is(equalTo(expected)));
                }),

                DynamicTest.dynamicTest(FORMAT + " Array Float Input", () -> {
                    final Map<String, Object> jsonMapRaw = new HashMap();
                    final List<Float> arrayFloat = new ArrayList<>();
                    arrayFloat.add(12.34f);
                    arrayFloat.add(23.45f);
                    arrayFloat.add(34.56f);
                    arrayFloat.add(45.67f);
                    jsonMapRaw.put("arrayFloat", arrayFloat);
                    final Map<String, Object> jsonMap = shuffle(jsonMapRaw);
                    final String json = new ConvertMapToJson(FORMATTING)
                            .apply(jsonMap);
                    final String expected = String.format("{\n  %s\n}",
                            "\"arrayFloat\" : [ 12.34, 23.45, 34.56, 45.67 ]"
                    );
                    assertThat("Unexpected conversion", json, is(equalTo(expected)));
                }),

                DynamicTest.dynamicTest(FORMAT + " Array Integer Input", () -> {
                    final Map<String, Object> jsonMapRaw = new HashMap();
                    final List<Integer> arrayInteger = new ArrayList<>();
                    arrayInteger.add(1234);
                    arrayInteger.add(2345);
                    arrayInteger.add(3456);
                    arrayInteger.add(4567);
                    jsonMapRaw.put("arrayInteger", arrayInteger);
                    final Map<String, Object> jsonMap = shuffle(jsonMapRaw);
                    final String json = new ConvertMapToJson(FORMATTING)
                            .apply(jsonMap);
                    final String expected = String.format("{\n  %s\n}",
                            "\"arrayInteger\" : [ 1234, 2345, 3456, 4567 ]"
                    );
                    assertThat("Unexpected conversion", json, is(equalTo(expected)));
                }),

                DynamicTest.dynamicTest(FORMAT + " Array Null Input", () -> {
                    final Map<String, Object> jsonMapRaw = new HashMap();
                    final List<Object> arrayNull = new ArrayList<>();
                    arrayNull.add(null);
                    arrayNull.add(null);
                    arrayNull.add(null);
                    arrayNull.add(null);
                    jsonMapRaw.put("arrayNull", arrayNull);
                    final Map<String, Object> jsonMap = shuffle(jsonMapRaw);
                    final String json = new ConvertMapToJson(FORMATTING)
                            .apply(jsonMap);
                    final String expected = String.format("{\n  %s\n}",
                            "\"arrayNull\" : [ null, null, null, null ]"
                    );
                    assertThat("Unexpected conversion", json, is(equalTo(expected)));
                }),

                DynamicTest.dynamicTest(FORMAT + " Array String Input", () -> {
                    final Map<String, Object> jsonMapRaw = new HashMap();
                    final List<String> arrayString = new ArrayList<>();
                    arrayString.add("aValue");
                    arrayString.add("bValue");
                    arrayString.add("cValue");
                    arrayString.add("dValue");
                    jsonMapRaw.put("arrayString", arrayString);
                    final Map<String, Object> jsonMap = shuffle(jsonMapRaw);
                    final String json = new ConvertMapToJson(FORMATTING)
                            .apply(jsonMap);
                    final String expected = String.format("{\n  %s\n}",
                            "\"arrayString\" : [ \"aValue\", \"bValue\", \"cValue\", \"dValue\" ]"
                    );
                    assertThat("Unexpected conversion", json, is(equalTo(expected)));
                }),

                DynamicTest.dynamicTest(FORMAT + " Simple One of Each Input", () -> {
                    final Map<String, Object> jsonMapRaw = new HashMap();
                    final List<Boolean> arrayBoolean = new ArrayList<>();
                    arrayBoolean.add(true);
                    arrayBoolean.add(false);
                    arrayBoolean.add(true);
                    arrayBoolean.add(false);
                    jsonMapRaw.put("arrayBoolean", arrayBoolean);
                    final List<Float> arrayFloat = new ArrayList<>();
                    arrayFloat.add(12.34f);
                    arrayFloat.add(23.45f);
                    arrayFloat.add(34.56f);
                    arrayFloat.add(45.67f);
                    jsonMapRaw.put("arrayFloat", arrayFloat);
                    final List<Integer> arrayInteger = new ArrayList<>();
                    arrayInteger.add(1234);
                    arrayInteger.add(2345);
                    arrayInteger.add(3456);
                    arrayInteger.add(4567);
                    jsonMapRaw.put("arrayInteger", arrayInteger);
                    final List<Object> arrayNull = new ArrayList<>();
                    arrayNull.add(null);
                    arrayNull.add(null);
                    arrayNull.add(null);
                    arrayNull.add(null);
                    jsonMapRaw.put("arrayNull", arrayNull);
                    final List<String> arrayString = new ArrayList<>();
                    arrayString.add("aValue");
                    arrayString.add("bValue");
                    arrayString.add("cValue");
                    arrayString.add("dValue");
                    jsonMapRaw.put("arrayString", arrayString);
                    final Map<String, Object> jsonMap = shuffle(jsonMapRaw);
                    final String json = new ConvertMapToJson(FORMATTING)
                            .apply(jsonMap);
                    final String expected = String.format("{\n  %s,\n  %s,\n  %s,\n  %s,\n  %s\n}",
                            "\"arrayBoolean\" : [ true, false, true, false ]",
                            "\"arrayFloat\" : [ 12.34, 23.45, 34.56, 45.67 ]",
                            "\"arrayInteger\" : [ 1234, 2345, 3456, 4567 ]",
                            "\"arrayNull\" : [ null, null, null, null ]",
                            "\"arrayString\" : [ \"aValue\", \"bValue\", \"cValue\", \"dValue\" ]"
                    );
                    assertThat("Unexpected conversion", json, is(equalTo(expected)));
                })

        );
    }

    @TestFactory
    @DisplayName("Basic Json " + FORMAT)
    public Collection<DynamicTest> basic() {

        return Arrays.asList(

                DynamicTest.dynamicTest(FORMAT + " Empty Input", () -> {
                    final String json = new ConvertMapToJson(FORMATTING)
                            .apply(new HashMap());
                    assertThat("Unexpected conversion", json, is(equalTo("{ }")));
                }),

                DynamicTest.dynamicTest(FORMAT + " Simple Boolean Input", () -> {
                    final Map<String, Object> jsonMapRaw = new HashMap();
                    jsonMapRaw.put("aBoolean", true);
                    final Map<String, Object> jsonMap = shuffle(jsonMapRaw);
                    final String json = new ConvertMapToJson(FORMATTING)
                            .apply(jsonMap);
                    final String expected = String.format("{\n  %s\n}",
                            "\"aBoolean\" : true"
                    );
                    assertThat("Unexpected conversion", json, is(equalTo(expected)));
                }),

                DynamicTest.dynamicTest(FORMAT + " Simple Float Input", () -> {
                    final Map<String, Object> jsonMapRaw = new HashMap();
                    jsonMapRaw.put("aFloat", 12.34f);
                    final Map<String, Object> jsonMap = shuffle(jsonMapRaw);
                    final String json = new ConvertMapToJson(FORMATTING)
                            .apply(jsonMap);
                    final String expected = String.format("{\n  %s\n}",
                            "\"aFloat\" : 12.34"
                    );
                    assertThat("Unexpected conversion", json, is(equalTo(expected)));
                }),

                DynamicTest.dynamicTest(FORMAT + " Simple Integer Input", () -> {
                    final Map<String, Object> jsonMapRaw = new HashMap();
                    jsonMapRaw.put("aInteger", 1234);
                    final Map<String, Object> jsonMap = shuffle(jsonMapRaw);
                    final String json = new ConvertMapToJson(FORMATTING)
                            .apply(jsonMap);
                    final String expected = String.format("{\n  %s\n}",
                            "\"aInteger\" : 1234"
                    );
                    assertThat("Unexpected conversion", json, is(equalTo(expected)));
                }),

                DynamicTest.dynamicTest(FORMAT + " Simple Null Input", () -> {
                    final Map<String, Object> jsonMapRaw = new HashMap();
                    jsonMapRaw.put("aNull", null);
                    final Map<String, Object> jsonMap = shuffle(jsonMapRaw);
                    final String json = new ConvertMapToJson(FORMATTING)
                            .apply(jsonMap);
                    final String expected = String.format("{\n  %s\n}",
                            "\"aNull\" : null"
                    );
                    assertThat("Unexpected conversion", json, is(equalTo(expected)));
                }),

                DynamicTest.dynamicTest(FORMAT + " Simple String Input", () -> {
                    final Map<String, Object> jsonMapRaw = new HashMap();
                    jsonMapRaw.put("aString", "aValue");
                    final Map<String, Object> jsonMap = shuffle(jsonMapRaw);
                    final String json = new ConvertMapToJson(FORMATTING)
                            .apply(jsonMap);
                    final String expected = String.format("{\n  %s\n}",
                            "\"aString\" : \"aValue\""
                    );
                    assertThat("Unexpected conversion", json, is(equalTo(expected)));
                }),

                DynamicTest.dynamicTest(FORMAT + " Simple One of Each Input", () -> {
                    final Map<String, Object> jsonMapRaw = new HashMap();
                    jsonMapRaw.put("aBoolean", true);
                    jsonMapRaw.put("aFloat", 12.34f);
                    jsonMapRaw.put("aInteger", 1234);
                    jsonMapRaw.put("aNull", null);
                    jsonMapRaw.put("aString", "aValue");
                    final Map<String, Object> jsonMap = shuffle(jsonMapRaw);
                    final String json = new ConvertMapToJson(FORMATTING)
                            .apply(jsonMap);
                    final String expected = String.format("{\n  %s,\n  %s,\n  %s,\n  %s,\n  %s\n}",
                            "\"aBoolean\" : true",
                            "\"aFloat\" : 12.34",
                            "\"aInteger\" : 1234",
                            "\"aNull\" : null",
                            "\"aString\" : \"aValue\""
                    );
                    assertThat("Unexpected conversion", json, is(equalTo(expected)));
                })

        );
    }

}
