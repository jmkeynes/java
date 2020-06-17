package com.learn.shop.entity.wechat.msg.event;

import lombok.Data;

/**
 * @author 江文谱
 * @version 1.0
 * @date 2020/6/17
 * 事件基类封装
 */
@Data
public class BaseEvent {

    /**
     * 开发者微信号
     */
    private String toUserName;
    /**
     * 发送方帐号（一个OpenID）
     */
    private String fromUserName;
    /**
     * 消息创建时间 （整型）
     */
    private long createTime;
    /**
     * 消息类型
     */
    private String msgType;
    /**
     * 事件类型
     */
    private String event;
}
