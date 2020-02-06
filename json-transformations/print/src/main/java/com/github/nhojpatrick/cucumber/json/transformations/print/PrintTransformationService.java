package com.github.nhojpatrick.cucumber.json.transformations.print;

import com.github.nhojpatrick.cucumber.json.core.transform.Transformation;
import com.github.nhojpatrick.cucumber.json.core.transform.TransformationService;
import com.github.nhojpatrick.cucumber.json.jodabeans.transform.TransformActionTask;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static java.util.Objects.requireNonNull;

public class PrintTransformationService
        implements TransformationService {

    public static final String ACTION = "Print";

    private static final Logger LOGGER = LoggerFactory.getLogger(PrintTransformationService.class);

    public PrintTransformationService() {
    }

    @Override
    public String getAction() {
        return ACTION;
    }

    @Override
    public Transformation resolve(final TransformActionTask transformActionTask) {

        LOGGER.debug("PrintTransformationService.resolve(input={})", transformActionTask);

        requireNonNull(transformActionTask, "TransformActionTask");

        final Transformation transformation = new PrintTransformation();

        LOGGER.debug("PrintTransformationService.resolve(input={}) output={}", transformActionTask, transformation);

        return transformation;
    }

}
