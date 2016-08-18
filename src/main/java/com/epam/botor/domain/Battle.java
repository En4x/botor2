package com.epam.botor.domain;

import java.util.Locale;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

@Component("starWarsBattle")
public class Battle {
	private final static Logger LOGGER = LoggerFactory.getLogger(Battle.class);
	
	@Autowired
	private MessageSource messageSource;
	
	@Autowired
	private Locale locale;

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
    	long start = System.currentTimeMillis();
    	LOGGER.debug("BATTLE STARTED");
    	
    	LOGGER.debug(messageSource.getMessage("battle.start.message", new Object[] { battleground.getName() }, locale));
    	
    	for (String armyName : armies.keySet()) {
    		Army army = armies.get(armyName);
    		LOGGER.debug("Battle with " + armyName);
    		LOGGER.debug("Leader: " + army.getLeader().getName());
    		for (Person person : army.getFighters()) {
    			LOGGER.debug(person.getName() + ": " + person.fight());
    		}
    	}
    	LOGGER.debug("BATTLE ENDED");
    	LOGGER.debug("BATTLE LENGTH = " + (System.currentTimeMillis() - start));
    	
    }

	@Override
	public String toString() {
		return "Battle [battleground=" + battleground + ", armies=" + armies + "]";
	}

    
}
