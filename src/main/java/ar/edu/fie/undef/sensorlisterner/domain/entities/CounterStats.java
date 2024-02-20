package ar.edu.fie.undef.sensorlisterner.domain.entities;

import ar.edu.fie.undef.sensorlisterner.domain.enums.CounterZone;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.util.Date;

@Entity
public class CounterStats {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty
    private Long id;
    @JsonProperty

    private int storeId;
    @Enumerated(EnumType.STRING)
    @JsonProperty

    private CounterZone zone;
    @JsonProperty

    private Long occupiedInterval;
    @JsonProperty

    private Date occupiedTimestamp;
    @JsonProperty

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
