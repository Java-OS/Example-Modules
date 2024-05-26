module application.jpms.engine {
    requires org.slf4j;
    requires jos.api;
    requires io.vertx.web;
    requires io.vertx.core;
    requires application.jpms.common;

    provides ir.moke.jos.api.IModule with ir.moke.module.engine.ModuleRunner;
}