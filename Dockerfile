# Use an official OpenJDK runtime as a parent image
FROM openjdk:11-jdk-slim

# Set the working directory in the container
WORKDIR /app

# Copy the Maven wrapper files
COPY .mvn/ .mvn/
COPY mvnw .

# Copy the project files to the container
COPY . .

# Package the application, skipping tests
RUN ./mvnw clean package -DskipTests

# Run the application
CMD ["java", "-jar", "target/golf-club-api-0.0.1-SNAPSHOT.jar"]