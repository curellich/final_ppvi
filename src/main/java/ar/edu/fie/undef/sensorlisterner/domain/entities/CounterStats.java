package ar.edu.fie.undef.sensorlisterner.domain.entities;

import ar.edu.fie.undef.sensorlisterner.domain.enums.CounterZone;
import jakarta.persistence.*;

@Entity
public class CounterStats {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int storeId;
    private Enum<CounterZone> zone;
    private Long occupiedInterval;

    @ManyToOne
    @JoinColumn(name = "occupied_counter_event_id")
    private CounterEvent CounterEventIdWithOccupiedStatus;

    @ManyToOne
    @JoinColumn(name = "free_counter_event_id")
    private CounterEvent CounterEventIdWithFreeStatus;

    public CounterStats() {
    }
}
