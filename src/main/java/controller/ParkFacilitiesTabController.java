package controller;

import entity.DBMethods;
import entity.Facility;
import entity.Park;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import java.net.URL;
import java.util.*;


public class ParkFacilitiesTabController implements Initializable {

    @FXML
    private ComboBox<Park> parkComboBox;

    @FXML
    private ListView<String> selectedParkFacilitiesListView;

    @FXML
    void addFacilityToSelectedPark(ActionEvent event) {
        Park selectedPark = parkComboBox.getValue();

        // Hardcode adding facility object to park
        Integer facilityID = DBMethods.addFacility("Gondola",13);
        Facility facilityObject = DBMethods.getFacility(facilityID);
        DBMethods.addFacilityForSpecificPark(selectedPark,facilityObject);
        //

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        final ObservableList<Park> parks = FXCollections.observableArrayList(DBMethods.getParks());

        parkComboBox.getItems().clear();

        parkComboBox.getItems().addAll(parks);
    }

    public void displayFacilitiesForSelectedPark(ActionEvent actionEvent) {
        Park selectedPark = parkComboBox.getValue();

        final ObservableList<Facility> facilitiesForSelectedPark = DBMethods.getFacilitiesForSpecificPark(selectedPark);
        //DBMethods.listFacilitiesForSelectedPark(selectedPark);

        selectedParkFacilitiesListView.getItems().clear();

        selectedParkFacilitiesListView.getItems().addAll(String.valueOf(facilitiesForSelectedPark));
    }
}

