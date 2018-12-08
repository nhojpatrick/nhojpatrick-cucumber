package com.github.nhojpatrick.cucumber.json.transform;

import com.github.nhojpatrick.cucumber.json.exceptions.InvalidTransformActionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;

public enum TransformAction {

    REMOVE("Remove"),

    SET("Set"),

    WHITESPACE("Whitespace");

    private static Logger LOGGER = LoggerFactory.getLogger(TransformAction.class);

    private String value;

    TransformAction(final String value) {
        this.value = value;
    }

    private static final List<TransformAction> ENUM_CACHE = Arrays.asList(values());

    public static TransformAction resolve(final String action)
            throws InvalidTransformActionException {

        return ENUM_CACHE.stream()
                // FIXME name().equalsIgnoreCase deprecated in future release
                .map(p -> {
                    if (!p.value.equals(action)
                            && p.name().equalsIgnoreCase(action)) {
                        LOGGER.warn(String.format("TransformAction.resolve(%s) Case Insensitive matching is deprecated", action));
                    }
                    return p;
                })
                .filter(p -> p.value.equals(action)
                        || p.name().equalsIgnoreCase(action)
                )
                .findFirst()
                .orElseThrow(() -> new InvalidTransformActionException(action));
    }

}
