package com.github.nhojpatrick.cucumber.json.transform.utils;

import com.github.nhojpatrick.cucumber.json.exceptions.UnsupportedDataTypeException;

@FunctionalInterface
public interface CastTo {

    Object castTo(final String type, final String value)
            throws UnsupportedDataTypeException;

}
