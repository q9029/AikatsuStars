package me.q9029.stars.listener;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.apache.log4j.Logger;

/**
 * セッションリスナ.
 * 命名悩み...
 * @author Queue
 */
public class SessionListener implements HttpSessionListener {

	private static final Logger logger = Logger.getLogger(SessionListener.class);

	@Override
	public void sessionCreated(HttpSessionEvent event) {
		HttpSession session = event.getSession();
		if (session != null) {
			logger.info("Session is created. id=" + session.getId());
		} else {
			logger.info("Session is created. id=null");
		}
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent event) {
		HttpSession session = event.getSession();
		if (session != null) {
			logger.info("Session is destroyed. id=" + session.getId());
		} else {
			logger.info("Session is destroyed. id=null");
		}
	}
}
