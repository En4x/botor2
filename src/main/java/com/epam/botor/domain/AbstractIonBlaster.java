package com.epam.botor.domain;

public abstract class AbstractIonBlaster implements IonBlaster {

    private int ionDamage;

    public AbstractIonBlaster() {    	
    }

    public AbstractIonBlaster(final int ionDamage) {

        this.ionDamage = ionDamage;
    }

    @Override
    public int getIonDamage() {
        return ionDamage;
    }
    
    abstract String use();

}
