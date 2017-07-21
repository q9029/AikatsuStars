package com.github.q9029.stars_trade.proxy;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.springframework.stereotype.Component;

@Component
public class LoggingProxy {

	private static final Logger LOG = Logger.getLogger(LoggingProxy.class);

	public void before(JoinPoint joinPoint) {
		String className = joinPoint.getTarget().getClass().getSimpleName();
		String methodName = joinPoint.getSignature().getName();
		LOG.info(new StringBuilder().append("開始 ").append(className).append('#').append(methodName));
	}

	public void after(JoinPoint joinPoint) {
		String className = joinPoint.getTarget().getClass().getSimpleName();
		String methodName = joinPoint.getSignature().getName();
		LOG.info(new StringBuilder().append("終了 ").append(className).append('#').append(methodName));
	}
}
