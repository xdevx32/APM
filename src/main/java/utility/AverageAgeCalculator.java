package utility;

import entity.DBMethods;
import entity.Kid;
import entity.Park;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.Set;

public class AverageAgeCalculator {

    public static Integer calculateAverageAge() {
        Integer averageAge = 0;
        Integer totalAge = 0;
        Integer totalCount = 0;

        final ObservableList<Park> parkData = FXCollections.observableArrayList(DBMethods.getParks());

        for (Park park : parkData) {
            Set<Kid> kids = park.getKidVisitors();

            for (Kid kid : kids) {
                totalAge += kid.getAge();
            }
            totalCount += park.getKidVisitors().size();
        }

        if (totalCount != 0) {
            averageAge = totalAge / totalCount;
        }

        return averageAge;
    }

}
