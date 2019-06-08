package entity;

import javax.persistence.*;

import java.util.Set;
import java.util.TreeSet;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "facility")
public class Facility implements Comparable {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "idFacility", unique = true, nullable = false)
    private Integer idFacility;

    @Column(name = "name", length = 25)
    private String name;

    @Column(name = "minAge")
    private Integer minAge;

    @ManyToMany()
    private Set<Park> parks = new TreeSet<>();

    Facility() {
        this.name = "Facility name not entered";
    }

    public Facility(String name, Integer minAge, Set<Park> parks) {
        this.name = name;
        this.minAge = minAge;
        this.parks = parks;
    }

    public Facility(String name, Integer minAge) {
        this.name = name;
        this.minAge = minAge;
    }


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

    public Integer getIdFacility() {
        return idFacility;
    }

    public String getName() {
        return name;
    }

    public Integer getMinAge() {
        return minAge;
    }

    public Set<Park> getParks() {
        return parks;
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
