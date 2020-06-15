package com.learn.shop.config;

import lombok.Getter;

/**
 * @author 江文谱
 * @version 1.0
 * @date 2020/5/5 21:05
 */
@Getter
public enum QueueEnum {

    /**
     * 消息通知队列
     */
    QUEUE_ORDER_CANCEL("learn.order.direct", "learn.order.cancel", "learn.order.cancel"),

    /**
     * 延迟消息通知队列
     */
    QUEUE_TTL_ORDER_CANCEL("learn.order.direct.ttl", "learn.order.cancel.ttl", "learn.order.cancel.ttl");

    /**
     * 交换机
     */
    private final String exchange;

    /**
     * 队列名称
     */
    private final String name;

    /**
     * 路由键
     */
    private final String routeKey;

    QueueEnum(String exchange, String name, String routeKey) {
        this.exchange = exchange;
        this.name = name;
        this.routeKey = routeKey;
    }
}
