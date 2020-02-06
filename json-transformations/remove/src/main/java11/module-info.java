module com.github.nhojpatrick.cucumber.json.transformations.remove {
    exports com.github.nhojpatrick.cucumber.json.transformations.remove;
    uses com.github.nhojpatrick.cucumber.json.core.transform.TransformationService;
    provides com.github.nhojpatrick.cucumber.json.core.transform.TransformationService
            with com.github.nhojpatrick.cucumber.json.transformations.remove.RemoveTransformationService;
    requires com.google.guice;
    requires org.apache.commons.lang3;
    requires org.joda.beans;
    requires org.slf4j;
    requires transitive com.github.nhojpatrick.cucumber.json.transformations.core;
}
