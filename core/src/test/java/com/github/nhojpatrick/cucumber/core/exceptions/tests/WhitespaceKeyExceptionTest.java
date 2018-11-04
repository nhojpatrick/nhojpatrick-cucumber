package com.github.nhojpatrick.cucumber.core.exceptions.tests;

import com.github.nhojpatrick.cucumber.core.exceptions.WhitespaceKeyException;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.function.Executable;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class WhitespaceKeyExceptionTest {

    @TestFactory
    public Collection<DynamicTest> exceptions() {

        return Arrays.asList(

                DynamicTest.dynamicTest("default", () -> {
                    final Executable testMethod = () -> {
                        throw new WhitespaceKeyException();
                    };
                    final WhitespaceKeyException expectedThrown = assertThrows(WhitespaceKeyException.class, testMethod);
                    assertThat(expectedThrown.getMessage(), is(equalTo("Whitespace string Key.")));
                })

        );
    }

}
