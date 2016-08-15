package com.epam.botor.domain;

public class Battleground {

    private final String name;
    private BattlegroundType type = BattlegroundType.DRY;

    public Battleground(final String name, final BattlegroundType type) {
        super();
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public BattlegroundType getType() {
        return type;
    }

    public void setType(final BattlegroundType type) {
        this.type = type;
    }

}
