module com.github.nhojpatrick.cucumber.testing.internal.objects {
    exports com.github.nhojpatrick.cucumber.testing.internal.objects;
    exports com.github.nhojpatrick.cucumber.testing.internal.objects.legacy;
    opens com.github.nhojpatrick.cucumber.testing.internal.objects
            to com.fasterxml.jackson.databind;
    opens com.github.nhojpatrick.cucumber.testing.internal.objects.legacy
            to com.fasterxml.jackson.databind;
    requires com.github.spotbugs.annotations;
    requires org.joda.beans;
    requires org.slf4j;
    requires transitive com.fasterxml.jackson.databind;
}
