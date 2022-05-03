open module com.github.nhojpatrick.cucumber.all.glue.test {
    requires com.github.nhojpatrick.cucumber.all.glue;
    requires org.apache.logging.log4j;
    requires org.hamcrest;
    requires transitive io.cucumber.junit.platform.engine;
    requires transitive org.junit.jupiter.api;
    requires transitive org.junit.jupiter.engine;
    requires transitive org.junit.platform.suite.api;
}
