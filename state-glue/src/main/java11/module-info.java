module com.github.nhojpatrick.cucumber.state.glue {
    exports com.github.nhojpatrick.cucumber.state.steps;
    requires com.github.nhojpatrick.hamcrest.collections;
    requires com.github.spotbugs.annotations;
    requires com.google.guice;
    requires io.cucumber.datatable;
    requires io.cucumber.java;
    requires org.hamcrest;
    requires org.junit.jupiter.api;
    requires org.slf4j;
    requires transitive com.github.nhojpatrick.cucumber.core;
    requires transitive com.github.nhojpatrick.cucumber.state;
}
