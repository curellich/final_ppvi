package ar.edu.fie.undef.sensorlisterner.interfaces.requests;

import ar.edu.fie.undef.sensorlisterner.domain.enums.DeviceStatus;

import java.util.Date;

public record HealthCheckEventRecord(Long storeId, String macAddress, Date timestamp, DeviceStatus status, String details) {
}
