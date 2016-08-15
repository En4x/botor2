package com.epam.botor.domain;

public class Jedi implements ForceUser {

    @Override
    public ForceSide getAlliance() {
        return ForceSide.LIGHT;
    }

}
