module com.github.nhojpatrick.cucumber.testing.internal.glue {
    exports com.github.nhojpatrick.cucumber.testing.internal.steps.json.transform;
    exports com.github.nhojpatrick.cucumber.testing.internal.steps.json.map;
    exports com.github.nhojpatrick.cucumber.testing.internal.steps.state;
    requires com.github.spotbugs.annotations;
    requires com.google.guice;
    requires io.cucumber.datatable;
    requires io.cucumber.java;
    requires org.hamcrest;
    requires org.junit.jupiter.api;
    requires org.slf4j;
    requires transitive com.github.nhojpatrick.cucumber.core;
    requires transitive com.github.nhojpatrick.cucumber.json.core;
    requires transitive com.github.nhojpatrick.cucumber.json.map;
    requires transitive com.github.nhojpatrick.cucumber.json.transform;
    requires transitive com.github.nhojpatrick.cucumber.json.transformations.all;
    requires transitive com.github.nhojpatrick.cucumber.json.transformations.set;
    requires transitive com.github.nhojpatrick.cucumber.json.transformations.remove;
    requires transitive com.github.nhojpatrick.cucumber.json.transformations.reverse;
    requires transitive com.github.nhojpatrick.cucumber.json.transformations.whitespace;
    requires transitive com.github.nhojpatrick.cucumber.state;
    requires transitive com.github.nhojpatrick.cucumber.testing.internal.objects;
}
