package com.github.nhojpatrick.cucumber.core.exceptions.tests;

import com.github.nhojpatrick.cucumber.core.exceptions.NullGenericsKeyException;
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

public class NullGenericsKeyExceptionTest {

    @TestFactory
    public Collection<DynamicTest> exceptions() {

        return Arrays.asList(

                DynamicTest.dynamicTest("default", () -> {
                    final Executable testMethod = () -> {
                        throw new NullGenericsKeyException();
                    };
                    final NullGenericsKeyException expectedThrown = assertThrows(NullGenericsKeyException.class, testMethod);
                    assertAll("Checking Exception",
                            () -> assertThat(expectedThrown.getMessage(), is(equalTo("Null Generics Key Type."))),
                            () -> assertThat(expectedThrown.getCause(), is(nullValue()))
                    );
                })

        );
    }

}
