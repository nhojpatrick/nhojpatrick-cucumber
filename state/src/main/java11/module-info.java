module com.github.nhojpatrick.cucumber.state {
    exports com.github.nhojpatrick.cucumber.state.exceptions;
    exports com.github.nhojpatrick.cucumber.state.validation;
    exports com.github.nhojpatrick.cucumber.state.validation.impl
            to
            com.github.nhojpatrick.cucumber.state.tests;
    exports com.github.nhojpatrick.cucumber.state;
    requires com.github.nhojpatrick.hamcrest.collections;
    requires com.github.spotbugs.annotations;
    requires com.google.guice;
    requires io.cucumber.datatable;
    requires io.cucumber.guice;
    requires io.cucumber.java;
    requires org.apache.commons.lang3;
    requires org.hamcrest;
    requires org.junit.jupiter.api;
    requires org.slf4j;
    requires transitive com.github.nhojpatrick.cucumber.core;
}
