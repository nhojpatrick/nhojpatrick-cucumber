package com.github.nhojpatrick.cucumber.json.testing.objects;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestingConstants {

    public static final MyComplexObj COMPLEX_OBJECT_AS_OBJECT;
    public static final Map<String, Object> COMPLEX_OBJECT_AS_JSON_MAP;

    public static final MySimpleObj SIMPLE_OBJECT_AS_OBJECT;
    public static final Map<String, Object> SIMPLE_OBJECT_AS_JSON_MAP;

    static {
        final List<MyListNestedObj> nests = Arrays.asList(
                new MyListNestedObj("nests1", 1, new MyListNestedBottomObj("nests1Charlie")),
                new MyListNestedObj("nests2", 2, new MyListNestedBottomObj("nests2Charlie")),
                new MyListNestedObj("nests3", 3, new MyListNestedBottomObj("nests3Charlie"))
        );

        final List<String> labels = Arrays.asList("labelOne", "labelTwo", "labelThree");
        final MyNestedObj nested = new MyNestedObj("Nested", labels, new MyBottomObj("Alpha"), nests);

        final List<MyListComplexObj> objs = Arrays.asList(
                new MyListComplexObj("objs1", 1, new MyListComplexBottomObj("objs1Bravo")),
                new MyListComplexObj("objs2", 2, new MyListComplexBottomObj("objs2Bravo")),
                new MyListComplexObj("objs3", 3, new MyListComplexBottomObj("objs3Bravo"))
        );

        final List<String> tags = Arrays.asList("tagOne", "tagTwo", "tagThree");
        COMPLEX_OBJECT_AS_OBJECT = new MyComplexObj("Complex", true, 3234, tags, nested, objs);
    }

    static {
        final Map<String, Object> objs1Bottom = new HashMap<>();
        objs1Bottom.put("bravo", "objs1Bravo");

        final Map<String, Object> objs1 = new HashMap<>();
        objs1.put("lcName", "objs1");
        objs1.put("lcId", 1);
        objs1.put("lcBottom", objs1Bottom);

        final Map<String, Object> objs2Bottom = new HashMap<>();
        objs2Bottom.put("bravo", "objs2Bravo");

        final Map<String, Object> objs2 = new HashMap<>();
        objs2.put("lcName", "objs2");
        objs2.put("lcId", 2);
        objs2.put("lcBottom", objs2Bottom);

        final Map<String, Object> objs3Bottom = new HashMap<>();
        objs3Bottom.put("bravo", "objs3Bravo");

        final Map<String, Object> objs3 = new HashMap<>();
        objs3.put("lcName", "objs3");
        objs3.put("lcId", 3);
        objs3.put("lcBottom", objs3Bottom);

        final List<Map<String, Object>> objs = new ArrayList<>();
        objs.add(objs1);
        objs.add(objs2);
        objs.add(objs3);

        final Map<String, Object> nests1Bottom = new HashMap<>();
        nests1Bottom.put("charlie", "nests1Charlie");

        final Map<String, Object> nests1 = new HashMap<>();
        nests1.put("lnName", "nests1");
        nests1.put("lnId", 1);
        nests1.put("lnBottom", nests1Bottom);

        final Map<String, Object> nests2Bottom = new HashMap<>();
        nests2Bottom.put("charlie", "nests2Charlie");

        final Map<String, Object> nests2 = new HashMap<>();
        nests2.put("lnName", "nests2");
        nests2.put("lnId", 2);
        nests2.put("lnBottom", nests2Bottom);

        final Map<String, Object> nests3Bottom = new HashMap<>();
        nests3Bottom.put("charlie", "nests3Charlie");

        final Map<String, Object> nests3 = new HashMap<>();
        nests3.put("lnName", "nests3");
        nests3.put("lnId", 3);
        nests3.put("lnBottom", nests3Bottom);

        final List<Map<String, Object>> nests = new ArrayList<>();
        nests.add(nests1);
        nests.add(nests2);
        nests.add(nests3);

        final Map<String, Object> bottom = new HashMap<>();
        bottom.put("alpha", "Alpha");

        final Map<String, Object> nested = new HashMap<>();
        nested.put("name", "Nested");
        nested.put("labels", Arrays.asList("labelOne", "labelTwo", "labelThree"));
        nested.put("bottom", bottom);
        nested.put("nests", nests);

        final Map<String, Object> expected = new HashMap<>();
        expected.put("title", "Complex");
        expected.put("active", true);
        expected.put("count", 3234);
        expected.put("tags", Arrays.asList("tagOne", "tagTwo", "tagThree"));
        expected.put("nested", nested);
        expected.put("objs", objs);

        COMPLEX_OBJECT_AS_JSON_MAP = new HashMap<>(expected);
    }

    static {
        SIMPLE_OBJECT_AS_OBJECT = new MySimpleObj("ASimpleName");

        final Map<String, Object> expected = new HashMap<>();
        expected.put("simpleName", "ASimpleName");
        SIMPLE_OBJECT_AS_JSON_MAP = new HashMap<>(expected);
    }

    public static final Map<String, Object> getBasicJsonMap() {

        final List<String> array1 = new ArrayList<>(Arrays.asList("aList"));
        final List<String> array2 = new ArrayList<>(Arrays.asList("bList"));
        final List<String> array3 = new ArrayList<>(Arrays.asList("cList"));
        final List<String> array4 = new ArrayList<>(Arrays.asList("dList"));

        final Map<String, Object> map1 = new HashMap<>();
        map1.put("aMap", 1);
        final Map<String, Object> map2 = new HashMap<>();
        map2.put("bMap", 2);
        final Map<String, Object> map3 = new HashMap<>();
        map3.put("cMap", 3);
        final Map<String, Object> map4 = new HashMap<>();
        map4.put("dMap", 4);

        final Map<String, Object> map = new HashMap<>();

        map.put("keyArray", new ArrayList<>(Arrays.asList(array1, array2, array3, array4)));
        map.put("keyBoolean", true);
        map.put("keyBooleanArray", new ArrayList<>(Arrays.asList(true, false, true, false)));
        map.put("keyDouble", 12.34d);
        map.put("keyDoubleArray", new ArrayList<>(Arrays.asList(12.34d, 23.45d, 34.56d, 45.67d)));
        map.put("keyFloat", 23.45f);
        map.put("keyFloatArray", new ArrayList<>(Arrays.asList(12.34f, 23.45f, 34.56f, 45.67f)));
        map.put("keyInteger", 3456);
        map.put("keyIntegerArray", new ArrayList<>(Arrays.asList(1234, 2345, 3456, 4567)));
        map.put("keyLong", 4567L);
        map.put("keyLongArray", new ArrayList<>(Arrays.asList(1234L, 2345L, 3456L, 4567L)));
        map.put("keyMap", new HashMap<String, Object>());
        map.put("keyMapArray", new ArrayList<>(Arrays.asList(map1, map2, map3, map4)));
        map.put("keyNull", null);
        map.put("keyString", "oldValue");
        map.put("keyStringArray", new ArrayList<>(Arrays.asList("aString", "bString", "cString", "dString")));

        return map;
    }

}
