module p08_vertx {
    requires jos.api;
    requires io.vertx.core;
    requires io.vertx.web;
    requires org.slf4j;

    provides ir.moke.jos.api.IModule with ir.moke.module.vertx.ModuleRunner;
}