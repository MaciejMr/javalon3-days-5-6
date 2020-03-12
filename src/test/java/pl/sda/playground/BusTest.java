package pl.sda.playground;

import org.junit.jupiter.api.Test;

import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

class BusTest {

    @Test
    void should() {
        //given
        LocalTime localTime = LocalTime.of(10,15);
        //when
        LocalTime nexBus = new Bus (localTime).next();
        //then
        assertEquals(LocalTime.of(10,20),nexBus);
    }

    @Test
    void shouldNightBus() {
        //given
        LocalTime localTime = LocalTime.of(22,15);
        //when
        LocalTime nexBus = new Bus (localTime).next();
        //then
        assertEquals(LocalTime.of(22,30),nexBus);

    }
}