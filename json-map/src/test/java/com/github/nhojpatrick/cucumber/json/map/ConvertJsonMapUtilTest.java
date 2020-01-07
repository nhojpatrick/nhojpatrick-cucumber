package com.github.nhojpatrick.cucumber.json.map;

import com.github.nhojpatrick.cucumber.json.map.impl.ConvertObjectToMap;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.function.Executable;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;

public class ConvertJsonMapUtilTest {

    @TestFactory
    @DisplayName("Constructor validation")
    public Collection<DynamicTest> constructorValidation() {

        return Arrays.asList(

                DynamicTest.dynamicTest("Null ConvertObjectToMap", () -> {
                    final Executable testMethod = () -> new ConvertJsonMapUtil(null);
                    final NullPointerException thrown = assertThrows(NullPointerException.class, testMethod);
                    assertAll("Checking Exception",
                            () -> assertThat(thrown.getMessage(), is(equalTo("ConvertObjectToMap"))),
                            () -> assertThat(thrown.getCause(), is(nullValue()))
                    );
                }),

                DynamicTest.dynamicTest("Success args constructor", () -> {
                    final ConvertJsonMapUtil classUnderTest = new ConvertJsonMapUtil(mock(ConvertObjectToMap.class));
                    assertThat(classUnderTest, is(notNullValue()));
                }),

                DynamicTest.dynamicTest("Success no-args constructor", () -> {
                    final ConvertJsonMapUtil classUnderTest = new ConvertJsonMapUtil();
                    assertThat(classUnderTest, is(notNullValue()));
                })

        );

    }

}
