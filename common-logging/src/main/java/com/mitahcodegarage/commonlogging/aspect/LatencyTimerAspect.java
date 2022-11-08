package com.mitahcodegarage.commonlogging.aspect;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.CodeSignature;

public class LatencyTimerAspect {
    private static final Logger logger = LogManager.getLogger();

    public Object latencyLogger(ProceedingJoinPoint joinPoint) throws Throwable {

        long startTime = System.currentTimeMillis();
        Object response = joinPoint.proceed();
        long endTime = System.currentTimeMillis();
        logger.trace("Execution time taken by the method: [{}] = [{} ms]", getSimpleClassName(joinPoint), endTime - startTime);

        return response;
    }

    private String getSimpleClassName(ProceedingJoinPoint joinPoint) {
        CodeSignature codeSignature = (CodeSignature) joinPoint.getSignature();

        String[] packageNames = codeSignature.getDeclaringTypeName().split("[.]");
        int size = packageNames.length;
        return packageNames[size-2] + "." + packageNames[size-1] + "." + codeSignature.getName();
    }
}
