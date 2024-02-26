package ar.edu.fie.undef.sensorlisterner;

import ar.edu.fie.undef.sensorlisterner.utils.DateUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UnitTests {
    @Test
    @DisplayName("Test function to get the diffrence between the time when the counter was occupied and the time when it was free")
    void test() {
        Date date1 = new Date(2021, 10, 10, 10, 10, 10);
        Date date2 = new Date(2021, 10, 10, 10, 11, 30);
        long secondsDiff = DateUtils.getDifferenceInSeconds(date1, date2);
        long minutesDiff = DateUtils.getDifferenceInMinutes(date1, date2);
        long millisecondsDiff = DateUtils.getDifferenceInMilliseconds(date1, date2);
        assertEquals(80, secondsDiff);
        assertEquals(1, minutesDiff);
        assertEquals(80000, millisecondsDiff);



    }
}
