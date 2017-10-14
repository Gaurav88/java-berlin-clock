package com.ubs.opsit.interviews.chain;

import com.ubs.opsit.interviews.clock.BerlinClock;
import com.ubs.opsit.interviews.clock.Color;
import com.ubs.opsit.interviews.clock.LampState;
import com.ubs.opsit.interviews.util.Utils;

public class MinutesLampStatusCalc implements LampStatusCalc {
    private LampStatusCalc chain;
    private int minuteFirstRow = Utils.MINUTE_FIRST_ROW;
    private int minuteSecondRow = Utils.MINUTE_SECOND_ROW;

    @Override
    public void setNextChain(LampStatusCalc nextChain) {
        this.chain = nextChain;
    }

    /**
     * @param berlinClock
     *
     */
    @Override
    public void status(BerlinClock berlinClock) {
        int firstRowLampCount = berlinClock.getMinute() / 5;
        int secondRowLampCount = berlinClock.getMinute() % 5;
        updateLampStatus(berlinClock, firstRowLampCount, minuteFirstRow, Color.Y);
        updateQuarter(berlinClock);
        updateLampStatus(berlinClock, secondRowLampCount, minuteSecondRow, Color.Y);

    }

    /**
     * @param berlinClock
     */
    private void updateQuarter(BerlinClock berlinClock) {
        for (int i = 0; i < berlinClock.getLampList().get(minuteFirstRow).size(); i++) {
            if (LampState.OFF.equals(berlinClock.getLampList().get(minuteFirstRow).get(i).getLampState())) {
                break;
            }
            if (i > 1 && (i + 1) % 3 == 0) {
                berlinClock.getLampList().get(minuteFirstRow).get(i).setColor(Color.R);
            }
        }
    }
}
