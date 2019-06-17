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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class FacilityTabController implements Initializable {

    @FXML
    private TextField facilityNameTextField;

    @FXML
    private TextField facilityMinAgeTextField;

    @FXML
    private TableView<Facility> facilityTableView;

    @FXML
    private TableColumn facilityNameColumn;

    @FXML
    private TableColumn facilityMinAgeColumn;

    @FXML
    private ComboBox<Park> selectParkComboBox;

    @FXML
    private void saveFacilityData(ActionEvent event) {

        if ((facilityNameTextField.getText() != null && !facilityNameTextField.getText().isEmpty())
                && (facilityMinAgeTextField.getText() != null && !facilityMinAgeTextField.getText().isEmpty())) {
            String facilityName = facilityNameTextField.getText();
            Integer minAge = Integer.parseInt(facilityMinAgeTextField.getText());

            Integer facilityId = DBMethods.addFacility(facilityName, minAge);
            Facility facilityObject = DBMethods.getFacility(facilityId);

            facilityTableView.getItems().add(facilityObject);
            facilityNameTextField.clear();
            facilityMinAgeTextField.clear();
        } else {
            // TODO
            System.out.println("Error message for not entering data");
        }
    }

    @FXML
    public void deleteFacilityData(ActionEvent actionEvent) {
        Facility selectedObject = facilityTableView.getSelectionModel().getSelectedItem();
        if (selectedObject != null) {
            System.out.println(selectedObject.getIdFacility());
            facilityTableView.getItems().removeAll(selectedObject);
            DBMethods.deleteFacility(selectedObject.getIdFacility());
        }
    }

    @FXML
    void addFacilityToSelectedPark(ActionEvent event) {
        Park selectedPark = selectParkComboBox.getValue();

        Facility facility = facilityTableView.getSelectionModel().getSelectedItem();

        DBMethods.addFacilityForSpecificPark(selectedPark.getIdPark(), facility);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        final ObservableList<Facility> facilityData = FXCollections.observableArrayList(DBMethods.getFacilities());

        facilityNameColumn.setCellValueFactory(
                new PropertyValueFactory<>("name"));
        facilityMinAgeColumn.setCellValueFactory(
                new PropertyValueFactory<>("minAge"));

        facilityTableView.setItems(facilityData);

        ObservableList<Park> parkData = FXCollections.observableArrayList(DBMethods.getParks());

        selectParkComboBox.setItems(parkData);
    }

}
