module com.github.nhojpatrick.cucumber.json.map {
    exports com.github.nhojpatrick.cucumber.json.map;
    exports com.github.nhojpatrick.cucumber.json.map.impl
            to com.github.nhojpatrick.cucumber.json.map.test;
    requires com.fasterxml.jackson.annotation;
    requires com.github.spotbugs.annotations;
    requires org.hamcrest;
    requires org.junit.jupiter.api;
    requires org.slf4j;
    requires transitive com.fasterxml.jackson.core;
    requires transitive com.fasterxml.jackson.databind;
    requires transitive com.github.nhojpatrick.cucumber.core;
    requires transitive com.github.nhojpatrick.cucumber.state;
}
