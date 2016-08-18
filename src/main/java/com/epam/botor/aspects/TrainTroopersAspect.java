package com.epam.botor.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.DeclareParents;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.epam.botor.App;
import com.epam.botor.domain.DefaultForceUser;
import com.epam.botor.domain.ForceSide;
import com.epam.botor.domain.ForceUser;

@Aspect
@Component
public class TrainTroopersAspect {
	private static final Logger LOGGER = LoggerFactory.getLogger(TrainTroopersAspect.class);
	
    @DeclareParents(
            value = "com.epam.botor.domain.Trooper",
            defaultImpl = DefaultForceUser.class)
    private static ForceUser forceUserTrooper;

    //we can not catch com.epam.botor.domain.Trooper.getAlliance, since it does not have it at evaluation time,
    //toString is called before getAlliance so it may work, but it is an unreliable solution 
    @Before("execution (* com.epam.botor.domain.Trooper.toString()) && this(forceUser)")
    public void trainSoldierBadly(final JoinPoint jp, final ForceUser forceUser) {

        LOGGER.debug(jp.getSignature().toString() + "!");

        forceUser.setAlliance(ForceSide.getRandomSide());

    }

}
