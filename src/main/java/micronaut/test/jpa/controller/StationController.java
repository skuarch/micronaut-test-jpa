package micronaut.test.jpa.controller;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import micronaut.test.jpa.model.entity.Station;
import micronaut.test.jpa.model.repository.StationRepository;

@Controller("/station")
public class StationController {

    private final StationRepository stationRepository;

    public StationController(StationRepository stationRepository){
        this.stationRepository = stationRepository;
    }

    @Get(produces = MediaType.APPLICATION_JSON)
    public Station get() {
        Station station = stationRepository.findById(1L).get();
        return station;
    }

}
