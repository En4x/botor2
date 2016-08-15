package com.epam.botor.domain;

public class Sith implements ForceUser {

    @Override
    public ForceSide getAlliance() {
        return ForceSide.DARK;
    }

}
