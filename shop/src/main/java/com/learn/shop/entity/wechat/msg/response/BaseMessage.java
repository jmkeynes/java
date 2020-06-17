package com.learn.shop.entity.wechat.msg.response;

import lombok.Data;

/**
 * @author 江文谱
 * @version 1.0
 * @date 2020/6/17
 */
@Data
public class BaseMessage {
    // 接收方帐号（收到的OpenID）
    private String ToUserName;
    // 开发者微信号
    private String FromUserName;
    // 消息创建时间 （整型）
    private long CreateTime;
    // 消息类型
    private String MsgType;
}
