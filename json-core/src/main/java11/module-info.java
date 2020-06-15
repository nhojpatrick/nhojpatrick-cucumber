module com.github.nhojpatrick.cucumber.json.core {
    exports com.github.nhojpatrick.cucumber.json.core.castto;
    exports com.github.nhojpatrick.cucumber.json.core.castto.exceptions;
    exports com.github.nhojpatrick.cucumber.json.core.exceptions;
    exports com.github.nhojpatrick.cucumber.json.core.transform;
    exports com.github.nhojpatrick.cucumber.json.core.transform.utils;
    exports com.github.nhojpatrick.cucumber.json.core.validation;
    exports com.github.nhojpatrick.cucumber.json.core.validation.impl
            to
            com.github.nhojpatrick.cucumber.json.core.tests,
            com.github.nhojpatrick.cucumber.json.transform,
            com.github.nhojpatrick.cucumber.json.transform.tests,
            com.github.nhojpatrick.cucumber.json.transformations.core,
            com.github.nhojpatrick.cucumber.json.transformations.print,
            com.github.nhojpatrick.cucumber.json.transformations.print.tests,
            com.github.nhojpatrick.cucumber.json.transformations.remove,
            com.github.nhojpatrick.cucumber.json.transformations.remove.tests,
            com.github.nhojpatrick.cucumber.json.transformations.reverse,
            com.github.nhojpatrick.cucumber.json.transformations.reverse.tests,
            com.github.nhojpatrick.cucumber.json.transformations.set,
            com.github.nhojpatrick.cucumber.json.transformations.set.tests,
            com.github.nhojpatrick.cucumber.json.transformations.whitespace,
            com.github.nhojpatrick.cucumber.json.transformations.whitespace.tests;
    requires org.apache.commons.lang3;
    requires org.slf4j;
    requires transitive com.github.nhojpatrick.cucumber.core;
    requires transitive com.github.nhojpatrick.cucumber.json.jodabeans;
    requires transitive org.joda.beans;
}
