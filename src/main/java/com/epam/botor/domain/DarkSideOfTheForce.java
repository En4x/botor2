package com.epam.botor.domain;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Configurable;

@Configurable
public class DarkSideOfTheForce implements Force {

    @Resource(name = "theDarkSide")
    private ForceSide forceSide;

    @Override
    public String drawFrom() {
        return "Drawing from the " + forceSide + " side";
    }

}
