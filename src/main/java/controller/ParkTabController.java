package controller;

import entity.DBMethods;
import entity.ObservableListHolder;
import entity.Park;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import utility.AlertErrorUtility;

import java.net.URL;
import java.util.ResourceBundle;

public class ParkTabController implements Initializable {

    private ObservableListHolder observableListHolder = ObservableListHolder.getInstance();

    @FXML
    private AnchorPane parksTab;

    @FXML
    private TableView<Park> parkTableView;

    @FXML
    private TableColumn<Object, Object> parkNameColumn;

    @FXML
    private TableColumn<Object, Object> entryTicketPriceColumn;

    @FXML
    private TextField parkNameTextField;

    @FXML
    private TextField entryTicketPriceTextField;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ObservableList<Park> parkData = observableListHolder.getParksObservableList();

        parkNameColumn.setCellValueFactory(
                new PropertyValueFactory<>("name"));
        entryTicketPriceColumn.setCellValueFactory(
                new PropertyValueFactory<>("entryTicketPrice"));

        parkTableView.setItems(parkData);
    }

    @FXML
    void saveParkData(ActionEvent event) {
        if ((parkNameTextField.getText() != null && !parkNameTextField.getText().isEmpty())
                && (entryTicketPriceTextField.getText() != null && !entryTicketPriceTextField.getText().isEmpty())) {
            String parkName = parkNameTextField.getText();
            Double entryTicketPrice = Double.parseDouble(entryTicketPriceTextField.getText());

            Integer parkId = DBMethods.addPark(parkName, entryTicketPrice);
            Park parkObject = DBMethods.getPark(parkId);

            observableListHolder.addParkToArrayList(parkObject);

            parkTableView.getItems().add(parkObject);
            parkNameTextField.clear();
            entryTicketPriceTextField.clear();
        } else {
            AlertErrorUtility.showCustomAlert("Неправилно въведени данни!");
        }
    }

    @FXML
    void deleteParkData(ActionEvent event) {
        Park selectedObject = parkTableView.getSelectionModel().getSelectedItem();
        if (selectedObject != null) {
            parkTableView.getItems().removeAll(selectedObject);
            DBMethods.deletePark(selectedObject.getIdPark());

            observableListHolder.removeParkFromArrayList(selectedObject);
        }
    }
}


