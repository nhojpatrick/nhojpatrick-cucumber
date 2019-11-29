package com.github.nhojpatrick.cucumber.json.transformations.whitespace.exceptions;

public class WhitespaceInvalidArgumentException
        extends WhitespaceTransformationArgumentException {

    public WhitespaceInvalidArgumentException(final String value) {
        super(String.format("Whitespace prefix/suffix is not valid number %s.", value));
    }

}
