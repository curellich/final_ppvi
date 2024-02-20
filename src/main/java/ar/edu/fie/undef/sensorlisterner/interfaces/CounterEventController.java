//
package ar.edu.fie.undef.sensorlisterner.interfaces;

import ar.edu.fie.undef.sensorlisterner.domain.entities.ConnectionEvent;
import ar.edu.fie.undef.sensorlisterner.domain.entities.CounterEvent;
import ar.edu.fie.undef.sensorlisterner.domain.entities.HealthCheckEvent;
import ar.edu.fie.undef.sensorlisterner.infrastruture.ConnectionEventRepository;
import ar.edu.fie.undef.sensorlisterner.infrastruture.CounterEventRepository;
import ar.edu.fie.undef.sensorlisterner.infrastruture.HealthCheckEventRepository;
import ar.edu.fie.undef.sensorlisterner.interfaces.requests.ConnectionEventRecord;
import ar.edu.fie.undef.sensorlisterner.interfaces.requests.CounterEventRecord;
import ar.edu.fie.undef.sensorlisterner.interfaces.requests.HealthCheckEventRecord;
import ar.edu.fie.undef.sensorlisterner.interfaces.responses.StandardResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CounterEventController {

    private final CounterEventRepository counterEventRepository;
    private final ConnectionEventRepository connectionEventRepository;
    private final HealthCheckEventRepository healthCheckEventRepository;

    private StandardResponse response;

    public CounterEventController(CounterEventRepository counterEventRepository, ConnectionEventRepository connectionEventRepository, HealthCheckEventRepository healthCheckEventRepository) {
        this.counterEventRepository = counterEventRepository;
        this.connectionEventRepository = connectionEventRepository;
        this.healthCheckEventRepository = healthCheckEventRepository;
    }

    @PostMapping("api/v1/counterstatus")
    private ResponseEntity<StandardResponse> createCounterEvent(@RequestBody CounterEventRecord request) {

        var counterEvent = new CounterEvent(
                request.storeId(),
                request.macAddress(),
                request.timestamp(),
                request.zone(),
                request.status(),
                request.direction(),
                request.description());
        try {
            CounterEvent savedCounterEvent = counterEventRepository.save(counterEvent);
            var jsonSavedCounterEvent = savedCounterEvent.toString();
            response = new StandardResponse(true, "Counter event created", savedCounterEvent);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (Exception e) {
            response = new StandardResponse(false, "Counter event not created", null);
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("api/v1/connections")
    private ResponseEntity<StandardResponse> createConnectionEvent(@RequestBody ConnectionEventRecord request) {
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
    private ResponseEntity<StandardResponse> createHealthCheckEvent(@RequestBody HealthCheckEventRecord request) {
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
