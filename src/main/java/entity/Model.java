package entity;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.List;
/*
*
*  Singleton class for keeping one instance of the Model
*
 */
public class Model {

    private ObservableList<Park> parksObservableList = FXCollections.observableArrayList();

    private List<Park> parksList = DBMethods.getParks();

    // static variable single_instance of type Model
    private static Model single_instance = null;

    // static method to create instance of Singleton class
    public static Model getInstance()
    {
        if (single_instance == null)
            single_instance = new Model();

        return single_instance;
    }

    public ObservableList<Park> getParksObservableList() {
        return parksObservableList;
    }

    public void setParksObservableList(ArrayList<Park> parksList) {
        parksObservableList.setAll(parksList);
    }

    public Model() {
        parksObservableList.setAll(DBMethods.getParks());
    }

    public void addParkToArrayList(Park park) {
        this.parksList.add(park);
    }

    public void removeParkFromArrayList(Park selectedObject) {
        this.parksList.remove(selectedObject);
    }
}