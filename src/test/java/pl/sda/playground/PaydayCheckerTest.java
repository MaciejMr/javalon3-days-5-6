package pl.sda.playground;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class PaydayCheckerTest {

    @Test
    void should() {
        //given
        LocalDate localDate = LocalDate.of(2020, 3,7);
        //when
        PaydayChecker paydayChecker = new PaydayChecker(localDate);
        LocalDate myLocalDate = paydayChecker.getPayDay();
        //then
        LocalDate expectedDate = LocalDate.of(2020, 3,26);
        assertEquals(expectedDate,myLocalDate);
    }
    @Test
    void shouldTestWeekend() {
        //given
        LocalDate localDate = LocalDate.of(2020, 4,7);
        //when
        PaydayChecker paydayChecker = new PaydayChecker(localDate);
        LocalDate myLocalDate = paydayChecker.getPayDay();
        //then
        LocalDate expectedDate = LocalDate.of(2020, 4,24);
        assertEquals(expectedDate,myLocalDate);
    }

}