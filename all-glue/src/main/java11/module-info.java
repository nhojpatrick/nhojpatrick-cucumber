module com.github.nhojpatrick.cucumber.all.glue {
    requires org.hamcrest;
    requires org.junit.jupiter.api;
    requires org.slf4j;
    requires transitive com.github.nhojpatrick.cucumber.http.request.glue;
    requires transitive com.github.nhojpatrick.cucumber.http.response.glue;
    requires transitive com.github.nhojpatrick.cucumber.json.map.glue;
    requires transitive com.github.nhojpatrick.cucumber.json.transform.glue;
    requires transitive com.github.nhojpatrick.cucumber.state.glue;
}
