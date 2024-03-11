FROM maven:3.8.3-amazoncorretto-17

WORKDIR /app

COPY . .

RUN mvn clean package

EXPOSE 8080

CMD ["java", "-jar", "/app/target/eldar.jar"]