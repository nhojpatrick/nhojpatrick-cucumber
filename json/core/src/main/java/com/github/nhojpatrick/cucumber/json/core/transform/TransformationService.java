package com.github.nhojpatrick.cucumber.json.core.transform;

import com.github.nhojpatrick.cucumber.core.exceptions.CheckedIllegalArgumentException;
import com.github.nhojpatrick.cucumber.json.jodabeans.transform.TransformActionTask;

public interface TransformationService {

    String getAction();

    Transformation resolve(TransformActionTask transformActionTask)
            throws CheckedIllegalArgumentException;

}
