package com.learn.shop.service.impl;

import com.google.common.base.Preconditions;
import com.learn.shop.filter.BloomFilterHelper;
import com.learn.shop.service.IRedisService;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.SessionCallback;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @author 江文谱
 * @version 1.0
 * @date 2020/6/1 14:37
 * @ClassName RedisServiceImpl  redis操作实现
 */
@Service
public class RedisServiceImpl<T> implements IRedisService<T> {

    private static final Logger LOGGER = LoggerFactory.getLogger(RedisServiceImpl.class);

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Autowired
    private RedissonClient client;

    @Value("${redis.expire.timeout}")
    private long expire;

    @Override
    public void set(String key, String value) {
        redisTemplate.opsForValue().set(key, value);
    }

    @Override
    public String get(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    @Override
    public boolean expire(String key, long expire) {
        return redisTemplate.expire(key, expire, TimeUnit.SECONDS);
    }

    @Override
    public void remove(String key) {
        redisTemplate.delete(key);
    }

    @Override
    public Long increment(String key, long delta) {
        return redisTemplate.opsForValue().increment(key, delta);
    }

    @Override
    public void addByBloomFilter(BloomFilterHelper<String> bloomFilterHelper, String key, String value) {
        Preconditions.checkArgument(bloomFilterHelper != null, "错误！!");
        int[] offsets = bloomFilterHelper.murmurHashOffset(value);
        for (int offset : offsets) {
            redisTemplate.opsForValue().setBit(key, offset, true);
        }
    }

    @Override
    public boolean includeByBloomFilter(BloomFilterHelper<String> bloomFilterHelper, String key, String value) {
        Preconditions.checkArgument(bloomFilterHelper != null, "错误！!");
        int[] offsets = bloomFilterHelper.murmurHashOffset(value);
        for (int offset : offsets) {
            if (!redisTemplate.opsForValue().getBit(key, offset)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 根据map集合 采用redis流水线的工作模式将数据批量缓存到redis中
     * 并且设置数据缓存有效期，，结合随机时间防止数据集中过期，导致缓存服务器宕机
     *
     * @param map key value
     * @return 执行结果
     */
    @Override
    public boolean batchAddRedis(Map<String, String> map) {
        SessionCallback session = new SessionCallback() {
            @Override
            public Boolean execute(RedisOperations operations) throws DataAccessException {
                map.keySet().forEach(key -> {
                    operations.opsForValue().set(key, map.get(key));
                    operations.expire(key, expire + new Random().nextInt(120), TimeUnit.SECONDS);
                });
                return true;
            }
        };
        redisTemplate.execute(session);
        return true;
    }

    @Override
    public boolean addRedis(String key, String value) {
        RLock lock = client.getLock(key);
        lock.lock();
        try {
            redisTemplate.opsForValue().set(key, value);
            redisTemplate.expire(key, expire + new Random().nextInt(120), TimeUnit.SECONDS);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            LOGGER.error(e.getMessage());
            return false;
        }finally {
            lock.unlock();
        }
    }
}
