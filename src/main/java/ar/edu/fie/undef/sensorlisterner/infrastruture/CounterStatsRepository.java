package ar.edu.fie.undef.sensorlisterner.infrastruture;

import ar.edu.fie.undef.sensorlisterner.domain.entities.CounterStats;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CounterStatsRepository extends JpaRepository<CounterStats, Long> {
    List<CounterStats> findAllByOrderByIdDesc();

}
