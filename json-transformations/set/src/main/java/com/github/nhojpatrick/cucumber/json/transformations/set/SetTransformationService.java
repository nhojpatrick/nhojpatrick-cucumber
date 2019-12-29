package com.github.nhojpatrick.cucumber.json.transformations.set;

import com.github.nhojpatrick.cucumber.json.core.exceptions.CastToException;
import com.github.nhojpatrick.cucumber.json.core.transform.Transformation;
import com.github.nhojpatrick.cucumber.json.core.transform.TransformationService;
import com.github.nhojpatrick.cucumber.json.core.transform.utils.CastToUtil;
import com.github.nhojpatrick.cucumber.json.jodabeans.transform.TransformActionTask;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static java.util.Objects.requireNonNull;

public class SetTransformationService
        implements TransformationService {

    public static final String ACTION = "Set";

    private static final Logger LOGGER = LoggerFactory.getLogger(SetTransformationService.class);

    public SetTransformationService() {
    }

    @Override
    public String getAction() {
        return ACTION;
    }

    @Override
    public Transformation resolve(final TransformActionTask transformActionTask)
            throws CastToException {

        LOGGER.debug("SetTransformationService.resolve(input={})", transformActionTask);

        requireNonNull(transformActionTask, "TransformActionTask");
        requireNonNull(transformActionTask.getType(), "TransformActionTask.getType()");

        final Object value = new CastToUtil()
                .castTo(transformActionTask.getValue(), transformActionTask.getType());
        final Transformation transformation = new SetTransformation(value);

        LOGGER.debug("SetTransformationService.resolve(input={}) output={}", transformActionTask, transformation);

        return transformation;
    }

}
