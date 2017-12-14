package me.q9029.stars.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * OAuthログインチェックフィルタ.
 * @author Queue
 */
public class OAuthCredentialsFilter implements Filter {

//	private static final Logger logger = Logger.getLogger(OAuthCredentialsFilter.class);

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
		// TODO 実装
		chain.doFilter(req, resp);
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
