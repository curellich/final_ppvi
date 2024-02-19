package ar.edu.fie.undef.sensorlisterner.infrastruture;

import ar.edu.fie.undef.sensorlisterner.domain.entities.CounterEvent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CounterEventRepository extends JpaRepository<CounterEvent, Long> {
}
