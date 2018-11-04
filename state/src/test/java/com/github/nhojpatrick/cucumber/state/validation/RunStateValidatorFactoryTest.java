package com.github.nhojpatrick.cucumber.state.validation;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;

public class RunStateValidatorFactoryTest {

    @Test
    public void get() {

        final RunStateValidator actual = RunStateValidatorFactory.getInstance();

        assertThat(actual, is(notNullValue()));
    }

    @Test
    public void getInstance() {

        final RunStateValidator actual = new RunStateValidatorFactory()
                .get();

        assertThat(actual, is(notNullValue()));
    }

}
