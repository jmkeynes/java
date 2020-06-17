package com.learn.shop.entity.wechat.strategy;

import java.util.Map;

/**
 * @author 江文谱
 * @version 1.0
 * @date 2020/6/17
 */
public class MsgStrategyContext {

    private final MsgStrategy msgStrategy;

    public MsgStrategyContext(MsgStrategy msgStrategy) {
        this.msgStrategy = msgStrategy;
    }

    public String execute(Map<String, String> requestMap) {
        return this.msgStrategy.execute(requestMap);
    }
}
