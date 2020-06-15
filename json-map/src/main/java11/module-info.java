module com.github.nhojpatrick.cucumber.json.map {
    exports com.github.nhojpatrick.cucumber.json.map;
    exports com.github.nhojpatrick.cucumber.json.map.impl
            to
            com.github.nhojpatrick.cucumber.json.map.tests;
    requires org.hamcrest;
    requires org.junit.jupiter.api;
    requires org.slf4j;
    requires transitive com.fasterxml.jackson.databind;
    requires transitive com.github.nhojpatrick.cucumber.core;
    requires transitive com.github.nhojpatrick.cucumber.state;
}
