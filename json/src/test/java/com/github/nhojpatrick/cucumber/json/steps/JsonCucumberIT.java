package com.github.nhojpatrick.cucumber.json.steps;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty"},
        glue = {
                "com.github.nhojpatrick.cucumber.json.steps",
                "com.github.nhojpatrick.cucumber.state.steps"
        }
//        ,
//        tags = {
//                "@Tag"
//        }
)
public class JsonCucumberIT {
}
