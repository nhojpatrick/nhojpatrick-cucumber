package com.github.nhojpatrick.cucumber.json.transform.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Supplier;

public class TransformImpl_InputSource {

    public static final Supplier<Map> INPUT_SOURCE_EMPTY = () -> new LinkedHashMap<>();

    public static final Supplier<Map> INPUT_SOURCE_LEVEL2 = () -> {

        final Map<String, Object> a2ArrayObjects = new LinkedHashMap<>();
        a2ArrayObjects.put("a2ArrayObjects_knownKey", "a2ArrayObjects0_knownValue");

        final Map<Object, Object> a2PathObject = new LinkedHashMap<>();
        a2PathObject.put("a2PathObject_b2Primitive", "bPrimitive");

        final Map<String, Object> parent = new LinkedHashMap<>();

        parent.put("a2ArrayEmpty", new ArrayList<>());
        parent.put("a2ArrayObjects", new ArrayList<>(Arrays.asList(
                a2ArrayObjects,
                new LinkedHashMap<>(),
                null
        )));
        parent.put("a2ArrayPrimitives", new ArrayList<>(Arrays.asList(
                "a2PrimitiveArray0",
                null
        )));
        parent.put("a2Null", null);
        parent.put("a2PathEmpty", new LinkedHashMap<>());
        parent.put("a2PathObject", a2PathObject);
        parent.put("a2Primitive", "aPrimitive");

        return parent;
    };

    public static final Supplier<Map> INPUT_SOURCE_NULL = () -> null;

}
