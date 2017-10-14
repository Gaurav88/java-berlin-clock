package com.ubs.opsit.interviews.chain;

import com.ubs.opsit.interviews.clock.BerlinClock;
import com.ubs.opsit.interviews.clock.Color;
import com.ubs.opsit.interviews.util.Utils;

public class HoursLampStatusCalc implements LampStatusCalc {
    private LampStatusCalc chain;
    private int hourFirstRow = Utils.HOUR_FIRST_ROW;
    private int hourSecondRow = Utils.HOUR_SECOND_ROW;

    @Override
    public void setNextChain(LampStatusCalc nextChain) {
        this.chain = nextChain;
    }

    /**
     * @param berlinClock
     */
    @Override
    public void status(BerlinClock berlinClock) {

        int firstRowLampCount = berlinClock.getHour() / 5;
        int secondRowLampCount = berlinClock.getHour() % 5;
        updateLampStatus(berlinClock, firstRowLampCount, hourFirstRow, Color.R);
        updateLampStatus(berlinClock, secondRowLampCount, hourSecondRow, Color.R);
        this.chain.status(berlinClock);

    }


}
