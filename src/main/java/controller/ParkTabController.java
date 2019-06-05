package controller;

import entity.DBMethods;
import entity.Facility;
import entity.Manager;
import entity.Park;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ParkTabController implements Initializable {

    @FXML
    private AnchorPane parksTab;

    @FXML
    private TableView<Park> parkTableView;

    @FXML
    private TableColumn parkNameColumn;

    @FXML
    private TableColumn entryTicketPriceColumn;

    @FXML
    private TextField parkNameTextField;

    @FXML
    private TextField entryTicketPriceTextField;

    @FXML
    void deleteParkData(ActionEvent event) {

    }

    @FXML
    void saveParkData(ActionEvent event) {
        /*
        if ((parkNameTextField.getText() != null && !parkNameTextField.getText().isEmpty())
                && (entryTicketPriceTextField.getText() != null && !entryTicketPriceTextField.getText().isEmpty())) {
            String parkName = parkNameTextField.getText();
            Double entryTicketPrice = Double.parseDouble(entryTicketPriceTextField.getText());
            ArrayList<Facility> facilities = new ArrayList<Facility>(); // TODO CHECK HOW IT WORKS
            Manager manager = new Manager(1, "Шефчето",3000.0);

            int parkId = DBMethods.addPark(parkName, entryTicketPrice, manager,facilities);
            Park parkObject = DBMethods.getPark(parkId);

            parkTableView.getItems().add(parkObject);
            parkNameTextField.clear();
            entryTicketPriceTextField.clear();
        } else {
            // TODO
            System.out.println("Error message for not entering data");
        }
        */
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        /*
        final ObservableList<Park> parkData = FXCollections.observableArrayList(DBMethods.getParks());

        parkNameColumn.setCellValueFactory(
                new PropertyValueFactory<>("name"));
        entryTicketPriceColumn.setCellValueFactory(
                new PropertyValueFactory<>("entryTicketPrice"));

        parkTableView.setItems(parkData);

         */
    }
}


