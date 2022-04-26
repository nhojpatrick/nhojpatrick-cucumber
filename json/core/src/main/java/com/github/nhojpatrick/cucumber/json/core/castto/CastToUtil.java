package com.github.nhojpatrick.cucumber.json.core.castto;

import com.github.nhojpatrick.cucumber.json.core.castto.exceptions.CastToException;
import com.github.nhojpatrick.cucumber.json.core.castto.exceptions.UnsupportedDataTypeConversionException;
import com.github.nhojpatrick.cucumber.json.core.castto.exceptions.UnsupportedDataTypeException;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;

import java.util.ArrayList;
import java.util.HashMap;

import static java.util.Objects.requireNonNull;

public class CastToUtil
        implements CastTo {

    @Override
    public Object castTo(final String value, final String type)
            throws CastToException {

        requireNonNull(type, "CastToUtil.castTo(type)");

        try {
            return doCastTo(value, type);

        } catch (final RuntimeException re) {
            throw new UnsupportedDataTypeConversionException(type, value, re);
        }
    }

    @SuppressFBWarnings(value = {"CC_CYCLOMATIC_COMPLEXITY",
            "URV_CHANGE_RETURN_TYPE"}, justification = "As designed")
    private Object doCastTo(final String value, final String type)
            throws UnsupportedDataTypeConversionException,
            UnsupportedDataTypeException {

        switch (type) {
            case "null":
                return null;

            case "JsonObject":
                return new HashMap<String, Object>();

            case "java.lang.String":
                return value;

            case "java.lang.Boolean":
                if (!"true".equals(value)
                        && !"false".equals(value)) {
                    throw new UnsupportedDataTypeConversionException(type, value);
                }
                return Boolean.valueOf(value);

            case "java.lang.Integer":
                return Integer.valueOf(value);

            case "java.lang.Float":
                return Float.valueOf(value);

            case "java.lang.Long":
                return Long.valueOf(value);

            case "java.lang.Double":
                return Double.valueOf(value);

            case "JsonArray<JsonObject>":
                return new ArrayList<HashMap<String, Object>>();

            case "JsonArray<java.lang.String>":
                return new ArrayList<String>();

            case "JsonArray<java.lang.Boolean>":
                return new ArrayList<Boolean>();

            case "JsonArray<java.lang.Integer>":
                return new ArrayList<Integer>();

            case "JsonArray<java.lang.Float>":
                return new ArrayList<Float>();

            case "JsonArray<java.lang.Double>":
                return new ArrayList<Double>();

            case "JsonArray<java.lang.Long>":
                return new ArrayList<Long>();

            default:
                throw new UnsupportedDataTypeException(type);
        }
    }

}
