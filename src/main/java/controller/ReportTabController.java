package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import utility.AverageAgeCalculator;
import utility.TotalIncomeCalculator;

import java.net.URL;
import java.util.ResourceBundle;

public class ReportTabController implements Initializable {

    @FXML
    private Label totalIncomeForParks;

    @FXML
    private Label avgAgeLabel;

    @FXML
    void refreshData(ActionEvent event) {
        avgAgeLabel.setText(AverageAgeCalculator.calculateAverageAge().toString());

        totalIncomeForParks.setText(TotalIncomeCalculator.calculateTotalIncome().toString());
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        avgAgeLabel.setText(AverageAgeCalculator.calculateAverageAge().toString());

        totalIncomeForParks.setText(TotalIncomeCalculator.calculateTotalIncome().toString());
    }
}
