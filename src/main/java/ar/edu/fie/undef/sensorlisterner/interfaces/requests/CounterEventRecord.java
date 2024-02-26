package ar.edu.fie.undef.sensorlisterner.interfaces.requests;

import ar.edu.fie.undef.sensorlisterner.domain.enums.CounterDirection;
import ar.edu.fie.undef.sensorlisterner.domain.enums.CounterStatus;
import ar.edu.fie.undef.sensorlisterner.domain.enums.CounterZone;

import java.util.Date;

public record CounterEventRecord(int storeId, String macAddress, Date timestamp, CounterZone zone, CounterStatus status,
                                 CounterDirection direction, String description) {
}
