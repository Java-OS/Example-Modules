module p01_basic {
    requires jos.api;
    requires org.slf4j;
    exports ir.moke.module.basic;
    provides ir.moke.jos.api.IModule with ir.moke.module.basic.ModuleRunner;
}