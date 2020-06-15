package com.github.nhojpatrick.cucumber.json.map.impl.tests;

import com.github.nhojpatrick.cucumber.core.exceptions.NullObjectException;
import com.github.nhojpatrick.cucumber.json.map.impl.ConvertObjectToMap;
import com.github.nhojpatrick.cucumber.testing.internal.objects.BasicArraysOuterObj;
import com.github.nhojpatrick.cucumber.testing.internal.objects.BasicAttributesOuterObj;
import com.github.nhojpatrick.cucumber.testing.internal.objects.TestingInternalObjectsConstants;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.util.Map;

import static com.github.nhojpatrick.hamcrest.lang.IsThrowable.throwable;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ConvertObjectToMapTest {

    private ConvertObjectToMap classUnderTest;

    @BeforeEach
    public void beforeEach() {
        this.classUnderTest = new ConvertObjectToMap();
    }

    @Test
    public void check_null() {

        final Executable testMethod = () -> this.classUnderTest.apply(null);

        final RuntimeException thrown = assertThrows(RuntimeException.class, testMethod);
        assertAll("Checking Exception",
                () -> MatcherAssert.assertThat(thrown.getCause(), is(throwable(NullObjectException.class, "Null object.")))
        );
    }

    @Test
    public void check_StringEmpty() {

        final Executable testMethod = () -> this.classUnderTest.apply("");

        final IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, testMethod);

        final String expectedMessage = "Cannot construct instance of `java.util.LinkedHashMap` (although at least one Creator exists): no String-argument constructor/factory method to deserialize from String value ('')\n at [Source: UNKNOWN; line: -1, column: -1]";
        assertThat(thrown.getMessage(), is(equalTo(expectedMessage)));
    }

    @Test
    public void check_BasicArraysObj() {

        final BasicArraysOuterObj toBeTested = TestingInternalObjectsConstants.OBJECT_BASIC_ARRAYS;

        final Map<String, Object> expected = TestingInternalObjectsConstants.MAP_BASIC_ARRAYS;

        final Map<String, Object> actual = this.classUnderTest.apply(toBeTested);

        assertThat(actual, is(equalTo(expected)));
    }

    @Test
    public void check_BasicAttributesObj() {

        final BasicAttributesOuterObj toBeTested = TestingInternalObjectsConstants.OBJECT_BASIC_ATTRIBUTES;

        final Map<String, Object> expected = TestingInternalObjectsConstants.MAP_BASIC_ATTRIBUTES;

        final Map<String, Object> actual = this.classUnderTest.apply(toBeTested);

        assertThat(actual, is(equalTo(expected)));
    }

}
