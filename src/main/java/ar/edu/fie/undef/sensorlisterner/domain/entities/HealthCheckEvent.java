package ar.edu.fie.undef.sensorlisterner.domain.entities;

import ar.edu.fie.undef.sensorlisterner.domain.enums.DeviceStatus;
import jakarta.persistence.*;



@Entity
@Table(name = "health_check_events")
public class HealthCheckEvent extends Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Enum<DeviceStatus> status;
    private String details;

    public HealthCheckEvent() {
        super();
    }
}
