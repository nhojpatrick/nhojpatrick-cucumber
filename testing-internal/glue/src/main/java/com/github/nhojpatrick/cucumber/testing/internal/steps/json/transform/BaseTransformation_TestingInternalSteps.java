package com.github.nhojpatrick.cucumber.testing.internal.steps.json.transform;

import com.github.nhojpatrick.cucumber.core.exceptions.IllegalKeyException;
import com.github.nhojpatrick.cucumber.core.exceptions.IllegalTypeClassException;
import com.github.nhojpatrick.cucumber.core.exceptions.TypeMismatchException;
import com.github.nhojpatrick.cucumber.json.core.transform.Transform;
import com.github.nhojpatrick.cucumber.json.core.transform.Transformation;
import com.github.nhojpatrick.cucumber.json.transform.factory.TransformFactory;
import com.github.nhojpatrick.cucumber.state.RunState;
import com.google.inject.Inject;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import org.junit.jupiter.api.function.Executable;

import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SuppressFBWarnings(value = {"EI_EXPOSE_REP2", "THROWS_METHOD_THROWS_CLAUSE_THROWABLE"}, justification = "Accepted will look at changing")
public abstract class BaseTransformation_TestingInternalSteps {

    protected RunState runState;

    @Inject
    public BaseTransformation_TestingInternalSteps(final RunState runState) {
        this.runState = runState;
    }

    public <T extends Exception> void transformationCheck(final String runStateJsonMapKey,
                                                          final String path,
                                                          final Class<T> t,
                                                          final String expectedExceptionMessageRaw,
                                                          final Transformation transformation)
            throws IllegalKeyException,
            IllegalTypeClassException,
            TypeMismatchException {

        final Map<String, Object> input = this.runState.get(runStateJsonMapKey, Map.class);

        final Transform transform = TransformFactory.getFactory()
                .get();

        final Executable testMethod = () -> transform.transform(path, input, transformation);

        transformationCheck(t, expectedExceptionMessageRaw, testMethod);
    }

    public <T extends Exception> void transformationCheck(final Class<T> t,
                                                          final String expectedExceptionMessageRaw,
                                                          final Executable testMethod) {

        final T thrown = assertThrows(t, testMethod);
        final String expectedExceptionMessage = expectedExceptionMessageRaw
                .replace("\\t", "\t")
                .replace("\\n", "\n");
        assertThat(thrown.getMessage(), is(equalTo(expectedExceptionMessage)));
    }

}
