module com.github.nhojpatrick.cucumber.testing.internal.objects {
    exports com.github.nhojpatrick.cucumber.testing.internal.objects;
    opens com.github.nhojpatrick.cucumber.testing.internal.objects;
    requires com.fasterxml.jackson.annotation;
    requires com.github.spotbugs.annotations;
    requires org.joda.beans;
    requires org.slf4j;
    requires transitive com.fasterxml.jackson.core;
    requires transitive com.fasterxml.jackson.databind;
}
