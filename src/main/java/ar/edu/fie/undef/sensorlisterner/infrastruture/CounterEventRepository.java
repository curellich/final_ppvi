package ar.edu.fie.undef.sensorlisterner.infrastruture;

import ar.edu.fie.undef.sensorlisterner.domain.entities.CounterEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface CounterEventRepository extends JpaRepository<CounterEvent, Long> {
  @Query("SELECT e FROM CounterEvent e WHERE e.storeId = :storeId AND e.macAddress = :macAddress AND e.status = 'OCCUPIED' ORDER BY timestamp DESC LIMIT 1")
CounterEvent findLastOccupiedEvent(@Param("storeId") int storeId, @Param("macAddress") String macAddress);
}
