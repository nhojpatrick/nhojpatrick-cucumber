package com.github.nhojpatrick.cucumber.json.transform.transformations.set;

import com.github.nhojpatrick.cucumber.json.core.exceptions.CastToException;
import com.github.nhojpatrick.cucumber.json.core.transform.TransformActionTask;
import com.github.nhojpatrick.cucumber.json.core.transform.Transformation;
import com.github.nhojpatrick.cucumber.json.core.transform.TransformationService;
import com.github.nhojpatrick.cucumber.json.core.transform.utils.CastToUtil;

public class SetTransformationService
        implements TransformationService {

    public static final String ACTION = "set";

    @Override
    public String getAction() {
        return ACTION;
    }

    @Override
    public Transformation resolve(final TransformActionTask transformActionTask)
            throws CastToException {

        final Object value = new CastToUtil()
                .castTo(transformActionTask.getValue(), transformActionTask.getType());
        return new SetTransformation(value);
    }

}
