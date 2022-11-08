package com.mitahcodegarage.commonlogging.aspect;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.reflect.CodeSignature;

public class MethodExitAspect {
    private Logger logger = LogManager.getLogger();

    public void traceLogger(JoinPoint joinPoint) throws Throwable {
        CodeSignature codeSignature = (CodeSignature) joinPoint.getSignature();
        logger.trace("Method Exit : [{}]", codeSignature.getName());
    }
}
