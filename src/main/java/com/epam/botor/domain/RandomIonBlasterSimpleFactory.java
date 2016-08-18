package com.epam.botor.domain;

public abstract class RandomIonBlasterSimpleFactory {

    public IonBlaster produceIonBlaster() {
    	final IonBlasterType ionBlasterType = IonBlasterType.getRandomIonBlasterType();

        IonBlaster result = null;

        switch (ionBlasterType) {
        case PISTOL:
            result = getIonBlasterPistol();
            break;
        case RIFLE:
            result = getIonBlasterRifle();
            break;
        case CANNON:
            result = getIonBlasterCannon();
            break;
        default:
            throw new IllegalArgumentException("Not supported: " + ionBlasterType);
        }

        return result;

    }

    public abstract IonBlasterRifle getIonBlasterRifle();

    public abstract IonBlasterPistol getIonBlasterPistol();

    public abstract IonBlasterCannon getIonBlasterCannon();

}