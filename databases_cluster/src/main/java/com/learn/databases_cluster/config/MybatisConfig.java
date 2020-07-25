package com.learn.databases_cluster.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * 作者： jwp
 * 创建时间： 2020/7/19 21:04
 * 描述：Mybatis
 */
@Configuration
@MapperScan("com.learn.databases_cluster.dao")
public class MybatisConfig {
}
