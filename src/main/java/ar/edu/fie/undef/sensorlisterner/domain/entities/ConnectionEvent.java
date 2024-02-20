package ar.edu.fie.undef.sensorlisterner.domain.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "connection_events")
public class ConnectionEvent extends Event {
    @JsonProperty
    private String ssid;
    @JsonProperty
    private Integer signalStrength;

    public ConnectionEvent(int storeId, String macAddress, Date timestamp, String ssid, Integer signalStrength) {
        super(storeId, macAddress, timestamp);
        this.ssid = ssid;
        this.signalStrength = signalStrength;
    }



    public ConnectionEvent() {

    }
}
