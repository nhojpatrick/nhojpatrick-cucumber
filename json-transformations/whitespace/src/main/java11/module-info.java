module com.github.nhojpatrick.cucumber.json.transformations.whitespace {
    exports com.github.nhojpatrick.cucumber.json.transformations.whitespace;
    exports com.github.nhojpatrick.cucumber.json.transformations.whitespace.exceptions;
    uses com.github.nhojpatrick.cucumber.json.core.transform.TransformationService;
    provides com.github.nhojpatrick.cucumber.json.core.transform.TransformationService
            with com.github.nhojpatrick.cucumber.json.transformations.whitespace.WhitespaceTransformationService;
    requires com.github.spotbugs.annotations;
    requires com.google.common;
    requires com.google.guice;
    requires org.apache.commons.lang3;
    requires org.joda.beans;
    requires org.slf4j;
    requires transitive com.github.nhojpatrick.cucumber.core;
    requires transitive com.github.nhojpatrick.cucumber.json.core;
    requires transitive com.github.nhojpatrick.cucumber.json.jodabeans;
    requires transitive com.github.nhojpatrick.cucumber.json.transformations.core;
}
