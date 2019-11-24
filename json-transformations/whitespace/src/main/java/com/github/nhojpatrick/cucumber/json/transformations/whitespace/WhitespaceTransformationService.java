package com.github.nhojpatrick.cucumber.json.transformations.whitespace;

import com.github.nhojpatrick.cucumber.json.core.transform.TransformActionTask;
import com.github.nhojpatrick.cucumber.json.core.transform.Transformation;
import com.github.nhojpatrick.cucumber.json.core.transform.TransformationService;
import com.github.nhojpatrick.cucumber.json.transformations.whitespace.exceptions.WhitespaceTransformationArgumentException;

public class WhitespaceTransformationService
        implements TransformationService {

    public static final String ACTION = "whitespace";

    @Override
    public String getAction() {
        return ACTION;
    }

    @Override
    public Transformation resolve(final TransformActionTask transformActionTask)
            throws WhitespaceTransformationArgumentException {

        return new WhitespaceTransformation(4, 4);
    }

}
