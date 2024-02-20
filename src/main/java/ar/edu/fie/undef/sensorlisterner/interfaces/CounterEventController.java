//
package ar.edu.fie.undef.sensorlisterner.interfaces;

import ar.edu.fie.undef.sensorlisterner.domain.entities.ConnectionEvent;
import ar.edu.fie.undef.sensorlisterner.domain.entities.CounterEvent;
import ar.edu.fie.undef.sensorlisterner.domain.entities.HealthCheckEvent;
import ar.edu.fie.undef.sensorlisterner.infrastruture.ConnectionEventRepository;
import ar.edu.fie.undef.sensorlisterner.infrastruture.CounterEventRepository;
import ar.edu.fie.undef.sensorlisterner.infrastruture.CounterStatsRepository;
import ar.edu.fie.undef.sensorlisterner.infrastruture.HealthCheckEventRepository;
import ar.edu.fie.undef.sensorlisterner.interfaces.requests.ConnectionEventRecord;
import ar.edu.fie.undef.sensorlisterner.interfaces.requests.CounterEventRecord;
import ar.edu.fie.undef.sensorlisterner.interfaces.requests.HealthCheckEventRecord;
import ar.edu.fie.undef.sensorlisterner.interfaces.responses.StandardResponse;
import ar.edu.fie.undef.sensorlisterner.services.CounterStatsService;
import ar.edu.fie.undef.sensorlisterner.services.publisher.Publisher;
import ar.edu.fie.undef.sensorlisterner.utils.JsonUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class CounterEventController {

    private final CounterEventRepository counterEventRepository;
    private final ConnectionEventRepository connectionEventRepository;
    private final HealthCheckEventRepository healthCheckEventRepository;
    private final CounterStatsRepository counterStatsRepository;

    private Publisher publisher;
    private static final Logger logger = LoggerFactory.getLogger(CounterEventController.class);
    private StandardResponse response;

    public CounterEventController(CounterEventRepository counterEventRepository, ConnectionEventRepository connectionEventRepository, HealthCheckEventRepository healthCheckEventRepository, CounterStatsRepository counterStatsRepository, Publisher publisher) {
        this.counterEventRepository = counterEventRepository;
        this.connectionEventRepository = connectionEventRepository;
        this.healthCheckEventRepository = healthCheckEventRepository;
        this.counterStatsRepository = counterStatsRepository;
        this.publisher = publisher;
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<StandardResponse> handleInvalidInput(HttpMessageNotReadableException ex) {
        logger.error("Invalid input: {}", ex.getMessage());
        StandardResponse response = new StandardResponse(false, "Invalid input", null);
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @PostMapping("api/v1/counterstatus")
    public ResponseEntity<StandardResponse> createCounterEvent(@RequestBody CounterEventRecord request) {

        logger.info("Received a new counter event with status: {}", request.status().name());
        String jsonRequest = JsonUtil.convertToJson(request);
        publisher.publish(jsonRequest);

        var counterEvent = new CounterEvent(
                request.storeId(),
                request.macAddress(),
                request.timestamp(),
                request.zone(),
                request.status(),
                request.direction(),
                request.description());

        try {
            //FIRST SAVE THE COUNTER EVENT
            CounterEvent savedCounterEvent = counterEventRepository.save(counterEvent);
            logger.info("Counter event saved with id: {} ", savedCounterEvent.getId());

            //THEN CREATE THE COUNTER STATS IF THE COUNTER IS FREE
            if (request.status().name().equals("FREE")) {
                CounterStatsService counterStatsService = new CounterStatsService(counterEventRepository, counterStatsRepository);
                counterStatsService.createNewCounterStats(counterEvent);
            }

            //RETURN THE RESPONSE
            response = new StandardResponse(true, "Counter event created", savedCounterEvent);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (Exception e) {
            response = new StandardResponse(false, "Error saving counter event", null);
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }


    }

    @PostMapping("api/v1/connections")
    public ResponseEntity<StandardResponse> createConnectionEvent(@RequestBody ConnectionEventRecord request) {
        logger.info("Received a new connection event received");
        var connectionEvent = new ConnectionEvent(
                request.storeId(),
                request.macAddress(),
                request.timestamp(),
                request.ssid(),
                request.signalStrength());
        try {
            ConnectionEvent savedConnectionEvent = connectionEventRepository.save(connectionEvent);
            response = new StandardResponse(true, "Connection event created", savedConnectionEvent);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (Exception e) {
            response = new StandardResponse(false, "Connection event not created", null);
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("api/v1/healthchecks")
    public ResponseEntity<StandardResponse> createHealthCheckEvent(@RequestBody HealthCheckEventRecord request) {
        logger.info("Received a new health check event received");
        var healthCheckEvent = new HealthCheckEvent(
                request.storeId(),
                request.macAddress(),
                request.timestamp(),
                request.status(),
                request.details());
        try {
            HealthCheckEvent savedHealthCheckEvent = healthCheckEventRepository.save(healthCheckEvent);
            response = new StandardResponse(true, "HealthCheck event created", savedHealthCheckEvent);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (Exception e) {
            response = new StandardResponse(false, "HealthCheck event not created", null);
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
