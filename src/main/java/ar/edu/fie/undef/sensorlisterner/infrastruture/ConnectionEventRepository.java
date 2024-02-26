package ar.edu.fie.undef.sensorlisterner.infrastruture;

import ar.edu.fie.undef.sensorlisterner.domain.entities.ConnectionEvent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConnectionEventRepository extends JpaRepository<ConnectionEvent, Long> {

}
