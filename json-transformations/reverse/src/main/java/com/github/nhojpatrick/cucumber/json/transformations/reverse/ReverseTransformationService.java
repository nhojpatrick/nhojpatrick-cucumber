package com.github.nhojpatrick.cucumber.json.transformations.reverse;

import com.github.nhojpatrick.cucumber.json.core.transform.TransformActionTask;
import com.github.nhojpatrick.cucumber.json.core.transform.Transformation;
import com.github.nhojpatrick.cucumber.json.core.transform.TransformationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static java.util.Objects.requireNonNull;

public class ReverseTransformationService
        implements TransformationService {

    public static final String ACTION = "Reverse";

    private static final Logger LOGGER = LoggerFactory.getLogger(ReverseTransformationService.class);

    public ReverseTransformationService() {
    }

    @Override
    public String getAction() {
        return ACTION;
    }

    @Override
    public Transformation resolve(final TransformActionTask transformActionTask) {

        LOGGER.debug("ReverseTransformationService.resolve(input={})", transformActionTask);

        requireNonNull(transformActionTask, "TransformActionTask");

        final Transformation transformation = new ReverseTransformation();

        LOGGER.debug("ReverseTransformationService.resolve(input={}) output={}", transformActionTask, transformation);

        return transformation;
    }

}
