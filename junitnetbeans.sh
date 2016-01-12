#!/bin/bash
#java -cp .:/usr/share/java/junit.jar org.junit.runner.JUnitCore DataConverterTest.Java
JAVA_HOME=/home/donovan/jdk1.8.0_65 
#ant -f /home/donovan/integration/PlanetisJava-Connection -Dnb.internal.action.name=test -Dignore.failing.tests=true test
ant -f /home/donovan/integration/PlanetisJava-Connection -Djavac.includes=model/ConfigTest.java -Dnb.internal.action.name=test.single -Dtest.includes=model/ConfigTest.java -Dignore.failing.tests=true test-single

