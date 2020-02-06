package com.github.nhojpatrick.cucumber.json.transform;

import com.github.nhojpatrick.cucumber.json.map.ConvertJsonMapConstants;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.jupiter.api.Assertions.assertAll;

public class TransformConstantsTest {

    @Test
    public void defaultMapKey() {

        assertAll("Checking Constant DEFAULT_MAP_KEY",
                () -> assertThat("Not as ConvertJsonMapConstants", TransformConstants.DEFAULT_MAP_KEY, is(equalTo(ConvertJsonMapConstants.DEFAULT_JSON_MAP_KEY))),
                () -> assertThat("Not as expected", TransformConstants.DEFAULT_MAP_KEY, is(equalTo("runState.json.map")))
        );
    }

}
