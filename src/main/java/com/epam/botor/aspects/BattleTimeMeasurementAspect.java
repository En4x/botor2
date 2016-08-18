package com.epam.botor.aspects;

import java.util.Date;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class BattleTimeMeasurementAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(BattleTimeMeasurementAspect.class);

    @Around("battlePlays()")
    public Object measureBattleTime(final ProceedingJoinPoint joinPoint) throws Throwable {

        long startedNanoTime = System.nanoTime();

        LOGGER.warn("BATTLE STARTED: " + new Date());

        Object result = joinPoint.proceed();

        LOGGER.warn("BATTLE ENDED: " + new Date());
        LOGGER.warn("BATTLE LASTED (sec): " + (System.nanoTime() - startedNanoTime) / 1000000000.0);

        return result;

    }

    @Pointcut("execution (* com.epam.botor.domain.Battle.battle())")
    private void battlePlays() {

    }

}
