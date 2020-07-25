package com.learn.databases_cluster.utils;

import com.learn.databases_cluster.config.DataSourceConfig;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.List;

/**
 * 作者： jwp
 * 创建时间： 2020/7/21 21:33
 * 描述：DataSourceUtils
 */
public class DataSourceUtils {

    /**
     * 截取url字符串
     *
     * @param dataSourceUrl 数据源的url
     * @return 例： 192.168.249.128
     */
    public static String getIp(String dataSourceUrl, int port) {
        return dataSourceUrl.split("//")[1].split(":" + port)[0];
    }

    /**
     * 检查ip port是否可以
     *
     * @param ip   ip地址
     * @param port 端口号
     * @return 这个服务器是否可用
     */
    public static boolean checkIpPort(String ip, int port) {
        Socket socket = new Socket();
        try {
            socket.connect(new InetSocketAddress(ip, port), 3000);
            return true;
        } catch (Exception e) {
            return false;
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.getMessage();
            }
        }
    }

    /**
     * 重置数据源 下标
     *
     * @param namesArr 数据源名称
     */
    public static void resetDataSourceList(List<String> namesArr) {
        for (int i = 0; i < namesArr.size(); i++) {
            String dataSourceIPAndIndex = DataSourceConfig.names.get(namesArr.get(i)).toString();
            dataSourceIPAndIndex.replace(dataSourceIPAndIndex.split(",")[1], String.valueOf(i));
            DataSourceConfig.names.put(namesArr.get(i), dataSourceIPAndIndex);
        }
    }

}
