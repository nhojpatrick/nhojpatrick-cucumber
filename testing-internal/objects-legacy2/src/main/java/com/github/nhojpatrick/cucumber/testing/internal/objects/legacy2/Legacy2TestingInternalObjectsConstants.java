package com.github.nhojpatrick.cucumber.testing.internal.objects.legacy2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Legacy2TestingInternalObjectsConstants {

    public static final Map<String, Object> LEGACY2_MAP_BASIC_ARRAYS;

    public static final Map<String, Object> LEGACY2_MAP_BASIC_ATTRIBUTES;

    public static final Map<String, Object> LEGACY2_MAP_EMPTY = Collections.unmodifiableMap(new HashMap<>());

    public static final Legacy2BasicArraysOuterObj LEGACY2_OBJECT_BASIC_ARRAYS;

    public static final Legacy2BasicAttributesOuterObj LEGACY2_OBJECT_BASIC_ATTRIBUTES;

    public static Map<String, Object> getLegacy2MapBasicArrays() {

        final List<Map<String, Object>> objectsArray = new ArrayList<>();

        final Map<String, Object> aObjectArray = new HashMap<>();
        aObjectArray.put(Legacy2BasicArraysInnerObj.OBJECT_ARRAY_ID, "aObjectArrayId");
        objectsArray.add(aObjectArray);

        final Map<String, Object> bObjectArray = new HashMap<>();
        bObjectArray.put(Legacy2BasicArraysInnerObj.OBJECT_ARRAY_ID, "bObjectArrayId");
        objectsArray.add(bObjectArray);

        final Map<String, Object> cObjectArray = new HashMap<>();
        cObjectArray.put(Legacy2BasicArraysInnerObj.OBJECT_ARRAY_ID, "cObjectArrayId");
        objectsArray.add(cObjectArray);

        final Map<String, Object> dObjectArray = new HashMap<>();
        dObjectArray.put(Legacy2BasicArraysInnerObj.OBJECT_ARRAY_ID, "dObjectArrayId");
        objectsArray.add(dObjectArray);

        final List<String> primitivesArray = new ArrayList<>();
        primitivesArray.add("aPrimitiveArray");
        primitivesArray.add("bPrimitiveArray");
        primitivesArray.add("cPrimitiveArray");
        primitivesArray.add("dPrimitiveArray");

        final Map<String, Object> basicArrays = new LinkedHashMap<>();

        basicArrays.put(Legacy2BasicArraysOuterObj.NULL_ARRAY, null);
        basicArrays.put(Legacy2BasicArraysOuterObj.OBJECTS_ARRAY, objectsArray);
        basicArrays.put(Legacy2BasicArraysOuterObj.PRIMITIVE, "aPrimitive");
        basicArrays.put(Legacy2BasicArraysOuterObj.PRIMITIVES_ARRAY, primitivesArray);

        return basicArrays;
    }

    static {
        LEGACY2_MAP_BASIC_ARRAYS = Collections.unmodifiableMap(new LinkedHashMap(getLegacy2MapBasicArrays()));
    }

    public static Map<String, Object> getLegacy2MapBasicAttributes() {

        final Map<String, Object> basicAttributes = new LinkedHashMap<>();

        basicAttributes.put(Legacy2BasicAttributesOuterObj.A_BOOLEAN, true);
        basicAttributes.put(Legacy2BasicAttributesOuterObj.A_FLOAT, 12.34f);
        basicAttributes.put(Legacy2BasicAttributesOuterObj.A_INTEGER, 1234);
        basicAttributes.put(Legacy2BasicAttributesOuterObj.A_NULL, null);
        basicAttributes.put(Legacy2BasicAttributesOuterObj.A_OBJECT, new HashMap<>());
        basicAttributes.put(Legacy2BasicAttributesOuterObj.A_STRING, "aValue");

        return basicAttributes;
    }

    static {
        LEGACY2_MAP_BASIC_ATTRIBUTES = Collections.unmodifiableMap(new LinkedHashMap(getLegacy2MapBasicAttributes()));
    }

    public static Legacy2BasicArraysOuterObj getLegacy2ObjectBasicArrays() {

        final List<Legacy2BasicArraysInnerObj> objectsArray = new ArrayList<>();
        objectsArray.add(new Legacy2BasicArraysInnerObj("aObjectArrayId"));
        objectsArray.add(new Legacy2BasicArraysInnerObj("bObjectArrayId"));
        objectsArray.add(new Legacy2BasicArraysInnerObj("cObjectArrayId"));
        objectsArray.add(new Legacy2BasicArraysInnerObj("dObjectArrayId"));

        final List<String> primitivesArray = new ArrayList<>();
        primitivesArray.add("aPrimitiveArray");
        primitivesArray.add("bPrimitiveArray");
        primitivesArray.add("cPrimitiveArray");
        primitivesArray.add("dPrimitiveArray");

        return new Legacy2BasicArraysOuterObj(objectsArray, "aPrimitive", primitivesArray);
    }

    static {
        LEGACY2_OBJECT_BASIC_ARRAYS = getLegacy2ObjectBasicArrays();
    }

    public static Legacy2BasicAttributesOuterObj getLegacy2ObjectBasicAttributes() {

        return new Legacy2BasicAttributesOuterObj(true, 12.34f, 1234, "aValue");
    }

    static {
        LEGACY2_OBJECT_BASIC_ATTRIBUTES = getLegacy2ObjectBasicAttributes();
    }

}
