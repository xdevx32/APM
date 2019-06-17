package entity;

import javax.persistence.*;

import java.util.Set;
import java.util.HashSet;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "park")
public class Park implements java.io.Serializable {

    private Integer idPark;

    private String name;

    private Double entryTicketPrice;

    private Manager manager;

    private Set<Facility> facilities = new HashSet<>();



    // Getters with annotations
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "idPark", unique = true, nullable = false)
    public Integer getIdPark() {
        return idPark;
    }

    @Column(name = "name", length = 25)
    public String getName() {
        return name;
    }

    @Column(name = "entryTicketPrice")
    public Double getEntryTicketPrice() {
        return entryTicketPrice;
    }

    @OneToOne
    public Manager getManager() {
        return manager;
    }

    @OneToMany(fetch=FetchType.EAGER, cascade = CascadeType.ALL)
    public Set<Facility> getFacilities() {
        //TODO Check which is correct
        return facilities;
        //return new HashSet<Facility>(this.facilities);
    }

    // Setters

    public void setIdPark(Integer idPark) {
        this.idPark = idPark;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEntryTicketPrice(Double entryTicketPrice) {
        this.entryTicketPrice = entryTicketPrice;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public void setFacilities(Set<Facility> facilities) {
        this.facilities = facilities;

    }

    // Constructors

    public Park() {
        this.name = "Park name not set";
    }

    public Park(String name, Double entryTicketPrice) {
        this.idPark = idPark;
        this.name = name;
        this.entryTicketPrice = entryTicketPrice;
    }

    public Park(String name, Double entryTicketPrice, Manager manager, Set<Facility> facilities) {
        this.idPark = idPark;
        this.name = name;
        this.entryTicketPrice = entryTicketPrice;
        this.manager = manager;
        this.facilities = facilities;
    }

    public Park(Integer idPark, String name, Double entryTicketPrice, Manager manager, Set<Facility> facilities) {
        this.idPark = idPark;
        this.name = name;
        this.entryTicketPrice = entryTicketPrice;
        this.manager = manager;
        this.facilities = facilities;
    }

    // Additional

    public void setSingleFacility(Facility facility) {
        this.facilities.add(facility);
    }

    //TODO
    @Override
    public String toString() {
        //return "Park{" + "idPark=" + idPark + ", name=" + name + ", entryTicketPrice=" + entryTicketPrice +'}';
        return name;
    }



}