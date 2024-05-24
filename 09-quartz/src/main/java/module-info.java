module p09_quartz {
    requires org.slf4j;
    requires quartz;
    requires jos.api;
    opens ir.moke.module.quartz to quartz;

    provides ir.moke.jos.api.JModule with ir.moke.module.quartz.ModuleRunner;
}