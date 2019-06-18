package entity;

import javax.persistence.*;

import java.util.HashSet;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "kid")
public class Kid implements java.io.Serializable {

    // Properties

    private Integer idKid;

    private Integer age;

    private Set<Park> visitedParks = new HashSet<>();

    // Getters with annotations

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "idKid", unique = true, nullable = false)
    public Integer getIdKid() {
        return idKid;
    }

    @Column(name = "age")
    public Integer getAge() {
        return age;
    }

    @ManyToMany(fetch=FetchType.EAGER, cascade = CascadeType.ALL)
    public Set<Park> getVisitedParks() {
        return visitedParks;
    }


    // Constructors

    Kid() {

    }

    public Kid(Integer age) {
        this.idKid = idKid;
        this.age = age;
    }

    public Kid(Integer idKid, Integer age) {
        this.idKid = idKid;
        this.age = age;
    }

    // Setters

    public void setIdKid(Integer idKid) {
        this.idKid = idKid;
    }

    public void setAge(Integer age) {
        this.idKid = idKid;
        this.age = age;
    }

    public void setVisitedParks(Set<Park> visitedParks) {
        this.visitedParks = visitedParks;
    }

    //TODO
    @Override
    public String toString() {
        return "Kid";
    }
}
