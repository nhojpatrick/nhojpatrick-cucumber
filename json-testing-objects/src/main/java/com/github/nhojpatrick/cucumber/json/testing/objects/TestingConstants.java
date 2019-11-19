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

}
