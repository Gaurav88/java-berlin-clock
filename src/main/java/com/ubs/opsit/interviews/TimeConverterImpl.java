package com.ubs.opsit.interviews;

import com.ubs.opsit.interviews.chain.HoursLampStatusCalc;
import com.ubs.opsit.interviews.chain.LampStatusCalc;
import com.ubs.opsit.interviews.chain.MinutesLampStatusCalc;
import com.ubs.opsit.interviews.chain.SecondsLampStatusCalc;
import com.ubs.opsit.interviews.clock.BerlinClock;
import com.ubs.opsit.interviews.clock.Lamp;
import com.ubs.opsit.interviews.exception.BerlinClockException;
import com.ubs.opsit.interviews.validator.BerlinClockValidator;
import com.ubs.opsit.interviews.validator.Validator;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class TimeConverterImpl implements TimeConverter {
    private Validator berlinClockValidator;
    private BerlinClock berlinClock;
    private LampStatusCalc lampStatusCalc;

    public TimeConverterImpl() {
        berlinClockValidator = new BerlinClockValidator();
        this.lampStatusCalc = new SecondsLampStatusCalc();
        LampStatusCalc hoursLampStatusCalc = new HoursLampStatusCalc();
        LampStatusCalc minutesLampStatusCalc = new MinutesLampStatusCalc();
        lampStatusCalc.setNextChain(hoursLampStatusCalc);
        hoursLampStatusCalc.setNextChain(minutesLampStatusCalc);
    }

    /**
     * @param aTime
     * @return
     */
    @Override
    public String convertTime(String aTime) {

        String msg;
        try {
            if (aTime.equals("24:00:00")) {
                berlinClock = new BerlinClock(24, 0, 0);
            } else {
                berlinClockValidator.validate(aTime);
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
                LocalTime time = LocalTime.parse(aTime, formatter);
                berlinClock = new BerlinClock(time.getHour(), time.getMinute(), time.getSecond());
            }
            lampStatusCalc.status(berlinClock);
            msg = convertToString().toString();
        } catch (BerlinClockException e) {
            msg = e.getMessage();
        }
        return msg;
    }

    /**
     * converts List to Message
     *
     * @return
     */
    public StringBuffer convertToString() {
        StringBuffer msg = new StringBuffer();
        int count = 0;
        for (List<Lamp> lampList : berlinClock.getLampList()) {
            for (Lamp lamp : lampList) {
                msg.append(lamp.getColor().getDesc());
            }
            count++;
            if (count != berlinClock.getLampList().size()) {
                msg.append("\r\n");
            }
        }
        return msg;
    }
}
