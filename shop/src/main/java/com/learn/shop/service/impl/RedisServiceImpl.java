package com.learn.shop.service.impl;

import com.google.common.base.Preconditions;
import com.learn.shop.filter.BloomFilterHelper;
import com.learn.shop.service.IRedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author 江文谱
 * @version 1.0
 * @date 2020/6/1 14:37
 * @ClassName RedisServiceImpl  redis操作实现
 */
@Service
public class RedisServiceImpl implements IRedisService {

    @Autowired
    private StringRedisTemplate redisTemplate;

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
        Preconditions.checkArgument(bloomFilterHelper != null, "");
        int[] offsets = bloomFilterHelper.murmurHashOffset(value);
        for (int offset : offsets) {
            redisTemplate.opsForValue().setBit(key, offset, true);
        }
    }

    @Override
    public boolean includeByBloomFilter(BloomFilterHelper<String> bloomFilterHelper, String key, String value) {
        Preconditions.checkArgument(bloomFilterHelper!=null,"");
        int[] offsets = bloomFilterHelper.murmurHashOffset(value);
        for (int offset : offsets) {
            if (!redisTemplate.opsForValue().getBit(key, offset)) {
                return false;
            }
        }
        return true;
    }
}
