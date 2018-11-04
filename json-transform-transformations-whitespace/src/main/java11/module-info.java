module com.github.nhojpatrick.cucumber.json.transform.transformations.whitespace {
    exports com.github.nhojpatrick.cucumber.json.transform.transformations.whitespace;
    provides com.github.nhojpatrick.cucumber.json.core.transform.TransformationService
            with com.github.nhojpatrick.cucumber.json.transform.transformations.whitespace.WhitespaceTransformationService;
    requires transitive com.github.nhojpatrick.cucumber.core;
    requires transitive com.github.nhojpatrick.cucumber.json.core;
    requires org.apache.commons.lang3;
    requires transitive org.joda.beans;
}
