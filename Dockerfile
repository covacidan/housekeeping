FROM openjdk:8-jdk-alpine

#ARG JAR_FILE=target/*.jar
#COPY ${JAR_FILE} housekeeping.jar
#ENTRYPOINT ["java","-jar","/housekeeping.jar"]


WORKDIR /app

COPY .mvn/ .mvn
COPY mvnw pom.xml ./
RUN ./mvnw dependency:resolve

COPY src ./src

CMD ["./mvnw", "spring-boot:run"]
