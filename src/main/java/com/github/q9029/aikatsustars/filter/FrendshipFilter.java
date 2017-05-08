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

import com.github.q9029.aikatsustars.controller.constant.RequestURI;
import com.github.q9029.aikatsustars.controller.constant.SessionKey;

import twitter4j.Friendship;
import twitter4j.ResponseList;
import twitter4j.Twitter;

public class FrendshipFilter implements Filter {

    /**
     * ロガー.
     */
    private static final Logger LOG = Logger.getLogger(FrendshipFilter.class);

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpSession session = null;

        try {
            HttpServletRequest req = (HttpServletRequest) request;
            session = req.getSession();
            Twitter twitter = (Twitter) session.getAttribute(SessionKey.ACCOUNT);
            ResponseList<Friendship> ids = twitter.lookupFriendships(2434248589L);
            LOG.info("FollowedBy:" + ids.get(0).isFollowedBy() + ";Following:" + ids.get(0).isFollowing());

            // 処理を継続
            chain.doFilter(request, response);

        } catch (Exception e) {
            LOG.error("Invalid OAuth access token.", e);

            // セッションの破棄
            if (session != null) {
                session.invalidate();
            }

            // signinへリダイレクト
            ((HttpServletResponse) response).sendRedirect(RequestURI.SIGNIN);
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
