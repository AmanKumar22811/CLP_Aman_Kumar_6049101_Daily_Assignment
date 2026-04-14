# Stage 1: Build using Maven
FROM maven:3.9.9-eclipse-temurin-21 AS builder

WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Stage 2: Run your app
FROM eclipse-temurin:21-jdk

WORKDIR /app

# Copy built jar from builder stage
COPY --from=builder /app/target/*.jar app.jar

EXPOSE 6969

CMD ["java","-jar","app.jar"]