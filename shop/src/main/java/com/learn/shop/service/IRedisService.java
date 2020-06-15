package com.learn.shop.service;

import com.learn.shop.filter.BloomFilterHelper;

import java.util.Map;

/**
 * @author 江文谱
 * @version 1.0
 * @date 2020/6/1 14:36
 * @ClassName IRedisService  redis 缓存服务
 */
public interface IRedisService<T> {

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
     *
     * @param key   key redis键
     * @param delta 自增步长
     */
    Long increment(String key, long delta);

    /**
     * 根据给定的布隆过滤器添加值
     *
     * @param bloomFilterHelper 布隆过滤器
     * @param key               key
     * @param value             value
     */
    void addByBloomFilter(BloomFilterHelper<String> bloomFilterHelper, String key, String value);

    /**
     * 根据给定的布隆过滤器判断值是否存在
     *
     * @param bloomFilterHelper 布隆过滤器
     * @param key               key
     * @param value             value
     */
    boolean includeByBloomFilter(BloomFilterHelper<String> bloomFilterHelper, String key, String value);

    /**
     * 批量添加到缓存
     *
     * @param map 缓存数据
     * @return 执行结果给
     * @date 2020-6-15
     * @author jwp
     */
    boolean batchAddRedis(Map<String, String> map);

    /**
     * redis增量操作
     * @param key key
     * @param value value
     * @return 执行结果
     */
    boolean addRedis(String key,String value);
}
