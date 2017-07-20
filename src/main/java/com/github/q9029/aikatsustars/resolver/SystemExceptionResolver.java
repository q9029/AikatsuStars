package com.github.q9029.aikatsustars.resolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import com.github.q9029.aikatsustars.controller.CallbackController;
import com.github.q9029.aikatsustars.controller.constant.View;

@Component
public class SystemExceptionResolver implements HandlerExceptionResolver {

	private static final Logger LOG = Logger.getLogger(CallbackController.class);

	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {

		LOG.error(ex.getMessage(), ex);

		HttpSession session = request.getSession();
		if (session != null) {
			session.invalidate();
		}

		ModelAndView modelAndView = new ModelAndView(View.ERROR);
		modelAndView.setStatus(HttpStatus.NOT_FOUND);
		return modelAndView;
	}
}
