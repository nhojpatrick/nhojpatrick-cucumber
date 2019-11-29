package com.github.nhojpatrick.cucumber.json.transformations.remove;

import com.github.nhojpatrick.cucumber.json.core.transform.TransformActionTask;
import com.github.nhojpatrick.cucumber.json.core.transform.Transformation;
import com.github.nhojpatrick.cucumber.json.core.transform.TransformationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static java.util.Objects.requireNonNull;

public class RemoveTransformationService
        implements TransformationService {

    public static final String ACTION = "remove";

    private static final Logger LOGGER = LoggerFactory.getLogger(RemoveTransformationService.class);

    public RemoveTransformationService() {
    }

    @Override
    public String getAction() {
        return ACTION;
    }

    @Override
    public Transformation resolve(final TransformActionTask transformActionTask) {

        LOGGER.debug("RemoveTransformationService.resolve(input={})", transformActionTask);

        requireNonNull(transformActionTask, "TransformActionTask");

        final Transformation transformation = new RemoveTransformation();

        LOGGER.debug("RemoveTransformationService.resolve(input={}) output={}", transformActionTask, transformation);

        return transformation;
    }

}
