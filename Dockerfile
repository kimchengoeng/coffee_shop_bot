FROM gradle:8.5-jdk21 AS build
WORKDIR /app
COPY . .
RUN gradle build --no-daemon -x test

FROM eclipse-temurin:21-jre
WORKDIR /app
COPY build/libs/*.jar app.war
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.war"]