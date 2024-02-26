package ar.edu.fie.undef.sensorlisterner.services;

import ar.edu.fie.undef.sensorlisterner.domain.entities.CounterEvent;

public interface ICounterStatsService {
    public void createNewCounterStats(CounterEvent event);
}
