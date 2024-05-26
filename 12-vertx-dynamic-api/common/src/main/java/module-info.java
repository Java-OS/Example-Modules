module application.jpms.common {
    requires org.slf4j;
    requires jos.api;
    requires io.vertx.web;
    requires io.vertx.core;
    exports ir.moke.module.common;
}