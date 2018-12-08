package com.github.nhojpatrick.cucumber.json.transform.utils;

import com.github.nhojpatrick.cucumber.json.exceptions.CastToException;
import com.github.nhojpatrick.cucumber.json.exceptions.UnsupportedDataTypeException;

import java.util.ArrayList;
import java.util.HashMap;

public class CastToUtil
        implements CastTo {

    @Override
    public Object castTo(final String value, final String type)
            throws CastToException {

        switch (type) {
            case "JsonArray<JsonObject>":
                return new ArrayList<HashMap<String, Object>>();

            case "JsonArray<java.lang.Boolean>":
                return new ArrayList<Boolean>();

            case "JsonArray<java.lang.Double>":
                return new ArrayList<Double>();

            case "JsonArray<java.lang.Float>":
                return new ArrayList<Float>();

            case "JsonArray<java.lang.Long>":
                return new ArrayList<Long>();

            case "JsonArray<java.lang.Integer>":
                return new ArrayList<Integer>();

            case "JsonArray<java.lang.String>":
                return new ArrayList<String>();

            case "JsonObject":
                return new HashMap<String, Object>();

            case "java.lang.Boolean":
                return Boolean.valueOf(value);

            case "java.lang.Double":
                return Double.valueOf(value);

            case "java.lang.Float":
                return Float.valueOf(value);

            case "java.lang.Long":
                return Long.valueOf(value);

            case "java.lang.Integer":
                return Integer.valueOf(value);

            case "java.lang.String":
                return value;

            case "null":
                return null;

            default:
                throw new UnsupportedDataTypeException(type);
        }
    }

}
