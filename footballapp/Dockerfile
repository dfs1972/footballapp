# Use a Maven image with Java 23 to build the application
FROM maven:3.9.9-eclipse-temurin-23 AS build
WORKDIR /app

# Copy the pom.xml and source code
COPY pom.xml .
COPY src ./src

# Build the application
RUN mvn clean package -DskipTests

# Use a lightweight JRE image for the final container
FROM eclipse-temurin:23-jre-alpine
WORKDIR /app

# Copy the built jar from the build stage
COPY --from=build /app/target/footballapp-1.0-SNAPSHOT.jar app.jar

# Railway will provide the PORT environment variable
EXPOSE 8081

# Start the application
ENTRYPOINT ["java", "-jar", "app.jar"]
