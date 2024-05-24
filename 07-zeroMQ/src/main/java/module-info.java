module p07_zeromq {
    requires org.slf4j;
    requires jos.api;
    requires org.zeromq.jeromq;

    provides ir.moke.jos.api.JModule with ir.moke.module.zeromq.ModuleRunner;
}
