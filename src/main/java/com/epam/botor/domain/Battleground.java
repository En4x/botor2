package com.epam.botor.domain;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("dryBattleground")
public class Battleground {

    private final String name;
    private BattlegroundType type;

    public Battleground(@Value("dry battle ground") final String name, @Value("DRY") final BattlegroundType type) {
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
