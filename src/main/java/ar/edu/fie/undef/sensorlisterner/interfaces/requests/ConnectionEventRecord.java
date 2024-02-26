package ar.edu.fie.undef.sensorlisterner.interfaces.requests;

import java.util.Date;

public record ConnectionEventRecord(int storeId, String macAddress, Date timestamp, String ssid, Integer signalStrength) {
}

