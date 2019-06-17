package entity;

import javax.persistence.*;

import java.util.HashSet;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "facility")
public class Facility implements java.io.Serializable {

    // Properties

    private Integer idFacility;

    private String name;

    private Integer minAge;

    private Set<Park> parks = new HashSet<>();


    // Getters with annotations

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "idFacility", unique = true, nullable = false)
    public Integer getIdFacility() {
        return idFacility;
    }

    @Column(name = "name", length = 25)
    public String getName() {
        return name;
    }

    @Column(name = "minAge")
    public Integer getMinAge() {
        return minAge;
    }

    @OneToMany(fetch=FetchType.EAGER, cascade = CascadeType.ALL)
    public Set<Park> getParks() {
        return parks;
    }

    // Setters

    public void setIdFacility(Integer idFacility) {
        this.idFacility = idFacility;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMinAge(Integer minAge) {
        this.minAge = minAge;
    }

    public void setParks(Set<Park> parks) {
        this.parks = parks;
    }

    // Constructors

    Facility() {
        this.idFacility = idFacility;
        this.name = "Facility name not entered";
    }

    public Facility(String name, Integer minAge, Set<Park> parks) {
        this.idFacility = idFacility;
        this.name = name;
        this.minAge = minAge;
        this.parks = parks;
    }

    public Facility(String name, Integer minAge) {
        this.idFacility = idFacility;
        this.name = name;
        this.minAge = minAge;
    }

    //TODO
    @Override
    public String toString() {
        return this.name;
    }

}
