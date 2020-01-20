package com.github.nhojpatrick.cucumber.testing.internal.objects;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import static com.github.nhojpatrick.cucumber.testing.internal.objects.TestingInternalObjectsConstants.MAP_BASIC_ARRAYS;
import static com.github.nhojpatrick.cucumber.testing.internal.objects.TestingInternalObjectsConstants.OBJECT_BASIC_ARRAYS;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.jupiter.api.Assertions.assertAll;

public class TestingInternalObjectsConstantsTest {

    @Test
    public void basicArrays()
            throws JsonProcessingException {

        final String mapBasicArraysAsStr = new ObjectMapper()
                .writeValueAsString(MAP_BASIC_ARRAYS);

        final String objectBasicArraysAsStr = new ObjectMapper()
                .writeValueAsString(OBJECT_BASIC_ARRAYS);

        final String expectation = new StringBuilder()
                .append("{")
                .append("\"")
                .append(BasicArraysOuterObj.OBJECTS_ARRAY)
                .append("\":[")
                .append("{\"object_array_id\":\"aObjectArrayId\"},")
                .append("{\"object_array_id\":\"bObjectArrayId\"},")
                .append("{\"object_array_id\":\"cObjectArrayId\"},")
                .append("{\"object_array_id\":\"dObjectArrayId\"}")
                .append("],\"")
                .append(BasicArraysOuterObj.OBJECTS_EMPTY)
                .append("\":[],\"")
                .append(BasicArraysOuterObj.OBJECTS_NULL)
                .append("\":null,\"")
                .append(BasicArraysOuterObj.PRIMITIVES_ARRAY)
                .append("\":[")
                .append("\"aPrimitiveArray\",")
                .append("\"bPrimitiveArray\",")
                .append("\"cPrimitiveArray\",")
                .append("\"dPrimitiveArray\"")
                .append("],\"")
                .append(BasicArraysOuterObj.PRIMITIVES_EMPTY)
                .append("\":[],\"")
                .append(BasicArraysOuterObj.PRIMITIVES_NULL)
                .append("\":null")
                .append("}")
                .toString();

        assertAll("Check Both Ways",
                () -> assertThat("Maps against Object", mapBasicArraysAsStr, is(equalTo(objectBasicArraysAsStr))),
                () -> assertThat("Maps against Expectation", mapBasicArraysAsStr, is(equalTo(expectation))),
                () -> assertThat("Object against Map", objectBasicArraysAsStr, is(equalTo(mapBasicArraysAsStr))),
                () -> assertThat("Object against Expectation", objectBasicArraysAsStr, is(equalTo(expectation)))
        );
    }

}
