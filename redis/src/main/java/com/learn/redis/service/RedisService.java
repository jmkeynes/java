package com.learn.redis.service;

/**
 * @author：江文谱
 * @date： 2020/5/5 20:15
 * @version： 1.0
 *
 * redisUtil工具类
 * 对象和数组都以Json字符串形式存储
 */
public interface RedisService {

    /**
     * 数据存储
     * @param key 键
     * @param value 值
     */
    void set(String key,String value);

    /**
     * 获取数据
     * @param key 键
     * @return 值
     */
    String get(String key);

    /**
     * 设置超时时间
     * @param key 键
     * @param expire 超时时间
     * @return 设置结果
     */
    boolean expire(String key,long expire);

    /**
     * 清除数据
     * @param key 键
     */
    void remove(String key);

    /**
     * 自增操作
     * @param key 键
     * @param dalte 自增值
     */
    Long increment(String key,long dalte);
}
