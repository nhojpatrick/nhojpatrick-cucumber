package com.github.nhojpatrick.cucumber.state.steps.state;

import com.github.nhojpatrick.cucumber.core.exceptions.IllegalKeyException;
import com.github.nhojpatrick.cucumber.core.exceptions.IllegalTypeClassException;
import com.github.nhojpatrick.cucumber.core.exceptions.TypeMismatchException;
import com.github.nhojpatrick.cucumber.state.RunState;
import com.google.inject.Inject;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import java.util.List;
import java.util.Map;

import static com.github.nhojpatrick.hamcrest.collections.IsMap.mapWithSize;
import static java.util.stream.Collectors.toList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.jupiter.api.Assertions.assertAll;

public class StateSteps {

    private RunState runState;

    @Inject
    public StateSteps(final RunState runState) {
        this.runState = runState;
    }

    @Then("^I have an empty run state$")
    public void assertEmptyRunState() {

        assertAll("Expected Empty Run State",
                () -> assertThat("Expected to be empty", this.runState.get(), is(mapWithSize(0)))
        );
    }

    @Given("^I have run state key->value string pairs of:$")
    public void assertRunStateKeyValuePairsAsStrings(final DataTable data)
            throws IllegalKeyException,
            IllegalTypeClassException,
            TypeMismatchException {

        final Map<String, String> stringStringMap = data.asMap(String.class, String.class);

        for (final Map.Entry<String, String> row : stringStringMap.entrySet()) {
            final Object runStateValueObj = this.runState.get(row.getKey(), Object.class);
            final String runStateValueAsStr = String.valueOf(runStateValueObj);
            assertThat(String.format("Unexpected RunState for key '%s'", row.getKey()), runStateValueAsStr, is(equalTo(row.getValue())));
        }
    }

//    @Then("I expected {string} to match {string}")
    @Then("^I expected \"([^\"]*)\" to match \"([^\"]*)\"$")
    public void checkKeyReturnsValue(final String key, final String value)
            throws Exception {

        assertThat(this.runState.get(key, String.class), is(equalTo(value)));
    }

    @Given("^I have cleared the run state$")
    public void clearRunState() {

        final List<String> keys = this.runState.get()
                .keySet()
                .stream()
                .collect(toList());
        clearRunStateForKeys(keys);
    }

    @Given("^I have cleared the run state for keys:$")
    public void clearRunStateForKeys(final List<String> keys) {

        keys.forEach(p -> {
            try {
                this.runState.clear(p);

            } catch (final IllegalKeyException ike) {
                throw new RuntimeException("Illegal key whilst clearing run state.", ike);
            }
        });
    }

//    @Given("I've defined {string} is {string}")
    @Given("^I've defined \"([^\"]*)\" is \"([^\"]*)\"$")
    public void setKeyToValue(final String key, final String value)
            throws Exception {
        this.runState.set(key, value);
    }

}
