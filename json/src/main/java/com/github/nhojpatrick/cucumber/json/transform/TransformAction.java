package com.github.nhojpatrick.cucumber.json.transform;

import com.github.nhojpatrick.cucumber.json.exceptions.InvalidTransformActionException;

import java.util.Arrays;
import java.util.List;

public enum TransformAction {

    REMOVE,

    SET,

    WHITESPACE;

    private static final List<TransformAction> ENUM_CACHE = Arrays.asList(values());

    public static TransformAction resolve(final String action)
            throws InvalidTransformActionException {

        return ENUM_CACHE.stream()
                .filter(p -> p.name().equalsIgnoreCase(action))
                .findFirst()
                .orElseThrow(() -> new InvalidTransformActionException(action));
    }

}
