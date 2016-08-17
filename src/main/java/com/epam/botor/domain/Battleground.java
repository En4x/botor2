package com.epam.botor.domain;

import org.springframework.beans.factory.annotation.Value;

public class Battleground {

	@Value("${battleground.default.name}")
    private final String name;
    private BattlegroundType type;

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

	@Override
	public String toString() {
		return "Battleground [name=" + name + ", type=" + type + "]";
	}

    
}
