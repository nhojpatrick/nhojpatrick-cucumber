module com.github.nhojpatrick.cucumber.testing.internal.objects.legacy2 {
    exports com.github.nhojpatrick.cucumber.testing.internal.objects.legacy2;
    opens com.github.nhojpatrick.cucumber.testing.internal.objects.legacy2
            to com.fasterxml.jackson.databind;
    requires com.github.nhojpatrick.cucumber.testing.internal.objects;
    requires com.github.spotbugs.annotations;
    requires org.joda.beans;
    requires org.slf4j;
    requires transitive com.fasterxml.jackson.databind;
}
