package com.github.nhojpatrick.cucumber.json.core.castto.exceptions.tests;

import com.github.nhojpatrick.cucumber.json.core.castto.exceptions.UnsupportedDataTypeException;
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

public class UnsupportedDataTypeExceptionTest {

    @TestFactory
    public Collection<DynamicTest> exceptions() {

        return Arrays.asList(

                dynamicTest("type", () -> {
                    final Executable testMethod = () -> {
                        throw new UnsupportedDataTypeException("Type");
                    };
                    final UnsupportedDataTypeException thrown = assertThrows(UnsupportedDataTypeException.class, testMethod);
                    assertAll(
                            () -> assertThat(thrown.getMessage(), is(equalTo(String.format(UnsupportedDataTypeException.UNSUPPORTED_DATA_TYPE_MSG, "Type")))),
                            () -> assertThat(thrown.getCause(), is(nullValue()))
                    );
                })

        );
    }

}
