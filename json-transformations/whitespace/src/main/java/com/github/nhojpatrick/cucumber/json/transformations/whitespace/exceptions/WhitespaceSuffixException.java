package com.github.nhojpatrick.cucumber.json.transformations.whitespace.exceptions;

public class WhitespaceSuffixException
        extends WhitespaceTransformationArgumentException {

    public WhitespaceSuffixException(final int suffix) {
        super(String.format("Whitespace suffix must be positive but was %d.", suffix));
    }

}
