module com.github.nhojpatrick.cucumber.state {
    exports com.github.nhojpatrick.cucumber.state.exceptions;
    exports com.github.nhojpatrick.cucumber.state.validation;
    exports com.github.nhojpatrick.cucumber.state;
    requires com.github.nhojpatrick.cucumber.core;
    requires com.github.nhojpatrick.hamcrest.collections;
    requires com.google.guice;
    requires cucumber.core;
    requires cucumber.guice;
    requires cucumber.java;
    requires datatable;
    requires hamcrest.core;
    requires org.apache.commons.lang3;
    requires org.junit.jupiter.api;
}
