package com.zhfk.me.config;

import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import java.util.Arrays;

@Configuration
public class MyEnvironmentFun implements EnvironmentAware {
    @Override
    public void setEnvironment(Environment environment) {
        Arrays.stream(environment.getDefaultProfiles()).forEach(System.out::println);
    }
}
