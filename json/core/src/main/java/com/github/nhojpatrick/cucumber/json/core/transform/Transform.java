package com.github.nhojpatrick.cucumber.json.core.transform;

import com.github.nhojpatrick.cucumber.core.exceptions.IllegalKeyException;
import com.github.nhojpatrick.cucumber.core.exceptions.IllegalOperationException;
import com.github.nhojpatrick.cucumber.json.core.exceptions.InvalidPathException;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;

import java.util.Map;

public interface Transform {

    @SuppressFBWarnings(value = "PI_DO_NOT_REUSE_PUBLIC_IDENTIFIERS_CLASS_NAMES", justification = "Accepted")
    Map<String, Object> transform(String path,
                                  Map<String, Object> input,
                                  Transformation transformation)
            throws IllegalKeyException,
            IllegalOperationException,
            InvalidPathException;

}
