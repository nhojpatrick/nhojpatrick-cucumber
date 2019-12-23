package com.github.nhojpatrick.cucumber.json.transformations.whitespace;

import com.github.nhojpatrick.cucumber.json.core.transform.TransformActionTask;
import com.github.nhojpatrick.cucumber.json.core.transform.Transformation;
import com.github.nhojpatrick.cucumber.json.core.transform.TransformationService;
import com.github.nhojpatrick.cucumber.json.transformations.whitespace.exceptions.WhitespaceTransformationArgumentException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static java.util.Objects.requireNonNull;

public class WhitespaceTransformationService
        implements TransformationService {

    public static final String ACTION = "Whitespace";

    private static final Logger LOGGER = LoggerFactory.getLogger(WhitespaceTransformationService.class);

    public WhitespaceTransformationService() {
    }

    @Override
    public String getAction() {
        return ACTION;
    }

    @Override
    public Transformation resolve(final TransformActionTask transformActionTask)
            throws WhitespaceTransformationArgumentException {

        LOGGER.debug("WhitespaceTransformationService.resolve(input={})", transformActionTask);

        requireNonNull(transformActionTask, "TransformActionTask");

        final Transformation transformation = new WhitespaceTransformation(4, 4);

        LOGGER.debug("WhitespaceTransformationService.resolve(input={}) output={}",
                transformActionTask,
                transformation
        );

        return transformation;
    }

}
