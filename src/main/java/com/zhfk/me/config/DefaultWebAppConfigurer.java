package com.zhfk.me.config;

import com.zhfk.me.interceptor.DefaultInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class DefaultWebAppConfigurer implements WebMvcConfigurer {
    // 多个拦截器组成一个拦截器链
    // addPathPatterns 用于添加拦截规则
    // excludePathPatterns 用户排除拦截

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new DefaultInterceptor()).addPathPatterns("/**");
    }
}
