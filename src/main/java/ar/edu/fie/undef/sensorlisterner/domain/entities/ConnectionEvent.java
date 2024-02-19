package ar.edu.fie.undef.sensorlisterner.domain.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "connection_events")
public class ConnectionEvent extends Event{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String ssid;
    private Integer signalStrength;

    public ConnectionEvent() {
        super();
    }
}
