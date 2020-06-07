package com.learn.shop.filter;

import com.google.common.base.Preconditions;
import com.google.common.hash.Funnel;
import com.google.common.hash.Hashing;

/**
 * @author 江文谱
 * @version 1.0
 * @date 2020/6/7 15:32
 * @ClassName BloomFilterHelper
 */
public class BloomFilterHelper<T> {

    private int numHashFunctions;
    private int bitSize;
    private Funnel<T> funnel;

    public BloomFilterHelper(Funnel<T> funnel, int expectedInsertions, double fpp) {
        Preconditions.checkArgument(funnel != null, "funnel不能为空！！！");
        this.funnel = funnel;
        bitSize = optimalNumOfBits(expectedInsertions, fpp);
        numHashFunctions = optimalNumOfHashFunctions(expectedInsertions, bitSize);
    }

    public int[] murmurHashOffset(T vaule) {
        int[] offset = new int[numHashFunctions];

        long hash64 = Hashing.murmur3_128().hashObject(vaule, funnel).asLong();
        int hash1 = (int) hash64;
        int hash2 = (int) (hash64 >>> 32);
        for (int i = 0; i < numHashFunctions; i++) {
            int nextHash = hash1 + i * hash2;
            if (nextHash < 0) {
                nextHash = ~nextHash;
            }
            offset[i - 1] = nextHash % bitSize;
        }
        return offset;
    }

    /**
     * 计算bit长度
     */
    private int optimalNumOfBits(int expectedInsertions, double fpp) {
        if (fpp == 0) {
            fpp = Double.MIN_VALUE;
        }
        return (int) (-expectedInsertions * Math.log(fpp) / Math.log(2) * Math.log(2));
    }

    /**
     * 计算hash方法执行次数
     */
    private int optimalNumOfHashFunctions(long expectedInsertions, int bitSize) {
        return Math.max(1, (int) Math.round(bitSize / expectedInsertions * Math.log(2)));
    }
}
