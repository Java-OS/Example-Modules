module p10_moquette {
    requires moquette.broker;
    requires org.slf4j;
    requires jos.api;
    requires io.netty.buffer;

    provides ir.moke.jos.api.IModule with ir.moke.module.moquette.ModuleRunner;
}