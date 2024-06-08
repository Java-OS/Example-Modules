module p05_apache_tomcat {
    requires org.slf4j;
    requires jos.api;
    requires org.apache.tomcat.embed.core;
    exports ir.moke.module.tomcat.servlet;

    provides ir.moke.jos.api.IModule with ir.moke.module.tomcat.ModuleRunner;
}
