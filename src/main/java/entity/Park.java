package entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "park")
public class Park implements java.io.Serializable {

    private Integer idPark;

    private String name;

    private Double entryTicketPrice;

    private Manager manager;

    private Set<Facility> facilities = new HashSet<Facility>(0);

    private Set<Kid> kidVisitors = new HashSet<>();

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

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "park_facility", joinColumns = {@JoinColumn(name = "idPark")}, inverseJoinColumns = {@JoinColumn(name = "idFacility")})
    public Set<Facility> getFacilities() {
        return facilities;
    }

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "park_kid", joinColumns = {@JoinColumn(name = "idPark")}, inverseJoinColumns = {@JoinColumn(name = "idKid")})
    public Set<Kid> getKidVisitors() {
        return kidVisitors;
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

    public void setKidVisitors(Set<Kid> kidVisitors) {
        this.kidVisitors = kidVisitors;
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

    public void unsetManager() {
        this.manager = null;
    }

    public void setSingleFacility(Facility facility) {
        this.facilities.add(facility);
    }

    public void setSingleKidVisitor(Kid kid) {
        this.kidVisitors.add(kid);
    }

    public Double calculateTotalIncome() {
        return this.getKidVisitors().size() * this.entryTicketPrice;
    }

    @Override
    public String toString() {
        return name;
        //For testing purposes
        //return "Име на парк: " + name + " с мениджър: " + this.getManager().getName() + ".";
    }



}