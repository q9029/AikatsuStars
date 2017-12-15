package me.q9029.stars.filter;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.log4j.Logger;

/**
 * 応答時間ロギングフィルタ.
 * @author Queue
 */
public class RespTimeLoggingFilter implements Filter {

	private static final Logger logger = Logger.getLogger(RespTimeLoggingFilter.class);

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {

		// 開始時間取得
		long startTime = System.nanoTime();

		// 処理実施
		chain.doFilter(req, resp);

		// 処理時間計算
		long procTime = TimeUnit.MILLISECONDS.convert(System.nanoTime() - startTime, TimeUnit.NANOSECONDS);

		// ログ出力
		String message = new StringBuilder().append("応答時間 ").append(procTime).append("ms").toString();
		logger.info(message);
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// do nothing.
	}

	@Override
	public void destroy() {
		// do nothing.
	}
}
