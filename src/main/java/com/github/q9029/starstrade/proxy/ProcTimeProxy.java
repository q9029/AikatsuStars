package com.github.q9029.starstrade.proxy;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Component;

@Component
public class ProcTimeProxy {

	private static final Logger LOG = Logger.getLogger(ProcTimeProxy.class);

	public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
		long startTime = System.nanoTime();
		try {
			return joinPoint.proceed();
		} finally {
			long procTime = TimeUnit.MILLISECONDS.convert(System.nanoTime() - startTime, TimeUnit.NANOSECONDS);
			LOG.info(new StringBuilder().append("処理時間 ").append(procTime).append("ms"));
		}
	}
}
