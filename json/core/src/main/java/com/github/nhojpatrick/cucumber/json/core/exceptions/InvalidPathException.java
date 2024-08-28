package com.github.nhojpatrick.cucumber.json.core.exceptions;

import com.github.nhojpatrick.cucumber.core.exceptions.CheckedIllegalArgumentException;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;

public class InvalidPathException
        extends CheckedIllegalArgumentException {

    @SuppressFBWarnings(value = "PI_DO_NOT_REUSE_PUBLIC_IDENTIFIERS_CLASS_NAMES", justification = "Accepted")
    public InvalidPathException(final String message) {
        super(message);
    }

    public InvalidPathException(final String format, final Object... vars) {
        this(String.format(format, vars));
    }

}
