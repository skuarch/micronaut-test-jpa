package micronaut.test.jpa.model.repository;

import io.micronaut.configuration.hibernate.jpa.scope.CurrentSession;
import micronaut.test.jpa.model.entity.Station;

import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import io.micronaut.spring.tx.annotation.Transactional;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

@Singleton
public class StationRepositoryImpl implements StationRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public StationRepositoryImpl(@CurrentSession EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Station> findById(@NotNull Long id) {
        return Optional.ofNullable(entityManager.find(Station.class, id));
    }

    @Override
    @Transactional
    public Station save(@NotBlank Station station) {
        entityManager.persist(station);
        return station;
    }

    @Override
    @Transactional
    public void delete(@NotNull Station station) {
        entityManager.remove(station);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Station> findAll() {
        String qlString = "SELECT s FROM Station as s";
        Query query = entityManager.createQuery(qlString, Station.class);
        return query.getResultList();
    }

    @Override
    @Transactional
    public Station update(@NotNull Station station) {
        return entityManager.merge(station);
    }
}
