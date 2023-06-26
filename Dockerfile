# Use the official Maven Docker image as the base image
FROM maven:3.8.4-openjdk-11 AS build

# Set the working directory inside the container
WORKDIR /app

# Copy the POM file to the container
COPY pom.xml .

# Download the project dependencies
RUN mvn dependency:go-offline -B

# Copy the application source code to the container
COPY src ./src

# Build the application
RUN mvn package -DskipTests

# Use the official OpenJDK 11 Docker image as the base image for the final image
FROM adoptopenjdk:11-jre-hotspot

# Set the working directory inside the container
WORKDIR /app

# Copy the JAR file from the build stage to the final image
COPY --from=build /app/target/spring-boot-docker.jar app.jar

# Expose the port on which your Spring Boot application listens
EXPOSE 8080

# Define the command to run your application
CMD ["java", "-jar", "app.jar"]
