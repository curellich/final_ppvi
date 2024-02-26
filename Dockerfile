FROM openjdk:20-slim-buster
ADD /build/libs/sensor-listerner-0.0.1-SNAPSHOT.jar app.jar
ENV spring.datasource.url=jdbc:mysql://localhost:3306/finalppvi
ENV spring.datasource.username=root
ENV spring.datasource.password=password
ENV spring.data.redis.host=localhost
ENV spring.data.redis.port=6379
EXPOSE 8080
CMD ["java", "-jar", "app.jar"]