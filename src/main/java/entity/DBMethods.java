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

    /* Method to RETURN a facility in the database */
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


    /* Method to  LIST all the facilities */

    // This is not even used!??!?!?!?
    public static void listFacilities() {
        Session session = sessionFactory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            List facilities = session.createQuery("FROM " + Facility.class.getName()).list();
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

    /* Method to delete a facility by id */
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

    public static Manager getManager(Integer managerId) {
        Session session = sessionFactory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            Manager manager = (Manager) session.get(Manager.class, managerId);
            //ObservableList<Facility> facilityObservableList = FXCollections.observableArrayList(facility);
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

    // This is not even used ?!??!!
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

    // GET ALL METHODS


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
}
