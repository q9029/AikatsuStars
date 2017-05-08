package com.github.q9029.aikatsustars.proxy;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Component;

/**
 * 処理時間ロギングプロキシ.
 * @author q9029
 */
@Component
public class ProcTimeProxy {

    /**
     * ロガー.
     */
    private static final Logger LOG = Logger.getLogger(ProcTimeProxy.class);

    /**
     * メソッドの処理時間をロギングします.
     * @param joinPoint
     * @return
     * @throws Throwable
     */
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {

        // 処理開始時刻の取得
        long startTime = System.nanoTime();

        try {
            // 処理を継続
            Object obj = joinPoint.proceed();

            // 戻り値を返却
            return obj;

        } finally {
            // 処理終了時刻の取得
            long procTime = TimeUnit.MILLISECONDS.convert(System.nanoTime() - startTime, TimeUnit.NANOSECONDS);

            // ログ出力
            LOG.info(new StringBuilder().append("処理時間 ").append(procTime).append("ms"));
        }
    }
}
