package com.github.nhojpatrick.cucumber.json.core.transform;

import com.github.nhojpatrick.cucumber.core.exceptions.CheckedIllegalArgumentException;

public interface TransformationService {

    String getAction();

    Transformation resolve(TransformActionTask transformActionTask)
            throws CheckedIllegalArgumentException;

}
