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
import static org.junit.jupiter.api.Assertions.assertThrows;

public class NullGenericsValueExceptionTest {

    @TestFactory
    public Collection<DynamicTest> exceptions() {

        return Arrays.asList(

                DynamicTest.dynamicTest("default", () -> {
                    final Executable testMethod = () -> {
                        throw new NullGenericsValueException();
                    };
                    final NullGenericsValueException expectedThrown = assertThrows(NullGenericsValueException.class, testMethod);
                    assertThat(expectedThrown.getMessage(), is(equalTo("Null Generics Value Type.")));
                })

        );
    }

}
