package com.github.nhojpatrick.cucumber.json.validation;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;

public class PathValidatorFactoryTest {

    @Test
    public void getInstance() {
        final PathValidator actual = PathValidatorFactory.getInstance();
        assertThat(actual, is(notNullValue()));
    }

}
