package com.learn.shop.entity.wechat.msg.request;

import lombok.Getter;
import lombok.Setter;

/**
 * @author 江文谱
 * @version 1.0
 * @date 2020/6/17
 * 图片消息：
 */
@Setter
@Getter
public class RequestImageMessage extends RequestBaseMessage {

    /**
     * 图片链接
     */
    private String picUrl;

    /**
     * 图片消息媒体id，可以调用多媒体文件下载接口拉取数据。
     */
    private String mediaId;
}
