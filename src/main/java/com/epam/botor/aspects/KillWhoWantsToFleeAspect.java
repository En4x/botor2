package com.epam.botor.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.epam.botor.domain.IDoNotWantToFightException;
import com.epam.botor.domain.Person;

@Aspect
@Component
public class KillWhoWantsToFleeAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(KillWhoWantsToFleeAspect.class);

    @AfterThrowing(
            pointcut = "execution (String com.epam.botor.domain.Person.fight())",
            throwing = "exception")
    public void killWhoWantsToFlee(final JoinPoint joinPoint, final IDoNotWantToFightException exception) {

        Person targetPerson = (Person) joinPoint.getTarget();

        LOGGER.warn(targetPerson.getName() + " (Dog tag: " + targetPerson.getDogTagID() + ") is fleeing! Kill him!");

    }

}
