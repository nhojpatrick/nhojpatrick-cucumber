package com.github.nhojpatrick.cucumber.json.exceptions;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.function.Executable;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class UnsupportedDataTypeExceptionTest {

    @TestFactory
    public Collection<DynamicTest> exceptions() {

        return Arrays.asList(

                DynamicTest.dynamicTest("type", () -> {
                    final Executable testMethod = () -> {
                        throw new UnsupportedDataTypeException("Type");
                    };
                    final UnsupportedDataTypeException expectedThrown = assertThrows(UnsupportedDataTypeException.class, testMethod);
                    assertAll(
                            () -> assertThat(expectedThrown.getMessage(), is(equalTo(String.format(UnsupportedDataTypeException.UNSUPPORTED_DATA_TYPE_MSG, "Type")))),
                            () -> assertThat(expectedThrown.getCause(), is(nullValue()))
                    );
                })

        );
    }

}
