package ar.edu.fie.undef.sensorlisterner.services.publisher;

import org.springframework.stereotype.Component;

@Component
public interface MessagePublisher {
    public void publish(String message);
}
