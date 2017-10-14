package com.ubs.opsit.interviews.chain;

import com.ubs.opsit.interviews.clock.BerlinClock;
import com.ubs.opsit.interviews.clock.Color;
import com.ubs.opsit.interviews.exception.BerlinClockException;
import com.ubs.opsit.interviews.util.Utils;
import org.junit.Test;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class HoursLampStatusCalcTest {
    @Test
    public void testStatus() throws BerlinClockException {
        String aTime = "22:45:30";

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalTime time = LocalTime.parse(aTime, formatter);
        LampStatusCalc minutesLampStatusCalc = new MinutesLampStatusCalc();
        LampStatusCalc hoursLampStatusCalc = new HoursLampStatusCalc();
        hoursLampStatusCalc.setNextChain(minutesLampStatusCalc);
        BerlinClock berlinClock = new BerlinClock(time.getHour(), time.getMinute(), time.getSecond());
        hoursLampStatusCalc.status(berlinClock);
        assert berlinClock.getLampList().get(Utils.HOUR_FIRST_ROW).get(0).getColor() == Color.R;
        assert berlinClock.getLampList().get(Utils.HOUR_SECOND_ROW).get(0).getColor() == Color.R;
    }
}
