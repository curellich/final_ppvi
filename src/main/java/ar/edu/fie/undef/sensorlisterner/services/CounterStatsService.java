package ar.edu.fie.undef.sensorlisterner.services;

import ar.edu.fie.undef.sensorlisterner.domain.entities.CounterEvent;
import ar.edu.fie.undef.sensorlisterner.domain.entities.CounterStats;
import ar.edu.fie.undef.sensorlisterner.infrastruture.CounterEventRepository;
import ar.edu.fie.undef.sensorlisterner.infrastruture.CounterStatsRepository;
import ar.edu.fie.undef.sensorlisterner.utils.DateUtils;


public class CounterStatsService implements ICounterStatsService {

    private final CounterEventRepository counterEventRepository;
    private final CounterStatsRepository counterStatsRepository;

    public CounterStatsService(CounterEventRepository counterEventRepository, CounterStatsRepository counterStatsRepository) {
        this.counterEventRepository = counterEventRepository;
        this.counterStatsRepository = counterStatsRepository;
    }

    public void createNewCounterStats(CounterEvent event) {
        //Get last event with status OCCUPIED
        CounterEvent lastOccupiedEvent = counterEventRepository.findLastOccupiedEvent(event.getStoreId(), event.getMacAddress());
        if (lastOccupiedEvent != null) {
            //Calculate time difference
            long timeInterval = DateUtils.getDifferenceInSeconds(lastOccupiedEvent.getTimestamp(), event.getTimestamp());

            //Create new CounterStats
            CounterStats counterStats = new CounterStats(
                    event.getStoreId(),
                    event.getZone(),
                    timeInterval,
                    lastOccupiedEvent.getTimestamp(),
                    event.getTimestamp()
            );
            //Save new CounterStats

            try{
                counterStatsRepository.save(counterStats);
            }catch (Exception e){
                System.out.println("Error saving CounterStats");
            }
        }
    }
}
