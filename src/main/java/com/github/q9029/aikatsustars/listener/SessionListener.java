package com.github.q9029.aikatsustars.listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.apache.log4j.Logger;

public class SessionListener implements HttpSessionListener {

    /**
     * ロガー.
     */
    private static final Logger LOG = Logger.getLogger(SessionListener.class);

    @Override
    public void sessionCreated(HttpSessionEvent event) {
        LOG.debug("session created");
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent event) {
        LOG.debug("session destroyed");
        throw new RuntimeException();
    }
}
