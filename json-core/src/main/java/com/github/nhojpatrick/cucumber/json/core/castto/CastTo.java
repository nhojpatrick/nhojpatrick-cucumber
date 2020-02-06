package com.github.nhojpatrick.cucumber.json.core.castto;

import com.github.nhojpatrick.cucumber.json.core.castto.exceptions.CastToException;

@FunctionalInterface
public interface CastTo {

    Object castTo(final String type, final String value)
            throws CastToException;

}
