package com.github.nhojpatrick.cucumber.json.steps.map;

import com.github.nhojpatrick.cucumber.json.map.steps.ConvertToMapSteps;
import com.github.nhojpatrick.cucumber.state.RunState;
import com.google.inject.Inject;
import io.cucumber.java.en.Given;
import org.junit.jupiter.api.function.Executable;

import static com.github.nhojpatrick.cucumber.json.map.ConvertToMapConstants.DEFAULT_MAP_KEY;
import static com.github.nhojpatrick.cucumber.json.map.ConvertToMapConstants.DEFAULT_OBJECT_KEY;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MapJsonCucumberSteps {

    private RunState runState;

    @Inject
    public MapJsonCucumberSteps(final RunState runState) {
        this.runState = runState;
    }

    @Given("I convert object to json map using default RunStateKeys produces the AssertionError {string}")
    public void convertToMap_AssertionError(final String expectedExceptionMessageRaw) {

        convertToMap_AssertionError(DEFAULT_OBJECT_KEY, DEFAULT_MAP_KEY, expectedExceptionMessageRaw);
    }

    @Given("I convert object using RunStateKey {string}, to json map using RunStateKey {string} produces the AssertionError {string}")
    public void convertToMap_AssertionError(final String runStateObjectKey, final String runStateJsonMapKey, final String expectedExceptionMessageRaw) {

        final ConvertToMapSteps convertToMapSteps = new ConvertToMapSteps(this.runState);
        final Executable testMethod = () -> convertToMapSteps.convertToMap(runStateObjectKey, runStateJsonMapKey);
        final AssertionError expectedThrown = assertThrows(AssertionError.class, testMethod);
        final String expectedExceptionMessage = expectedExceptionMessageRaw
                .replace("\\t", "\t")
                .replace("\\n", "\n");
        assertThat(expectedThrown.getMessage(), is(equalTo(expectedExceptionMessage)));
    }

    @Given("I convert object to json map using default RunStateKeys produces the IllegalArgumentException {string}")
    public void convertToMap_IllegalArgumentException(final String expectedExceptionMessageRaw) {

        convertToMap_IllegalArgumentException(DEFAULT_OBJECT_KEY, DEFAULT_MAP_KEY, expectedExceptionMessageRaw);
    }

    @Given("I convert object using RunStateKey {string}, to json map using RunStateKey {string} produces the IllegalArgumentException {string}")
    public void convertToMap_IllegalArgumentException(final String runStateObjectKey, final String runStateJsonMapKey, final String expectedExceptionMessageRaw) {

        final ConvertToMapSteps convertToMapSteps = new ConvertToMapSteps(this.runState);
        final Executable testMethod = () -> convertToMapSteps.convertToMap(runStateObjectKey, runStateJsonMapKey);
        final IllegalArgumentException expectedThrown = assertThrows(IllegalArgumentException.class, testMethod);
        final String expectedExceptionMessage = expectedExceptionMessageRaw
                .replace("\\t", "\t")
                .replace("\\n", "\n");
        assertThat(expectedThrown.getMessage(), is(equalTo(expectedExceptionMessage)));
    }

}
