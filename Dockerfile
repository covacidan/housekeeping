FROM openjdk:8-jdk-alpine

ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} housekeeping.jar
ENTRYPOINT ["java","-jar","/housekeeping.jar"]