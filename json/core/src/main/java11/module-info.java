module com.github.nhojpatrick.cucumber.json.core {
    exports com.github.nhojpatrick.cucumber.json.core.castto;
    exports com.github.nhojpatrick.cucumber.json.core.castto.exceptions;
    exports com.github.nhojpatrick.cucumber.json.core.exceptions;
    exports com.github.nhojpatrick.cucumber.json.core.transform;
    exports com.github.nhojpatrick.cucumber.json.core.transform.utils;
    exports com.github.nhojpatrick.cucumber.json.core.validation;
    exports com.github.nhojpatrick.cucumber.json.core.validation.impl
            to
            com.github.nhojpatrick.cucumber.json.core.test,
            com.github.nhojpatrick.cucumber.json.transform,
            com.github.nhojpatrick.cucumber.json.transform.test,
            com.github.nhojpatrick.cucumber.json.transformations.core,
            com.github.nhojpatrick.cucumber.json.transformations.core.test,
            com.github.nhojpatrick.cucumber.json.transformations.print,
            com.github.nhojpatrick.cucumber.json.transformations.print.test,
            com.github.nhojpatrick.cucumber.json.transformations.remove,
            com.github.nhojpatrick.cucumber.json.transformations.remove.test,
            com.github.nhojpatrick.cucumber.json.transformations.reverse,
            com.github.nhojpatrick.cucumber.json.transformations.reverse.test,
            com.github.nhojpatrick.cucumber.json.transformations.set,
            com.github.nhojpatrick.cucumber.json.transformations.set.test,
            com.github.nhojpatrick.cucumber.json.transformations.whitespace,
            com.github.nhojpatrick.cucumber.json.transformations.whitespace.test;
    requires com.github.spotbugs.annotations;
    requires org.apache.commons.lang3;
    requires org.slf4j;
    requires transitive com.github.nhojpatrick.cucumber.core;
    requires transitive com.github.nhojpatrick.cucumber.json.jodabeans;
    requires transitive org.joda.beans;
}
