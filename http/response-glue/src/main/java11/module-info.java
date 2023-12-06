module com.github.nhojpatrick.cucumber.http.response.glue {
    requires com.github.nhojpatrick.cucumber.http.constants;
    requires com.google.guice;
    requires io.cucumber.java;
    requires org.hamcrest;
    requires org.junit.jupiter.api;
    requires org.slf4j;
    requires transitive com.github.nhojpatrick.cucumber.http.response;
    requires transitive com.github.nhojpatrick.cucumber.state;
}
