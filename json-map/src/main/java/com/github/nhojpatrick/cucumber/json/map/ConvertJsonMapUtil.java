package com.github.nhojpatrick.cucumber.json.map;

import com.github.nhojpatrick.cucumber.core.exceptions.IllegalKeyException;
import com.github.nhojpatrick.cucumber.core.exceptions.IllegalTypeClassException;
import com.github.nhojpatrick.cucumber.core.exceptions.TypeMismatchException;
import com.github.nhojpatrick.cucumber.json.map.impl.ConvertMapToJson;
import com.github.nhojpatrick.cucumber.json.map.impl.ConvertObjectToMap;
import com.github.nhojpatrick.cucumber.state.RunState;
import com.github.nhojpatrick.cucumber.state.exceptions.NullRunStateException;
import com.github.nhojpatrick.cucumber.state.validation.RunStateValidatorFactory;

import java.util.Map;

import static java.util.Objects.requireNonNull;

public class ConvertJsonMapUtil {

    private final ConvertMapToJson convertMapToJson;
    private final ConvertObjectToMap convertObjectToMap;

    public ConvertJsonMapUtil() {
        this(
                new ConvertMapToJson(),
                new ConvertObjectToMap()
        );
    }

    public ConvertJsonMapUtil(final boolean formatJson) {
        this(
                new ConvertMapToJson(formatJson),
                new ConvertObjectToMap()
        );
    }

    public ConvertJsonMapUtil(final ConvertMapToJson convertMapToJson,
                              final ConvertObjectToMap convertObjectToMap) {
        requireNonNull(convertMapToJson, "ConvertMapToJson");
        requireNonNull(convertObjectToMap, "ConvertObjectToMap");
        this.convertMapToJson = convertMapToJson;
        this.convertObjectToMap = convertObjectToMap;
    }

    public void convertMapToJson(final RunState runState,
                                 final String runStateJsonMapKey,
                                 final String runStateJsonStringKey)
            throws IllegalKeyException,
            IllegalTypeClassException,
            NullRunStateException,
            TypeMismatchException {

        requireNonNull(runState, "RunState");
        requireNonNull(runStateJsonMapKey, "RunStateJsonMapKey");
        requireNonNull(runStateJsonStringKey, "RunStateJsonStringKey");

        RunStateValidatorFactory.getInstance()
                .withNull(runStateJsonStringKey)
                .withValue(runStateJsonMapKey)
                .verify(runState);

        final Map<String, Object> runStateJsonMapValue = runState.get(runStateJsonMapKey, Map.class);
        final String runStateJsonStringValue = this.convertMapToJson.apply(runStateJsonMapValue);
        runState.set(runStateJsonStringKey, runStateJsonStringValue);
    }

    public void convertObjectToMap(final RunState runState,
                                   final String runStateObjectKey,
                                   final String runStateJsonMapKey)
            throws IllegalKeyException,
            IllegalTypeClassException,
            NullRunStateException,
            TypeMismatchException {

        requireNonNull(runState, "RunState");
        requireNonNull(runStateObjectKey, "RunStateObjectKey");
        requireNonNull(runStateJsonMapKey, "RunStateJsonMapKey");

        RunStateValidatorFactory.getInstance()
                .withNull(runStateJsonMapKey)
                .withValue(runStateObjectKey)
                .verify(runState);

        final Object runStateObjectValue = runState.get(runStateObjectKey, Object.class);
        final Map<String, Object> runStateJsonMapValue = this.convertObjectToMap.apply(runStateObjectValue);
        runState.set(runStateJsonMapKey, runStateJsonMapValue);
    }

}
