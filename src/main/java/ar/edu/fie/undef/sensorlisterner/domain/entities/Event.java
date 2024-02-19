package ar.edu.fie.undef.sensorlisterner.domain.entities;

import java.util.Date;

public abstract class Event {

    private Long storeId;
    private String macAddress;
    private Date timestamp;

    public Event() {
    }

}


