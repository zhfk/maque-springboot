package com.zhfk.me.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class StartupRunner implements CommandLineRunner {
    Logger logger = LoggerFactory.getLogger(StartupRunner.class);
    @Override
    public void run(String... args) throws Exception {
        Arrays.stream(args).forEach(System.out::println);
        logger.info("start up ...");

    }
}
