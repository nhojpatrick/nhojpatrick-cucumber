package com.github.nhojpatrick.cucumber.json.core.castto.exceptions;

public class UnsupportedDataTypeConversionException
        extends CastToException {

    public static final String UNSUPPORTED_DATA_TYPE_CONVERSION_MSG
            = "Unsupported data type conversion for type '%s' from value '%s'.";

    public UnsupportedDataTypeConversionException(final String type, final String value) {
        super(String.format(UNSUPPORTED_DATA_TYPE_CONVERSION_MSG, type, value));
    }

    public UnsupportedDataTypeConversionException(final String type, final String value, final Throwable cause) {
        super(String.format(UNSUPPORTED_DATA_TYPE_CONVERSION_MSG, type, value), cause);
    }

}
