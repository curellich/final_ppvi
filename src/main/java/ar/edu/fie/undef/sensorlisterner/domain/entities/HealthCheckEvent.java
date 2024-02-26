package ar.edu.fie.undef.sensorlisterner.domain.entities;

import ar.edu.fie.undef.sensorlisterner.domain.enums.DeviceStatus;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.util.Date;


@Entity
@Table(name = "health_check_events")
public class HealthCheckEvent extends Event {
    @Enumerated(EnumType.STRING)
    @JsonProperty
    private DeviceStatus status;
    @JsonProperty
    private String details;

    public HealthCheckEvent(int storeId, String macAddress, java.util.Date timestamp, DeviceStatus status, String details) {
        super(storeId, macAddress, timestamp);
        this.status = status;
        this.details = details;
    }

    public HealthCheckEvent() {

    }
}
