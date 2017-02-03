package com.github.q9029.aikatsustars.proxy;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.springframework.stereotype.Component;

@Component
public class LoggerProxy {

    private static final Logger LOG = Logger.getLogger(LoggerProxy.class);

    public void beforeMethod(JoinPoint joinPoint) {
        if (LOG.isTraceEnabled()) {
            String cName = joinPoint.getTarget().getClass().getSimpleName();
            String mName = joinPoint.getSignature().getName();
            LOG.trace("Start " + cName + "." + mName + "()");
        }
    }

    public void afterMethod(JoinPoint joinPoint) {
        if (LOG.isTraceEnabled()) {
            String cName = joinPoint.getTarget().getClass().getSimpleName();
            String mName = joinPoint.getSignature().getName();
            LOG.trace("End " + cName + "." + mName + "()");
        }
    }
}
