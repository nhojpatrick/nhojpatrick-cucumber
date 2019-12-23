package com.github.nhojpatrick.cucumber.state.steps;

import com.github.nhojpatrick.cucumber.core.exceptions.WhitespaceKeyException;
import com.github.nhojpatrick.cucumber.state.RunState;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.function.Executable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static com.github.nhojpatrick.hamcrest.lang.IsThrowable.throwable;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StateStepsTest {

    @TestFactory
    public Collection<DynamicTest> exceptions() {

        return Arrays.asList(

                DynamicTest.dynamicTest("clearRunStateForKeys", () -> {
                    final RunState runState = new RunState();
                    final StateSteps classUnderTest = new StateSteps(runState);
                    final List<String> keys = new ArrayList<>();
                    keys.add("    ");

                    final Executable testMethod = () -> classUnderTest.clearRunStateForKeys(keys);
                    final RuntimeException thrown = assertThrows(RuntimeException.class, testMethod);
                    assertAll("Checking Exception",
                            () -> assertThat(thrown.getMessage(), is(equalTo("Illegal key whilst clearing run state."))),
                            () -> assertThat(thrown.getCause(), is(throwable(WhitespaceKeyException.class, "Whitespace String Key.")))
                    );
                })

        );
    }

}
