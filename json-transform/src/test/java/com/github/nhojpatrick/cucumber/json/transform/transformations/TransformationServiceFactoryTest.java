package com.github.nhojpatrick.cucumber.json.transform.transformations;

import com.github.nhojpatrick.cucumber.json.core.transform.TransformationService;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;

import static com.github.nhojpatrick.hamcrest.optionals.IsOptional.optionalIsEmpty;
import static com.github.nhojpatrick.hamcrest.optionals.IsOptional.optionalIsPresent;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNull.notNullValue;

public class TransformationServiceFactoryTest {

    @Test
    public void getInstance() {
        final TransformationServiceFactory actual = TransformationServiceFactory.getFactory();
        assertThat(actual, is(notNullValue()));
    }

    @Test
    public void singleInstance() {
        final TransformationServiceFactory first = TransformationServiceFactory.getFactory();
        final TransformationServiceFactory second = TransformationServiceFactory.getFactory();
        assertThat(first, is(equalTo(second)));
    }

    @TestFactory
    public Collection<DynamicTest> resolve() {

        return Arrays.asList(

                DynamicTest.dynamicTest("Resolve Null", () -> {
                    final TransformationServiceFactory transformationServiceFactory = TransformationServiceFactory.getFactory();
                    final Optional<TransformationService> actual = transformationServiceFactory.resolve(null);
                    assertThat("TransformationService", actual, optionalIsEmpty());
                }),

                DynamicTest.dynamicTest("Resolve Remove", () -> {
                    final TransformationServiceFactory transformationServiceFactory = TransformationServiceFactory.getFactory();
                    final Optional<TransformationService> actual = transformationServiceFactory.resolve("Remove");
                    assertThat("TransformationService", actual, optionalIsPresent());
                    assertThat("TransformationService", actual.get().getAction(), is(equalTo("Remove")));
                }),

                DynamicTest.dynamicTest("Resolve Remove WeridCase", () -> {
                    final TransformationServiceFactory transformationServiceFactory = TransformationServiceFactory.getFactory();
                    final Optional<TransformationService> actual = transformationServiceFactory.resolve("ReMoVe");
                    assertThat("TransformationService", actual, optionalIsPresent());
                    assertThat("TransformationService", actual.get().getAction(), is(equalTo("Remove")));
                })

        );
    }

}
