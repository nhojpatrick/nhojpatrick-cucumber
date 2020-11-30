package com.github.nhojpatrick.cucumber.all.steps.tests;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        strict = true,
        plugin = {"pretty"},
        glue = {
                "com.github.nhojpatrick.cucumber.all.steps",
                "com.github.nhojpatrick.cucumber.testing.internal.steps"
        }
)
public class AllStepsCucumberIT {
}
