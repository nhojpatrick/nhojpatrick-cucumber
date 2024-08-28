package com.github.nhojpatrick.cucumber.json.map.steps.tests;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

import static io.cucumber.junit.platform.engine.Constants.GLUE_PROPERTY_NAME;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("com/github/nhojpatrick/cucumber/json/map/steps/tests")
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "com.github.nhojpatrick.cucumber.json.map.steps,com.github.nhojpatrick.cucumber.state.steps,com.github.nhojpatrick.cucumber.testing.internal.steps")
public class JsonMapStepsCucumberIT {
}
