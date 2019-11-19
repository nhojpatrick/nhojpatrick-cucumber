package com.github.nhojpatrick.cucumber.json.core.validation;

import com.github.nhojpatrick.cucumber.json.core.validation.impl.PathElementImpl;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNot.not;

public class PathElementImplTest {

    @TestFactory
    public Collection<DynamicTest> tests() {

        return Arrays.asList(

                DynamicTest.dynamicTest("equals - null", () -> {
                    final PathElementImpl classUnderTest = new PathElementImpl("abc");
                    assertThat(classUnderTest, is(not(equalTo(null))));
                }),

                DynamicTest.dynamicTest("equals - String", () -> {
                    final PathElementImpl classUnderTest = new PathElementImpl("abc");
                    assertThat(classUnderTest, is(not(equalTo(""))));
                })

        );
    }

}
