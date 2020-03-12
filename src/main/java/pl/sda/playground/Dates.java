package pl.sda.playground;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Dates {
    public static void main(String[] args) {
        String input = "2020/03/07";

        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDate parsedDate = LocalDate.parse(input, inputFormatter);


        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("dd. MMMM yyy");

        LocalDate payDay = new PaydayChecker(parsedDate).getPayDay();
        Period toPayday = Period.between(LocalDate.now(), payDay);
        System.out.println("Days to payday: " + toPayday.getDays());
        System.out.println("Payday date is: " + payDay.format(outputFormatter));


        LocalTime localTime = LocalTime.now();
        LocalTime next = new Bus(localTime).next();
        Duration between = Duration.between(localTime, next);
        System.out.println("Next bus: " + next);
        System.out.println("Arrives in: " + between.toMinutes());

    }
}
