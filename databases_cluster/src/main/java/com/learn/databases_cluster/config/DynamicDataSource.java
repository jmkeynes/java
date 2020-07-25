package com.learn.databases_cluster.config;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;


/**
 * 作者： jwp
 * 创建时间： 2020/7/19 19:44
 * 描述：DynamicDataSource
 */
@Slf4j
public class DynamicDataSource extends AbstractRoutingDataSource {

    private static final Logger LOGGER = LoggerFactory.getLogger(DynamicDataSource.class);

    /**
     * 通过绑定线程的数据源上下文实现多数据源动态切换
     */
    @Override
    protected Object determineCurrentLookupKey() {
        String dataSource = DataSourceContext.getDataSource();
        LOGGER.info("\n当前的数据源名称是：——>{}", dataSource);
        return dataSource;
    }
}
