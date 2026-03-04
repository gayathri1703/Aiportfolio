FROM eclipse-temurin:21-jdk

WORKDIR /app

COPY . .

# Give execute permission to mvnw
RUN chmod +x mvnw

# Build the project
RUN ./mvnw clean package -DskipTests

# Run the Spring Boot jar
CMD ["java","-jar","target/aiportfolio-0.0.1-SNAPSHOT.jar"]