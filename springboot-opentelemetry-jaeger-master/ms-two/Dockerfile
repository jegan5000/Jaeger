# FROM openjdk:17-jdk-slim
# WORKDIR /app
# COPY /target/*.jar main.jar

# CMD ["java", "-jar", "main.jar"]

FROM eclipse-temurin:17-jdk-focal
 
WORKDIR /app
 
COPY .mvn/ .mvn
COPY mvnw pom.xml ./

RUN ./mvnw dependency:go-offline
 
COPY src ./src
 
ADD https://github.com/open-telemetry/opentelemetry-java-instrumentation/releases/latest/download/opentelemetry-javaagent.jar .
ENV JAVA_TOOL_OPTIONS "-javaagent:./opentelemetry-javaagent.jar"

CMD ["./mvnw", "spring-boot:run"]