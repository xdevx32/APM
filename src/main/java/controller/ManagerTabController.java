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
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import java.net.URL;
import java.util.ResourceBundle;

public class ManagerTabController implements Initializable {

    @FXML
    private TextField managerNameTextField;

    @FXML
    private TextField managerSalaryTextField;

    @FXML
    private TableView<Manager> managerTableView;

    @FXML
    private TableColumn managerNameColumn;

    @FXML
    private TableColumn managerSalaryColumn;

    @FXML
    private ComboBox<Park> selectParkComboBox;

    @FXML
    void deleteManagerData(ActionEvent event) {
        Manager selectedObject = managerTableView.getSelectionModel().getSelectedItem();
        if (selectedObject != null) {
            System.out.println(selectedObject.getIdManager());
            managerTableView.getItems().removeAll(selectedObject);
            DBMethods.deleteManager(selectedObject.getIdManager());
        }
    }

    @FXML
    void saveManagerData(ActionEvent event) {
        if ((managerNameTextField.getText() != null && !managerNameTextField.getText().isEmpty())
                && (managerSalaryTextField.getText() != null && !managerSalaryTextField.getText().isEmpty())) {
            String managerName = managerNameTextField.getText();
            Double managerSalary = Double.parseDouble(managerSalaryTextField.getText());

            Integer managerId = DBMethods.addManager(managerName, managerSalary);
            Manager managerObject = DBMethods.getManager(managerId);

            managerTableView.getItems().add(managerObject);
            managerNameTextField.clear();
            managerSalaryTextField.clear();
        } else {
            // TODO
            System.out.println("Error message for not entering data");
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        final ObservableList<Manager> managerData = FXCollections.observableArrayList(DBMethods.getManagers());

        managerNameColumn.setCellValueFactory(
                new PropertyValueFactory<>("name"));
        managerSalaryColumn.setCellValueFactory(
                new PropertyValueFactory<>("salary"));

        managerTableView.setItems(managerData);

        ObservableList<Park> parkData = FXCollections.observableArrayList(DBMethods.getParks());

        selectParkComboBox.setItems(parkData);
    }

    @FXML
    void addManagerToPark(ActionEvent event) {
        Park selectedPark = selectParkComboBox.getValue();

        Manager manager = managerTableView.getSelectionModel().getSelectedItem();

        DBMethods.addManagerForSpecificPark(selectedPark.getIdPark(), manager);
    }
}

