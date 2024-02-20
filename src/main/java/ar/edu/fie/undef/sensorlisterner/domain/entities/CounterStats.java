package ar.edu.fie.undef.sensorlisterner.domain.entities;

import ar.edu.fie.undef.sensorlisterner.domain.enums.CounterZone;
import jakarta.persistence.*;

import java.util.Date;

@Entity
public class CounterStats {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int storeId;
    @Enumerated(EnumType.STRING)
    private CounterZone zone;
    private Long occupiedInterval;
    private Date occupiedTimestamp;
    private Date freeTimestamp;

    public CounterStats() {
    }

    public CounterStats(int storeId, CounterZone zone, Long occupiedInterval, Date occupiedTimestamp, Date freeTimestamp) {
        this.storeId = storeId;
        this.zone = zone;
        this.occupiedInterval = occupiedInterval;
        this.occupiedTimestamp = occupiedTimestamp;
        this.freeTimestamp = freeTimestamp;
    }
}
