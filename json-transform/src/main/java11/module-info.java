module com.github.nhojpatrick.cucumber.json.transform {
    exports com.github.nhojpatrick.cucumber.json.transform;
    exports com.github.nhojpatrick.cucumber.json.transform.exceptions;
    exports com.github.nhojpatrick.cucumber.json.transform.factory;
    exports com.github.nhojpatrick.cucumber.json.transform.impl
            to
            com.github.nhojpatrick.cucumber.json.transform.tests;
    exports com.github.nhojpatrick.cucumber.json.transform.transformations;
    exports com.github.nhojpatrick.cucumber.json.transform.validation
            to
            com.github.nhojpatrick.cucumber.json.transform.tests;
    uses com.github.nhojpatrick.cucumber.json.core.transform.TransformationService;
    requires com.github.spotbugs.annotations;
    requires org.apache.commons.text;
    requires org.hamcrest;
    requires org.junit.jupiter.api;
    requires org.slf4j;
    requires transitive com.github.nhojpatrick.cucumber.json.core;
    requires transitive com.github.nhojpatrick.cucumber.json.map;
}
