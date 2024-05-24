module p07_zeromq {
    requires org.slf4j;
    requires jos.api;
    requires io.vertx.web;
    requires io.vertx.core;

    provides ir.moke.jos.api.JModule with ir.moke.module.vertx.ModuleRunner;
}
