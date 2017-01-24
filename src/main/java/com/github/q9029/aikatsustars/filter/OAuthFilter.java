package com.github.q9029.aikatsustars.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class OAuthFilter implements Filter {

//    /**
//     * ロガー.
//     */
//    private static final Logger LOG = Logger.getLogger(OAuthFilter.class);

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

//        // セッション
//        HttpSession session = null;
//
//        try {
//            LOG.debug("start doFilter");
//
//            // セッションの取得
//            session = ((HttpServletRequest) request).getSession();
//
//            // セッションにTwitterインスタンスが存在する場合
//            if (session.getAttribute(ControllerConst.Session.TWITTER) != null) {
//
//                // セッションにリクエストトークンが存在しない場合
//                if (session.getAttribute(ControllerConst.Session.TWITTER_REQUEST_TOKEN) == null) {
//
//                    // Twitterインスタンスを取得する
//                    Twitter twitter = (Twitter) session.getAttribute(ControllerConst.Session.TWITTER);
//
//                    // 有効性確認
//                    twitter.verifyCredentials();
//                }
//            }

            // CookieからOAuthTokenの取得
            // if () {
            // Twitterの新規インスタンスを取得する。
            // Twitter twitter = new TwitterFactory().getInstance();
            // CookieからAccessTokenの取得
            // twitter.setOAuthAccessToken(new AccessToken(null, null));
            // 有効性確認
            // twitter.verifyCredentials();
            // セッションにTwitterのインスタンスを登録する。
            // request.getSession().setAttribute(ServletConst.Session.TWITTER,
            // twitter);
            // }

            // 処理を継続
            chain.doFilter(request, response);

//        } catch (Exception e) {
//            // ((HttpServletResponse) response).sendError(503);
//
//            LOG.info("Invalid or expired token.");
//            LOG.trace("", e);
//
//            // セッションがNULLでない場合
//            if (session != null) {
//                // セッションを破棄する
//                session.invalidate();
//            }
//
//            // リダイレクトする
//            ((HttpServletResponse) response).sendRedirect("/");
//
//        } catch (Error e) {
//            ((HttpServletResponse) response).sendError(503);
//            LOG.fatal("", e);
//        }
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
