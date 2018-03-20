package de.myDom.aspect;

import de.myDom.annotation.LogExecutionTime;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ExampleAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExampleAspect.class);

//    @Around(value = "@annotation(de.myDom.annotation.LogExecutionTime)")
    @Around("execution(@de.myDom.annotation.LogExecutionTime * *(..)) && @annotation(logExecutionTime)")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint, LogExecutionTime logExecutionTime) throws Throwable {
        Object proceed = null;

        int i = 0;
        while(i < logExecutionTime.repeat()) {
            final long start = System.currentTimeMillis();

            proceed = joinPoint.proceed();
            i++;

            final long executionTime = System.currentTimeMillis() - start;

            LOGGER.info(joinPoint.getSignature() + " executed in " + executionTime + "ms");
        }

        return proceed;
    }

}
