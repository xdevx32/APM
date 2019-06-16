package entity;

import javax.persistence.*;

import java.util.Set;
import java.util.TreeSet;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "park")
public class Park implements java.io.Serializable {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "idPark", unique = true, nullable = false)
    private Integer idPark;

    @Column(name = "name", length = 25)
    private String name;

    @Column(name = "entryTicketPrice")
    private Double entryTicketPrice;

    @OneToOne(mappedBy = "park")
    private Manager manager;

    //@ManyToMany(fetch=FetchType.EAGER, cascade = CascadeType.ALL)
    @ManyToMany(mappedBy = "park", fetch=FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Facility> facilities = new TreeSet<>();

    public Park(String name, Double entryTicketPrice, TreeSet<Facility> facilities) {
        this.name = name;
        this.entryTicketPrice = entryTicketPrice;
        this.facilities = facilities;
    }

    Park(){
        this.name = "Park Name Not Set";
    }

    public Park(String name, Double entryTicketPrice, Manager manager, Set<Facility> facilities) {
        this.name = name;
        this.entryTicketPrice = entryTicketPrice;
        this.manager = manager;
        this.facilities = facilities;
    }

    public Park(String name, Double entryTicketPrice, Manager manager, TreeSet<Facility> facilities) {
        this.name = name;
        this.entryTicketPrice = entryTicketPrice;
        this.manager = manager;
        this.facilities = facilities;
    }

    public Park(String name, Double entryTicketPrice) {
        this.idPark = idPark;
        this.name = name;
        this.entryTicketPrice = entryTicketPrice;
    }

    public Integer getIdPark() {
        return idPark;
    }

    public void setIdPark(Integer idPark) {
        this.idPark = idPark;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getEntryTicketPrice() {
        return entryTicketPrice;
    }

    public void setEntryTicketPrice(Double entryTicketPrice) {
        this.entryTicketPrice = entryTicketPrice;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public void setFacilities(TreeSet<Facility> facilities) {
        this.facilities = facilities;
    }

    public void setSingleFacility(Facility facility) {
        this.facilities.add(facility);
    }

    public Set<Facility> getFacilities() {
        return new TreeSet<Facility>(this.facilities);
    }

    public void setFacilities(Set<Facility> facilities) {
        this.facilities = facilities;
    }


    @Override
    public String toString() {
        //return "Park{" + "idPark=" + idPark + ", name=" + name + ", entryTicketPrice=" + entryTicketPrice +'}';
        return name;
    }



}