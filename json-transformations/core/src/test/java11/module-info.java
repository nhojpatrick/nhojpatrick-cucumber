open module com.github.nhojpatrick.cucumber.json.transformations.core.test {
    uses com.github.nhojpatrick.cucumber.json.core.transform.TransformationService;
    requires com.github.nhojpatrick.cucumber.json.transformations.core;
    requires com.github.nhojpatrick.cucumber.testing.internal.objects;
    requires com.github.nhojpatrick.hamcrest.collections;
    requires com.github.nhojpatrick.hamcrest.lang;
    requires org.apache.logging.log4j;
    requires org.hamcrest;
    requires transitive org.junit.jupiter.api;
    requires transitive org.junit.jupiter.engine;
}
