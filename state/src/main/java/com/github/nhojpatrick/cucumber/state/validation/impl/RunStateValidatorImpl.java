package com.github.nhojpatrick.cucumber.state.validation.impl;

import com.github.nhojpatrick.cucumber.core.exceptions.IllegalKeyException;
import com.github.nhojpatrick.cucumber.core.exceptions.NullKeyException;
import com.github.nhojpatrick.cucumber.state.RunState;
import com.github.nhojpatrick.cucumber.state.exceptions.NullRunStateException;
import com.github.nhojpatrick.cucumber.state.validation.RunStateValidator;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;

import java.util.HashSet;
import java.util.Set;

import static com.github.nhojpatrick.hamcrest.collections.IsCollection.collectionWithSize;
import static java.util.Objects.isNull;
import static java.util.stream.Collectors.toSet;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.assertAll;

@SuppressFBWarnings(value = "THROWS_METHOD_THROWS_CLAUSE_THROWABLE", justification = "JUnit assertAll API")
public class RunStateValidatorImpl
        implements RunStateValidator {

    private final Set<String> nulls;
    private final Set<String> values;

    public RunStateValidatorImpl() {
        this.nulls = new HashSet<>();
        this.values = new HashSet<>();
    }

    @Override
    public RunStateValidator withNull(final String key)
            throws IllegalKeyException {

        if (isNull(key)) {
            throw new NullKeyException();
        }

        this.nulls.add(key);

        return this;
    }

    @Override
    public RunStateValidator withValue(final String key)
            throws IllegalKeyException {

        if (isNull(key)) {
            throw new NullKeyException();
        }

        this.values.add(key);

        return this;
    }

    @Override
    public void verify(final RunState runState)
            throws NullRunStateException {

        if (isNull(runState)) {
            throw new NullRunStateException();
        }

        final Set<String> nullErrors = this.nulls.stream()
                .filter(p -> {
                    try {
                        return runState.isSet(p);

                    } catch (final IllegalKeyException ike) {
                        return false;
                    }
                })
                .collect(toSet());

        final Set<String> valuesErrors = this.values.stream()
                .filter(p -> {
                    try {
                        return runState.isUnset(p);

                    } catch (final IllegalKeyException ike) {
                        return false;
                    }
                })
                .collect(toSet());

        assertAll("Run State Validation",
                () -> assertThat("Keys where value was expected to be null",
                        nullErrors,
                        is(collectionWithSize(0)
                        )),
                () -> assertThat("Keys where value was expected to be non null",
                        valuesErrors,
                        is(collectionWithSize(0)
                        ))
        );
    }

}
