package com.github.nhojpatrick.cucumber.testing.internal.steps.json.map;

import com.github.nhojpatrick.cucumber.json.map.ConvertJsonMapUtil;
import com.github.nhojpatrick.cucumber.state.RunState;
import com.google.inject.Inject;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import io.cucumber.java.en.Given;
import org.junit.jupiter.api.function.Executable;

import static com.github.nhojpatrick.cucumber.json.map.ConvertJsonMapConstants.DEFAULT_JSON_MAP_KEY;
import static com.github.nhojpatrick.cucumber.json.map.ConvertJsonMapConstants.DEFAULT_JSON_OBJECT_KEY;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SuppressFBWarnings(value = "EI_EXPOSE_REP2", justification = "Accepted will look at changing")
public class ConvertObjectToMap_TestingInternalSteps {

    private RunState runState;

    @Inject
    public ConvertObjectToMap_TestingInternalSteps(final RunState runState) {
        this.runState = runState;
    }

    @Given("TestingInternalSteps I convert object to json map using default RunStateKeys produces the AssertionError {string}")
    public void convertObjectToMap_AssertionError(final String expectedExceptionMessageRaw) {

        convertObjectToMap_AssertionError(
                DEFAULT_JSON_OBJECT_KEY,
                DEFAULT_JSON_MAP_KEY,
                expectedExceptionMessageRaw
        );
    }

    @Given("TestingInternalSteps I convert object using RunStateKey {string}, to json map using RunStateKey {string} produces the AssertionError {string}")
    public void convertObjectToMap_AssertionError(final String runStateObjectKey,
                                                  final String runStateJsonMapKey,
                                                  final String expectedExceptionMessageRaw) {

        final ConvertJsonMapUtil convertJsonMapUtil = new ConvertJsonMapUtil();
        final Executable testMethod = () -> convertJsonMapUtil.convertObjectToMap(
                this.runState,
                runStateObjectKey,
                runStateJsonMapKey
        );
        final AssertionError thrown = assertThrows(AssertionError.class, testMethod);
        final String expectedExceptionMessage = expectedExceptionMessageRaw
                .replace("\\t", "\t")
                .replace("\\n", "\n");
        assertThat(thrown.getMessage(), is(equalTo(expectedExceptionMessage)));
    }

    @Given("TestingInternalSteps I convert object to json map using default RunStateKeys produces the IllegalArgumentException {string}")
    public void convertObjectToMap_IllegalArgumentException(final String expectedExceptionMessageRaw) {

        convertObjectToMap_IllegalArgumentException(
                DEFAULT_JSON_OBJECT_KEY,
                DEFAULT_JSON_MAP_KEY,
                expectedExceptionMessageRaw
        );
    }

    @Given("TestingInternalSteps I convert object using RunStateKey {string}, to json map using RunStateKey {string} produces the IllegalArgumentException {string}")
    public void convertObjectToMap_IllegalArgumentException(final String runStateObjectKey,
                                                            final String runStateJsonMapKey,
                                                            final String expectedExceptionMessageRaw) {

        final ConvertJsonMapUtil convertJsonMapUtil = new ConvertJsonMapUtil();
        final Executable testMethod = () -> convertJsonMapUtil.convertObjectToMap(
                this.runState,
                runStateObjectKey,
                runStateJsonMapKey
        );
        final IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, testMethod);
        final String expectedExceptionMessage = expectedExceptionMessageRaw
                .replace("\\t", "\t")
                .replace("\\n", "\n");
        assertThat(thrown.getMessage(), is(equalTo(expectedExceptionMessage)));
    }

    @Given("TestingInternalSteps I convert object to json map using default RunStateKeys produces the RuntimeException {string}")
    public void convertObjectToMap_RuntimeException(final String expectedExceptionMessageRaw) {

        convertObjectToMap_RuntimeException(
                DEFAULT_JSON_OBJECT_KEY,
                DEFAULT_JSON_MAP_KEY,
                expectedExceptionMessageRaw
        );
    }

    @Given("TestingInternalSteps I convert object using RunStateKey {string}, to json map using RunStateKey {string} produces the RuntimeException {string}")
    public void convertObjectToMap_RuntimeException(final String runStateObjectKey,
                                                            final String runStateJsonMapKey,
                                                            final String expectedExceptionMessageRaw) {

        final ConvertJsonMapUtil convertJsonMapUtil = new ConvertJsonMapUtil();
        final Executable testMethod = () -> convertJsonMapUtil.convertObjectToMap(
                this.runState,
                runStateObjectKey,
                runStateJsonMapKey
        );
        final RuntimeException thrown = assertThrows(RuntimeException.class, testMethod);
        final String expectedExceptionMessage = expectedExceptionMessageRaw
                .replace("\\t", "\t")
                .replace("\\n", "\n");
        assertThat(thrown.getMessage(), is(equalTo(expectedExceptionMessage)));
    }

}
