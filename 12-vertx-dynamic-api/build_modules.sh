#!/bin/bash 


(cd common/    ; mvn -DskipTests clean compile package install jpkg:archive)
echo "###################################################################################"
(cd engine/    ; mvn -DskipTests clean compile package install jpkg:archive)
echo "###################################################################################"
(cd api-hello/ ; mvn -DskipTests clean compile package install jpkg:archive)
echo "###################################################################################"
(cd api-bye/ ; mvn -DskipTests clean compile package install jpkg:archive)

echo 
echo 

echo "Install this packages : " 
find $(pwd -P) -type f -iname "*.jpkg"
