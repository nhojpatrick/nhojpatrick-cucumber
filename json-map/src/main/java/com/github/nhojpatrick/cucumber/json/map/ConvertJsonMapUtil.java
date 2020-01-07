package com.github.nhojpatrick.cucumber.json.map;

import com.github.nhojpatrick.cucumber.core.exceptions.IllegalKeyException;
import com.github.nhojpatrick.cucumber.core.exceptions.IllegalTypeClassException;
import com.github.nhojpatrick.cucumber.core.exceptions.TypeMismatchException;
import com.github.nhojpatrick.cucumber.json.map.impl.ConvertObjectToMap;
import com.github.nhojpatrick.cucumber.state.RunState;
import com.github.nhojpatrick.cucumber.state.exceptions.NullRunStateException;
import com.github.nhojpatrick.cucumber.state.validation.RunStateValidatorFactory;

import java.util.Map;

import static java.util.Objects.requireNonNull;

public class ConvertJsonMapUtil {

    private final ConvertObjectToMap convertObjectToMap;

    public ConvertJsonMapUtil() {
        this(
                new ConvertObjectToMap()
        );
    }

    public ConvertJsonMapUtil(final ConvertObjectToMap convertObjectToMap) {
        requireNonNull(convertObjectToMap, "ConvertObjectToMap");
        this.convertObjectToMap = convertObjectToMap;
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
