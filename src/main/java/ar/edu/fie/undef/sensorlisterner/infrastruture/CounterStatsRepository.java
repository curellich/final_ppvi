package ar.edu.fie.undef.sensorlisterner.infrastruture;

import ar.edu.fie.undef.sensorlisterner.domain.entities.CounterStats;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CounterStatsRepository extends JpaRepository<CounterStats, Long> {
}
