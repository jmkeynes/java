package com.learn.shop.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 江文谱
 * @version 1.0
 * @date 2020/6/5 0:11
 * @ClassName BaseController
 */
public abstract class BaseController<T> {

    public Map<String, Object> getMap(IPage<T> result) {

        Map<String, Object> map = new HashMap<>();
        if (result == null) {
            map.put("code", 1);
            map.put("msg", "err");
        } else {
            map.put("code", 0);
            map.put("data", result.getRecords());
            map.put("count", result.getTotal());
            map.put("msg", "success");
        }
        return map;
    }
}
