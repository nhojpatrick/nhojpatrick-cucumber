package com.github.nhojpatrick.cucumber.json.validation;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNot.not;

public class PathArrayElementImplTest {

    @TestFactory
    public Collection<DynamicTest> tests() {

        final PathElement classUnderTest = new PathArrayElementImpl("abc[1]", "abc", 1);

        return Arrays.asList(

                DynamicTest.dynamicTest("equals - null", () -> {
                    assertThat(classUnderTest, is(not(equalTo(null))));
                }),

                DynamicTest.dynamicTest("equals - null", () -> {
                    assertThat(classUnderTest, is(not(equalTo(null))));
                }),

                DynamicTest.dynamicTest("getArrayIndex matches", () -> {
                    assertThat(classUnderTest.getArrayIndex(), is(equalTo(1)));
                }),

                DynamicTest.dynamicTest("getArrayIndex no match", () -> {
                    assertThat(classUnderTest.getArrayIndex(), is(not(equalTo(0))));
                })

        );
    }

}
