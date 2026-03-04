FROM eclipse-temurin:21-jdk

WORKDIR /app

# Copy files
COPY . .

# Give permission to mvnw
RUN chmod +x ./mvnw

# Build Spring Boot jar
RUN ./mvnw clean package -DskipTests

# Expose port
EXPOSE 8080

# Start application
CMD ["java","-jar","target/aiportfolio-0.0.1-SNAPSHOT.jar"]