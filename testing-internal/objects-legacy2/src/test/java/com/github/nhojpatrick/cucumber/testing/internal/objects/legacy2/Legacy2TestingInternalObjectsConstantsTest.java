package com.github.nhojpatrick.cucumber.testing.internal.objects.legacy2;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import static com.github.nhojpatrick.cucumber.testing.internal.objects.legacy2.Legacy2TestingInternalObjectsConstants.LEGACY2_MAP_BASIC_ARRAYS;
import static com.github.nhojpatrick.cucumber.testing.internal.objects.legacy2.Legacy2TestingInternalObjectsConstants.LEGACY2_MAP_BASIC_ATTRIBUTES;
import static com.github.nhojpatrick.cucumber.testing.internal.objects.legacy2.Legacy2TestingInternalObjectsConstants.LEGACY2_OBJECT_BASIC_ARRAYS;
import static com.github.nhojpatrick.cucumber.testing.internal.objects.legacy2.Legacy2TestingInternalObjectsConstants.LEGACY2_OBJECT_BASIC_ATTRIBUTES;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.jupiter.api.Assertions.assertAll;

public class Legacy2TestingInternalObjectsConstantsTest {

    @Test
    public void basicArrays()
            throws JsonProcessingException {

        final String mapBasicArraysAsStr = new ObjectMapper()
                .writeValueAsString(LEGACY2_MAP_BASIC_ARRAYS);

        final String objectBasicArraysAsStr = new ObjectMapper()
                .writeValueAsString(LEGACY2_OBJECT_BASIC_ARRAYS);

        final String expectation = "{\"null_array\":null,\"objects_array\":[{\"object_array_id\":\"aObjectArrayId\"},{\"object_array_id\":\"bObjectArrayId\"},{\"object_array_id\":\"cObjectArrayId\"},{\"object_array_id\":\"dObjectArrayId\"}],\"primitive\":\"aPrimitive\",\"primitives_array\":[\"aPrimitiveArray\",\"bPrimitiveArray\",\"cPrimitiveArray\",\"dPrimitiveArray\"]}";

        assertAll("Check Both Ways",
                () -> assertThat("Maps against Object", mapBasicArraysAsStr, is(equalTo(objectBasicArraysAsStr))),
                () -> assertThat("Maps against Expectation", mapBasicArraysAsStr, is(equalTo(expectation))),
                () -> assertThat("Object against Map", objectBasicArraysAsStr, is(equalTo(mapBasicArraysAsStr))),
                () -> assertThat("Object against Expectation", objectBasicArraysAsStr, is(equalTo(expectation)))
        );
    }

    @Test
    public void basicAttributes()
            throws JsonProcessingException {

        final String mapBasicAttributesAsStr = new ObjectMapper()
                .writeValueAsString(LEGACY2_MAP_BASIC_ATTRIBUTES);

        final String objectBasicAttributesAsStr = new ObjectMapper()
                .writeValueAsString(LEGACY2_OBJECT_BASIC_ATTRIBUTES);

        final String expectation = "{\"a_boolean\":true,\"a_float\":12.34,\"a_integer\":1234,\"a_null\":null,\"a_object\":{},\"a_string\":\"aValue\"}";

        assertAll("Check Both Ways",
                () -> assertThat("Maps against Object", mapBasicAttributesAsStr, is(equalTo(objectBasicAttributesAsStr))),
                () -> assertThat("Maps against Expectation", mapBasicAttributesAsStr, is(equalTo(expectation))),
                () -> assertThat("Object against Map", objectBasicAttributesAsStr, is(equalTo(mapBasicAttributesAsStr))),
                () -> assertThat("Object against Expectation", objectBasicAttributesAsStr, is(equalTo(expectation)))
        );
    }

}
