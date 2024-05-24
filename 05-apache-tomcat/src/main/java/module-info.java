module p05_apache_tomcat {
    requires org.slf4j;
    requires org.apache.tomcat.embed.core;
    requires jos.api;

    provides ir.moke.jos.api.JModule with ir.moke.module.tomcat.ModuleRunner;
}
