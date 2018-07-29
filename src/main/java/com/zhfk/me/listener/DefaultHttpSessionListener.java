package com.zhfk.me.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class DefaultHttpSessionListener implements HttpSessionListener {
    Logger logger = LoggerFactory.getLogger(DefaultHttpSessionListener.class);
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        logger.info("DefaultHttpSessionListener ----> sessionCreated:"+se);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        logger.info("DefaultHttpSessionListener ----> sessionDestroyed:"+se);
    }
}
