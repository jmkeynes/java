package com.learn.databases_cluster.aspect;

import com.learn.databases_cluster.config.DataSourceConfig;
import com.learn.databases_cluster.config.DataSourceContext;
import com.learn.databases_cluster.constant.DataSourceType;
import com.learn.databases_cluster.utils.DataSourceUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Random;

/**
 * 作者： jwp
 * 创建时间： 2020/7/19 20:24
 * 描述：DataSourceAspect
 */
@Aspect
@Component
@Order(0)
public class DataSourceAspect {

    private static final Logger logger = LoggerFactory.getLogger(DataSourceAspect.class);

    @Around(value = "dataSourcePoint()")
    public Object dataSourceAround(ProceedingJoinPoint point) throws Throwable {
        //获取切换数据源之前的数据源，一般设置为超类
        String defaultDataSource = DataSourceContext.getDataSource();
        //根据注解判断切换对应的数据源
        changDataSource();
        Object result = point.proceed();
        //方法执行结束，数据源切回方法之前的数据源
        DataSourceContext.setDataSource(defaultDataSource);
        return result;
    }

    /**
     * 改变数据源上下文
     */
    private void changDataSource() {
        String source = getDataSource();
        if (null != source) {
            DataSourceContext.setDataSource(source);
        }
    }


    /**
     * 默认数据源名称
     */
    private String defaultDataSource = DataSourceType.MASTER_ONE;

    /**
     * 获取数据源
     */
    private String getDataSource() {

        //获取默认数据源的ip
        String[] ipAndIndex = DataSourceConfig.names.get(defaultDataSource).toString().split(",");
        int dataSourceIndex = Integer.parseInt(ipAndIndex[1]);
        String defaultDataSourceIP = ipAndIndex[0];

        if (DataSourceUtils.checkIpPort(defaultDataSourceIP, DataSourceConfig.port)) {
            //返回可用的默认的数据源
            return defaultDataSource;
        } else {
            List<String> namesArr = DataSourceConfig.namesArr;

            //删除默认的数据源
            namesArr.remove(dataSourceIndex);

            //重置数据源的下标
            DataSourceUtils.resetDataSourceList(namesArr);

            while (true) {
                if (CollectionUtils.isEmpty(DataSourceConfig.namesArr)) {
                    //集合中没有可用使用的数据源
                    throw new NullPointerException("\n-------------没有可用的数据库资源！！！-----------------------");
                }
                //采用随机算法，获取可用数据源在集合中的下标
                int index = new Random().nextInt(DataSourceConfig.namesArr.size());

                //取得数据源名称
                String name = DataSourceConfig.namesArr.get(index);
                String[] newIPAndIndex = DataSourceConfig.names.get(name).toString().split(",");
                if (DataSourceUtils.checkIpPort(newIPAndIndex[0], DataSourceConfig.port)) {
                    logger.info("\n-----------------------------获取切换数据源名称：{}----------------------", name);
                    defaultDataSource = name;
                    return defaultDataSource;
                } else {
                    //将不可以的数据源删除
                    DataSourceConfig.namesArr.remove(index);
                    logger.info("\n-----------------------------获取集合下标信息：{}------------------------------", index);
                }
            }
        }
    }


    @Pointcut(value = "@annotation(com.learn.databases_cluster.annotation.TargetDataSource)||" +
            "@within(com.learn.databases_cluster.annotation.TargetDataSource)")
    protected void targetDataSourcePoint() {
    }

    @Pointcut(value = "targetDataSourcePoint()")
    protected void dataSourcePoint() {
    }

}
