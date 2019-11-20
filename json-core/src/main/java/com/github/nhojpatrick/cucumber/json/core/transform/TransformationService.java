package com.github.nhojpatrick.cucumber.json.core.transform;

import com.github.nhojpatrick.cucumber.json.core.exceptions.CastToException;

public interface TransformationService {

    String getAction();

    Transformation resolve(TransformActionTask transformActionTask)
            throws CastToException;

}
