# Stage 1: Build the application
FROM maven:3.9.9-eclipse-temurin-23 AS build
WORKDIR /app

# Copy pom.xml and source code
COPY pom.xml .
COPY src ./src

# Build the JAR file, skipping tests for faster builds
RUN mvn clean package -DskipTests

# Stage 2: Run the application
FROM eclipse-temurin:23-jre-alpine
WORKDIR /app

# Copy the JAR from the build stage
COPY --from=build /app/target/footballapp-1.0-SNAPSHOT.jar app.jar

# Railway provides the PORT environment variable
# We set a default memory limit to prevent OOM kills on low-RAM plans (512MB)
ENV JAVA_OPTS="-Xmx384m -Xms256m -XX:+UseG1GC -XX:+ExitOnOutOfMemoryError"

# Expose the port (informative)
EXPOSE 8081

# Start the application using the JAVA_OPTS
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar app.jar"]
