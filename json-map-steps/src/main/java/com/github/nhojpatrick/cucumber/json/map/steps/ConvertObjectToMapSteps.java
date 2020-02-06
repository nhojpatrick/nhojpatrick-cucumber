package com.github.nhojpatrick.cucumber.json.map.steps;

import com.github.nhojpatrick.cucumber.core.exceptions.IllegalKeyException;
import com.github.nhojpatrick.cucumber.core.exceptions.IllegalTypeClassException;
import com.github.nhojpatrick.cucumber.core.exceptions.TypeMismatchException;
import com.github.nhojpatrick.cucumber.json.map.ConvertJsonMapUtil;
import com.github.nhojpatrick.cucumber.state.RunState;
import com.github.nhojpatrick.cucumber.state.exceptions.NullRunStateException;
import com.google.inject.Inject;
import io.cucumber.java.en.Given;

import static com.github.nhojpatrick.cucumber.json.map.ConvertJsonMapConstants.DEFAULT_JSON_MAP_KEY;
import static com.github.nhojpatrick.cucumber.json.map.ConvertJsonMapConstants.DEFAULT_JSON_OBJECT_KEY;

public class ConvertObjectToMapSteps {

    private final RunState runState;

    @Inject
    public ConvertObjectToMapSteps(final RunState runState) {
        this.runState = runState;
    }

    @Given("^I convert object to json map using default RunStateKeys$")
    public void convertObjectToMap()
            throws IllegalKeyException,
            IllegalTypeClassException,
            NullRunStateException,
            TypeMismatchException {

        convertObjectToMap(DEFAULT_JSON_OBJECT_KEY, DEFAULT_JSON_MAP_KEY);
    }

    @Given("I convert object using RunStateKey {string}, to json map using RunStateKey {string}")
    public void convertObjectToMap(final String runStateObjectKey, final String runStateJsonMapKey)
            throws IllegalKeyException,
            IllegalTypeClassException,
            NullRunStateException,
            TypeMismatchException {

        new ConvertJsonMapUtil()
                .convertObjectToMap(
                        this.runState,
                        runStateObjectKey,
                        runStateJsonMapKey
                );
    }

}
