package com.epam.botor.domain;

import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component("starWarsBattle")
public class Battle {
	Logger LOGGER = LoggerFactory.getLogger(Battle.class);

	@Resource(name = "dryBattleground")
    private Battleground battleground;

	@Resource(name = "armiesOfBattle")
    private Map<String, Army> armies;


    public Battleground getBattleground() {
        return battleground;
    }

    public Map<String, Army> getArmies() {
        return armies;
    }
    
    public void battle() {
    	//TODO: implement
    	LOGGER.debug(toString());
    }

	@Override
	public String toString() {
		return "Battle [battleground=" + battleground + ", armies=" + armies + "]";
	}

    
}
