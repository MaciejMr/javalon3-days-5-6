package pl.sda.playground;


import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

public class PaydayChecker {

    LocalDate localDate;
    PaydayChecker(LocalDate localDate2) {
        localDate = localDate2;
    }


    LocalDate getPayDay() {
        LocalDate fiveDayToPay = lastDayOfMonth().minusDays(5);
        if (fiveDayToPay.getDayOfWeek() == DayOfWeek.SATURDAY) {
            return fiveDayToPay.minusDays(1);
        }
        if (fiveDayToPay.getDayOfWeek() == DayOfWeek.SUNDAY) {
            return fiveDayToPay.minusDays(2);
        }
        return fiveDayToPay;
    }
    public LocalDate lastDayOfMonth() {
        return localDate.with(TemporalAdjusters.lastDayOfMonth());
    }
}
