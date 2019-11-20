module com.github.nhojpatrick.cucumber.state {
    exports com.github.nhojpatrick.cucumber.state.exceptions;
    exports com.github.nhojpatrick.cucumber.state.validation;
    exports com.github.nhojpatrick.cucumber.state;
    requires transitive com.github.nhojpatrick.cucumber.core;
    requires com.github.nhojpatrick.hamcrest.collections;
    requires com.google.guice;
    requires io.cucumber.core;
    requires io.cucumber.datatable;
    requires io.cucumber.guice;
    requires io.cucumber.java;
    requires org.apache.commons.lang3;
    requires org.hamcrest;
    requires org.junit.jupiter.api;
    requires org.slf4j;
}
