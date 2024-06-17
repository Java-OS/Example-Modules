#!/bin/bash 

mvn -DskipTests clean compile package install
echo 
echo 

echo "Install this packages : " 
find $(pwd -P) -type f -iname "*.jpkg"
