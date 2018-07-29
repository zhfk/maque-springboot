package com.zhfk.me.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 自定义拦截器
 */
public class DefaultInterceptor implements HandlerInterceptor {
    Logger logger = LoggerFactory.getLogger(DefaultInterceptor.class);
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        logger.info("DefaultInterceptor 请求处理之前进行调用------> preHandle:"+handler);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        logger.info("DefaultInterceptor 请求处理之后进行调用，但是在视图被渲染之前------> postHandle:"+handler);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        logger.info("DefaultInterceptor 渲染了对应的视图之后------> afterCompletion:"+handler);
    }
}
