package com.epam.botor.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.epam.botor.domain.Person;

@Aspect
@Component
public class CryBeforeFightAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(CryBeforeFightAspect.class);

    @Before("execution (String com.epam.botor.domain.Person.fight())")
    public void cryBefore(final JoinPoint joinPoint) {

        Person targetPerson = (Person) joinPoint.getTarget();

        LOGGER.warn(targetPerson.getName() + ": " + targetPerson.battleCry());

    }

}
