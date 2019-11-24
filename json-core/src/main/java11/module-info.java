module com.github.nhojpatrick.cucumber.json.core {
    exports com.github.nhojpatrick.cucumber.json.core.exceptions;
    exports com.github.nhojpatrick.cucumber.json.core.transform;
    exports com.github.nhojpatrick.cucumber.json.core.transform.utils;
    exports com.github.nhojpatrick.cucumber.json.core.validation;
    exports com.github.nhojpatrick.cucumber.json.core.validation.impl
            to
            com.github.nhojpatrick.cucumber.json,
            com.github.nhojpatrick.cucumber.json.transformations.remove,
            com.github.nhojpatrick.cucumber.json.transformations.set,
            com.github.nhojpatrick.cucumber.json.transformations.whitespace;
    requires transitive com.github.nhojpatrick.cucumber.core;
    requires org.apache.commons.lang3;
    requires transitive org.joda.beans;
    requires org.slf4j;
}
