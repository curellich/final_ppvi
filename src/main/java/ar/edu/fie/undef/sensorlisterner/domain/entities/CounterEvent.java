package ar.edu.fie.undef.sensorlisterner.domain.entities;

import ar.edu.fie.undef.sensorlisterner.domain.enums.CounterDirection;
import ar.edu.fie.undef.sensorlisterner.domain.enums.CounterStatus;
import ar.edu.fie.undef.sensorlisterner.domain.enums.CounterZone;
import jakarta.persistence.*;



@Entity
@Table(name = "counter_events")
public class CounterEvent extends Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Enum<CounterZone> zone;
    private Enum<CounterStatus> status;
    private Enum<CounterDirection> direction;

    private String description;

    public CounterEvent() {

    }
}
