package com.github.nhojpatrick.cucumber.testing.internal.steps.json.transform;

import com.github.nhojpatrick.cucumber.core.exceptions.IllegalKeyException;
import com.github.nhojpatrick.cucumber.core.exceptions.IllegalOperationException;
import com.github.nhojpatrick.cucumber.core.exceptions.IllegalTypeClassException;
import com.github.nhojpatrick.cucumber.core.exceptions.TypeMismatchException;
import com.github.nhojpatrick.cucumber.json.core.castto.exceptions.UnsupportedDataTypeException;
import com.github.nhojpatrick.cucumber.json.core.transform.Transformation;
import com.github.nhojpatrick.cucumber.json.transformations.whitespace.WhitespaceTransformation;
import com.github.nhojpatrick.cucumber.json.transformations.whitespace.exceptions.WhitespaceTransformationArgumentException;
import com.github.nhojpatrick.cucumber.state.RunState;
import com.google.inject.Inject;
import io.cucumber.java.en.Given;

import static com.github.nhojpatrick.cucumber.json.transform.TransformConstants.DEFAULT_MAP_KEY;

public class WhitespaceTransformation_TestingInternalSteps
        extends BaseTransformation_TestingInternalSteps {

    @Inject
    public WhitespaceTransformation_TestingInternalSteps(final RunState runState) {
        super(runState);
    }

    @Given("TestingInternalSteps I transform json map using default RunStateKey and whitespace the following path {string} with prefix {int} and suffix {int} produces the IllegalPathOperationException {string}")
    public void whitespaceIllegalPathOperationException(final String path,
                                                        final int prefix,
                                                        final int suffix,
                                                        final String expectedExceptionMessageRaw)
            throws IllegalKeyException,
            IllegalTypeClassException,
            TypeMismatchException,
            WhitespaceTransformationArgumentException {

        whitespaceIllegalPathOperationException(DEFAULT_MAP_KEY, path, prefix, suffix, expectedExceptionMessageRaw);
    }

    @Given("TestingInternalSteps I transform json map using RunStateKey {string} and whitespace the following path {string} with prefix {int} and suffix {int} produces the IllegalPathOperationException {string}")
    public void whitespaceIllegalPathOperationException(final String runStateJsonMapKey,
                                                        final String path,
                                                        final int prefix,
                                                        final int suffix,
                                                        final String expectedExceptionMessageRaw)
            throws IllegalKeyException,
            IllegalTypeClassException,
            TypeMismatchException,
            WhitespaceTransformationArgumentException {

        whitespace(runStateJsonMapKey,
                path,
                prefix,
                suffix,
                IllegalOperationException.class,
                expectedExceptionMessageRaw);
    }

    @Given("TestingInternalSteps I transform json map using default RunStateKey and whitespace the following path {string} with prefix {int} and suffix {int} produces the UnsupportedDataTypeException {string}")
    public void whitespaceUnsupportedDataTypeException(final String path,
                                                       final int prefix,
                                                       final int suffix,
                                                       final String expectedExceptionMessageRaw)
            throws IllegalKeyException,
            IllegalTypeClassException,
            TypeMismatchException,
            WhitespaceTransformationArgumentException {

        whitespaceUnsupportedDataTypeException(DEFAULT_MAP_KEY, path, prefix, suffix, expectedExceptionMessageRaw);
    }

    @Given("TestingInternalSteps I transform json map using RunStateKey {string} and whitespace the following path {string} with prefix {int} and suffix {int} produces the UnsupportedDataTypeException {string}")
    public void whitespaceUnsupportedDataTypeException(final String runStateJsonMapKey,
                                                       final String path,
                                                       final int prefix,
                                                       final int suffix,
                                                       final String expectedExceptionMessageRaw)
            throws IllegalKeyException,
            IllegalTypeClassException,
            TypeMismatchException,
            WhitespaceTransformationArgumentException {

        whitespace(runStateJsonMapKey,
                path,
                prefix,
                suffix,
                UnsupportedDataTypeException.class,
                expectedExceptionMessageRaw);
    }

    public <T extends Exception> void whitespace(final String runStateJsonMapKey,
                                                 final String path,
                                                 final Integer prefix,
                                                 final Integer suffix,
                                                 final Class<T> t,
                                                 final String expectedExceptionMessageRaw)
            throws IllegalKeyException,
            IllegalTypeClassException,
            TypeMismatchException,
            WhitespaceTransformationArgumentException {

        final Transformation transformation = new WhitespaceTransformation(prefix, suffix);

        transformationCheck(runStateJsonMapKey, path, t, expectedExceptionMessageRaw, transformation);
    }

}
