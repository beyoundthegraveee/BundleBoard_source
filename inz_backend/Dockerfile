FROM openjdk:23-jdk-slim

WORKDIR /app

ADD target/InzBackendApplication.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]