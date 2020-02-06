package com.github.nhojpatrick.cucumber.testing.internal.steps.json.transform;

import com.github.nhojpatrick.cucumber.core.exceptions.IllegalKeyException;
import com.github.nhojpatrick.cucumber.core.exceptions.IllegalTypeClassException;
import com.github.nhojpatrick.cucumber.core.exceptions.TypeMismatchException;
import com.github.nhojpatrick.cucumber.json.core.exceptions.IllegalPathOperationException;
import com.github.nhojpatrick.cucumber.json.core.transform.Transformation;
import com.github.nhojpatrick.cucumber.json.transformations.reverse.ReverseTransformation;
import com.github.nhojpatrick.cucumber.state.RunState;
import com.google.inject.Inject;
import io.cucumber.java.en.Given;

import static com.github.nhojpatrick.cucumber.json.transform.TransformConstants.DEFAULT_MAP_KEY;

public class ReverseTransformation_TestingInternalSteps
        extends BaseTransformation_TestingInternalSteps {

    @Inject
    public ReverseTransformation_TestingInternalSteps(final RunState runState) {
        super(runState);
    }

    @Given("TestingInternalSteps I transform json map using default RunStateKey and reverse the following path {string} produces the IllegalPathOperationException {string}")
    public void reverse(final String path, final String expectedExceptionMessageRaw)
            throws IllegalKeyException,
            IllegalTypeClassException,
            TypeMismatchException {

        reverse(DEFAULT_MAP_KEY, path, expectedExceptionMessageRaw);
    }

    @Given("TestingInternalSteps I transform json map using RunStateKey {string} and reverse the following path {string} produces the IllegalPathOperationException {string}")
    public void reverse(final String runStateJsonMapKey, final String path, final String expectedExceptionMessageRaw)
            throws IllegalKeyException,
            IllegalTypeClassException,
            TypeMismatchException {

        final Transformation transformation = new ReverseTransformation();

        transformationCheck(
                runStateJsonMapKey,
                path,
                IllegalPathOperationException.class,
                expectedExceptionMessageRaw,
                transformation
        );
    }

}
