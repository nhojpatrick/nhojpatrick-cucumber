package com.github.nhojpatrick.cucumber.json.steps.transform;

import com.github.nhojpatrick.cucumber.core.exceptions.IllegalKeyException;
import com.github.nhojpatrick.cucumber.core.exceptions.IllegalTypeClassException;
import com.github.nhojpatrick.cucumber.core.exceptions.TypeMismatchException;
import com.github.nhojpatrick.cucumber.json.core.exceptions.IllegalPathOperationException;
import com.github.nhojpatrick.cucumber.json.core.transform.Transform;
import com.github.nhojpatrick.cucumber.json.transform.factory.TransformFactory;
import com.github.nhojpatrick.cucumber.json.transformations.reverse.ReverseTransformation;
import com.github.nhojpatrick.cucumber.state.RunState;
import com.google.inject.Inject;
import io.cucumber.java.en.Given;
import org.junit.jupiter.api.function.Executable;

import java.util.Map;

import static com.github.nhojpatrick.cucumber.json.transform.constants.TransformConstants.DEFAULT_MAP_KEY;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ReverseTransformationJsonCucumberSteps {

    private RunState runState;

    @Inject
    public ReverseTransformationJsonCucumberSteps(final RunState runState) {
        this.runState = runState;
    }

    @Given("I transform json map using default RunStateKey and reverse the following path {string} produces the IllegalOperationException {string}")
    public void reverse(final String path, final String expectedExceptionMessageRaw)
            throws IllegalKeyException,
            IllegalTypeClassException,
            TypeMismatchException {

        reverse(DEFAULT_MAP_KEY, path, expectedExceptionMessageRaw);
    }

    @Given("I transform json map using RunStateKey {string} and reverse the following path {string} produces the IllegalOperationException {string}")
    public void reverse(final String runStateJsonMapKey, final String path, final String expectedExceptionMessageRaw)
            throws IllegalKeyException,
            IllegalTypeClassException,
            TypeMismatchException {

        final Map<String, Object> input = this.runState.get(runStateJsonMapKey, Map.class);

        final Transform transform = TransformFactory.getInstance();
        final ReverseTransformation reverseTransformation = new ReverseTransformation();
        final Executable testMethod = () -> transform.transform(input, path, reverseTransformation);

        final IllegalPathOperationException expectedThrown = assertThrows(IllegalPathOperationException.class, testMethod);
        final String expectedExceptionMessage = expectedExceptionMessageRaw
                .replace("\\t", "\t")
                .replace("\\n", "\n");
        assertThat(expectedThrown.getMessage(), is(equalTo(expectedExceptionMessage)));
    }

}
