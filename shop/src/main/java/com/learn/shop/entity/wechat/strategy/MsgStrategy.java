package com.learn.shop.entity.wechat.strategy;

import java.util.Map;

/**
 * @author 江文谱
 * @version 1.0
 * @date 2020/6/17
 */
public interface MsgStrategy {

    String execute(Map<String, String> requestMap);
}
