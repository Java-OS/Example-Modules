module p01_basic {
    requires jos.api;
    requires org.slf4j;
    exports com.sample.module.basic;
    provides ir.moke.jos.api.JModule with com.sample.module.basic.ModuleRunner;
}