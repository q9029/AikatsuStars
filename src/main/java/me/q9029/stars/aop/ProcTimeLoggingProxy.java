package me.q9029.stars.aop;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Component;

/**
 * 処理時間ロギングプロキシ.
 * @author Queue
 */
@Component
public class ProcTimeLoggingProxy {

	private static final Logger logger = Logger.getLogger(ProcTimeLoggingProxy.class);

	public Object adviceAround(ProceedingJoinPoint joinPoint) throws Throwable {
		// 開始時間取得
		long startTime = System.nanoTime();
		try {
			// 処理実施
			return joinPoint.proceed();

		} finally {
			// 処理時間計算
			long procTime = TimeUnit.MILLISECONDS.convert(System.nanoTime() - startTime, TimeUnit.NANOSECONDS);

			// ログ出力
			String message = new StringBuilder().append("処理時間 ").append(procTime).append("ms").toString();
			logger.info(message);
		}
	}
}
