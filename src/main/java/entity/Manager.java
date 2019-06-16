package entity;

import javax.persistence.*;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "manager")
public class Manager implements java.io.Serializable {


    // Check this for salary
    // https://www.baeldung.com/hibernate-dynamic-mapping
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "idManager", unique = true, nullable = false)
    private Integer idManager;

    @Column(name = "name", length = 45)
    private String name;

    @Column(name = "salary")
    private Double salary;

    @OneToOne
    private Park park;

    Manager() {
        this.name = "Manager name not set";
    }

    public Manager(String name, Double salary) {
        this.name = name;
        this.salary = salary;
    }

    public Manager(Integer idManager, String name, Double salary) {
        this.idManager = idManager;
        this.name = name;
        this.salary = salary;
    }

    public Integer getIdManager() {
        return idManager;
    }

    public void setIdManager(Integer idManager) {
        this.idManager = idManager;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }
}
