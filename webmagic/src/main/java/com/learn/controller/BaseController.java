package com.learn.controller;

import com.learn.pojo.PageResultPojo;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ：江文谱
 * @date ： 2020/5/1 11:40
 * @version ： 1.0
 */
public abstract class BaseController<T> {

    Map<String,Object> resultGoToLayuiFormat(PageResultPojo result){
        Map<String,Object> map = new HashMap();
        map.put("code", 0);
        map.put("data", result.getRows());
        map.put("count", result.getTotal());
        map.put("msg", "success");
        return map;
    }
}
