package com.github.nhojpatrick.cucumber.testing.internal.steps.json.map;

import com.github.nhojpatrick.cucumber.json.map.ConvertJsonMapUtil;
import com.github.nhojpatrick.cucumber.state.RunState;
import com.google.inject.Inject;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import io.cucumber.java.en.Given;
import org.junit.jupiter.api.function.Executable;

import static com.github.nhojpatrick.cucumber.json.map.ConvertJsonMapConstants.DEFAULT_JSON_MAP_KEY;
import static com.github.nhojpatrick.cucumber.json.map.ConvertJsonMapConstants.DEFAULT_JSON_STRING_KEY;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SuppressFBWarnings(value = {"EI_EXPOSE_REP2", "THROWS_METHOD_THROWS_CLAUSE_THROWABLE"}, justification = "Accepted will look at changing")
public class ConvertMapToJson_TestingInternalSteps {

    private RunState runState;

    @Inject
    public ConvertMapToJson_TestingInternalSteps(final RunState runState) {
        this.runState = runState;
    }

    @Given("TestingInternalSteps I convert json map to json string using default RunStateKeys produces the AssertionError {string}")
    public void convertMapToJson_AssertionError(final String expectedExceptionMessageRaw) {

        convertMapToJson_AssertionError(
                DEFAULT_JSON_MAP_KEY,
                DEFAULT_JSON_STRING_KEY,
                expectedExceptionMessageRaw
        );
    }

    @Given("TestingInternalSteps I convert json map using RunStateKey {string}, to json string using RunStateKey {string} produces the AssertionError {string}")
    public void convertMapToJson_AssertionError(final String runStateJsonMapKey,
                                                final String runStateJsonStringKey,
                                                final String expectedExceptionMessageRaw) {

        final ConvertJsonMapUtil convertJsonMapUtil = new ConvertJsonMapUtil();
        final Executable testMethod = () -> convertJsonMapUtil.convertMapToJson(
                this.runState,
                runStateJsonMapKey,
                runStateJsonStringKey);
        final AssertionError thrown = assertThrows(AssertionError.class, testMethod);
        final String expectedExceptionMessage = expectedExceptionMessageRaw
                .replace("\\t", "\t")
                .replace("\\n", "\n");
        assertThat(thrown.getMessage(), is(equalTo(expectedExceptionMessage)));
    }

    @Given("TestingInternalSteps I convert json map to json string using default RunStateKeys produces the IllegalArgumentException {string}")
    public void convertMapToJson_IllegalArgumentException(final String expectedExceptionMessageRaw) {

        convertMapToJson_IllegalArgumentException(
                DEFAULT_JSON_MAP_KEY,
                DEFAULT_JSON_STRING_KEY,
                expectedExceptionMessageRaw
        );
    }

    @Given("TestingInternalSteps I convert json map using RunStateKey {string}, to json string using RunStateKey {string} produces the IllegalArgumentException {string}")
    public void convertMapToJson_IllegalArgumentException(final String runStateJsonMapKey,
                                                          final String runStateJsonStringKey,
                                                          final String expectedExceptionMessageRaw) {

        final ConvertJsonMapUtil convertJsonMapUtil = new ConvertJsonMapUtil();
        final Executable testMethod = () -> convertJsonMapUtil.convertMapToJson(
                this.runState,
                runStateJsonMapKey,
                runStateJsonStringKey);
        final IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, testMethod);
        final String expectedExceptionMessage = expectedExceptionMessageRaw
                .replace("\\t", "\t")
                .replace("\\n", "\n");
        assertThat(thrown.getMessage(), is(equalTo(expectedExceptionMessage)));
    }

}
