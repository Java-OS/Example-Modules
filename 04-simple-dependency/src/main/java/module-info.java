module p03_http_server {
    requires jos.api;
    requires org.slf4j;
    requires p00_common;
    requires jdk.httpserver;
    opens ir.moke.module.with_dependency.model;
    provides ir.moke.jos.api.JModule with ir.moke.module.with_dependency.ModuleRunner;
}