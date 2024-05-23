import ir.moke.module.httpserver.ModuleRunner;

module p03_http_server {
    requires jos.api;
    requires org.slf4j;
    requires jdk.httpserver;
    exports ir.moke.module.httpserver;
    provides ir.moke.jos.api.JModule with ModuleRunner;
}