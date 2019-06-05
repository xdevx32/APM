package entity;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "facility")
public class Facility implements java.io.Serializable {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "idFacility", unique = true, nullable = false)
    private Integer idFacility;

    @Column(name = "name", length = 25)
    private String name;

    @Column(name = "minAge")
    private Integer minAge;

    @OneToOne
    private Park park;

    Facility() {
        this.name = "Facility name not entered";
    }

    public Facility(String name) {
        this.name = name;
    }

    public Facility(String name, Integer minAge) {
        this.name = name;
        this.minAge = minAge;
    }

    public Facility(Integer idFacility, String name, Integer minAge) {
        this.idFacility = idFacility;
        this.name = name;
        this.minAge = minAge;
    }

    public Park getPark() {
        return park;
    }

    public void setPark(Park park) {
        this.park = park;
    }


    public Integer getIdFacility() {
        return idFacility;
    }

    public void setIdFacility(Integer idFacility) {
        this.idFacility = idFacility;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getMinAge() {
        return minAge;
    }

    public void setMinAge(Integer minAge) {
        this.minAge = minAge;
    }
}
