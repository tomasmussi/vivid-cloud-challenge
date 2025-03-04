# Largest Palindromic Finder

This program finds which is the largest palindromic number between two bounds passed.
If it exists, it returns the largest palindromic number, otherwise it returns -1.


## Compiling
It is necessary to have Java and Maven to compile and run the project.
The project is built using Java 17, but it can be compiled with lower versions of Java since it doesn't use any of the new features.
(though for testing it uses JUnit 5 and Hamcrest which may not be available in previous versions of Java)

To compile, the `mvn compiler:compile` goal cagn be run and the Java classes generated.
A JAR file can be generated by running `mvn jar:jar`

It is suggested to run the `mvn package` command as it will compile the project, run all tests and package
the application JAR to be run.

## Running

After compiling, the application can be run by executing the JAR:
```bash
java -jar target/vivid-cloud-challenge-1.0-SNAPSHOT.jar 100 200
```
or running the project with the default parameters set in the pom.xml file.
```bash
 mvn exec:java
```
