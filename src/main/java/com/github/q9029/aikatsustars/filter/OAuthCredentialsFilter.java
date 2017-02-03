package com.github.q9029.aikatsustars.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.github.q9029.aikatsustars.controller.constant.ControllerConst;

import twitter4j.Twitter;
import twitter4j.TwitterException;

public class OAuthCredentialsFilter implements Filter {

    /**
     * ロガー.
     */
    private static final Logger LOG = Logger.getLogger(OAuthCredentialsFilter.class);

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpSession session = null;

        try {
            // HttpSessionの取得
            session = ((HttpServletRequest) request).getSession();

            // OAuth有効性確認
            Twitter twitter = (Twitter) session.getAttribute(ControllerConst.Session.TWITTER);
            twitter.verifyCredentials();

            // 処理を継続
            chain.doFilter(request, response);

        } catch (TwitterException e) {
            LOG.error("Invalid OAuth access token.", e);

            // セッションの破棄
            if (session != null) {
                session.invalidate();
            }

            // signinへリダイレクト
            ((HttpServletResponse) response).sendRedirect(ControllerConst.Uri.SIGNIN);

        } catch (Exception e) {
            LOG.error("Invalid session.", e);

            // セッションの破棄
            if (session != null) {
                session.invalidate();
            }

            // signinへリダイレクト
            ((HttpServletResponse) response).sendRedirect(ControllerConst.Uri.SIGNIN);
        }
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // do nothing
    }

    @Override
    public void destroy() {
        // do nothing
    }
}
