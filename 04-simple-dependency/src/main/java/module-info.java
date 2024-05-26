module p04_simple_dependency {
    requires jos.api;
    requires org.slf4j;
    requires p00_common;
    requires jdk.httpserver;
    opens ir.moke.module.with_dependency.model;
    provides ir.moke.jos.api.IModule with ir.moke.module.with_dependency.ModuleRunner;
}