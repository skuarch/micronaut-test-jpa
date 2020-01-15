package micronaut.test.jpa.model.repository;

import micronaut.test.jpa.model.entity.Station;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

public interface StationRepository {

    Optional<Station> findById(@NotNull Long id);
    Station save(@NotBlank Station station);
    void delete(@NotNull Station station);
    List<Station> findAll();
    Station update(@NotNull Station station);

}
