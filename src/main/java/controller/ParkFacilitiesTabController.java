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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;


public class ParkFacilitiesTabController implements Initializable {

    @FXML
    private ComboBox<Park> parkComboBox;

    @FXML
    private ListView<String> selectedParkFacilitiesListView;

    @FXML
    private ImageView apmLogo;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        final ObservableList<Park> parkData = FXCollections.observableArrayList(DBMethods.getParks());

        File file = new File("src/main/resources/APM_Logo.jpg");
        Image image = new Image(file.toURI().toString());
        apmLogo.setImage(image);

        parkComboBox.getItems().clear();

        parkComboBox.getItems().addAll(parkData);
    }

    public void displayFacilitiesForSelectedPark(ActionEvent actionEvent) {
        Park selectedPark = parkComboBox.getValue();

        ObservableList<Facility> facilitiesForSelectedPark = DBMethods.getFacilitiesForSpecificPark(selectedPark);

        selectedParkFacilitiesListView.getItems().clear();

        List<String> facilityNames = new ArrayList<String>();

        for (Facility facility : facilitiesForSelectedPark) {
            facilityNames.add(facility.getName());
        }

        selectedParkFacilitiesListView.getItems().addAll(facilityNames);
    }

    @FXML
    void refreshDataAction(ActionEvent event) {

        final ObservableList<Park> parkData = FXCollections.observableArrayList(DBMethods.getParks());

        parkComboBox.getItems().clear();

        parkComboBox.getItems().addAll(parkData);
    }
}

