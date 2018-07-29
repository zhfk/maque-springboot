package com.zhfk.me.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableScheduling
public class SchedulingConfig {
    Logger logger = LoggerFactory.getLogger(SchedulingConfig.class);
    @Scheduled(cron = "0 1 * * * ?")
    public void heartBeat(){
        logger.info("heartbeat");
    }
}
