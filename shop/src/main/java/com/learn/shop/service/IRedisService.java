package com.learn.shop.service;

/**
 * @author 江文谱
 * @version 1.0
 * @date 2020/6/1 14:36
 * @ClassName IRedisService  redis 缓存服务
 */
public interface IRedisService {

    /**
     * 数据存储缓存中
     *
     * @param key   redis键
     * @param value redis值
     * @author 江文谱
     * @date 2020-6-1
     */
    void set(String key, String value);

    /**
     * 查询缓存数据
     *
     * @param key redis键
     * @author 江文谱
     * @date 2020-6-1
     */
    String get(String key);

    /**
     * 设置超时时间
     *
     * @param key    redis键
     * @param expire 缓存时间
     * @author 江文谱
     * @date 2020-6-1
     */
    boolean expire(String key, long expire);

    /**
     * 删除缓存数据
     *
     * @param key redis键
     * @author 江文谱
     * @date 2020-6-1
     */
    void remove(String key);

    /**
     * 自增
     * @param key key redis键
     * @param delta 自增步长
     */
    Long increment(String key, long delta);
}
