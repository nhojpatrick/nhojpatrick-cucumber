package com.github.nhojpatrick.cucumber.json.core.castto.exceptions.tests;

import com.github.nhojpatrick.cucumber.json.core.castto.exceptions.UnsupportedDataTypeConversionException;
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
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

public class UnsupportedDataTypeConversionExceptionTest {

    @TestFactory
    public Collection<DynamicTest> exceptions() {

        return Arrays.asList(

                dynamicTest("type, value", () -> {
                    final Executable testMethod = () -> {
                        throw new UnsupportedDataTypeConversionException("Type", "Value");
                    };
                    final UnsupportedDataTypeConversionException thrown = assertThrows(UnsupportedDataTypeConversionException.class, testMethod);
                    assertAll(
                            () -> assertThat(thrown.getMessage(), is(equalTo(String.format(UnsupportedDataTypeConversionException.UNSUPPORTED_DATA_TYPE_CONVERSION_MSG, "Type", "Value")))),
                            () -> assertThat(thrown.getCause(), is(nullValue()))
                    );
                }),

                dynamicTest("type, value Throwable", () -> {
                    final Throwable cause = new Throwable();
                    final Executable testMethod = () -> {
                        throw new UnsupportedDataTypeConversionException("Type", "Value", cause);
                    };
                    final UnsupportedDataTypeConversionException thrown = assertThrows(UnsupportedDataTypeConversionException.class, testMethod);
                    assertAll(
                            () -> assertThat(thrown.getMessage(), is(equalTo(String.format(UnsupportedDataTypeConversionException.UNSUPPORTED_DATA_TYPE_CONVERSION_MSG, "Type", "Value")))),
                            () -> assertThat(thrown.getCause(), is(equalTo(cause)))
                    );
                })

        );
    }

}
