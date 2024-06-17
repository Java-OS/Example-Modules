## Module with dependency

This module dependent to 00-module .   
Dependency scope in `pom.xml` must be `provided`.

before install you must compile and install 00-common .

```shell
(cd 00-common ; mvn clean compile package jpkg:archive)
(cd 04-simple-dependency ; mvn clean compile package jpkg:archive)
```

modules available on :

```shell
00-common/target/jos-module/00-common-0.1.jpkg
04-simple-dependency/target/jos-module/04-simple-dependency-0.1.jpkg
```
