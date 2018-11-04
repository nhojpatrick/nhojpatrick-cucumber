package com.github.nhojpatrick.cucumber.core.exceptions;

public class TypeMismatchException
        extends CheckedIllegalArgumentException {

    public TypeMismatchException(final Class<?> tClass, final ClassCastException cce) {
        super(String.format("Run state value does not match requested type '%s'.", String.valueOf(tClass)), cce);
    }

}
