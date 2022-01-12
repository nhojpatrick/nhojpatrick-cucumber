module com.github.nhojpatrick.cucumber.json.transformations.print {
    exports com.github.nhojpatrick.cucumber.json.transformations.print;
    uses com.github.nhojpatrick.cucumber.json.core.transform.TransformationService;
    provides com.github.nhojpatrick.cucumber.json.core.transform.TransformationService
            with com.github.nhojpatrick.cucumber.json.transformations.print.PrintTransformationService;
    requires com.github.spotbugs.annotations;
    requires com.google.guice;
    requires org.apache.commons.lang3;
    requires org.joda.beans;
    requires org.slf4j;
    requires transitive com.github.nhojpatrick.cucumber.core;
    requires transitive com.github.nhojpatrick.cucumber.json.core;
    requires transitive com.github.nhojpatrick.cucumber.json.jodabeans;
    requires transitive com.github.nhojpatrick.cucumber.json.transformations.core;
}
