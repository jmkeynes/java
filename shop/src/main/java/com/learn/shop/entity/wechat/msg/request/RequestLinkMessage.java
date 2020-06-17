package com.learn.shop.entity.wechat.msg.request;

import lombok.Getter;
import lombok.Setter;

/**
 * @author 江文谱
 * @version 1.0
 * @date 2020/6/17
 *  链接消息：
 */
@Setter
@Getter
public class RequestLinkMessage extends RequestBaseMessage {

    /**
     * 消息标题
     */
    private String title;

    /**
     * 消息描述
      */
    private String description;

    /**
     * 消息链接
     */
    private String url;

}
