package com.github.nhojpatrick.cucumber.json.core.transform;

import com.github.nhojpatrick.cucumber.json.core.exceptions.CastToException;

@FunctionalInterface
public interface CastTo {

    Object castTo(final String type, final String value)
            throws CastToException;

}
