package com.learn.hash;

/**
 * @author：江文谱
 * @date： 2020/5/9 7:38
 * @version： 1.0
 */
public class Person {

    private ThreadLocal<Integer> local = new ThreadLocal<>();
    private String name;
    private int seckillQualification;
    private Integer count;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public int getSeckillQualification() {
        return this.local.get();
    }

    public void setSeckillQualification(int seckillQualification) {
        this.local.set(seckillQualification);
    }
}
