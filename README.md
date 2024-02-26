# Sensor Listener Microservice

This is a Java Spring Boot microservice that listens for sensor events, stores and publishes them to a Redis topic. The service uses the Spring Data Redis module to interact with Redis.

The app creates new CounterStats based on the type of the event. It calculates the time difference between the last event with status OCCUPIED and the current event, and stores this information in the CounterStats entity.

![TP Final PPVI.jpg](..%2FTP%20Final%20PPVI.jpg)