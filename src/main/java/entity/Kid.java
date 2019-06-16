package entity;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "kid")
public class Kid implements java.io.Serializable {

    // Properties

    private Integer idKid;

    private Integer age;


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

    public void setIdKid(Integer idKid) {
        this.idKid = idKid;
    }

    public void setAge(Integer age) {
        this.idKid = idKid;
        this.age = age;
    }

    //TODO
    @Override
    public String toString() {
        return "Kid";
    }
}
