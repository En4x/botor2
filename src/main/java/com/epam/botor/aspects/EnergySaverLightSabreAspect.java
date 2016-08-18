package com.epam.botor.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.epam.botor.domain.LightSabre;

@Aspect
@Component
public class EnergySaverLightSabreAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(EnergySaverLightSabreAspect.class);

    @Before("lightSabreInUse()")
    public void switchOnBefore(final JoinPoint joinPoint) {

        LightSabre targetLightSabre = (LightSabre) joinPoint.getTarget();

        targetLightSabre.setSwitchedOn(true);

    }

    @AfterReturning(
            pointcut = "lightSabreInUse()",
            returning = "returnValue")
    public void switchOffAfter(final JoinPoint joinPoint, final String returnValue) {

        LightSabre targetLightSabre = (LightSabre) joinPoint.getTarget();

        LOGGER.warn("Returned value: " + returnValue);

        targetLightSabre.setSwitchedOn(false);

    }

    @Pointcut("execution (* com.epam.botor.domain.LightSabre.shoot())")
    private void lightSabreInUse() {

    }

}
