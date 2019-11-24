module com.github.nhojpatrick.cucumber.json.testing.objects {
    exports com.github.nhojpatrick.cucumber.json.testing.objects;
    opens com.github.nhojpatrick.cucumber.json.testing.objects
            to com.fasterxml.jackson.databind;
    requires org.slf4j;
    requires transitive com.fasterxml.jackson.databind;
}
