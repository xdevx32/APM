package controller;

import entity.DBMethods;
import entity.Kid;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.FlowPane;

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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        final ObservableList<Kid> kidData = FXCollections.observableArrayList(DBMethods.getKids());

        kidIdColumn.setCellValueFactory(
                new PropertyValueFactory<>("idKid"));
        kidAgeColumn.setCellValueFactory(
                new PropertyValueFactory<>("age"));

        kidTableView.setItems(kidData);
    }

    public void saveKidData(ActionEvent actionEvent) {
        if ((kidAgeTextField.getText() != null && !kidAgeTextField.getText().isEmpty())) {

            Integer kidAge = Integer.parseInt(kidAgeTextField.getText());

            Integer kidId = DBMethods.addKid(kidAge);
            Kid kidObject = DBMethods.getKid(kidId);

            kidTableView.getItems().add(kidObject);
            kidAgeTextField.clear();
        } else {
            // TODO
            System.out.println("Error message for not entering data");
        }
    }

    public void deleteKidData(ActionEvent actionEvent) {
        Kid selectedObject = kidTableView.getSelectionModel().getSelectedItem();
        if (selectedObject != null) {
            System.out.println(selectedObject.getIdKid());
            kidTableView.getItems().removeAll(selectedObject);
            DBMethods.deleteKid(selectedObject.getIdKid());
        }
    }
}
