package com.epam.botor.domain;

public enum IonBlasterType {

    PISTOL, RIFLE, CANNON;

    public static IonBlasterType getRandomIonBlasterType() {

        double random = Math.random();

        return random >= 0.7 ? PISTOL : random > 0.5 ? RIFLE : CANNON;
    }
}
