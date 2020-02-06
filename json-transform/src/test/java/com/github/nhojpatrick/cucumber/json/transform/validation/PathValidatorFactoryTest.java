package com.github.nhojpatrick.cucumber.json.transform.validation;

import com.github.nhojpatrick.cucumber.json.core.validation.PathValidator;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNull.notNullValue;

public class PathValidatorFactoryTest {

    @Test
    public void get() {
        final PathValidatorFactory factory = PathValidatorFactory.getFactory();
        final PathValidator actual = factory.get();
        assertThat(actual, is(notNullValue()));
    }

    @Test
    public void getFactory() {
        final PathValidatorFactory actual = PathValidatorFactory.getFactory();
        assertThat(actual, is(notNullValue()));
    }

    @Test
    public void singleFactory() {
        final PathValidatorFactory first = PathValidatorFactory.getFactory();
        final PathValidatorFactory second = PathValidatorFactory.getFactory();
        assertThat(first, is(equalTo(second)));
    }

}
