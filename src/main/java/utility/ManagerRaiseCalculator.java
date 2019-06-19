package utility;

import entity.DBMethods;
import entity.Manager;

public class ManagerRaiseCalculator {

    public static Integer percent = 14;

    public static Double targetIncomeForPark = 30.0;

    public static void raiseSalaryByPercent(Manager manager) {
        Double newSalary = 0.0;

        newSalary = manager.getSalary() + (percent * manager.getSalary()) / 100;

        DBMethods.updateManagerSalary(manager.getIdManager(), newSalary);

    }

}
