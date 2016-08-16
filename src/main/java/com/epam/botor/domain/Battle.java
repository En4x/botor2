package com.epam.botor.domain;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Battle {
	Logger LOGGER = LoggerFactory.getLogger(Battle.class);
	
    private final Battleground battleground;
    private final Map<String, Army> armies;

    public Battle(final Battleground battleground, final Map<String, Army> armies) {
        super();
        this.battleground = battleground;
        this.armies = armies;
    }

    public Battleground getBattleground() {
        return battleground;
    }

    public Map<String, Army> getArmies() {
        return armies;
    }
    
    public void battle() {
    	//TODO: implement
    	LOGGER.debug("" + armies);
    }

}
