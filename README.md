# Sample JOS Modules 

### this repository contain simple jos modules based on :
* Java pure 
* Tomcat
* Jetty
* ActiveMQ
* Micronaut Framework 
* ...

**Note :** _These modules tested with Java 21._ 

## Generate `jpkg` archive 
All jos modules should be archived with `jpkg` format .
this archive is based on the same zip archive , with the different that has a additional file named `manifest.yaml` inside that .  
this file help JOS to get information's of module.
[Please read `maven-jpkg` document](https://github.com/Java-OS/maven-jpkg)

### Manage Modules:
Open JOS web panel `http://w.x.y.z:7080` and go to modules tab , click on `+` button and choose `jpkg` archive.
![](pictures/01.png)

### Manage Logs: 
Click on log management button then config your log appender.
**Note :** currently jos support `file` and `syslog` appender.
#### File Appender
![](pictures/02.png)
now click on `+` to add new log appender base on your favorite configuration.    
![](pictures/03.png)   
click on love stream button if you want to verify pattern or levels.    
![](pictures/04.png)
#### Syslog Appender
Go to syslog tab.
![](pictures/05.png)
Click on `+` to add new syslog appender.    
![](pictures/06.png)


