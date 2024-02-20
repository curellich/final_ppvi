package ar.edu.fie.undef.sensorlisterner.domain.entities;

import ar.edu.fie.undef.sensorlisterner.domain.enums.DeviceStatus;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.util.Date;


@Entity
@Table(name = "health_check_events")
public class HealthCheckEvent extends Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty
    private Long id;
    @Enumerated(EnumType.STRING)
    @JsonProperty
    private DeviceStatus status;
    @JsonProperty
    private String details;

    public HealthCheckEvent(Long storeId, String macAddress, java.util.Date timestamp, DeviceStatus status, String details) {
        super(storeId, macAddress, timestamp);
        this.status = status;
        this.details = details;
    }

    public HealthCheckEvent(Long storeId, String macAddress, Date timestamp, Long id, DeviceStatus status, String details) {
        super(storeId, macAddress, timestamp);
        this.id = id;
        this.status = status;
        this.details = details;
    }

    public HealthCheckEvent() {

    }
}
