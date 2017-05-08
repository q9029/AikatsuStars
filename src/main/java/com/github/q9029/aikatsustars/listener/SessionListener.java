package com.github.q9029.aikatsustars.listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.apache.log4j.Logger;

/**
 * セッションリスナー.
 * @author q9029
 */
public class SessionListener implements HttpSessionListener {

    /**
     * ロガー.
     */
    private static final Logger LOG = Logger.getLogger(SessionListener.class);

    @Override
    public void sessionCreated(HttpSessionEvent event) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("セッションが生成されました。");
        }
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent event) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("セッションが破棄されました。");
        }
    }
}
