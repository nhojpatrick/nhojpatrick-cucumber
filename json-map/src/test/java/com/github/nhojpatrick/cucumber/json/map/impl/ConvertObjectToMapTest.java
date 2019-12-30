package com.github.nhojpatrick.cucumber.json.map.impl;

import com.github.nhojpatrick.cucumber.core.exceptions.NullObjectException;
import com.github.nhojpatrick.cucumber.testing.internal.objects.legacy.LegacyTestingInternalObjectsConstants;
import com.github.nhojpatrick.cucumber.testing.internal.objects.legacy.MyComplexObj;
import com.github.nhojpatrick.cucumber.testing.internal.objects.legacy.MySimpleObj;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.util.List;
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

        final String expectedMessage = "Cannot construct instance of `java.util.HashMap` (although at least one Creator exists): no String-argument constructor/factory method to deserialize from String value ('')\n at [Source: UNKNOWN; line: -1, column: -1]";
        assertThat(thrown.getMessage(), is(equalTo(expectedMessage)));
    }

    @Test
    public void check_MyComplexObj() {

        final MyComplexObj toBeTested = LegacyTestingInternalObjectsConstants.COMPLEX_OBJECT_AS_OBJECT;

        final Map<String, Object> expected = LegacyTestingInternalObjectsConstants.COMPLEX_OBJECT_AS_JSON_MAP;

        final Map<String, Object> actual = this.classUnderTest.apply(toBeTested);

        assertAll(
                () -> assertThat("whole object", actual, is(equalTo(expected))),
                () -> assertAll("nested",
                        () -> {
                            final Map<String, Object> actualNested = (Map<String, Object>) actual.get("nested");
                            final Map<String, Object> expectedNested = (Map<String, Object>) expected.get("nested");
                            assertThat("whole nested", actualNested, is(equalTo(expectedNested)));
                            assertAll("nests",
                                    () -> {
                                        final List<Map<String, Object>> actualNests = (List<Map<String, Object>>) actualNested.get("nests");
                                        final List<Map<String, Object>> expectedNests = (List<Map<String, Object>>) expectedNested.get("nests");
                                        assertThat("whole nests", actualNests, is(equalTo(expectedNests)));
                                    }
                            );
                        }
                ),
                () -> assertThat("objs", actual.get("objs"), is(equalTo(expected.get("objs"))))
        );
    }

    @Test
    public void check_MySimpleObj() {

        final MySimpleObj toBeTested = LegacyTestingInternalObjectsConstants.SIMPLE_OBJECT_AS_OBJECT;

        final Map<String, Object> expected = LegacyTestingInternalObjectsConstants.SIMPLE_OBJECT_AS_JSON_MAP;

        final Map<String, Object> actual = this.classUnderTest.apply(toBeTested);

        assertThat(actual, is(equalTo(expected)));
    }

}
