package com.github.nhojpatrick.cucumber.testing.internal.steps.json.transform;

import com.github.nhojpatrick.cucumber.core.exceptions.IllegalKeyException;
import com.github.nhojpatrick.cucumber.core.exceptions.IllegalOperationException;
import com.github.nhojpatrick.cucumber.core.exceptions.IllegalTypeClassException;
import com.github.nhojpatrick.cucumber.core.exceptions.TypeMismatchException;
import com.github.nhojpatrick.cucumber.json.core.castto.exceptions.UnsupportedDataTypeException;
import com.github.nhojpatrick.cucumber.json.core.transform.Transform;
import com.github.nhojpatrick.cucumber.json.transform.factory.TransformFactory;
import com.github.nhojpatrick.cucumber.json.transformations.whitespace.WhitespaceTransformation;
import com.github.nhojpatrick.cucumber.json.transformations.whitespace.exceptions.WhitespaceTransformationArgumentException;
import com.github.nhojpatrick.cucumber.state.RunState;
import com.google.inject.Inject;
import io.cucumber.java.en.Given;
import org.junit.jupiter.api.function.Executable;

import java.util.Map;

import static com.github.nhojpatrick.cucumber.json.transform.TransformConstants.DEFAULT_MAP_KEY;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class WhitespaceTransformationJsonCucumberSteps {

    private RunState runState;

    @Inject
    public WhitespaceTransformationJsonCucumberSteps(final RunState runState) {
        this.runState = runState;
    }

    @Given("I transform json map using default RunStateKey and whitespace the following path {string} with prefix {int} and suffix {int} produces the IllegalOperationException {string}")
    public void whitespaceIllegalOperationException(final String path,
                                                    final int prefix,
                                                    final int suffix,
                                                    final String expectedExceptionMessageRaw)
            throws IllegalKeyException,
            IllegalTypeClassException,
            TypeMismatchException,
            WhitespaceTransformationArgumentException {

        whitespaceIllegalOperationException(DEFAULT_MAP_KEY, path, prefix, suffix, expectedExceptionMessageRaw);
    }

    @Given("I transform json map using RunStateKey {string} and whitespace the following path {string} with prefix {int} and suffix {int} produces the IllegalOperationException {string}")
    public void whitespaceIllegalOperationException(final String runStateJsonMapKey,
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

    @Given("I transform json map using default RunStateKey and whitespace the following path {string} with prefix {int} and suffix {int} produces the UnsupportedDataTypeException {string}")
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

    @Given("I transform json map using RunStateKey {string} and whitespace the following path {string} with prefix {int} and suffix {int} produces the UnsupportedDataTypeException {string}")
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

        final Map<String, Object> input = this.runState.get(runStateJsonMapKey, Map.class);

        final Transform transform = TransformFactory.getFactory()
                .get();

        final WhitespaceTransformation whitespaceTransformation = new WhitespaceTransformation(prefix, suffix);
        final Executable testMethod = () -> transform.transform(input, path, whitespaceTransformation);

        final T thrown = assertThrows(t, testMethod);
        final String expectedExceptionMessage = expectedExceptionMessageRaw
                .replace("\\t", "\t")
                .replace("\\n", "\n");
        assertThat(thrown.getMessage(), is(equalTo(expectedExceptionMessage)));
    }

}
