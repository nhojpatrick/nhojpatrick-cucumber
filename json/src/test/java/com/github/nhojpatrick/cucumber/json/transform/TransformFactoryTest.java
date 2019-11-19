package com.github.nhojpatrick.cucumber.json.transform;

import com.github.nhojpatrick.cucumber.json.core.transform.Transform;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;

public class TransformFactoryTest {

    @Test
    public void getInstance() {
        final Transform actual = TransformFactory.getInstance();
        assertThat(actual, is(notNullValue()));
    }

}
