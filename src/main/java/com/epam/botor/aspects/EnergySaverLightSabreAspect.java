package com.epam.botor.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.epam.botor.domain.LightSabre;

@Aspect
@Component
public class EnergySaverLightSabreAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(EnergySaverLightSabreAspect.class);


    
    @Before("lightSabreInUse()")
    @Order(200)
    public void switchOnBefore(final JoinPoint joinPoint) {

        LightSabre targetLightSabre = (LightSabre) joinPoint.getTarget();

        LOGGER.warn("1 Switching on " + targetLightSabre.getName());
        LOGGER.warn(joinPoint.getTarget().getClass().getName());
        LOGGER.warn(joinPoint.getThis().getClass().getName());

        targetLightSabre.setSwitchedOn(true);

    }

    @Before("com.epam.botor.aspects.EnergySaverLightSabreAspect.lightSabreInUse()")
    @Order(100)
    public void testSwitchedOnBefore(final JoinPoint joinPoint) {

        LightSabre targetLightSabre = (LightSabre) joinPoint.getTarget();
        LOGGER.warn(joinPoint.getTarget().getClass().getName());
        LOGGER.warn(joinPoint.getThis().getClass().getName());
        LOGGER.warn("2 Switched on before use: " + targetLightSabre.isSwitchedOn());

    }
    
    @After("lightSabreInUse()")
    @Order(100)
    public void switchOffAfter(final JoinPoint joinPoint) {

        LightSabre targetLightSabre = (LightSabre) joinPoint.getTarget();

        LOGGER.warn("Switching off " + targetLightSabre.getName());

        targetLightSabre.setSwitchedOn(false);

    }

    @Pointcut("execution (String com.epam.botor.domain.LightSabre.shoot())")
    protected void lightSabreInUse() {

    }

}
