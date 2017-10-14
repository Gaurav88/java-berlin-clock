package com.ubs.opsit.interviews.clock;

import com.ubs.opsit.interviews.util.Utils;

import java.util.ArrayList;
import java.util.List;

public class BerlinClock {
    private List<List<Lamp>> lampList;
    private int hour;
    private int minute;
    private int second;

    public BerlinClock(int hours, int minutes, int seconds) {
        this.hour = hours;
        this.minute = minutes;
        this.second = seconds;
        initialize();
    }

    public List<List<Lamp>> getLampList() {
        return lampList;
    }

    private void initialize() {
        lampList = new ArrayList<>();
        lampList.add(createSecondLamp());
        lampList.add(createHourLampsFirstRow());
        lampList.add(createHourLampsSecongRow());
        lampList.add(createMinutesLampsFirstRow());
        lampList.add(createMinutesLampsSecongRow());
    }

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    public int getSecond() {
        return second;
    }

    /**
     * @return
     */
    private List<Lamp> createSecondLamp() {
        List<Lamp> hourLampList = new ArrayList<>();
        for (int i = 0; i < Utils.SECOND_LAMP_COUNT; i++) {
            hourLampList.add(new Lamp(Color.O, LampState.OFF));
        }
        return hourLampList;
    }

    /**
     * @return
     */
    private List<Lamp> createHourLampsFirstRow() {
        List<Lamp> hourLampList = new ArrayList<>();
        for (int i = 0; i < Utils.HOUR_LAMP_COUNT; i++) {
            hourLampList.add(new Lamp(Color.O, LampState.OFF));
        }
        return hourLampList;
    }

    /**
     * @return
     */
    private List<Lamp> createHourLampsSecongRow() {
        List<Lamp> hourLampList = new ArrayList<>();
        for (int i = 0; i < Utils.HOUR_LAMP_COUNT; i++) {
            hourLampList.add(new Lamp(Color.O, LampState.OFF));
        }
        return hourLampList;
    }

    /**
     * @return
     */
    private List<Lamp> createMinutesLampsFirstRow() {
        List<Lamp> hourLampList = new ArrayList<>();
        for (int i = 0; i < Utils.MINUTE_FIRST_ROW_LAMP_COUNT; i++) {
            hourLampList.add(new Lamp(Color.O, LampState.OFF));
        }
        return hourLampList;
    }

    /**
     * @return
     */
    private List<Lamp> createMinutesLampsSecongRow() {
        List<Lamp> hourLampList = new ArrayList<>();
        for (int i = 0; i < Utils.MINUTE_SECOND_ROW_LAMP_COUNT; i++) {
            hourLampList.add(new Lamp(Color.O, LampState.OFF));
        }
        return hourLampList;
    }
}
