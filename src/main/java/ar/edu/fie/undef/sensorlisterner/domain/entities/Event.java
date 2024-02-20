package ar.edu.fie.undef.sensorlisterner.domain.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

import java.util.Date;

@MappedSuperclass
public abstract class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty
    private Long id;
    @JsonProperty
    private int storeId;
    @JsonProperty
    private String macAddress;
    @JsonProperty
    private Date timestamp;
    protected Event() {
    }

    protected Event(int storeId, String macAddress, Date timestamp) {
        this.storeId = storeId;
        this.macAddress = macAddress;
        this.timestamp = timestamp;
    }

    public String getMacAddress() {
        return macAddress;
    }

    public Long getId() {
        return id;
    }

    public int getStoreId() {
        return storeId;
    }

    public Date getTimestamp() {
        return timestamp;
    }
}


