module com.github.nhojpatrick.cucumber.testing.internal.steps {
    exports com.github.nhojpatrick.cucumber.testing.internal.steps.json.transform;
    exports com.github.nhojpatrick.cucumber.testing.internal.steps.json.map;
    exports com.github.nhojpatrick.cucumber.testing.internal.steps.state;
    requires org.hamcrest;
    requires org.junit.jupiter.api;
    requires org.slf4j;
    requires transitive com.github.nhojpatrick.cucumber.json.map;
    requires transitive com.github.nhojpatrick.cucumber.json.transform;
    requires transitive com.github.nhojpatrick.cucumber.json.transformations.all;
    requires transitive com.github.nhojpatrick.cucumber.state;
    requires transitive com.github.nhojpatrick.cucumber.testing.internal.objects;
    requires transitive com.github.nhojpatrick.cucumber.testing.internal.objects.legacy;
    requires transitive com.github.nhojpatrick.cucumber.testing.internal.objects.legacy2;
}
