FROM maven:3.8.3-amazoncorretto-17

COPY . .

RUN mvn clean package

EXPOSE 8080

CMD ["java", "-jar", "/target/eldar-0.0.1-SNAPSHOT.jar"]