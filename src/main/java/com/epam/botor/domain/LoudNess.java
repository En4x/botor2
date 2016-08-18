package com.epam.botor.domain;

public enum LoudNess {

    LOW, HIGH;

    public static LoudNess getRandom() {
        return Math.random() > 0.5 ? LOW : HIGH;
    }

}