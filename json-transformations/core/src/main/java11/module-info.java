module com.github.nhojpatrick.cucumber.json.transformations.core {
    exports com.github.nhojpatrick.cucumber.json.transformations.core;
    requires com.github.spotbugs.annotations;
    requires org.apache.commons.lang3;
    requires org.joda.beans;
    requires org.slf4j;
    requires transitive com.github.nhojpatrick.cucumber.core;
    requires transitive com.github.nhojpatrick.cucumber.json.core;
}
