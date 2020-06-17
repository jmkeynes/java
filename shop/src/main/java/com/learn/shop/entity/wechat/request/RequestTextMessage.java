package com.learn.shop.entity.wechat.request;

import lombok.Getter;
import lombok.Setter;

/**
 * @author 江文谱
 * @version 1.0
 * @date 2020/6/17
 * 文本消息类Content ，主要是文本消息内容。
 */
@Setter
@Getter
public class RequestTextMessage extends RequestBaseMessage {

    /**
     * 消息内容
     */
    private String content;
}
