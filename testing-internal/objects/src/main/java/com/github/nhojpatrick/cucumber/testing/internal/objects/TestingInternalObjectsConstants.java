package com.github.nhojpatrick.cucumber.testing.internal.objects;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class TestingInternalObjectsConstants {

    public static final Map<String, Object> MAP_BASIC_ARRAYS;

    public static final BasicArraysOuterObj OBJECT_BASIC_ARRAYS;

    public static Map<String, Object> getMapBasicArrays() {

        final List<Map<String, Object>> objectsArray = new ArrayList<>();

        final Map<String, Object> aObjectArray = new HashMap<>();
        aObjectArray.put(BasicArraysInnerObj.OBJECT_ARRAY_ID, "aObjectArrayId");
        objectsArray.add(aObjectArray);

        final Map<String, Object> bObjectArray = new HashMap<>();
        bObjectArray.put(BasicArraysInnerObj.OBJECT_ARRAY_ID, "bObjectArrayId");
        objectsArray.add(bObjectArray);

        final Map<String, Object> cObjectArray = new HashMap<>();
        cObjectArray.put(BasicArraysInnerObj.OBJECT_ARRAY_ID, "cObjectArrayId");
        objectsArray.add(cObjectArray);

        final Map<String, Object> dObjectArray = new HashMap<>();
        dObjectArray.put(BasicArraysInnerObj.OBJECT_ARRAY_ID, "dObjectArrayId");
        objectsArray.add(dObjectArray);

        final List<String> primitivesArray = new ArrayList<>();
        primitivesArray.add("aPrimitiveArray");
        primitivesArray.add("bPrimitiveArray");
        primitivesArray.add("cPrimitiveArray");
        primitivesArray.add("dPrimitiveArray");

        final Map<String, Object> basicArrays = new LinkedHashMap<>();

        basicArrays.put(BasicArraysOuterObj.OBJECTS_ARRAY, objectsArray);
        basicArrays.put(BasicArraysOuterObj.OBJECTS_EMPTY, new ArrayList());
        basicArrays.put(BasicArraysOuterObj.OBJECTS_NULL, null);
        basicArrays.put(BasicArraysOuterObj.PRIMITIVES_ARRAY, primitivesArray);
        basicArrays.put(BasicArraysOuterObj.PRIMITIVES_EMPTY, new ArrayList());
        basicArrays.put(BasicArraysOuterObj.PRIMITIVES_NULL, null);

        return basicArrays;
    }

    static {
        MAP_BASIC_ARRAYS = Collections.unmodifiableMap(new LinkedHashMap(getMapBasicArrays()));
    }

    public static BasicArraysOuterObj getObjectBasicArrays() {

        final List<BasicArraysInnerObj> objectsArray = new ArrayList<>();
        objectsArray.add(new BasicArraysInnerObj("aObjectArrayId"));
        objectsArray.add(new BasicArraysInnerObj("bObjectArrayId"));
        objectsArray.add(new BasicArraysInnerObj("cObjectArrayId"));
        objectsArray.add(new BasicArraysInnerObj("dObjectArrayId"));

        final List<String> primitivesArray = new ArrayList<>();
        primitivesArray.add("aPrimitiveArray");
        primitivesArray.add("bPrimitiveArray");
        primitivesArray.add("cPrimitiveArray");
        primitivesArray.add("dPrimitiveArray");

        return new BasicArraysOuterObj(objectsArray, primitivesArray);
    }

    static {
        OBJECT_BASIC_ARRAYS = getObjectBasicArrays();
    }

}
