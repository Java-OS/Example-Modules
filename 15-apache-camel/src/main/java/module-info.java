module p09_quartz {
    requires org.slf4j;
    requires jos.api;
    requires camel.main;
    requires camel.core.model;
    requires camel.api;

    exports ir.moke.module.camel;

    provides ir.moke.jos.api.IModule with ir.moke.module.camel.ModuleRunner;
}