module com.github.nhojpatrick.cucumber.json.transform.transformations.remove {
    exports com.github.nhojpatrick.cucumber.json.transform.transformations.remove;
    provides com.github.nhojpatrick.cucumber.json.core.transform.TransformationService
            with com.github.nhojpatrick.cucumber.json.transform.transformations.remove.RemoveTransformationService;
    requires transitive com.github.nhojpatrick.cucumber.core;
    requires transitive com.github.nhojpatrick.cucumber.json.core;
    requires org.apache.commons.lang3;
    requires transitive org.joda.beans;
}
