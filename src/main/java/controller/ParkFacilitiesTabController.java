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

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        final ObservableList<Park> parks = FXCollections.observableArrayList(DBMethods.getParks());

        parkComboBox.getItems().clear();

        parkComboBox.getItems().addAll(parks);


    }

    public void displayFacilitiesForSelectedPark(ActionEvent actionEvent) {
        Park selectedPark = parkComboBox.getValue();

        ArrayList<String> facilityNames= new ArrayList<>();

        for (Facility facility : selectedPark.getFacilities()) {
            facilityNames.add(facility.getName());
        }


        selectedParkFacilitiesListView.getItems().clear();

        selectedParkFacilitiesListView.getItems().addAll(facilityNames);
    }
}
