package com.github.nhojpatrick.cucumber.json.map;

import com.github.nhojpatrick.cucumber.core.exceptions.IllegalKeyException;
import com.github.nhojpatrick.cucumber.core.exceptions.IllegalTypeClassException;
import com.github.nhojpatrick.cucumber.core.exceptions.TypeMismatchException;
import com.github.nhojpatrick.cucumber.state.RunState;
import com.github.nhojpatrick.cucumber.state.exceptions.NullRunStateException;
import com.github.nhojpatrick.cucumber.state.validation.RunStateValidatorFactory;

import java.util.Map;

import static java.util.Objects.requireNonNull;

public class ConvertToMapUtil {

    private final ConvertToMap convertToMap;

    public ConvertToMapUtil() {
        this(new ConvertToMap());
    }

    public ConvertToMapUtil(final ConvertToMap convertToMap) {
        requireNonNull(convertToMap, "ConvertToMap");
        this.convertToMap = convertToMap;
    }

    public void convertToMap(final RunState runState,
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

        final Object obj = runState.get(runStateObjectKey, Object.class);
        final Map<String, Object> runStateJsonMapValue = this.convertToMap.apply(obj);
        runState.set(runStateJsonMapKey, runStateJsonMapValue);
    }

}
