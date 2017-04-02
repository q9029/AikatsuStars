package com.github.q9029.aikatsustars.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class CheckAdminFollow implements Filter {

    private static List<Long> ADMIN_LIST;

    @Override
    public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
            throws IOException, ServletException {


    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        ADMIN_LIST = new ArrayList<Long>();
        // q9029
        ADMIN_LIST.add(2434248589L);
    }

    @Override
    public void destroy() {
        // do nothing
    }
}
