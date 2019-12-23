package com.github.nhojpatrick.cucumber.state.steps;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        strict = true,
        plugin = {"pretty"},
        glue = {
                "com.github.nhojpatrick.cucumber.state.steps",
                "com.github.nhojpatrick.cucumber.testing.internal.steps"
        }
)
public class StateStepsCucumberIT {
}
