module com.github.nhojpatrick.cucumber.json {
    exports com.github.nhojpatrick.cucumber.json.exceptions;
    exports com.github.nhojpatrick.cucumber.json.transform;
    exports com.github.nhojpatrick.cucumber.json.validation;
    requires org.slf4j;
    requires transitive com.fasterxml.jackson.databind;
    requires transitive com.github.nhojpatrick.cucumber.core;
    requires transitive com.github.nhojpatrick.cucumber.json.core;
}
