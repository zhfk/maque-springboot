package com.zhfk.me.config;

import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * DruidMonitorConfigurer 与 注解配置方式选择一个即可
 */
@Configuration
public class DruidMonitorConfigurer {
    /**
     * 注册 ServletRegistrationBean
     * @return
     */
    @Bean
    public ServletRegistrationBean<StatViewServlet> servletRegistrationBean(){
        ServletRegistrationBean<StatViewServlet> bean = new ServletRegistrationBean<>(new StatViewServlet(),"/druid/*");
        bean.addInitParameter("allow","0.0.0.0");
        bean.addInitParameter("loginUsername","admin");
        bean.addInitParameter("loginPassword","admin");
        bean.addInitParameter("resetEnable","false");
        return bean;
    }

    /**
     * 注册 FilterRegistrationBean
     */
    @Bean
    public FilterRegistrationBean<WebStatFilter> filterRegistrationBean(){
        FilterRegistrationBean<WebStatFilter> bean = new FilterRegistrationBean<>(new WebStatFilter());
        bean.addUrlPatterns("/*");
        bean.addInitParameter("exclusions","*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
        return bean;
    }
}
