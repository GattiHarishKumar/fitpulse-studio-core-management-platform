#!/bin/sh
set -eu
command -v java >/dev/null 2>&1 || { echo "Java is not installed."; exit 1; }
command -v mvn >/dev/null 2>&1 || { echo "Maven is not installed."; exit 1; }
echo "Java:"
java -version
echo "Maven:"
mvn -version
echo "Building project..."
mvn clean package
echo "Build successful: target/zumba-management-system.war"
