# Use a base image with Java and Maven pre-installed
FROM maven:3.9.2 AS builder

# Set the working directory
WORKDIR /app

# Copy the POM file and install dependencies
COPY pom.xml .
RUN mvn dependency:go-offline

# Copy the application source code
COPY src ./src

# Build the Spring Boot application
RUN mvn -e -X package -DskipTests

# Use an OpenJDK image for running the application
FROM openjdk:17

# Set the working directory
WORKDIR /app

# Copy the built JAR file from the builder stage
COPY --from=builder /app/target/*.jar app.jar

# Expose the application port
EXPOSE 8080

# Command to run the Spring Boot application
CMD ["java", "-jar", "app.jar"]
