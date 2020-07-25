package com.learn.databases_cluster.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * 作者： jwp
 * 创建时间： 2020/7/19 19:45
 * 描述：DataSourceContext
 */
public class DataSourceContext {

    private static final Logger logger = LoggerFactory.getLogger(DataSourceContext.class);

    private static final ThreadLocal<String> contextHolder = new ThreadLocal<>();

    //设置线程级别私有变量
    public static void setDataSource(String value) {
        logger.info("\n设置线程级别私有变量 value->{}", value);
        contextHolder.set(value);
    }

    public static String getDataSource() {
        return contextHolder.get();
    }

    public static void clearDataSource() {
        contextHolder.remove();
    }
}
