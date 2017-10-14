package com.ubs.opsit.interviews.chain;

import com.ubs.opsit.interviews.clock.BerlinClock;
import com.ubs.opsit.interviews.clock.Color;
import com.ubs.opsit.interviews.clock.LampState;

public interface LampStatusCalc {
    /**
     * @param nextChain
     */
    void setNextChain(LampStatusCalc nextChain);

    /**
     * @param berlinClock
     *
     */
    void status(BerlinClock berlinClock);

    /**
     * @param berlinClock
     * @param count
     * @param row
     * @param color
     */
    default void updateLampStatus(BerlinClock berlinClock, int count, int row, Color color) {
        for (int i = 0; i < count; i++) {
            berlinClock.getLampList().get(row).get(i).setLampState(LampState.ON);
            berlinClock.getLampList().get(row).get(i).setColor(color);
        }
    }
}
