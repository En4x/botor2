package com.epam.botor.domain;

public class IonBlasterPistol extends AbstractIonBlaster {

    public IonBlasterPistol() {
    }

    public IonBlasterPistol(final int ionDamage) {
        super(ionDamage);
    }

    public String use() {
        return "IonIon";
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("IonBlasterPistol [").append(super.toString()).append("]");
        return builder.toString();
    }

}
