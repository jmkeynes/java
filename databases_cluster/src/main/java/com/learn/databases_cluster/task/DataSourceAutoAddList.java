package com.learn.databases_cluster.task;

import com.learn.databases_cluster.config.DataSourceConfig;
import com.learn.databases_cluster.utils.DataSourceUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 作者： jwp
 * 创建时间： 2020/7/25 12:46
 * 描述：DataSourceAutoAddList
 */
@EnableScheduling
@Component
public class DataSourceAutoAddList {

    private static final Logger LOGGER = LoggerFactory.getLogger(DataSourceAutoAddList.class);

    @Value("${server.mysqlHosts}")
    private String dataSourceStr;

    /**
     * 定时任务  每秒监听连接失败的数据库信息并添加到数据源集合中
     */
    @Scheduled(cron = "0/30 * * * * ? ")
    public void dbsAdd() {
        LOGGER.info("\n进入定时任务！！！！");
        List<String> namesArr = DataSourceConfig.namesArr;
        String[] names = dataSourceStr.split(",");
        if (names.length > namesArr.size()) {
            LOGGER.info("\n有数据库连接失败！！！！\n正在重启中.....");
            for (String name : names) {
                if (!namesArr.contains(name)) {
                    String ipAndPortStr = DataSourceConfig.names.get(name).toString();
                    String[] ipAndPort = ipAndPortStr.split(",");
                    boolean checkSuccess = DataSourceUtils.checkIpPort(ipAndPort[0], 3306);
                    if (checkSuccess) {
                        namesArr.add(name);
                        //重置数据源的下标
                        DataSourceUtils.resetDataSourceList(namesArr);
                        LOGGER.info("\n数据库连接成功！！！\n感谢伟大的程序员！！！");
                    }
                }
            }
        }
    }


}
