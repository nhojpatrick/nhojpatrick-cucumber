package com.github.nhojpatrick.cucumber.core.exceptions.tests;

import com.github.nhojpatrick.cucumber.core.exceptions.NullGenericsValueException;
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

public class NullGenericsValueExceptionTest {

    @TestFactory
    public Collection<DynamicTest> exceptions() {

        return Arrays.asList(

                dynamicTest("default", () -> {
                    final Executable testMethod = () -> {
                        throw new NullGenericsValueException();
                    };
                    final NullGenericsValueException thrown = assertThrows(NullGenericsValueException.class, testMethod);
                    assertAll("Checking Exception",
                            () -> assertThat(thrown.getMessage(), is(equalTo("Null Generics Value Type."))),
                            () -> assertThat(thrown.getCause(), is(nullValue()))
                    );
                })

        );
    }

}
