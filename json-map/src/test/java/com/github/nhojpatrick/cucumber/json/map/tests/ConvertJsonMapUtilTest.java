package com.github.nhojpatrick.cucumber.json.map.tests;

import com.github.nhojpatrick.cucumber.json.map.ConvertJsonMapUtil;
import com.github.nhojpatrick.cucumber.json.map.impl.ConvertMapToJson;
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
import static org.junit.jupiter.api.DynamicTest.dynamicTest;
import static org.mockito.Mockito.mock;

public class ConvertJsonMapUtilTest {

    @TestFactory
    @DisplayName("Constructor validation")
    public Collection<DynamicTest> constructorValidation() {

        return Arrays.asList(

                dynamicTest("Null ConvertMapToJson", () -> {
                    final Executable testMethod = () -> new ConvertJsonMapUtil(null, null);
                    final NullPointerException thrown = assertThrows(NullPointerException.class, testMethod);
                    assertAll("Checking Exception",
                            () -> assertThat(thrown.getMessage(), is(equalTo("ConvertMapToJson"))),
                            () -> assertThat(thrown.getCause(), is(nullValue()))
                    );
                }),

                dynamicTest("Null ConvertObjectToMap", () -> {
                    final Executable testMethod = () -> new ConvertJsonMapUtil(mock(ConvertMapToJson.class), null);
                    final NullPointerException thrown = assertThrows(NullPointerException.class, testMethod);
                    assertAll("Checking Exception",
                            () -> assertThat(thrown.getMessage(), is(equalTo("ConvertObjectToMap"))),
                            () -> assertThat(thrown.getCause(), is(nullValue()))
                    );
                }),

                dynamicTest("Success args constructor", () -> {
                    final ConvertJsonMapUtil classUnderTest = new ConvertJsonMapUtil(mock(ConvertMapToJson.class), mock(ConvertObjectToMap.class));
                    assertThat(classUnderTest, is(notNullValue()));
                }),

                dynamicTest("Success args formatJson constructor", () -> {
                    final ConvertJsonMapUtil classUnderTest = new ConvertJsonMapUtil(false);
                    assertThat(classUnderTest, is(notNullValue()));
                }),

                dynamicTest("Success no-args constructor", () -> {
                    final ConvertJsonMapUtil classUnderTest = new ConvertJsonMapUtil();
                    assertThat(classUnderTest, is(notNullValue()));
                })

        );

    }

}
