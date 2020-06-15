package com.github.nhojpatrick.cucumber.json.transform.factory.tests;

import com.github.nhojpatrick.cucumber.json.core.transform.Transform;
import com.github.nhojpatrick.cucumber.json.transform.factory.TransformFactory;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNull.notNullValue;

public class TransformFactoryTest {

    @Test
    public void get() {
        final TransformFactory factory = TransformFactory.getFactory();
        final Transform actual = factory.get();
        assertThat(actual, is(notNullValue()));
    }

    @Test
    public void getFactory() {
        final TransformFactory actual = TransformFactory.getFactory();
        assertThat(actual, is(notNullValue()));
    }

    @Test
    public void singleFactory() {
        final TransformFactory first = TransformFactory.getFactory();
        final TransformFactory second = TransformFactory.getFactory();
        assertThat(first, is(equalTo(second)));
    }

}
