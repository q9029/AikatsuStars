package com.github.q9029.starstrade.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.github.q9029.starstrade.controller.constant.RequestKey;
import com.github.q9029.starstrade.controller.constant.RequestUri;
import com.github.q9029.starstrade.controller.constant.SessionKey;
import com.github.q9029.starstrade.repository.dto.AccountDto;
import com.github.q9029.starstrade.service.TwitterService;
import com.github.q9029.starstrade.util.ApplicationContextUtil;

public class OAuthCredentialsFilter implements Filter {

	private static final Logger LOG = Logger.getLogger(OAuthCredentialsFilter.class);

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = null;
		try {
			session = req.getSession();
			AccountDto account = (AccountDto) session.getAttribute(SessionKey.ACCOUNT);
			TwitterService service = ApplicationContextUtil.getComponent(TwitterService.class);
			service.verify(account);
			chain.doFilter(req, response);
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
			if (session != null) {
				session.invalidate();
			}
			req.setAttribute(RequestKey.Attribute.REDIRECT_URI, req.getContextPath());
			RequestDispatcher dispatcher = req.getRequestDispatcher(RequestUri.SIGNIN);
			dispatcher.forward(req, response);
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
