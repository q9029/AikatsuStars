package com.github.q9029.aikatsustars.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.github.q9029.aikatsustars.controller.constant.RequestURI;
import com.github.q9029.aikatsustars.controller.constant.SessionKey;

import twitter4j.Twitter;

public class OAuthCredentialsFilter implements Filter {

	private static final Logger LOG = Logger.getLogger(OAuthCredentialsFilter.class);

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		HttpSession session = null;
		try {
			session = ((HttpServletRequest) request).getSession();
			Twitter twitter = (Twitter) session.getAttribute(SessionKey.ACCOUNT);
			twitter.verifyCredentials();
			chain.doFilter(request, response);
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
			if (session != null) {
				session.invalidate();
			}
			((HttpServletResponse) response).sendRedirect(RequestURI.INDEX);
		}
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
