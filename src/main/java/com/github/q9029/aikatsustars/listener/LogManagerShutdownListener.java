package com.github.q9029.aikatsustars.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

/**
 * シャットダウンリスナー.
 * @author q9029
 */
public class LogManagerShutdownListener implements ServletContextListener {

    /**
     * Logger.
     */
    private static final Logger LOG = Logger.getLogger(LogManagerShutdownListener.class);

    @Override
    public void contextDestroyed(ServletContextEvent event) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("ログマネージャをシャットダウンします。");
        }

        // ログマネージャのシャットダウン
        LogManager.shutdown();
    }

    @Override
    public void contextInitialized(ServletContextEvent event) {
        // do nothing.
    }
}
