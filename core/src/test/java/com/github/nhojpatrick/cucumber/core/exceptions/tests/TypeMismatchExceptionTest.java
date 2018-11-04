package com.github.nhojpatrick.cucumber.core.exceptions.tests;

import com.github.nhojpatrick.cucumber.core.exceptions.TypeMismatchException;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.function.Executable;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TypeMismatchExceptionTest {

    @TestFactory
    public Collection<DynamicTest> exceptions() {

        return Arrays.asList(

                DynamicTest.dynamicTest("default", () -> {
                    final ClassCastException cause = new ClassCastException();
                    final Executable testMethod = () -> {
                        throw new TypeMismatchException(String.class, cause);
                    };
                    final TypeMismatchException expectedThrown = assertThrows(TypeMismatchException.class, testMethod);
                    assertAll("Checking Exception",
                            () -> assertThat(expectedThrown.getMessage(), is(equalTo("Run state value does not match requested type 'class java.lang.String'."))),
                            () -> assertThat(expectedThrown.getCause(), is(equalTo(cause)))
                    );
                })

        );
    }

}
