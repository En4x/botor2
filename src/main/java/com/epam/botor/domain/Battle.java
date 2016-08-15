package com.epam.botor.domain;

import java.util.List;

public class Battle {

    private final Battleground battleground;
    private final List<Army> armies;

    public Battle(final Battleground battleground, final List<Army> armies) {
        super();
        this.battleground = battleground;
        this.armies = armies;
    }

    public Battleground getBattleground() {
        return battleground;
    }

    public List<Army> getArmies() {
        return armies;
    }

}
