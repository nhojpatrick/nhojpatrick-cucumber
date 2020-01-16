package com.github.nhojpatrick.cucumber.testing.internal.steps.json.transform;

import com.github.nhojpatrick.cucumber.core.exceptions.IllegalKeyException;
import com.github.nhojpatrick.cucumber.core.exceptions.IllegalOperationException;
import com.github.nhojpatrick.cucumber.core.exceptions.IllegalTypeClassException;
import com.github.nhojpatrick.cucumber.core.exceptions.TypeMismatchException;
import com.github.nhojpatrick.cucumber.json.core.castto.CastTo;
import com.github.nhojpatrick.cucumber.json.core.castto.CastToUtil;
import com.github.nhojpatrick.cucumber.json.core.castto.exceptions.CastToException;
import com.github.nhojpatrick.cucumber.json.core.castto.exceptions.UnsupportedDataTypeException;
import com.github.nhojpatrick.cucumber.json.core.transform.Transform;
import com.github.nhojpatrick.cucumber.json.transform.factory.TransformFactory;
import com.github.nhojpatrick.cucumber.json.transformations.set.SetTransformation;
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

public class SetTransformation_TestingInternalSteps {

    private RunState runState;

    @Inject
    public SetTransformation_TestingInternalSteps(final RunState runState) {
        this.runState = runState;
    }

    @Given("TestingInternalSteps I transform json map using default RunStateKey and set the following path {string} to {string} of type {string} produces the IllegalPathOperationException {string}")
    public void setIllegalOperationException(final String path,
                                             final String value,
                                             final String type,
                                             final String expectedExceptionMessageRaw)
            throws CastToException,
            IllegalKeyException,
            IllegalTypeClassException,
            TypeMismatchException {

        setIllegalOperationException(DEFAULT_MAP_KEY, path, value, type, expectedExceptionMessageRaw);
    }

    @Given("TestingInternalSteps I transform json map using RunStateKey {string} and set the following path {string} to {string} of type {string} produces the IllegalPathOperationException {string}")
    public void setIllegalOperationException(final String runStateJsonMapKey,
                                             final String path,
                                             final String value,
                                             final String type,
                                             final String expectedExceptionMessageRaw)
            throws CastToException,
            IllegalKeyException,
            IllegalTypeClassException,
            TypeMismatchException {

        set(runStateJsonMapKey, path, value, type, IllegalOperationException.class, expectedExceptionMessageRaw);
    }

    @Given("TestingInternalSteps I transform json map using default RunStateKey and set the following path {string} to {string} of type {string} produces the UnsupportedDataTypeException {string}")
    public void setUnsupportedDataTypeException(final String path,
                                                final String value,
                                                final String type,
                                                final String expectedExceptionMessageRaw)
            throws CastToException,
            IllegalKeyException,
            IllegalTypeClassException,
            TypeMismatchException {

        setUnsupportedDataTypeException(DEFAULT_MAP_KEY, path, value, type, expectedExceptionMessageRaw);
    }

    @Given("TestingInternalSteps I transform json map using RunStateKey {string} and set the following path {string} to {string} of type {string} produces the UnsupportedDataTypeException {string}")
    public void setUnsupportedDataTypeException(final String runStateJsonMapKey,
                                                final String path,
                                                final String value,
                                                final String type,
                                                final String expectedExceptionMessageRaw)
            throws CastToException,
            IllegalKeyException,
            IllegalTypeClassException,
            TypeMismatchException {

        set(runStateJsonMapKey, path, value, type, UnsupportedDataTypeException.class, expectedExceptionMessageRaw);
    }

    public <T extends Exception> void set(final String runStateJsonMapKey,
                                          final String path,
                                          final String valueAsStr,
                                          final String type,
                                          final Class<T> t,
                                          final String expectedExceptionMessageRaw)
            throws CastToException,
            IllegalKeyException,
            IllegalTypeClassException,
            TypeMismatchException {

        final Map<String, Object> input = this.runState.get(runStateJsonMapKey, Map.class);

        final Transform transform = TransformFactory.getFactory()
                .get();

        Executable testMethod;
        if (t.isAssignableFrom(UnsupportedDataTypeException.class)) {
            testMethod = () -> new CastToUtil().castTo(valueAsStr, type);

        } else {
            final CastTo castTo = new CastToUtil();
            final Object value = castTo.castTo(valueAsStr, type);
            final SetTransformation setTransformation = new SetTransformation(value);
            testMethod = () -> transform.transform(path, input, setTransformation);
        }

        final T thrown = assertThrows(t, testMethod);
        final String expectedExceptionMessage = expectedExceptionMessageRaw
                .replace("\\t", "\t")
                .replace("\\n", "\n");
        assertThat(thrown.getMessage(), is(equalTo(expectedExceptionMessage)));
    }

}
