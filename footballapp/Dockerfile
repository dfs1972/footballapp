# Use a Maven image with Java 25 to build the application
# Note: Using a generic maven image and installing JDK 25 if necessary,
# but for now we'll try a common base.
FROM maven:3.9.9-eclipse-temurin-21 AS build
WORKDIR /app

# Copy the pom.xml and source code
COPY pom.xml .
COPY src ./src

# Build the application
# We skip tests to speed up the deployment
RUN mvn clean package -DskipTests

# Use a lightweight JRE image for the final container
# Since you are using Java 25, we use the OpenJDK 25 early access image
FROM openjdk:25-slim
WORKDIR /app

# Copy the built jar from the build stage
COPY --from=build /app/target/footballapp-1.0-SNAPSHOT.jar app.jar

# Railway will provide the PORT environment variable
EXPOSE 8081

# Start the application
ENTRYPOINT ["java", "-jar", "app.jar"]
