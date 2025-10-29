FROM maven:3.9.6-openjdk:25 AS builder

WORKDIR /app

COPY . .

RUN mvn clean package

FROM openjdk:21-jre-slim

WORKDIR /app

COPY --from=builder /app/target/app.jar /app/app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]