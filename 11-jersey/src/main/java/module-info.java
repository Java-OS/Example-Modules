module p11_jersey {
    requires org.slf4j;
    requires jos.api;
    requires org.glassfish.grizzly.http.server;
    requires jersey.server;
    requires jersey.container.grizzly2.http;
    requires jakarta.ws.rs;
    requires jersey.common;
    requires jakarta.inject;
    requires jakarta.annotation;
    requires jersey.hk2;
    requires jakarta.validation;
    requires com.fasterxml.jackson.annotation;
    requires jakarta.xml.bind;
    requires jersey.media.json.jackson;
    requires jersey.media.json.binding;
    requires jakarta.json.bind;
    requires com.fasterxml.jackson.jakarta.rs.json;

    provides ir.moke.jos.api.IModule with ir.moke.module.jersey.ModuleRunner;

    exports ir.moke.module.jersey.resource;
    exports ir.moke.module.jersey.model;
}