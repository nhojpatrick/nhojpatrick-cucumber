package com.github.nhojpatrick.cucumber.json.steps.transform;

import com.github.nhojpatrick.cucumber.core.exceptions.IllegalKeyException;
import com.github.nhojpatrick.cucumber.core.exceptions.IllegalOperationException;
import com.github.nhojpatrick.cucumber.core.exceptions.IllegalTypeClassException;
import com.github.nhojpatrick.cucumber.core.exceptions.TypeMismatchException;
import com.github.nhojpatrick.cucumber.json.exceptions.CastToException;
import com.github.nhojpatrick.cucumber.json.exceptions.InvalidPathException;
import com.github.nhojpatrick.cucumber.json.exceptions.InvalidTransformActionException;
import com.github.nhojpatrick.cucumber.json.steps.map.ConvertToMapSteps;
import com.github.nhojpatrick.cucumber.json.transform.Transform;
import com.github.nhojpatrick.cucumber.json.transform.TransformAction;
import com.github.nhojpatrick.cucumber.json.transform.TransformFactory;
import com.github.nhojpatrick.cucumber.json.transform.transformations.RemoveTransformation;
import com.github.nhojpatrick.cucumber.json.transform.transformations.SetTransformation;
import com.github.nhojpatrick.cucumber.json.transform.transformations.Transformation;
import com.github.nhojpatrick.cucumber.json.transform.utils.CastToUtil;
import com.github.nhojpatrick.cucumber.state.RunState;
import com.github.nhojpatrick.cucumber.state.exceptions.NullRunStateException;
import com.github.nhojpatrick.cucumber.state.validation.RunStateValidatorFactory;
import com.google.inject.Inject;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;

import java.util.List;
import java.util.Map;

public class TransformationSteps {

    public static final String DEFAULT_MAP_KEY = ConvertToMapSteps.DEFAULT_MAP_KEY;

    private final RunState runState;

    @Inject
    public TransformationSteps(final RunState runState) {
        this.runState = runState;
    }

    @Given("^I transform json map using default RunStateKey on paths:$")
    public void transform(final DataTable dataTable)
            throws CastToException,
            IllegalKeyException,
            IllegalOperationException,
            IllegalTypeClassException,
            InvalidPathException,
            InvalidTransformActionException,
            NullRunStateException,
            TypeMismatchException {

        transform(DEFAULT_MAP_KEY, dataTable);
    }

    @Given("I transform json map using RunStateKey {string} on paths:")
    public void transform(final String runStateJsonMapKey, final DataTable dataTable)
            throws CastToException,
            IllegalKeyException,
            IllegalOperationException,
            IllegalTypeClassException,
            InvalidPathException,
            InvalidTransformActionException,
            NullRunStateException,
            TypeMismatchException {

        RunStateValidatorFactory.getInstance()
                .withValue(runStateJsonMapKey)
                .verify(this.runState);

        Map<String, Object> runStateJsonMapValue = this.runState.get(runStateJsonMapKey, Map.class);

        runStateJsonMapValue = transform(runStateJsonMapValue, dataTable.asMaps(String.class, String.class));

        this.runState.set(runStateJsonMapKey, runStateJsonMapValue);
    }

    private Map<String, Object> transform(Map<String, Object> runStateJsonMapValue,
                                          final List<Map<String, String>> dataTable)
            throws CastToException,
            IllegalKeyException,
            IllegalOperationException,
            InvalidPathException,
            InvalidTransformActionException {

        final Transform transform = TransformFactory.getInstance();

        for (final Map<String, String> row : dataTable) {

            final String path = row.get("path");

            final String actionAsStr = row.get("action");

            final TransformAction transformAction = TransformAction.resolve(actionAsStr);

            final Transformation transformation;

            switch (transformAction) {
                case REMOVE:
                    transformation = new RemoveTransformation();
                    break;

                case SET:
                    final String valueAsStr = row.get("value");
                    final String type = row.get("type");
                    final Object value = new CastToUtil()
                            .castTo(valueAsStr, type);
                    transformation = new SetTransformation(value);
                    break;

                default:
                    throw new RuntimeException(); // TODO new exception
            }

            runStateJsonMapValue = transform.transform(runStateJsonMapValue, path, transformation);
        }

        return runStateJsonMapValue;
    }

}
