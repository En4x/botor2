package com.epam.botor.domain;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;

public class Battle {
	Logger LOGGER = LoggerFactory.getLogger(Battle.class);

//	@Autowired
//	@Qualifier("defaultBattleGround")
	@Value("#{@dryBattleground}")
    private Battleground battleground;

	@Autowired
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
