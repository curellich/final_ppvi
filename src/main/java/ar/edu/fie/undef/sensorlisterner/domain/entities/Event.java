package ar.edu.fie.undef.sensorlisterner.domain.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.MappedSuperclass;

import java.util.Date;

@MappedSuperclass
public abstract class Event {

    @JsonProperty
    private Long storeId;
    @JsonProperty
    private String macAddress;
    @JsonProperty
    private Date timestamp;

    protected Event() {
    }

    protected Event(Long storeId, String macAddress, Date timestamp) {
        this.storeId = storeId;
        this.macAddress = macAddress;
        this.timestamp = timestamp;
    }
}


