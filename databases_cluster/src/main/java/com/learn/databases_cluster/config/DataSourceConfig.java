package com.learn.databases_cluster.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.learn.databases_cluster.constant.DataSourceType;
import com.learn.databases_cluster.utils.DataSourceUtils;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.util.*;

/**
 * 作者： jwp
 * 创建时间： 2020/7/19 18:47
 * 描述：DataSourceConfig
 */
@Configuration
@Slf4j
public class DataSourceConfig {

    private static final Logger LOGGER = LoggerFactory.getLogger(DataSourceConfig.class);

    //druid连接池
    @ConfigurationProperties(prefix = "spring.datasource.druid")
    private DruidDataSource druidDataSource() {
        LOGGER.info("连接池初始化！！");
        return new DruidDataSource();
    }

    //主机1号
    @Bean(name = "dataSourceMaster1")
    @ConfigurationProperties(prefix = "spring.datasource.master1")
    public DruidDataSource dataSourceMaster1() {
        LOGGER.info("master1初始化！！");
        return druidDataSource().cloneDruidDataSource();
    }

    //主机2号
    @Bean(name = "dataSourceMaster2")
    @ConfigurationProperties(prefix = "spring.datasource.master2")
    public DruidDataSource dataSourceMaster2() {
        LOGGER.info("master2初始化！！");
        return druidDataSource().cloneDruidDataSource();
    }

//    从机1号
//    @Bean(name = "dataSourceSlave1")
//    @ConfigurationProperties(prefix = "spring.datasource.slave1")
//    public DruidDataSource dataSourceSlave1() {
//        LOGGER.info("slave1初始化！！");
//        return druidDataSource().cloneDruidDataSource();
//    }

    //从机2号
//    @Bean(name = "dataSourceSlave2")
//    @ConfigurationProperties(prefix = "spring.datasource.slave2")
//    public DruidDataSource dataSourceSlave2() {
//        LOGGER.info("slave2初始化！！");
//        return druidDataSource().cloneDruidDataSource();
//    }

    @Value("${server.mysqlHosts}")
    private String dataSource;

    public static Map<String, Object> names = new HashMap<>();

    public static List<String> namesArr;

    /**
     * mysql端口一般是3306
     */
    public static final int port = 3306;

    public void init() {
        List<String> nameList = Arrays.asList(dataSource.split(","));
        namesArr = new ArrayList<>(nameList.size());
        nameList.forEach(name -> {
            switch (name) {
                case DataSourceType.MASTER_TWO:
                    String ip1 = DataSourceUtils.getIp(dataSourceMaster2().getUrl(), port);
                    names.put(name, ip1 + "," + namesArr.size());
                    namesArr.add(name);
                    break;
//                case DataSourceType.SLAVE_ONE:
//                    String ip2 = DataSourceUtils.getIp(dataSourceSlave1().getUrl(), port);
//                    names.put(name, ip2 + "," + namesArr.size());
//                    namesArr.add(name);
//                    break;
//                case DataSourceType.SLAVE_TWO:
//                    String ip3 = DataSourceUtils.getIp(dataSourceSlave2().getUrl(), port);
//                    names.put(name, ip3 + "," + namesArr.size());
//                    namesArr.add(name);
//                    break;
                default:
                    String ip = DataSourceUtils.getIp(dataSourceMaster1().getUrl(), port);
                    names.put(name, ip + "," + namesArr.size());
                    namesArr.add(name);
            }
        });
    }

    @Primary
    @Bean(name = "dataSource")
    public DataSource dataSource() {

        DynamicDataSource dynamicDataSource = new DynamicDataSource();
        //默认数据源
        dynamicDataSource.setDefaultTargetDataSource(dataSourceMaster1());
        //配置多数据源
        Map<Object, Object> dataSourceMap = new HashMap<>();
        dataSourceMap.put(DataSourceType.MASTER_ONE, dataSourceMaster1());
        dataSourceMap.put(DataSourceType.MASTER_TWO, dataSourceMaster2());
//        dataSourceMap.put(DataSourceType.SLAVE_ONE, dataSourceSlave1());
//        dataSourceMap.put(DataSourceType.SLAVE_TWO, dataSourceSlave2());
        dynamicDataSource.setTargetDataSources(dataSourceMap);
        LOGGER.info("\n进入数据源配置类中------------");
        init();
        return dynamicDataSource;
    }
}
