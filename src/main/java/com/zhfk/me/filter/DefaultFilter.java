package com.zhfk.me.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(
        filterName = "defaultFilter",
        urlPatterns = "/*"
)
public class DefaultFilter implements Filter {
    Logger logger = LoggerFactory.getLogger(DefaultFilter.class);
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        logger.info("DefaultFilter ----> init filter config:"+filterConfig);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        logger.info("DefaultFilter ----> doFilter");
        chain.doFilter(request,response);
    }

    @Override
    public void destroy() {
        System.out.println("DefaultFilter ----> destroy Filter");
    }
}
