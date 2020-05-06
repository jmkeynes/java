package com.learn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * 创建人：江文谱
 * 创建时间： 2020/4/30 21:33
 * 版本： 1.0
 */
@SpringBootApplication
@EnableScheduling
public class Application {

    /**
     * 启动类
     *
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
