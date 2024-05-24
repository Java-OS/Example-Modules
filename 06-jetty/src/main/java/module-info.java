module p05_apache_tomcat {
    requires org.slf4j;
    requires jos.api;
    requires org.eclipse.jetty.server;
    requires org.eclipse.jetty.servlet;
    exports ir.moke.module.jetty.servlet;
    provides ir.moke.jos.api.JModule with ir.moke.module.jetty.ModuleRunner;
}
