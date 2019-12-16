package com.github.nhojpatrick.cucumber.json.steps;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        strict = true,
        plugin = {"pretty"},
        glue = {
                "com.github.nhojpatrick.cucumber.json.steps",
                "com.github.nhojpatrick.cucumber.state.steps"
        }
)
public class JsonCucumberIT {
}
