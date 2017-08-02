package com.github.q9029.starstrade.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class SystemServletContextListener implements ServletContextListener {

	private static final Logger LOG = Logger.getLogger(SystemServletContextListener.class);

	@Override
	public void contextDestroyed(ServletContextEvent event) {
		LOG.info("LogManager shutdown.");
		LogManager.shutdown();
	}

	@Override
	public void contextInitialized(ServletContextEvent event) {
		// do nothing.
	}
}
