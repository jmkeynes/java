package com.learn.shop.entity.wechat.msg.request;

import lombok.Data;

/**
 * @author 江文谱
 * @version 1.0
 * @date 2020/6/17
 * 请求消息的基类,主要是封装了一些共同的字段。
 */
@Data
public class RequestBaseMessage {

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
     * 消息类型（text/image/location/link）
     */
    private String msgType;

    /**
     * 消息id，64位整型
     */
    private long msgId;
}
