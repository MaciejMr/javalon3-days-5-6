package pl.sda.playground;

import java.time.LocalTime;

public class Bus {
    private static final LocalTime EIGHT = LocalTime.of(8, 0);
    private static final LocalTime TEN = LocalTime.of(22, 0);
    private LocalTime now;

    public Bus(LocalTime localTime) {
        this.now = localTime;
    }

    public LocalTime next() {
        if (now.isAfter(EIGHT) && now.isBefore(TEN)) {
            return schedule();
        }
        return nightSchedule();
    }

    private LocalTime schedule() {
        LocalTime twentyMin = LocalTime.of(now.getHour(), 20);
        LocalTime nextMin = LocalTime.of(now.getHour(), 40);
        if (now.isBefore(twentyMin)) {
            return twentyMin;
        } else if (now.isBefore(nextMin)) {
            return nextMin;
        } else {
            return twentyMin.plusHours(1);
        }
    }

    private LocalTime nightSchedule() {
        LocalTime halfMin = LocalTime.of(now.getHour(), 30);
        if (now.isAfter(halfMin)) {
            return halfMin.plusHours(1);
        } else {
            return halfMin;
        }
    }
}
