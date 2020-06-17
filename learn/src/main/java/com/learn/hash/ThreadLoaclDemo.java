package com.learn.hash;

import java.util.ArrayList;
import java.util.List;

/**
 * @author：江文谱
 * @date： 2020/5/9 6:59
 * @version： 1.0
 */
public class ThreadLoaclDemo {


    public static void main(String[] args) {

        List<Person> people = new ArrayList<>();
//        Set<Person> people = new HashSet<>();
        int count = 0;
        while (count < 20) {
            Person p = new Person();
            int finalCount = count;
            Thread thread = new Thread(() -> {
                p.setName(Thread.currentThread().getName() + "的数据");
                p.setCount(finalCount);

            });
            thread.setName("线程" + count);
            thread.start();
            count++;
            people.add(p);
        }
        people.forEach(person ->
                System.out.println(person.getName() + "-->" + person.getCount()));
    }
}
