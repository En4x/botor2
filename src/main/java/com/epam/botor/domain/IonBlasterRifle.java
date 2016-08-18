package com.epam.botor.domain;

public class IonBlasterRifle extends AbstractIonBlaster {

    public IonBlasterRifle() {
    }

    public IonBlasterRifle(final int ionDamage) {
        super(ionDamage);
    }

    public String use() {
        return "IonIonIonIonIonIonIonIonIonIon";
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("IonBlasterRifle [").append(super.toString()).append("]");
        return builder.toString();
    }

}