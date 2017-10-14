package com.ubs.opsit.interviews.chain;

import com.ubs.opsit.interviews.clock.BerlinClock;
import com.ubs.opsit.interviews.clock.Color;
import com.ubs.opsit.interviews.clock.Lamp;
import com.ubs.opsit.interviews.clock.LampState;
import com.ubs.opsit.interviews.util.Utils;

public class SecondsLampStatusCalc implements LampStatusCalc {
    private LampStatusCalc chain;
    private int index = Utils.SECOND_FIRST_ROW;

    @Override
    public void setNextChain(LampStatusCalc nextChain) {
        this.chain = nextChain;
    }

    /**
     * @param berlinClock
     */
    @Override
    public void status(BerlinClock berlinClock) {
        if (berlinClock.getSecond() != 1 && berlinClock.getSecond() % 2 == 0) {
            for (Lamp lamp : berlinClock.getLampList().get(index)) {
                lamp.setLampState(LampState.ON);
                lamp.setColor(Color.Y);
            }
        }
        this.chain.status(berlinClock);
    }
}
