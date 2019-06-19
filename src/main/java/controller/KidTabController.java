package controller;

import entity.DBMethods;
import entity.Kid;
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
import javafx.scene.layout.FlowPane;
import utility.AlertErrorUtility;

import java.net.URL;
import java.util.ResourceBundle;

public class KidTabController implements Initializable {

    @FXML
    private FlowPane KidTab;

    @FXML
    private TableView<Kid> kidTableView;

    @FXML
    private TableColumn kidIdColumn;

    @FXML
    private TableColumn kidAgeColumn;

    @FXML
    private TextField kidAgeTextField;

    @FXML
    private ComboBox<Park> selectParkComboBox;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        final ObservableList<Kid> kidData = FXCollections.observableArrayList(DBMethods.getKids());

        kidIdColumn.setCellValueFactory(
                new PropertyValueFactory<>("idKid"));
        kidAgeColumn.setCellValueFactory(
                new PropertyValueFactory<>("age"));

        kidTableView.setItems(kidData);

        ObservableList<Park> parks = FXCollections.observableArrayList(DBMethods.getParks());

        selectParkComboBox.getItems().clear();

        selectParkComboBox.getItems().addAll(parks);
    }

    @FXML
    public void saveKidData(ActionEvent actionEvent) {
        if ((kidAgeTextField.getText() != null && !kidAgeTextField.getText().isEmpty())) {

            Integer kidAge = Integer.parseInt(kidAgeTextField.getText());

            Integer kidId = DBMethods.addKid(kidAge);
            Kid kidObject = DBMethods.getKid(kidId);

            kidTableView.getItems().add(kidObject);
            kidAgeTextField.clear();
        } else {
            AlertErrorUtility.showCustomAlert("Неправилно въведени данни!");
        }
    }

    @FXML
    public void deleteKidData(ActionEvent actionEvent) {
        Kid selectedObject = kidTableView.getSelectionModel().getSelectedItem();
        if (selectedObject != null) {
            System.out.println(selectedObject.getIdKid());
            kidTableView.getItems().removeAll(selectedObject);
            DBMethods.deleteKid(selectedObject.getIdKid());
        }
    }

    @FXML
    void addKidAsVisitor(ActionEvent event) {
        Park selectedPark = selectParkComboBox.getValue();
        Kid selectedKid = kidTableView.getSelectionModel().getSelectedItem();

        DBMethods.addKidVisitorToPark(selectedPark.getIdPark(), selectedKid);
    }

    @FXML
    void refreshDataAction(ActionEvent event) {
        ObservableList<Park> parks = FXCollections.observableArrayList(DBMethods.getParks());

        selectParkComboBox.getItems().clear();

        selectParkComboBox.getItems().addAll(parks);
    }
}
