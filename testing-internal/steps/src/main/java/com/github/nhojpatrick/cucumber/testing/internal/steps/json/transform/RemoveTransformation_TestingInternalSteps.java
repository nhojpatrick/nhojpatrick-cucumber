package com.github.nhojpatrick.cucumber.testing.internal.steps.json.transform;

import com.github.nhojpatrick.cucumber.core.exceptions.IllegalKeyException;
import com.github.nhojpatrick.cucumber.core.exceptions.IllegalTypeClassException;
import com.github.nhojpatrick.cucumber.core.exceptions.TypeMismatchException;
import com.github.nhojpatrick.cucumber.json.core.exceptions.IllegalPathOperationException;
import com.github.nhojpatrick.cucumber.json.core.transform.Transformation;
import com.github.nhojpatrick.cucumber.json.transformations.remove.RemoveTransformation;
import com.github.nhojpatrick.cucumber.state.RunState;
import com.google.inject.Inject;
import io.cucumber.java.en.Given;

import static com.github.nhojpatrick.cucumber.json.transform.TransformConstants.DEFAULT_MAP_KEY;

public class RemoveTransformation_TestingInternalSteps
        extends BaseTransformation_TestingInternalSteps {

    @Inject
    public RemoveTransformation_TestingInternalSteps(final RunState runState) {
        super(runState);
    }

    @Given("TestingInternalSteps I transform json map using default RunStateKey and remove the following path {string} produces the IllegalPathOperationException {string}")
    public void remove(final String path, final String expectedExceptionMessageRaw)
            throws IllegalKeyException,
            IllegalTypeClassException,
            TypeMismatchException {

        remove(DEFAULT_MAP_KEY, path, expectedExceptionMessageRaw);
    }

    @Given("TestingInternalSteps I transform json map using RunStateKey {string} and remove the following path {string} produces the IllegalPathOperationException {string}")
    public void remove(final String runStateJsonMapKey, final String path, final String expectedExceptionMessageRaw)
            throws IllegalKeyException,
            IllegalTypeClassException,
            TypeMismatchException {

        final Transformation transformation = new RemoveTransformation();

        transformationCheck(
                runStateJsonMapKey,
                path,
                IllegalPathOperationException.class,
                expectedExceptionMessageRaw,
                transformation
        );
    }

}
