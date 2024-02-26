package ar.edu.fie.undef.sensorlisterner.interfaces;

import ar.edu.fie.undef.sensorlisterner.infrastruture.CounterStatsRepository;
import ar.edu.fie.undef.sensorlisterner.interfaces.responses.StandardResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CounterStatsController {

    private final CounterStatsRepository counterStatsRepository;

    public CounterStatsController(CounterStatsRepository counterStatsRepository) {
        this.counterStatsRepository = counterStatsRepository;
    }
    @GetMapping("api/v1/counterstats")
    public ResponseEntity<StandardResponse> getCounterStats() {
        var counterStats = counterStatsRepository.findAllByOrderByIdDesc();
        return new ResponseEntity<>(new StandardResponse(true, counterStats.size() + " Counter found", counterStats), HttpStatus.OK);
    }

}