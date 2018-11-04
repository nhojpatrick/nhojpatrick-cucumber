package com.github.nhojpatrick.cucumber.json.transform.transformations.whitespace.exceptions;

public class WhitespacePrefixException
        extends WhitespaceTransformationArgumentException {

    public WhitespacePrefixException(final int prefix) {
        super(String.format("Whitespace prefix must be positive but was %d.", prefix));
    }

}
