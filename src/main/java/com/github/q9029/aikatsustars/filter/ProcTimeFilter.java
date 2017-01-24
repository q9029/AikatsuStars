package com.github.q9029.aikatsustars.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.log4j.Logger;

public class ProcTimeFilter implements Filter {

    /**
     * ロガー.
     */
    private static final Logger LOG = Logger.getLogger(ProcTimeFilter.class);

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        // 処理開始時刻の取得
        long startTime = System.nanoTime();

        // 処理を継続
        chain.doFilter(request, response);

        // 処理終了時刻の取得
        long endTime = System.nanoTime();

        // ログ出力
        LOG.info("ProcessTime : " + (endTime - startTime) + " ns");
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
