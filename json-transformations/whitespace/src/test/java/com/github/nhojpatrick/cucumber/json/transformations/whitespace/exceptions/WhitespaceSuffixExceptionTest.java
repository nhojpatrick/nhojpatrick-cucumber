package com.github.nhojpatrick.cucumber.json.transformations.whitespace.exceptions;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.function.Executable;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class WhitespaceSuffixExceptionTest {

    @TestFactory
    public Collection<DynamicTest> exceptions() {

        return Arrays.asList(

                DynamicTest.dynamicTest("message", () -> {
                    final Executable testMethod = () -> {
                        throw new WhitespaceSuffixException(-1);
                    };
                    final WhitespaceSuffixException expectedThrown = assertThrows(WhitespaceSuffixException.class, testMethod);
                    assertThat(expectedThrown.getMessage(), is(equalTo("Whitespace suffix must be positive but was -1.")));
                })

        );
    }

}
