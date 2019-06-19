package entity;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "manager")
public class Manager implements java.io.Serializable {

    public Boolean hasPromotion = false;

    // Properties

    private Integer idManager;

    private String name;

    private Double salary;

    private Park park;

    // Getters with annotations

    // Check this for salary
    // https://www.baeldung.com/hibernate-dynamic-mapping
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "idManager", unique = true, nullable = false)
    public Integer getIdManager() {
        return idManager;
    }

    @Column(name = "name", length = 45)
    public String getName() {
        return name;
    }

    @Column(name = "salary")
    public Double getSalary() {
        return salary;
    }

    @Column(name = "hasPromotion")
    public Boolean getHasPromotion() {
        return hasPromotion;
    }

    @OneToOne(mappedBy = "manager")
    public Park getPark() {
        return park;
    }

    // Setters

    public void setIdManager(Integer idManager) {
        this.idManager = idManager;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public void setPark(Park park) {
        this.park = park;
    }

    public void setHasPromotion(Boolean hasPromotion) {
        this.hasPromotion = hasPromotion;
    }

    // Constructors

    Manager() {
        this.idManager = idManager;
        this.name = "Manager name not set";
    }

    public Manager(String name, Double salary) {
        this.idManager = idManager;
        this.name = name;
        this.salary = salary;
    }

    public Manager(Integer idManager, String name, Double salary) {
        this.idManager = idManager;
        this.name = name;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return name;
    }
}
