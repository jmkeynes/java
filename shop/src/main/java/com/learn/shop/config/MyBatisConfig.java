package com.learn.shop.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author 江文谱
 * @version 1.0
 * @date 2020/6/1 17:39
 * @ClassName MyBatisConfig
 */
@Configuration
@MapperScan("com.learn.shop.dao.*")
public class MyBatisConfig {
}
