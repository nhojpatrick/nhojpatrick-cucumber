package com.github.nhojpatrick.cucumber.testing.internal.objects;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class TestingInternalObjectsConstants {

    public static final Map<String, Object> MAP_BASIC_ARRAYS;

    public static final Map<String, Object> MAP_BASIC_PRIMITIVES;

    public static final Map<String, Object> MAP_EMPTY = Collections.unmodifiableMap(new HashMap<>());

    public static Map<String, Object> getMapBasicArrays() {

        final Map<String, Object> basicArrays = new LinkedHashMap<>();

        basicArrays.put("primitive", "aPrimitive");

        final List<String> primitivesArray = new ArrayList<>();
        primitivesArray.add("aPrimitiveArray");
        primitivesArray.add("bPrimitiveArray");
        primitivesArray.add("cPrimitiveArray");
        primitivesArray.add("dPrimitiveArray");
        basicArrays.put("primitives_array", primitivesArray);

        final List<Map<String, Object>> objectsArray = new ArrayList<>();

        final Map<String, Object> aObjectArray = new HashMap<>();
        aObjectArray.put("object_array_id", "aObjectArrayId");
        objectsArray.add(aObjectArray);

        final Map<String, Object> bObjectArray = new HashMap<>();
        bObjectArray.put("object_array_id", "bObjectArrayId");
        objectsArray.add(bObjectArray);

        final Map<String, Object> cObjectArray = new HashMap<>();
        cObjectArray.put("object_array_id", "cObjectArrayId");
        objectsArray.add(cObjectArray);

        final Map<String, Object> dObjectArray = new HashMap<>();
        dObjectArray.put("object_array_id", "dObjectArrayId");
        objectsArray.add(dObjectArray);

        basicArrays.put("objects_array", objectsArray);

        return basicArrays;
    }

    static {
        MAP_BASIC_ARRAYS = Collections.unmodifiableMap(new LinkedHashMap(getMapBasicArrays()));
    }

    public static Map<String, Object> getMapBasicPrimitives() {

        final Map<String, Object> basicPrimitive = new LinkedHashMap<>();

        basicPrimitive.put("a_boolean", true);
        basicPrimitive.put("a_float", 12.34f);
        basicPrimitive.put("a_integer", 1234);
        basicPrimitive.put("a_null", null);
        basicPrimitive.put("a_object", new HashMap<>());
        basicPrimitive.put("a_string", "aValue");

        return basicPrimitive;
    }

    static {
        MAP_BASIC_PRIMITIVES = Collections.unmodifiableMap(new LinkedHashMap(getMapBasicPrimitives()));
    }

}
