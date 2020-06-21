module com.github.nhojpatrick.cucumber.json.transform {
    exports com.github.nhojpatrick.cucumber.json.transform;
    exports com.github.nhojpatrick.cucumber.json.transform.exceptions;
    exports com.github.nhojpatrick.cucumber.json.transform.factory;
    exports com.github.nhojpatrick.cucumber.json.transform.transformations;
    uses com.github.nhojpatrick.cucumber.json.core.transform.TransformationService;
    requires com.github.spotbugs.annotations;
    requires org.apache.commons.text;
    requires org.hamcrest;
    requires org.junit.jupiter.api;
    requires org.slf4j;
    requires transitive com.github.nhojpatrick.cucumber.json.core;
    requires transitive com.github.nhojpatrick.cucumber.json.map;
}
