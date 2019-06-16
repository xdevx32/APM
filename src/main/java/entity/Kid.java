package entity;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "kid")

public class Kid implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "idKid", unique = true, nullable = false)
    private Integer idKid;

    @Column(name = "age")
    private Integer age;

    Kid() {

    }
    public Kid(Integer age) {
        this.age = age;
    }

    public Kid(Integer idKid, Integer age) {
        this.idKid = idKid;
        this.age = age;
    }

    public Integer getIdKid() {
        return idKid;
    }

    public void setIdKid(Integer idKid) {
        this.idKid = idKid;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

}
