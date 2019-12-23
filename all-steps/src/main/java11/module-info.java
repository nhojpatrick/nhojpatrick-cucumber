module com.github.nhojpatrick.cucumber.all.steps {
    requires org.hamcrest;
    requires org.junit.jupiter.api;
    requires org.slf4j;
    requires transitive com.github.nhojpatrick.cucumber.json.map.steps;
    requires transitive com.github.nhojpatrick.cucumber.json.transform.steps;
    requires transitive com.github.nhojpatrick.cucumber.state.steps;
}
