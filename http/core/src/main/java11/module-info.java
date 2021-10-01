module com.github.nhojpatrick.cucumber.http.core {
    exports com.github.nhojpatrick.cucumber.http.core.model;
    exports com.github.nhojpatrick.cucumber.http.core.model.impl
            to
            com.github.nhojpatrick.cucumber.http.core.test,
            com.github.nhojpatrick.cucumber.http.request,
            com.github.nhojpatrick.cucumber.http.request.glue,
            com.github.nhojpatrick.cucumber.http.request.test;
    exports com.github.nhojpatrick.cucumber.http.core.url;
    exports com.github.nhojpatrick.cucumber.http.core.url.impl
            to
            com.github.nhojpatrick.cucumber.http.core.test,
            com.github.nhojpatrick.cucumber.http.request,
            com.github.nhojpatrick.cucumber.http.request.glue,
            com.github.nhojpatrick.cucumber.http.request.test;
    requires org.slf4j;
    requires transitive com.github.nhojpatrick.cucumber.http.constants;
}
