package ar.edu.fie.undef.sensorlisterner.infrastruture;

import ar.edu.fie.undef.sensorlisterner.domain.entities.HealthCheckEvent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HealthCheckEventRepository extends JpaRepository<HealthCheckEvent, Long> {
}
