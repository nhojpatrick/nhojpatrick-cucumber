module com.github.nhojpatrick.cucumber.http.request {
    exports com.github.nhojpatrick.cucumber.http.request;
    requires org.hamcrest;
    requires org.junit.jupiter.api;
    requires org.slf4j;
    requires transitive com.github.nhojpatrick.cucumber.http.core;
    requires transitive com.github.nhojpatrick.cucumber.state;
}
