module p05_apache_tomcat {
    requires org.slf4j;
    requires jos.api;
    requires jakarta.servlet;
    requires org.apache.tomcat.jasper;
    requires org.apache.tomcat.catalina;
    exports ir.moke.module.tomcat.servlet;

    provides ir.moke.jos.api.JModule with ir.moke.module.tomcat.ModuleRunner;
}
