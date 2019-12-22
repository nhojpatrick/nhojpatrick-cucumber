module com.github.nhojpatrick.cucumber.json.transform {
    exports com.github.nhojpatrick.cucumber.json.transform.constants;
    exports com.github.nhojpatrick.cucumber.json.transform.factory;
    requires org.slf4j;
    requires transitive com.github.nhojpatrick.cucumber.json.core;
    requires transitive com.github.nhojpatrick.cucumber.json.map;
}
