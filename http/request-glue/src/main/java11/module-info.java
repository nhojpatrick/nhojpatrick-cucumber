module com.github.nhojpatrick.cucumber.http.request.glue {
    requires com.github.nhojpatrick.cucumber.http.constants;
    requires com.google.guice;
    requires io.cucumber.java;
    requires org.hamcrest;
    requires org.junit.jupiter.api;
    requires org.slf4j;
    requires transitive com.github.nhojpatrick.cucumber.http.request;
    requires transitive com.github.nhojpatrick.cucumber.state;
}
