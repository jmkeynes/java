package com.learn.hash;

import java.util.*;

/**
 * @author 江文谱
 * @version 1.0
 * @date 2020/6/17
 */
public class HashSetMain {

    public static void main(String[] args) {
        HashSet<String> set = new HashSet<>();
        set.add("111");
        set.add("111");
        set.forEach(System.out::println);

        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.addAll(set);
        linkedList.add("222");

        Map<String, String> map = new HashMap<>();
        map.put("k","v");

        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("K","V");

    }
}
