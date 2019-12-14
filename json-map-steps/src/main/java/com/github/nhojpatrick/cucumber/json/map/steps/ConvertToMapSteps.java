package com.github.nhojpatrick.cucumber.json.map.steps;

import com.github.nhojpatrick.cucumber.core.exceptions.IllegalKeyException;
import com.github.nhojpatrick.cucumber.core.exceptions.IllegalTypeClassException;
import com.github.nhojpatrick.cucumber.core.exceptions.TypeMismatchException;
import com.github.nhojpatrick.cucumber.json.map.ConvertToMap;
import com.github.nhojpatrick.cucumber.state.RunState;
import com.github.nhojpatrick.cucumber.state.exceptions.NullRunStateException;
import com.github.nhojpatrick.cucumber.state.validation.RunStateValidatorFactory;
import com.google.inject.Inject;
import io.cucumber.java.en.Given;

import java.util.Map;

import static com.github.nhojpatrick.cucumber.json.map.ConvertToMapConstants.DEFAULT_MAP_KEY;
import static com.github.nhojpatrick.cucumber.json.map.ConvertToMapConstants.DEFAULT_OBJECT_KEY;

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

        convertToMap(DEFAULT_OBJECT_KEY, DEFAULT_MAP_KEY);
    }

    @Given("I convert object using RunStateKey {string}, to json map using RunStateKey {string}")
    public void convertToMap(final String runStateObjectKey, final String runStateJsonMapKey)
            throws IllegalKeyException,
            IllegalTypeClassException,
            NullRunStateException,
            TypeMismatchException {

        RunStateValidatorFactory.getInstance()
                .withNull(runStateJsonMapKey)
                .withValue(runStateObjectKey)
                .verify(this.runState);

        final Object obj = this.runState.get(runStateObjectKey, Object.class);
        final ConvertToMap convertToMap = new ConvertToMap();
        final Map<String, Object> runStateJsonMapValue = convertToMap.apply(obj);
        this.runState.set(runStateJsonMapKey, runStateJsonMapValue);
    }

}
