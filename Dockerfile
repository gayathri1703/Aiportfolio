# Use Java 21
FROM eclipse-temurin:21-jdk

WORKDIR /app

# Copy project
COPY . .

# Build jar
RUN ./mvnw clean package -DskipTests

# Run jar
CMD ["java", "-jar", "target/aiportfolio-0.0.1-SNAPSHOT.jar"]