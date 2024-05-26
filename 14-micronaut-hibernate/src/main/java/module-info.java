module p14_micronaut_hibernate {
    requires io.micronaut.context;
    requires io.micronaut.http;
    requires io.micronaut.inject;
    requires io.micronaut.core;
    requires io.micronaut.json_core;
    requires io.micronaut.serde.micronaut_serde_jackson;
    requires io.micronaut.serde.micronaut_serde_api;
    requires io.micronaut.http_server;
    requires io.micronaut.http_netty;
    requires java.sql;
    requires jos.api;
    requires org.slf4j;
    requires jakarta.annotation;
    requires io.micronaut.data.micronaut_data_jpa;
    requires io.micronaut.data.micronaut_data_model;
    requires jakarta.inject;
    requires jakarta.persistence;
    requires jakarta.transaction;
    requires jakarta.cdi;
    requires com.fasterxml.jackson.core;
    requires com.fasterxml.jackson.annotation;

    exports ir.moke.module.micronaut.entity;
    exports ir.moke.module.micronaut.resource;
    exports ir.moke.module.micronaut.repository;

    opens ir.moke.module.micronaut.entity;
    opens ir.moke.module.micronaut.resource;
    opens ir.moke.module.micronaut.repository;


    provides ir.moke.jos.api.IModule with ir.moke.module.micronaut.ModuleRunner;
}