module com.github.nhojpatrick.cucumber.json.transformations.set {
    exports com.github.nhojpatrick.cucumber.json.transformations.set;
    provides com.github.nhojpatrick.cucumber.json.core.transform.TransformationService
            with com.github.nhojpatrick.cucumber.json.transformations.set.SetTransformationService;
    requires org.apache.commons.lang3;
    requires org.joda.beans;
    requires org.slf4j;
    requires transitive com.github.nhojpatrick.cucumber.core;
    requires transitive com.github.nhojpatrick.cucumber.json.core;
}
