package com.github.nhojpatrick.cucumber.core.exceptions.tests;

import com.github.nhojpatrick.cucumber.core.exceptions.TypeMismatchException;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.function.Executable;

import java.util.Arrays;
import java.util.Collection;

import static com.github.nhojpatrick.hamcrest.lang.IsThrowable.throwable;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

public class TypeMismatchExceptionTest {

    @TestFactory
    public Collection<DynamicTest> exceptions() {

        return Arrays.asList(

                dynamicTest("default", () -> {
                    final Executable testMethod = () -> {
                        throw new TypeMismatchException(String.class, new ClassCastException());
                    };
                    final TypeMismatchException thrown = assertThrows(TypeMismatchException.class, testMethod);
                    assertAll("Checking Exception",
                            () -> assertThat(thrown.getMessage(), is(equalTo("Run state value does not match requested type 'class java.lang.String'."))),
                            () -> assertThat(thrown.getCause(), is(throwable(ClassCastException.class)))
                    );
                })

        );
    }

}
