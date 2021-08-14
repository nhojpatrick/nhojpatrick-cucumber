package com.github.nhojpatrick.cucumber.json.map.steps;

import com.github.nhojpatrick.cucumber.core.exceptions.IllegalKeyException;
import com.github.nhojpatrick.cucumber.core.exceptions.IllegalTypeClassException;
import com.github.nhojpatrick.cucumber.core.exceptions.TypeMismatchException;
import com.github.nhojpatrick.cucumber.json.map.ConvertJsonMapUtil;
import com.github.nhojpatrick.cucumber.state.RunState;
import com.github.nhojpatrick.cucumber.state.exceptions.NullRunStateException;
import com.google.inject.Inject;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import io.cucumber.java.en.Given;

import static com.github.nhojpatrick.cucumber.json.map.ConvertJsonMapConstants.DEFAULT_JSON_MAP_KEY;
import static com.github.nhojpatrick.cucumber.json.map.ConvertJsonMapConstants.DEFAULT_JSON_STRING_KEY;

@SuppressFBWarnings(value = "EI_EXPOSE_REP2", justification = "Accepted will look at changing")
public class ConvertMapToJsonSteps {

    private final RunState runState;

    @Inject
    public ConvertMapToJsonSteps(final RunState runState) {
        this.runState = runState;
    }

    @Given("^I convert json map to json string using default RunStateKeys$")
    public void convertMapToJson()
            throws IllegalKeyException,
            IllegalTypeClassException,
            NullRunStateException,
            TypeMismatchException {

        convertMapToJsonFormatted(DEFAULT_JSON_MAP_KEY, DEFAULT_JSON_STRING_KEY);
    }

    @Given("^I convert json map to formatted json string using default RunStateKeys$")
    public void convertMapToJsonFormatted()
            throws IllegalKeyException,
            IllegalTypeClassException,
            NullRunStateException,
            TypeMismatchException {

        convertMapToJsonFormatted(DEFAULT_JSON_MAP_KEY, DEFAULT_JSON_STRING_KEY);
    }

    @Given("^I convert json map to unformatted json string using default RunStateKeys$")
    public void convertMapToJsonUnformatted()
            throws IllegalKeyException,
            IllegalTypeClassException,
            NullRunStateException,
            TypeMismatchException {

        convertMapToJsonUnformatted(DEFAULT_JSON_MAP_KEY, DEFAULT_JSON_STRING_KEY);
    }

    @Given("I convert json map using RunStateKey {string}, to json string using RunStateKey {string}")
    public void convertMapToJson(final String runStateJsonMapKey, final String runStateJsonStringKey)
            throws IllegalKeyException,
            IllegalTypeClassException,
            NullRunStateException,
            TypeMismatchException {

        convertMapToJson(this.runState, true,
                runStateJsonMapKey,
                runStateJsonStringKey
        );
    }

    @Given("I convert json map using RunStateKey {string}, to formatted json string using RunStateKey {string}")
    public void convertMapToJsonFormatted(final String runStateJsonMapKey, final String runStateJsonStringKey)
            throws IllegalKeyException,
            IllegalTypeClassException,
            NullRunStateException,
            TypeMismatchException {

        convertMapToJson(this.runState, true,
                runStateJsonMapKey,
                runStateJsonStringKey
        );
    }

    @Given("I convert json map using RunStateKey {string}, to unformatted json string using RunStateKey {string}")
    public void convertMapToJsonUnformatted(final String runStateJsonMapKey, final String runStateJsonStringKey)
            throws IllegalKeyException,
            IllegalTypeClassException,
            NullRunStateException,
            TypeMismatchException {

        convertMapToJson(this.runState, false,
                runStateJsonMapKey,
                runStateJsonStringKey
        );
    }

    private void convertMapToJson(final RunState runState,
                                  final boolean jsonFormatted,
                                  final String runStateJsonMapKey,
                                  final String runStateJsonStringKey)
            throws
            IllegalKeyException,
            IllegalTypeClassException,
            NullRunStateException,
            TypeMismatchException {

        new ConvertJsonMapUtil(jsonFormatted)
                .convertMapToJson(
                        runState,
                        runStateJsonMapKey,
                        runStateJsonStringKey
                );
    }

}
