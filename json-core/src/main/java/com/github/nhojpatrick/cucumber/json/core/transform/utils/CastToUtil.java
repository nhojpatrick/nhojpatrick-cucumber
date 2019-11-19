package com.github.nhojpatrick.cucumber.json.core.transform.utils;

import com.github.nhojpatrick.cucumber.json.core.exceptions.CastToException;
import com.github.nhojpatrick.cucumber.json.core.exceptions.UnsupportedDataTypeConversionException;
import com.github.nhojpatrick.cucumber.json.core.exceptions.UnsupportedDataTypeException;
import com.github.nhojpatrick.cucumber.json.core.transform.CastTo;

import java.util.ArrayList;
import java.util.HashMap;

public class CastToUtil
        implements CastTo {

    @Override
    public Object castTo(final String value, final String type)
            throws CastToException {

        switch (type) {
            case "null":
                return null;

            case "java.lang.String":
                return value;

            case "java.lang.Boolean":
                if (!"true".equalsIgnoreCase(value)
                        && !"false".equalsIgnoreCase(value)) {
                    throw new UnsupportedDataTypeConversionException(type, value);
                }
                return Boolean.valueOf(value);

            case "java.lang.Integer":
                try {
                    return Integer.valueOf(value);
                } catch (final RuntimeException re) {
                    throw new UnsupportedDataTypeConversionException(type, value, re);
                }

            case "java.lang.Long":
                try {
                    return Long.valueOf(value);
                } catch (final RuntimeException re) {
                    throw new UnsupportedDataTypeConversionException(type, value, re);
                }

            case "java.lang.Double":
                try {
                    return Double.valueOf(value);
                } catch (final RuntimeException re) {
                    throw new UnsupportedDataTypeConversionException(type, value, re);
                }

            case "java.lang.Float":
                try {
                    return Float.valueOf(value);
                } catch (final RuntimeException re) {
                    throw new UnsupportedDataTypeConversionException(type, value, re);
                }

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

            default:
                throw new UnsupportedDataTypeException(type);
        }
    }

}
