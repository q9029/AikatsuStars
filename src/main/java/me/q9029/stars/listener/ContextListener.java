package me.q9029.stars.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

/**
 * コンテキストリスナ.
 * 命名悩み...
 * @author Queue
 */
public class ContextListener implements ServletContextListener {

	private static final Logger logger = Logger.getLogger(ContextListener.class);

	@Override
	public void contextDestroyed(ServletContextEvent event) {
		logger.info("LogManager shutdown.");
		LogManager.shutdown();
	}

	@Override
	public void contextInitialized(ServletContextEvent event) {
		// do nothing.
	}
}
