package com.github.nhojpatrick.cucumber.testing.internal.steps.state;

import com.github.nhojpatrick.cucumber.core.exceptions.IllegalKeyException;
import com.github.nhojpatrick.cucumber.state.RunState;
import com.google.inject.Inject;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import static com.github.nhojpatrick.cucumber.testing.internal.objects.TestingInternalObjectsConstants.getMapBasicArrays;
import static com.github.nhojpatrick.cucumber.testing.internal.objects.TestingInternalObjectsConstants.getObjectBasicArrays;
import static com.github.nhojpatrick.cucumber.testing.internal.objects.TestingInternalObjectsConstants.getObjectBasicAttributes;
import static com.github.nhojpatrick.cucumber.testing.internal.objects.TestingInternalObjectsConstants.getMapBasicAttributes;

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
                    this.runState.set(row.getKey(), new LinkedHashMap<String, Object>());
                    break;

                case "Map_Null":
                    this.runState.set(row.getKey(), (Map<String, Object>) null);
                    break;

                case "Null":
                    this.runState.set(row.getKey(), null);
                    break;

                case "Object_BasicArrays":
                    this.runState.set(row.getKey(), getObjectBasicArrays());
                    break;

                case "Object_BasicAttributes":
                    this.runState.set(row.getKey(), getObjectBasicAttributes());
                    break;

                case "Object_Empty":
                    this.runState.set(row.getKey(), new Object());
                    break;

                case "Object_Null":
                    this.runState.set(row.getKey(), (Object) null);
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
