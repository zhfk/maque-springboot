package com.zhfk.me;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * ServletComponentScan //用于扫描自定义的servlet 和 filter， 例如druid监控
 */
@SpringBootApplication
@ServletComponentScan
public class MySpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(MySpringApplication.class, args);
    }
}
