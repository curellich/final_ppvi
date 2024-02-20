package ar.edu.fie.undef.sensorlisterner.domain.entities;

import ar.edu.fie.undef.sensorlisterner.domain.enums.CounterDirection;
import ar.edu.fie.undef.sensorlisterner.domain.enums.CounterStatus;
import ar.edu.fie.undef.sensorlisterner.domain.enums.CounterZone;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "counter_events")
public class CounterEvent extends Event {
    @Enumerated(EnumType.STRING)
    @JsonProperty
    private CounterZone zone;
    @Enumerated(EnumType.STRING)
    @JsonProperty
    private CounterStatus status;
    @Enumerated(EnumType.STRING)
    @JsonProperty
    private CounterDirection direction;
    @JsonProperty
    private String description;

    public CounterEvent(int storeId, String macAddress, Date timestamp, CounterZone zone, CounterStatus status, CounterDirection direction, String description) {
        super(storeId, macAddress, timestamp);
        this.zone = zone;
        this.status = status;
        this.direction = direction;
        this.description = description;
    }

    public CounterEvent() {

    }

    public CounterZone getZone() {
        return zone;
    }
}