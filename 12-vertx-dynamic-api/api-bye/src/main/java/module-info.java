import ir.moke.module.api.ModuleRunner;

module application.jpms.api.bye {
    requires org.slf4j;
    requires jos.api;
    requires io.vertx.web;
    requires io.vertx.core;
    requires application.jpms.common;
    exports ir.moke.module.api;

    provides ir.moke.jos.api.IModule with ModuleRunner;
}