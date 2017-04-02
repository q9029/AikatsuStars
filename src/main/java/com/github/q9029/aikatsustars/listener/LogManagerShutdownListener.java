package com.github.q9029.aikatsustars.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class LogManagerShutdownListener implements ServletContextListener {

    /**
     * Logger.
     */
    private static final Logger LOG = Logger.getLogger(LogManagerShutdownListener.class);

    @Override
    public void contextDestroyed(ServletContextEvent event) {
        // write buffered logs.
        LOG.debug("shutdown LogManager");
        LogManager.shutdown();
    }

    @Override
    public void contextInitialized(ServletContextEvent event) {
        // do nothing.
    }
}
