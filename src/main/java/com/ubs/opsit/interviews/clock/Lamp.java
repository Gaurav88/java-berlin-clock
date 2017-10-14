package com.ubs.opsit.interviews.clock;

public class Lamp {
    private Color color;
    private LampState lampState;

    public Lamp(Color color, LampState lampState) {
        this.color = color;
        this.lampState = lampState;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public LampState getLampState() {
        return lampState;
    }

    public void setLampState(LampState lampState) {
        this.lampState = lampState;
    }
}
