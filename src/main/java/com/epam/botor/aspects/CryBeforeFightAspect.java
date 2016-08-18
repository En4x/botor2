package com.epam.botor.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.epam.botor.domain.LoudNess;
import com.epam.botor.domain.Person;

@Aspect
@Component
public class CryBeforeFightAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(CryBeforeFightAspect.class);

    @Before(value = "execution (String com.epam.botor.domain.Person.fight()) && this(person)",
    		argNames = "person")
    public void cryBefore(final Person proxyPerson) {

        LOGGER.warn(proxyPerson.getName() + ": " + proxyPerson.battleCry(LoudNess.getRandom()));

    }

}
