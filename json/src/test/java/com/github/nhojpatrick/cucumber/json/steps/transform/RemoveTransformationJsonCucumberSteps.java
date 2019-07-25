package com.github.nhojpatrick.cucumber.json.steps.transform;

import com.github.nhojpatrick.cucumber.core.exceptions.IllegalKeyException;
import com.github.nhojpatrick.cucumber.core.exceptions.IllegalTypeClassException;
import com.github.nhojpatrick.cucumber.core.exceptions.TypeMismatchException;
import com.github.nhojpatrick.cucumber.json.exceptions.IllegalPathOperationException;
import com.github.nhojpatrick.cucumber.json.transform.Transform;
import com.github.nhojpatrick.cucumber.json.transform.TransformFactory;
import com.github.nhojpatrick.cucumber.json.transform.transformations.RemoveTransformation;
import com.github.nhojpatrick.cucumber.state.RunState;
import com.google.inject.Inject;
import io.cucumber.java.en.Given;
import org.junit.jupiter.api.function.Executable;

import java.util.Map;

import static com.github.nhojpatrick.cucumber.json.steps.transform.TransformationSteps.DEFAULT_MAP_KEY;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RemoveTransformationJsonCucumberSteps {

    private RunState runState;

    @Inject
    public RemoveTransformationJsonCucumberSteps(final RunState runState) {
        this.runState = runState;
    }

//    @Given("I transform json map using default RunStateKey and remove the following path {string} produces the IllegalOperationException {string}")
    @Given("^I transform json map using default RunStateKey and remove the following path \"([^\"]*)\" produces the IllegalOperationException \"([^\"]*)\"$")
    public void remove(final String path, final String expectedExceptionMessageRaw)
            throws IllegalKeyException,
            IllegalTypeClassException,
            TypeMismatchException {

        remove(DEFAULT_MAP_KEY, path, expectedExceptionMessageRaw);
    }

//    @Given("I transform json map using RunStateKey {string} and remove the following path {string} produces the IllegalOperationException {string}")
    @Given("^I transform json map using RunStateKey \"([^\"]*)\" and remove the following path \"([^\"]*)\" produces the IllegalOperationException \"([^\"]*)\"$")
    public void remove(final String runStateJsonMapKey, final String path, final String expectedExceptionMessageRaw)
            throws IllegalKeyException,
            IllegalTypeClassException,
            TypeMismatchException {

        final Map<String, Object> input = this.runState.get(runStateJsonMapKey, Map.class);

        final Transform transform = TransformFactory.getInstance();
        final RemoveTransformation removeTransformation = new RemoveTransformation();
        final Executable testMethod = () -> transform.transform(input, path, removeTransformation);

        final IllegalPathOperationException expectedThrown = assertThrows(IllegalPathOperationException.class, testMethod);
        final String expectedExceptionMessage = expectedExceptionMessageRaw
                .replace("\\t", "\t")
                .replace("\\n", "\n");
        assertThat(expectedThrown.getMessage(), is(equalTo(expectedExceptionMessage)));
    }

}
