package com.github.nhojpatrick.cucumber.json.transform.steps;

import com.github.nhojpatrick.cucumber.core.exceptions.CheckedIllegalArgumentException;
import com.github.nhojpatrick.cucumber.core.exceptions.IllegalOperationException;
import com.github.nhojpatrick.cucumber.json.core.transform.Transform;
import com.github.nhojpatrick.cucumber.json.core.transform.Transformation;
import com.github.nhojpatrick.cucumber.json.core.transform.TransformationService;
import com.github.nhojpatrick.cucumber.json.jodabeans.transform.TransformActionTask;
import com.github.nhojpatrick.cucumber.json.transform.exceptions.InvalidTransformActionException;
import com.github.nhojpatrick.cucumber.json.transform.factory.TransformFactory;
import com.github.nhojpatrick.cucumber.json.transform.transformations.TransformationServiceFactory;
import com.github.nhojpatrick.cucumber.state.RunState;
import com.github.nhojpatrick.cucumber.state.validation.RunStateValidatorFactory;
import com.google.inject.Inject;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;

import java.util.List;
import java.util.Map;

import static com.github.nhojpatrick.cucumber.json.transform.TransformConstants.CUCUMBER_DATA_TABLE_COLUMN_ACTION;
import static com.github.nhojpatrick.cucumber.json.transform.TransformConstants.CUCUMBER_DATA_TABLE_COLUMN_PATH;
import static com.github.nhojpatrick.cucumber.json.transform.TransformConstants.CUCUMBER_DATA_TABLE_COLUMN_TYPE;
import static com.github.nhojpatrick.cucumber.json.transform.TransformConstants.CUCUMBER_DATA_TABLE_COLUMN_VALUE;
import static com.github.nhojpatrick.cucumber.json.transform.TransformConstants.DEFAULT_MAP_KEY;

@SuppressFBWarnings(value = "EI_EXPOSE_REP2", justification = "Accepted will look at changing")
public class TransformationSteps {

    private final RunState runState;

    @Inject
    public TransformationSteps(final RunState runState) {
        this.runState = runState;
    }

    @Given("^I transform json map using default RunStateKey on paths:$")
    public void transform(final DataTable dataTable)
            throws CheckedIllegalArgumentException,
            IllegalOperationException {

        transform(DEFAULT_MAP_KEY, dataTable);
    }

    @Given("I transform json map using RunStateKey {string} on paths:")
    public void transform(final String runStateJsonMapKey, final DataTable dataTable)
            throws CheckedIllegalArgumentException,
            IllegalOperationException {

        RunStateValidatorFactory.getInstance()
                .withValue(runStateJsonMapKey)
                .verify(this.runState);

        Map<String, Object> runStateJsonMapValue = this.runState.get(runStateJsonMapKey, Map.class);

        runStateJsonMapValue = transform(runStateJsonMapValue, dataTable.asMaps(String.class, String.class));

        this.runState.set(runStateJsonMapKey, runStateJsonMapValue);
    }

    @SuppressFBWarnings(value = "PCAIL_POSSIBLE_CONSTANT_ALLOCATION_IN_LOOP",
            justification = "Accepted usage of new TransformActionTask.Builder()")
    private Map<String, Object> transform(Map<String, Object> runStateJsonMapValue,
                                          final List<Map<String, String>> dataTable)
            throws CheckedIllegalArgumentException,
            IllegalOperationException {

        final TransformationServiceFactory transformationServiceFactory = TransformationServiceFactory.getFactory();
        final Transform transform = TransformFactory.getFactory()
                .get();

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

            runStateJsonMapValue = transform.transform(path, runStateJsonMapValue, transformation);
        }

        return runStateJsonMapValue;
    }

}
