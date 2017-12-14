package com.github.q9029.starstrade.proxy;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.springframework.stereotype.Component;

@Component
public class LoggingProxy {

	private static final Logger logger = Logger.getLogger(LoggingProxy.class);

	public void before(JoinPoint joinPoint) {
		// TRACEレベルが出力可能か
		if (logger.isTraceEnabled()) {

			// クラス名、メソッド名の取得
			String className = joinPoint.getTarget().getClass().getSimpleName();
			String methodName = joinPoint.getSignature().getName();

			// ログ出力メッセージの作成
			String message = new StringBuilder()
					.append("開始 ").append(className).append('#').append(methodName).toString();

			// ログ出力
			logger.trace(message);
		}
	}

	public void after(JoinPoint joinPoint) {
		// TRACEレベルが出力可能か
		if (logger.isTraceEnabled()) {

			// クラス名、メソッド名の取得
			String className = joinPoint.getTarget().getClass().getSimpleName();
			String methodName = joinPoint.getSignature().getName();

			// ログ出力メッセージの作成
			String message = new StringBuilder()
					.append("終了 ").append(className).append('#').append(methodName).toString();

			// ログ出力
			logger.trace(message);
		}
	}
}
