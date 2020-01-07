package com.github.nhojpatrick.cucumber.json.map.steps;

import com.github.nhojpatrick.cucumber.core.exceptions.IllegalKeyException;
import com.github.nhojpatrick.cucumber.core.exceptions.IllegalTypeClassException;
import com.github.nhojpatrick.cucumber.core.exceptions.TypeMismatchException;
import com.github.nhojpatrick.cucumber.json.map.ConvertToMapUtil;
import com.github.nhojpatrick.cucumber.state.RunState;
import com.github.nhojpatrick.cucumber.state.exceptions.NullRunStateException;
import com.google.inject.Inject;
import io.cucumber.java.en.Given;

import static com.github.nhojpatrick.cucumber.json.map.ConvertToMapConstants.DEFAULT_JSON_MAP_KEY;
import static com.github.nhojpatrick.cucumber.json.map.ConvertToMapConstants.DEFAULT_JSON_OBJECT_KEY;

public class ConvertToMapSteps {

    private final RunState runState;

    @Inject
    public ConvertToMapSteps(final RunState runState) {
        this.runState = runState;
    }

    @Given("^I convert object to json map using default RunStateKeys$")
    public void convertToMap()
            throws IllegalKeyException,
            IllegalTypeClassException,
            NullRunStateException,
            TypeMismatchException {

        convertToMap(DEFAULT_JSON_OBJECT_KEY, DEFAULT_JSON_MAP_KEY);
    }

    @Given("I convert object using RunStateKey {string}, to json map using RunStateKey {string}")
    public void convertToMap(final String runStateObjectKey, final String runStateJsonMapKey)
            throws IllegalKeyException,
            IllegalTypeClassException,
            NullRunStateException,
            TypeMismatchException {

        new ConvertToMapUtil()
                .convertToMap(this.runState,
                        runStateObjectKey,
                        runStateJsonMapKey);
    }

}
