package com.github.nhojpatrick.cucumber.testing.internal.steps.state;

import com.github.nhojpatrick.cucumber.core.exceptions.IllegalKeyException;
import com.github.nhojpatrick.cucumber.state.RunState;
import com.google.inject.Inject;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static com.github.nhojpatrick.cucumber.testing.internal.objects.TestingInternalObjectsConstants.MAP_EMPTY;
import static com.github.nhojpatrick.cucumber.testing.internal.objects.TestingInternalObjectsConstants.getMapBasicArrays;
import static com.github.nhojpatrick.cucumber.testing.internal.objects.TestingInternalObjectsConstants.getMapBasicAttributes;
import static com.github.nhojpatrick.cucumber.testing.internal.objects.legacy.LegacyTestingInternalObjectsConstants.COMPLEX_OBJECT_AS_OBJECT;
import static com.github.nhojpatrick.cucumber.testing.internal.objects.legacy.LegacyTestingInternalObjectsConstants.SIMPLE_OBJECT_AS_OBJECT;

public class State_TestingInternalSteps {

    private RunState runState;

    @Inject
    public State_TestingInternalSteps(final RunState runState) {
        this.runState = runState;
    }

    @Given("^TestingInternalSteps I have setup the run state for keys and type:$")
    public void setupRunStateForKeysAndValue(final DataTable data)
            throws IllegalKeyException {

        final Map<String, String> stringStringMap = data.asMap(String.class, String.class);
        for (final Map.Entry<String, String> row : stringStringMap.entrySet()) {
            switch (row.getValue()) {
                case "ComplexObject":
                    this.runState.set(row.getKey(), COMPLEX_OBJECT_AS_OBJECT);
                    break;

                case "List_Empty":
                    this.runState.set(row.getKey(), new ArrayList<>());
                    break;

                case "Map_BasicArrays":
                    this.runState.set(row.getKey(), getMapBasicArrays());
                    break;

                case "Map_BasicAttributes":
                    this.runState.set(row.getKey(), getMapBasicAttributes());
                    break;

                case "Map_Empty":
                    this.runState.set(row.getKey(), new HashMap<>(MAP_EMPTY));
                    break;

                case "Null":
                    this.runState.set(row.getKey(), null);
                    break;

                case "Object":
                    this.runState.set(row.getKey(), new Object());
                    break;

                case "SimpleObject":
                    this.runState.set(row.getKey(), SIMPLE_OBJECT_AS_OBJECT);
                    break;

                default:
                    final String message = String.format("Unknown Type '%s' for key '%s'.",
                            row.getValue(),
                            row.getKey());
                    throw new IllegalArgumentException(message);
            }
        }
    }

}
