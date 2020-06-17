package com.learn.shop.entity.wechat.msg.response;

import lombok.Getter;
import lombok.Setter;

/**
 * @author 江文谱
 * @version 1.0
 * @date 2020/6/17
 * 回复文本消息
 */
@Setter
@Getter
public class TextMessage extends BaseMessage{

    /**
     * 回复的消息内容
     */
    private String Content;
}
