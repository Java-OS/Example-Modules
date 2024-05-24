# TODO: Please fix me   
### This project does not work

Project compiled, Install and started without any problem . 

Tomcat result error when receive http request ;
```shell
SLF4J(W): No SLF4J providers were found.                                                                                                                         
SLF4J(W): Defaulting to no-operation (NOP) logger implementation                                                                                                 
SLF4J(W): See https://www.slf4j.org/codes.html#noProviders for further details.                                                                                  
May 24, 2024 1:59:21 PM org.apache.coyote.AbstractProtocol init                                                                                                  
INFO: Initializing ProtocolHandler ["http-nio-8080"]                                                                                                             
May 24, 2024 1:59:21 PM org.apache.catalina.core.StandardService startInternal                                                                                   
INFO: Starting service [Tomcat]                                                                                                                                  
May 24, 2024 1:59:21 PM org.apache.catalina.core.StandardEngine startInternal                                                                                    
INFO: Starting Servlet engine: [Apache Tomcat/10.1.24]                                                                                                           
May 24, 2024 1:59:21 PM org.apache.catalina.startup.ContextConfig getDefaultWebXmlFragment                                 
INFO: No global web.xml found                                                                                                                                    
May 24, 2024 1:59:22 PM org.apache.jasper.servlet.TldScanner scanJars                                                                                            
INFO: At least one JAR was scanned for TLDs yet contained no TLDs. Enable debug logging for this logger for a complete list of JARs that were scanned but no TLDs
 were found in them. Skipping unneeded JARs during scanning can improve startup time and JSP compilation time.
May 24, 2024 1:59:22 PM org.apache.coyote.AbstractProtocol start
INFO: Starting ProtocolHandler ["http-nio-8080"]
May 24, 2024 1:59:24 PM org.apache.catalina.core.StandardHostValve invoke
SEVERE: Exception Processing [/api/hello]
java.lang.IllegalAccessError: class jakarta.security.auth.message.config.AuthConfigFactory (in module jakarta.security.auth.message) cannot access class org.apac
he.catalina.authenticator.jaspic.AuthConfigFactoryImpl (in module org.apache.tomcat.catalina) because module jakarta.security.auth.message does not read module o
rg.apache.tomcat.catalina
        at jakarta.security.auth.message@3.0/jakarta.security.auth.message.config.AuthConfigFactory.lambda$getFactory$0(AuthConfigFactory.java:82)
        at java.base/java.security.AccessController.doPrivileged(AccessController.java:571)
        at jakarta.security.auth.message@3.0/jakarta.security.auth.message.config.AuthConfigFactory.getFactory(AuthConfigFactory.java:76)
        at org.apache.tomcat.catalina@10.1.24/org.apache.catalina.authenticator.AuthenticatorBase.findJaspicProvider(AuthenticatorBase.java:1268)
        at org.apache.tomcat.catalina@10.1.24/org.apache.catalina.authenticator.AuthenticatorBase.getJaspicProvider(AuthenticatorBase.java:1261)
        at org.apache.tomcat.catalina@10.1.24/org.apache.catalina.authenticator.AuthenticatorBase.invoke(AuthenticatorBase.java:473)
        at org.apache.tomcat.catalina@10.1.24/org.apache.catalina.core.StandardHostValve.invoke(StandardHostValve.java:115)
        at org.apache.tomcat.catalina@10.1.24/org.apache.catalina.valves.ErrorReportValve.invoke(ErrorReportValve.java:93)
        at org.apache.tomcat.catalina@10.1.24/org.apache.catalina.core.StandardEngineValve.invoke(StandardEngineValve.java:74)
        at org.apache.tomcat.catalina@10.1.24/org.apache.catalina.connector.CoyoteAdapter.service(CoyoteAdapter.java:344)
        at org.apache.tomcat.coyote@10.1.24/org.apache.coyote.http11.Http11Processor.service(Http11Processor.java:389)
        at org.apache.tomcat.coyote@10.1.24/org.apache.coyote.AbstractProcessorLight.process(AbstractProcessorLight.java:63)
        at org.apache.tomcat.coyote@10.1.24/org.apache.coyote.AbstractProtocol$ConnectionHandler.process(AbstractProtocol.java:896)
        at org.apache.tomcat.coyote@10.1.24/org.apache.tomcat.util.net.NioEndpoint$SocketProcessor.doRun(NioEndpoint.java:1741)
        at org.apache.tomcat.coyote@10.1.24/org.apache.tomcat.util.net.SocketProcessorBase.run(SocketProcessorBase.java:52)
        at org.apache.tomcat.util@10.1.24/org.apache.tomcat.util.threads.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1190)
        at org.apache.tomcat.util@10.1.24/org.apache.tomcat.util.threads.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:659)
        at org.apache.tomcat.util@10.1.24/org.apache.tomcat.util.threads.TaskThread$WrappingRunnable.run(TaskThread.java:63)
        at java.base/java.lang.Thread.run(Thread.java:1583)
```   

I can not use this solution:  [StackOverflow Question](https://stackoverflow.com/questions/78527981/tomcat-jpms-error-jakarta-security-auth-message).      
Should i modify Jos `init` program any for tomcat ?!


