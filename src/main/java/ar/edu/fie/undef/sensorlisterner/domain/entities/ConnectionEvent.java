package ar.edu.fie.undef.sensorlisterner.domain.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "connection_events")
public class ConnectionEvent extends Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty
    private Long id;
    @JsonProperty
    private String ssid;
    @JsonProperty
    private Integer signalStrength;

    public ConnectionEvent(Long storeId, String macAddress, Date timestamp, String ssid, Integer signalStrength) {
        super(storeId, macAddress, timestamp);
        this.ssid = ssid;
        this.signalStrength = signalStrength;
    }

    public ConnectionEvent(Long storeId, String macAddress, Date timestamp, Long id, String ssid, Integer signalStrength) {
        super(storeId, macAddress, timestamp);
        this.id = id;
        this.ssid = ssid;
        this.signalStrength = signalStrength;
    }

    public ConnectionEvent() {

    }
}
