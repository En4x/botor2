package com.epam.botor.domain;

public class DefaultForceUser implements ForceUser {

    private ForceSide alliance;

    @Override
    public ForceSide getAlliance() {
        return alliance;
    }

    @Override
    public void setAlliance(final ForceSide alliance) {
        this.alliance = alliance;
    }

}