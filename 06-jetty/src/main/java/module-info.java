module p06_jetty {
    requires org.slf4j;
    requires jos.api;
    requires org.eclipse.jetty.server;
    requires org.eclipse.jetty.servlet;
    exports ir.moke.module.jetty.servlet;
    provides ir.moke.jos.api.JModule with ir.moke.module.jetty.ModuleRunner;
}
