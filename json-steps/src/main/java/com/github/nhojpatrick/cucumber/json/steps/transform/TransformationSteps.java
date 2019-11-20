package com.github.nhojpatrick.cucumber.json.steps.transform;

import com.github.nhojpatrick.cucumber.core.exceptions.IllegalKeyException;
import com.github.nhojpatrick.cucumber.core.exceptions.IllegalOperationException;
import com.github.nhojpatrick.cucumber.core.exceptions.IllegalTypeClassException;
import com.github.nhojpatrick.cucumber.core.exceptions.TypeMismatchException;
import com.github.nhojpatrick.cucumber.json.core.exceptions.CastToException;
import com.github.nhojpatrick.cucumber.json.core.exceptions.InvalidPathException;
import com.github.nhojpatrick.cucumber.json.core.transform.Transform;
import com.github.nhojpatrick.cucumber.json.core.transform.TransformActionTask;
import com.github.nhojpatrick.cucumber.json.core.transform.Transformation;
import com.github.nhojpatrick.cucumber.json.core.transform.TransformationService;
import com.github.nhojpatrick.cucumber.json.exceptions.InvalidTransformActionException;
import com.github.nhojpatrick.cucumber.json.steps.map.ConvertToMapSteps;
import com.github.nhojpatrick.cucumber.json.steps.transform.transformations.TransformationServiceFactory;
import com.github.nhojpatrick.cucumber.json.transform.TransformFactory;
import com.github.nhojpatrick.cucumber.state.RunState;
import com.github.nhojpatrick.cucumber.state.exceptions.NullRunStateException;
import com.github.nhojpatrick.cucumber.state.validation.RunStateValidatorFactory;
import com.google.inject.Inject;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;

import java.util.List;
import java.util.Map;

public class TransformationSteps {

    public static final String CUCUMBER_DATA_TABLE_COLUMN_ACTION = "action";
    public static final String CUCUMBER_DATA_TABLE_COLUMN_PATH = "path";
    public static final String CUCUMBER_DATA_TABLE_COLUMN_TYPE = "type";
    public static final String CUCUMBER_DATA_TABLE_COLUMN_VALUE = "value";
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

        final TransformationServiceFactory transformationServiceFactory = TransformationServiceFactory.getInstance();
        final Transform transform = TransformFactory.getInstance();

        for (final Map<String, String> row : dataTable) {

            final String action = row.get(CUCUMBER_DATA_TABLE_COLUMN_ACTION);

            final TransformationService transformationService = transformationServiceFactory.resolve(action)
                    .orElseThrow(() -> new InvalidTransformActionException(action));

            final String type = row.get(CUCUMBER_DATA_TABLE_COLUMN_TYPE);
            final String value = row.get(CUCUMBER_DATA_TABLE_COLUMN_VALUE);

            final TransformActionTask transformActionTask = new TransformActionTask.Builder()
                    .withType(type)
                    .withValue(value)
                    .build();

            final Transformation transformation = transformationService.resolve(transformActionTask);

            final String path = row.get(CUCUMBER_DATA_TABLE_COLUMN_PATH);

            runStateJsonMapValue = transform.transform(runStateJsonMapValue, path, transformation);
        }

        return runStateJsonMapValue;
    }

}
