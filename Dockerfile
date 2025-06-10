
FROM maven:3.8.4-openjdk-11 AS build

WORKDIR /app

COPY pom.xml .

RUN mvn dependency:go-offline -B

COPY src ./src

RUN mvn package -DskipTests

FROM adoptopenjdk:11-jre-hotspot

WORKDIR /app

COPY --from=build /app/target/spring-boot-docker.jar app.jar

EXPOSE 8082

# Define the command to run your application
CMD ["java", "-jar", "app.jar"]
