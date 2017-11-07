package com.xym.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling//启用调度任务支持
public class MyApplicationBoot {

    public static void main(String[] args) {
        SpringApplication.run(MyApplicationBoot.class, args);
    }

}
