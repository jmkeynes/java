package com.learn;

import java.util.Arrays;

/**
 * @author 江文谱
 * @version 1.0
 * @date 2020/6/7 11:56
 * @ClassName MyArryList
 */
public class MyArryList<T> {
    private Integer initSize = 0;
    private Integer size = 0;
    private Object[] objects = {};

    public MyArryList(Integer initSize) {
        this.initSize = initSize;
        this.objects = new Object[initSize];
    }

    public MyArryList() {
        this.objects = new Object[10];
    }

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

    public Object get(Integer index) {
        for (int i = 0; i < objects.length; i++) {
            if (index == i) {
//                System.out.println(objects[i]);
                return objects[i];
            }
        }
        return null;
    }

    public Integer size() {
        return this.size;
    }
}
