package com.github.q9029.starstrade.listener;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.apache.log4j.Logger;

public class SystemHttpSessionListener implements HttpSessionListener {

	private static final Logger LOG = Logger.getLogger(SystemHttpSessionListener.class);

	@Override
	public void sessionCreated(HttpSessionEvent event) {
		HttpSession session = event.getSession();
		if (session != null) {
			LOG.info("Session is created. id=" + session.getId());
		} else {
			LOG.info("Session is created. id=null");
		}
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent event) {
		HttpSession session = event.getSession();
		if (session != null) {
			LOG.info("Session is destroyed. id=" + session.getId());
		} else {
			LOG.info("Session is destroyed. id=null");
		}
	}
}
