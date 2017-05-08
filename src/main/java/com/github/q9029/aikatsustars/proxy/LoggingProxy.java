package com.github.q9029.aikatsustars.proxy;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.springframework.stereotype.Component;

/**
 * 開始終了ロギングプロキシ.
 * @author q9029
 */
@Component
public class LoggingProxy {

    /**
     * ロガー.
     */
    private static final Logger LOG = Logger.getLogger(LoggingProxy.class);

    /**
     * メソッドの開始をロギングします.
     * @param joinPoint
     */
    public void before(JoinPoint joinPoint) {
        if (LOG.isInfoEnabled()) {
            // クラス名、メソッド名の取得
            String className = joinPoint.getTarget().getClass().getSimpleName();
            String methodName = joinPoint.getSignature().getName();

            // ログ出力
            LOG.info(new StringBuilder().append("開始 クラス：").append(className).append(" メソッド：").append(methodName));
        }
    }

    /**
     * メソッドの終了をロギングします.
     * @param joinPoint
     */
    public void after(JoinPoint joinPoint) {
        if (LOG.isInfoEnabled()) {
            // クラス名、メソッド名の取得
            String className = joinPoint.getTarget().getClass().getSimpleName();
            String methodName = joinPoint.getSignature().getName();

            // ログ出力
            LOG.info(new StringBuilder().append("終了 クラス：").append(className).append(" メソッド：").append(methodName));
        }
    }
}
