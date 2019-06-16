/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import java.util.*;

public class DBMethods {

    private static SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    // Status: Ready
    /* FACILITY */
    /* Method to CREATE a facility in the database */
    public static Integer addFacility(String name, Integer minAge) {
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        Integer facilityID = null;

        try {
            tx = session.beginTransaction();
            Facility facility = new Facility(name, minAge);
            facilityID = (Integer) session.save(facility);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return facilityID;
    }

    // Status: Ready
    /* FACILITY */
    /* Method to ADD a facility to a PARK */
    public static void addFacilityForSpecificPark(Park park, Facility facility) {
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        Integer parkID = null;

        try {
            tx = session.beginTransaction();
            park.setSingleFacility(facility);
            parkID = (Integer) session.save(park);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        //return facilityID;
    }

    // Status: Ready
    /* FACILITY */
    /* Method to RETURN a facility from the database */
    public static Facility getFacility(Integer facilityID) {
        Session session = sessionFactory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            Facility facility = (Facility) session.get(Facility.class, facilityID);
            tx.commit();
            return facility;
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }

    // Status: In progress
    /* FACILITY */
    /* Method to LIST all the facilities */
    public static void listFacilitiesForSelectedPark(Park park) {
        Session session = sessionFactory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();

            //String hql = "SELECT P.facilities FROM "+ Park.class.getSimpleName() + " P WHERE P.idPark=" + park.getIdPark();
            //String hql = "FROM Park WHERE Park_idPark=" + park.getIdPark();
            //List facilities = session.createQuery(hql).list();

            Set<Facility> facilities = park.getFacilities();

            for (Iterator iterator = facilities.iterator(); iterator.hasNext();) {
                Facility facility = (Facility) iterator.next();
                System.out.println(" Name: " + facility.getName() + "Minimal Age: " + facility.getMinAge());
            }
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    // Status: Ready
    /* FACILITY */
    /* Method to DELETE a facility by id */
    public static void deleteFacility(Integer idFacility) {
        Session session = sessionFactory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            Facility facility = (Facility) session.get(Facility.class, idFacility);
            session.delete(facility);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    // Status: Ready
    /* FACILITY */
    /* Method to RETURN all facilities */
    public static ObservableList<Facility> getFacilities() {
        Session session = sessionFactory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            List facilities = session.createQuery("FROM " + Facility.class.getSimpleName()).list();
            ObservableList<Facility> facilityObservableList = FXCollections.observableArrayList(facilities);
            tx.commit();
            return facilityObservableList;
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }

    // Status: To be removed
    /* FACILITY */ //TODO AFTER ADD METHOD
    /* Method to RETURN all facilities FOR A SPECIFIC PARK*/
    public static ObservableList<Facility> getFacilitiesForSpecificPark(Park park) {
        Session session = sessionFactory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();

            // Modify to get the list of facilities in selected park.
            // Query or method.
            List facilities = session.createQuery("FROM " + Facility.class.getSimpleName() + "").list();
            ObservableList<Facility> facilityObservableList = FXCollections.observableArrayList(facilities);
            tx.commit();
            return facilityObservableList;
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }

    // Status: Ready
    /* PARK */
    /* Method to CREATE a park in the database */
    public static Integer addPark(String name, Double entryTicketPrice) {
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        Integer parkID = null;

        try {
            tx = session.beginTransaction();
            Park park = new Park(name,entryTicketPrice);
            parkID = (Integer) session.save(park);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return parkID;
    }

    // Status: Rework
    /* PARK */
    /* Method to CREATE a park WITH FACILITIES AND MANAGER in the database */
    public static Integer addPark(String name, Double entryTicketPrice, Manager manager, TreeSet<Facility> facilities) {
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        Integer parkID = null;

        try {
            tx = session.beginTransaction();
            Park park = new Park(name, entryTicketPrice, manager, facilities);
            parkID = (Integer) session.save(park);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return parkID;
    }

    // Status: Ready
    /* PARK */
    /* Method to RETURN a park from the database */
    public static Park getPark(Integer parkID) {
        Session session = sessionFactory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            Park park = (Park) session.get(Park.class, parkID);
            tx.commit();
            return park;
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }

    // Status: Ready
    /* PARK */
    /* Method to DELETE a park by id */
    public static void deletePark(Integer idPark) {
        Session session = sessionFactory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            Park park = (Park) session.get(Park.class, idPark);
            session.delete(park);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    // Status: Ready
    /* PARK */
    /* Method to RETURN all parks */
    public static ObservableList<Park> getParks() {
        Session session = sessionFactory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            List parks = session.createQuery("FROM " + Park.class.getSimpleName()).list();
            ObservableList<Park> parkObservableList = FXCollections.observableArrayList(parks);
            tx.commit();
            return parkObservableList;
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }

    // Status: Ready
    /* KID */
    /* Method to CREATE a kid in the database */
    public static Integer addKid(Integer age) {
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        Integer kidID = null;

        try {
            tx = session.beginTransaction();
            Kid kid = new Kid(age);
            kidID = (Integer) session.save(kid);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return kidID;
    }

    // Status: Ready
    /* KID */
    /* Method to RETURN a kid from the database */
    public static Kid getKid(Integer kidID) {
        Session session = sessionFactory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            Kid kid = (Kid) session.get(Kid.class, kidID);
            tx.commit();
            return kid;
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }

    // Status: Ready
    /* KID */
    /* Method to DELETE a kid by id */
    public static void deleteKid(Integer idKid) {
        Session session = sessionFactory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            Kid kid = (Kid) session.get(Kid.class, idKid);
            session.delete(kid);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    // Status: Ready
    /* KID */
    /* Method to RETURN all kids */
    public static ObservableList<Kid> getKids() {
        Session session = sessionFactory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            List kids = session.createQuery("FROM " + Kid.class.getSimpleName()).list();
            ObservableList<Kid> kidObservableList = FXCollections.observableArrayList(kids);
            tx.commit();
            return kidObservableList;
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }

    // Status: Ready
    /* MANAGER */
    /* Method to CREATE a manager in the database */
    public static Integer addManager(String managerName, Double managerSalary) {
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        Integer managerID = null;

        try {
            tx = session.beginTransaction();
            Manager manager = new Manager(managerName, managerSalary);
            managerID = (Integer) session.save(manager);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return managerID;

    }

    // Status: Ready
    /* MANAGER */
    /* Method to RETURN a manager from the database */
    public static Manager getManager(Integer managerId) {
        Session session = sessionFactory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            Manager manager = (Manager) session.get(Manager.class, managerId);
            tx.commit();
            return manager;
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return null;

    }

    // Status: Ready
    /* MANAGER */
    /* Method to RETURN all managers */
    public static ObservableList<Manager> getManagers() {
        Session session = sessionFactory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            List managers = session.createQuery("FROM " + Manager.class.getSimpleName()).list();
            ObservableList<Manager> managerObservableList = FXCollections.observableArrayList(managers);
            tx.commit();
            return managerObservableList;
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }

    // Status: To be removed
    /* MANAGER */
    /* Method to LIST all the managers */
    public static void listManagers() {
        Session session = sessionFactory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            List managers = session.createQuery("FROM " + Manager.class.getName()).list();
            for (Iterator iterator = managers.iterator(); iterator.hasNext();) {
                Manager manager = (Manager) iterator.next();
                System.out.println(" Name: " + manager.getName() + "Salary: " + manager.getSalary());
            }
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    // Status: To be done
    /* MANAGER */
    public static void deleteManager(Integer idManager) {
    }
}
