module com.github.nhojpatrick.cucumber.json {
    exports com.github.nhojpatrick.cucumber.json.exceptions;
    exports com.github.nhojpatrick.cucumber.json.map;
    exports com.github.nhojpatrick.cucumber.json.transform;
    exports com.github.nhojpatrick.cucumber.json.validation;
    requires com.fasterxml.jackson.core;
    requires transitive com.fasterxml.jackson.databind;
    requires transitive com.github.nhojpatrick.cucumber.core;
    requires transitive com.github.nhojpatrick.cucumber.json.core;
    requires transitive com.github.nhojpatrick.cucumber.json.transform.transformations.remove;
    requires transitive com.github.nhojpatrick.cucumber.json.transform.transformations.set;
    requires transitive com.github.nhojpatrick.cucumber.json.transform.transformations.whitespace;
    requires transitive com.github.nhojpatrick.cucumber.state;
    requires com.google.common;
    requires com.google.guice;
    requires io.cucumber.datatable;
    requires io.cucumber.java;
    requires org.apache.commons.lang3;
    requires org.junit.jupiter.api;
    requires org.slf4j;
}
