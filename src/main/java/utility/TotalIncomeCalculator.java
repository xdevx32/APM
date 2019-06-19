package utility;

import entity.DBMethods;
import entity.Park;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class TotalIncomeCalculator {

    public static Double calculateTotalIncome() {
        Double totalIncome = 0.0;

        final ObservableList<Park> parkData = FXCollections.observableArrayList(DBMethods.getParks());

        for (Park park : parkData) {
            Integer count = park.getKidVisitors().size();
            Double price = park.getEntryTicketPrice();
            totalIncome += count * price;
        }

        return totalIncome;
    }

}
