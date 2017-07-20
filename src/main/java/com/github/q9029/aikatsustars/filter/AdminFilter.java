package com.github.q9029.aikatsustars.filter;

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

import com.github.q9029.aikatsustars.controller.constant.RequestURI;
import com.github.q9029.aikatsustars.controller.constant.SessionKey;
import com.github.q9029.aikatsustars.repository.dto.AccountDto;

public class AdminFilter implements Filter {

	private static final Logger LOG = Logger.getLogger(AdminFilter.class);

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		HttpSession session = null;
		try {
			HttpServletRequest req = (HttpServletRequest) request;
			session = req.getSession();
			String requestUri = req.getRequestURI();
			AccountDto dto = (AccountDto) session.getAttribute(SessionKey.ACCOUNT);
			if (!RequestURI.Job.HEALTHCHECK.equals(requestUri) && !Boolean.TRUE.equals(dto.getAdministrative())) {
				RequestDispatcher dispatcher = request.getRequestDispatcher("/error");
				dispatcher.forward(request, response);
			} else {
				chain.doFilter(request, response);
			}
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
			if (session != null) {
				session.invalidate();
			}
			RequestDispatcher dispatcher = request.getRequestDispatcher(RequestURI.ERROR);
			dispatcher.forward(request, response);
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
