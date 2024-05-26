module p13_micronaut {
    requires io.micronaut.context;
    requires io.micronaut.http;
    requires io.micronaut.inject;
    requires io.micronaut.core;
    requires io.micronaut.json_core;
    requires io.micronaut.serde.micronaut_serde_jackson;
    requires io.micronaut.serde.micronaut_serde_api;
    requires io.micronaut.http_server;
    requires io.micronaut.http_netty;

    exports ir.moke.module.micronaut.model;
    exports ir.moke.module.micronaut.resource;

    requires java.sql;
    requires jos.api;
    requires org.slf4j;
    requires jakarta.annotation;

    provides ir.moke.jos.api.IModule with ir.moke.module.micronaut.ModuleRunner;
}