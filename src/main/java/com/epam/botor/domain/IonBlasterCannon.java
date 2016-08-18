package com.epam.botor.domain;

public class IonBlasterCannon extends AbstractIonBlaster {

    public IonBlasterCannon() {
    }

    public IonBlasterCannon(final int ionDamage) {
        super(ionDamage);
    }

    public String use() {
        return "ION-ION-ION-ION-ION-ION-ION";
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("IonBlasterCannon [").append(super.toString()).append("]");
        return builder.toString();
    }

}
