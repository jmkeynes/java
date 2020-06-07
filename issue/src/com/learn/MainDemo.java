package com.learn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author 江文谱
 * @version 1.0
 * @date 2020/6/7 9:37
 * @ClassName MainDemo
 */
public class MainDemo {
    public static void main(String[] args) {

        Integer count = 0;

        //公平锁
        Lock fairLock = new ReentrantLock();

        //非公平锁
        Lock nonfairLock = new ReentrantLock(false);

        //
        synchronized (count) {

        }

        String key = "K";
        String value = "V";
//        ConcurrentHashMap<String, String> chm = new ConcurrentHashMap<>();

        //在putVal方法中加了synchronized锁住了node f这个节点
//        chm.put(key, value);

        //默认初始化大小1<<4 16 加载因子0.75     new的时候会赋值加载因子
        Map<String, String> map = new HashMap<>();

        /**
         * put 的时候会通过hash算法计算key获取key的hashcode，调用putVal方法的时候将hashcode，key，value
         * 加载因子0.75 初始化大小16  1<<4  结构数组+链表+红黑二叉树
         */
//        System.out.println(map.put(key, value));
//        System.out.println(map.put(key, value));

        /**
         * 初始容量10 加载因子
         */
        List<String> list = new ArrayList<>();
        list.add(key);

        MyArrayList<Object> arrayList = new MyArrayList<>(2);
        System.out.println(arrayList.add(key));
        System.out.println(arrayList.add(key));
        System.out.println(arrayList.add(2255));
        for (Integer i = 0; i < arrayList.size(); i++) {
            System.out.println(arrayList.get(i));
        }

    }
}
