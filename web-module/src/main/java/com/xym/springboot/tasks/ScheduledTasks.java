package com.xym.springboot.tasks;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class ScheduledTasks {

    private Logger logger = LoggerFactory.getLogger(ScheduledTasks.class);

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(fixedRate = 5000)
    public void reportCurrentTime() {
        logger.debug("现在时间-----1：" + dateFormat.format(new Date()));
    }

    @Scheduled(cron = "*/2 * * * * *")
    public void reportCurrentTime2() {
        logger.debug("现在时间------2：" + dateFormat.format(new Date()));
    }

}
