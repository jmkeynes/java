package com.learn;

import java.util.Arrays;

/**
 * @author 江文谱
 * @version 1.0
 * @date 2020/6/7 11:56
 * @ClassName MyArrayList  自定义实现一个数组的效果，有add 和get方法
 */
public class MyArrayList<T> {

    //初始化大小
    private Integer initSize = 0;

    //集合长度
    private Integer size = 0;

    //初始集合
    private Object[] objects = {};

    //构造函数 初始化集合
    public MyArrayList(Integer initSize) {
        this.initSize = initSize;
        this.objects = new Object[initSize];
    }

    //无参数构造函数 初始化函数
    public MyArrayList() {
        this.objects = new Object[10];
    }

    /**
     * 集合添加的方法
     * @param t 添加的元素
     * @return 添加的返回结果
     */
    public boolean add(T t) {
        if (size < initSize) {
            for (int i = 0; i < objects.length; i++) {
                if (objects[i] == null) {
                    objects[i] = t;
                    size++;
                    return true;
                }
            }
        } else {
            Integer addSize = initSize << 1 / 2;
            initSize = initSize + addSize;
            objects = Arrays.copyOf(this.objects, initSize);
            for (int i = 0; i < objects.length; i++) {
                if (objects[i] == null) {
                    objects[i] = t;
                    size++;
                    return true;
                }
            }

        }
        return false;
    }

    /**
     * 集合元素的获取
     * @param index 下标
     * @return 查询的结果
     */
    public Object get(Integer index) {
        for (int i = 0; i < objects.length; i++) {
            if (index == i) {
                return objects[i];
            }
        }
        return null;
    }

    /**
     * 集合的长度
     */
    public Integer size() {
        return this.size;
    }
}
