#!/bin/bash
project_dir="/$HOME/javapro/bank"
cd $project_dir
echo "Compiling project.."
mkdir bin
javac -cp lib/gson-2.8.0.jar:lib/slf4j-api-1.7.12.jar -sourcepath ./src -d bin src/edu/core/java/bank/main.java
jar cmf src/manifest.mf Cards.jar -C bin/ .
java -cp 'Cards.jar:lib/*' edu.core.java.bank.Main