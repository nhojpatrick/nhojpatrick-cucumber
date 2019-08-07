package com.github.nhojpatrick.cucumber.json.steps;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
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
