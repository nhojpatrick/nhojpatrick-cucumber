package com.github.nhojpatrick.cucumber.testing.internal.steps.json.map;

import com.github.nhojpatrick.cucumber.json.map.ConvertToMapUtil;
import com.github.nhojpatrick.cucumber.state.RunState;
import com.google.inject.Inject;
import io.cucumber.java.en.Given;
import org.junit.jupiter.api.function.Executable;

import static com.github.nhojpatrick.cucumber.json.map.ConvertToMapConstants.DEFAULT_JSON_MAP_KEY;
import static com.github.nhojpatrick.cucumber.json.map.ConvertToMapConstants.DEFAULT_JSON_OBJECT_KEY;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MapJsonCucumberSteps {

    private RunState runState;

    @Inject
    public MapJsonCucumberSteps(final RunState runState) {
        this.runState = runState;
    }

    @Given("I convert object to json map using default RunStateKeys produces the AssertionError {string}")
    public void convertToMap_AssertionError(final String expectedExceptionMessageRaw) {

        convertToMap_AssertionError(
                DEFAULT_JSON_OBJECT_KEY,
                DEFAULT_JSON_MAP_KEY,
                expectedExceptionMessageRaw
        );
    }

    @Given("I convert object using RunStateKey {string}, to json map using RunStateKey {string} produces the AssertionError {string}")
    public void convertToMap_AssertionError(final String runStateObjectKey,
                                            final String runStateJsonMapKey,
                                            final String expectedExceptionMessageRaw) {

        final ConvertToMapUtil convertToMapUtil = new ConvertToMapUtil();
        final Executable testMethod = () -> convertToMapUtil.convertToMap(
                this.runState,
                runStateObjectKey,
                runStateJsonMapKey);
        final AssertionError thrown = assertThrows(AssertionError.class, testMethod);
        final String expectedExceptionMessage = expectedExceptionMessageRaw
                .replace("\\t", "\t")
                .replace("\\n", "\n");
        assertThat(thrown.getMessage(), is(equalTo(expectedExceptionMessage)));
    }

    @Given("I convert object to json map using default RunStateKeys produces the IllegalArgumentException {string}")
    public void convertToMap_IllegalArgumentException(final String expectedExceptionMessageRaw) {

        convertToMap_IllegalArgumentException(
                DEFAULT_JSON_OBJECT_KEY,
                DEFAULT_JSON_MAP_KEY,
                expectedExceptionMessageRaw
        );
    }

    @Given("I convert object using RunStateKey {string}, to json map using RunStateKey {string} produces the IllegalArgumentException {string}")
    public void convertToMap_IllegalArgumentException(final String runStateObjectKey,
                                                      final String runStateJsonMapKey,
                                                      final String expectedExceptionMessageRaw) {

        final ConvertToMapUtil convertToMapUtil = new ConvertToMapUtil();
        final Executable testMethod = () -> convertToMapUtil.convertToMap(
                this.runState,
                runStateObjectKey,
                runStateJsonMapKey);
        final IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, testMethod);
        final String expectedExceptionMessage = expectedExceptionMessageRaw
                .replace("\\t", "\t")
                .replace("\\n", "\n");
        assertThat(thrown.getMessage(), is(equalTo(expectedExceptionMessage)));
    }

}
