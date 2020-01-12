package com.github.nhojpatrick.cucumber.testing.internal.objects.legacy;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.Test;

import static com.github.nhojpatrick.cucumber.testing.internal.objects.legacy.LegacyTestingInternalObjectsConstants.COMPLEX_OBJECT_AS_JSON_MAP;
import static com.github.nhojpatrick.cucumber.testing.internal.objects.legacy.LegacyTestingInternalObjectsConstants.COMPLEX_OBJECT_AS_OBJECT;
import static com.github.nhojpatrick.cucumber.testing.internal.objects.legacy.LegacyTestingInternalObjectsConstants.SIMPLE_OBJECT_AS_JSON_MAP;
import static com.github.nhojpatrick.cucumber.testing.internal.objects.legacy.LegacyTestingInternalObjectsConstants.SIMPLE_OBJECT_AS_OBJECT;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.jupiter.api.Assertions.assertAll;

public class LegacyTestingInternalObjectsConstantsTest {

    @Test
    public void complex()
            throws JsonProcessingException {

        final String mapBasicArraysAsStr = new ObjectMapper()
                .writeValueAsString(COMPLEX_OBJECT_AS_OBJECT);

        final String objectBasicArraysAsStr = new ObjectMapper()
                .configure(SerializationFeature.ORDER_MAP_ENTRIES_BY_KEYS, true)
                .writeValueAsString(COMPLEX_OBJECT_AS_JSON_MAP);

        final String expectation = "{\"active\":true,\"count\":3234,\"nested\":{\"bottom\":{\"alpha\":\"Alpha\"},\"labels\":[\"labelOne\",\"labelTwo\",\"labelThree\"],\"name\":\"Nested\",\"nests\":[{\"lnBottom\":{\"charlie\":\"nests1Charlie\"},\"lnId\":1223,\"lnName\":\"nests1\"},{\"lnBottom\":{\"charlie\":\"nests2Charlie\"},\"lnId\":2234,\"lnName\":\"nests2\"},{\"lnBottom\":{\"charlie\":\"nests3Charlie\"},\"lnId\":3245,\"lnName\":\"nests3\"}]},\"objs\":[{\"lcBottom\":{\"bravo\":\"objs1Bravo\"},\"lcId\":1123,\"lcName\":\"objs1\"},{\"lcBottom\":{\"bravo\":\"objs2Bravo\"},\"lcId\":2134,\"lcName\":\"objs2\"},{\"lcBottom\":{\"bravo\":\"objs3Bravo\"},\"lcId\":3145,\"lcName\":\"objs3\"}],\"tags\":[\"tagOne\",\"tagTwo\",\"tagThree\"],\"title\":\"Complex\"}";

        assertAll("Check Both Ways",
                () -> assertThat("Maps against Object", mapBasicArraysAsStr, is(equalTo(objectBasicArraysAsStr))),
                () -> assertThat("Maps against Expectation", mapBasicArraysAsStr, is(equalTo(expectation))),
                () -> assertThat("Object against Map", objectBasicArraysAsStr, is(equalTo(mapBasicArraysAsStr))),
                () -> assertThat("Object against Expectation", objectBasicArraysAsStr, is(equalTo(expectation)))
        );
    }

    @Test
    public void simple()
            throws JsonProcessingException {

        final String mapBasicArraysAsStr = new ObjectMapper()
                .writeValueAsString(SIMPLE_OBJECT_AS_OBJECT);

        final String objectBasicArraysAsStr = new ObjectMapper()
                .configure(SerializationFeature.ORDER_MAP_ENTRIES_BY_KEYS, true)
                .writeValueAsString(SIMPLE_OBJECT_AS_JSON_MAP);

        final String expectation = "{\"simpleName\":\"ASimpleName\"}";

        assertAll("Check Both Ways",
                () -> assertThat("Maps against Object", mapBasicArraysAsStr, is(equalTo(objectBasicArraysAsStr))),
                () -> assertThat("Maps against Expectation", mapBasicArraysAsStr, is(equalTo(expectation))),
                () -> assertThat("Object against Map", objectBasicArraysAsStr, is(equalTo(mapBasicArraysAsStr))),
                () -> assertThat("Object against Expectation", objectBasicArraysAsStr, is(equalTo(expectation)))
        );
    }

}
