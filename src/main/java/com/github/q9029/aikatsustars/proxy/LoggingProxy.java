package com.github.q9029.aikatsustars.proxy;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.springframework.stereotype.Component;

/**
 * ロギングプロキシクラス.
 * @author q9029
 */
@Component
public class LoggingProxy {

    /**
     * ロガー.
     */
    private static final Logger LOG = Logger.getLogger(LoggingProxy.class);

    /**
     * メソッドの開始ログを出力します.
     * @param joinPoint
     */
    public void logBeforeMethod(JoinPoint joinPoint) {
        if (LOG.isInfoEnabled()) {
            String cName = joinPoint.getTarget().getClass().getSimpleName();
            String mName = joinPoint.getSignature().getName();
            LOG.info("Start " + cName + "." + mName + "()");
        }
    }

    /**
     * メソッドの終了ログを出力します.
     * @param joinPoint
     */
    public void logAfterMethod(JoinPoint joinPoint) {
        if (LOG.isInfoEnabled()) {
            String cName = joinPoint.getTarget().getClass().getSimpleName();
            String mName = joinPoint.getSignature().getName();
            LOG.info("End " + cName + "." + mName + "()");
        }
    }
}
