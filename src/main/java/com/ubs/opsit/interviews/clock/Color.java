package com.ubs.opsit.interviews.clock;

public enum Color {
    R("R"),
    Y("Y"),
    O("O");

    private String desc;

    Color(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }
}
