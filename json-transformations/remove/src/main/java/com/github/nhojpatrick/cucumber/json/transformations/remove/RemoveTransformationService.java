package com.github.nhojpatrick.cucumber.json.transformations.remove;

import com.github.nhojpatrick.cucumber.json.core.transform.TransformActionTask;
import com.github.nhojpatrick.cucumber.json.core.transform.Transformation;
import com.github.nhojpatrick.cucumber.json.core.transform.TransformationService;

public class RemoveTransformationService
        implements TransformationService {

    public static final String ACTION = "remove";

    @Override
    public String getAction() {
        return ACTION;
    }

    @Override
    public Transformation resolve(final TransformActionTask transformActionTask) {

        return new RemoveTransformation();
    }

}
