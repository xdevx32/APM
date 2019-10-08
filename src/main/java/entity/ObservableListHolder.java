package entity;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.List;
/*
*
*  A class for keeping observable lists and accessing them easily.
*
 */
public class ObservableListHolder {

    private ObservableList<Park> parksObservableList = FXCollections.observableArrayList();

    private List<Park> parksList = DBMethods.getParks();

    // static variable single_instance of type ObservableListHolder
    private static ObservableListHolder single_instance = null;

    // static method to create instance of Singleton class
    public static ObservableListHolder getInstance()
    {
        if (single_instance == null)
            single_instance = new ObservableListHolder();

        return single_instance;
    }

    public ObservableList<Park> getParksObservableList() {
        return parksObservableList;
    }

    public void setParksObservableList(ArrayList<Park> parksList) {
        parksObservableList.setAll(parksList);
    }

    public ObservableListHolder() {
        parksObservableList.setAll(DBMethods.getParks());
    }

    public void addParkToArrayList(Park park) {
        this.parksList.add(park);
    }

    public void removeParkFromArrayList(Park selectedObject) {
        this.parksList.remove(selectedObject);
    }
}