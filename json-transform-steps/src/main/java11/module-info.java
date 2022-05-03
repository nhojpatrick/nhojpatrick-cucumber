module com.github.nhojpatrick.cucumber.json.transform.glue {
    exports com.github.nhojpatrick.cucumber.json.transform.steps;
    requires com.github.spotbugs.annotations;
    requires com.google.guice;
    requires io.cucumber.datatable;
    requires io.cucumber.java;
    requires org.hamcrest;
    requires org.junit.jupiter.api;
    requires org.slf4j;
    requires transitive com.github.nhojpatrick.cucumber.core;
    requires transitive com.github.nhojpatrick.cucumber.json.core;
    requires transitive com.github.nhojpatrick.cucumber.json.jodabeans;
    requires transitive com.github.nhojpatrick.cucumber.json.transform;
    requires transitive com.github.nhojpatrick.cucumber.state;
}
