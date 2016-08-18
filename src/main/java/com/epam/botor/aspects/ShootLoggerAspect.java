package com.epam.botor.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ShootLoggerAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(ShootLoggerAspect.class);

    @Before("execution (* com.epam.botor.domain.LightSabre.shoot(..))")
    public void logShooting(final JoinPoint joinPoint) {

        String targetObjectClassName = joinPoint.getTarget().getClass().getSimpleName();

        LOGGER.debug(targetObjectClassName + " is shooting!");

    }

}
