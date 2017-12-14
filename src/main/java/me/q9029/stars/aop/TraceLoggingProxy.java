package me.q9029.stars.aop;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.springframework.stereotype.Component;

/**
 * トレースログ出力プロキシ.
 * @author Queue
 */
@Component
public class TraceLoggingProxy {

	private static final Logger logger = Logger.getLogger(TraceLoggingProxy.class);

	/**
	 * 開始ログ出力.
	 * @param joinPoint
	 */
	public void adviceBefore(JoinPoint joinPoint) {
		log(joinPoint, "開始");
	}

	/**
	 * 終了ログ出力.
	 * @param joinPoint
	 */
	public void adviceAfter(JoinPoint joinPoint) {
		log(joinPoint, "終了");
	}

	/**
	 * 正常終了ログ出力.
	 * @param joinPoint
	 */
	public void adviceAfterReturning(JoinPoint joinPoint) {
		log(joinPoint, "正常終了");
	}

	/**
	 * 例外終了ログ出力.
	 * @param joinPoint
	 */
	public void adviceAfterThrowing(JoinPoint joinPoint) {
		log(joinPoint, "例外終了");
	}

	private void log(JoinPoint joinPoint, String message) {
		// TRACEレベルが出力可能か
		if (logger.isTraceEnabled()) {

			// クラス名、メソッド名の取得
			String className = joinPoint.getTarget().getClass().getSimpleName();
			String methodName = joinPoint.getSignature().getName();

			// ログ出力メッセージの作成
			String log = new StringBuilder()
					.append(message).append(' ').append(className).append('#').append(methodName).toString();

			// ログ出力
			logger.trace(log);
		}
	}
}
