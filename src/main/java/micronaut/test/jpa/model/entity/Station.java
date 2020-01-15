package micronaut.test.jpa.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "station")
public class Station {

    @Id
    @Column(name = "station_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
