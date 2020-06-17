package com.learn.shop.entity.wechat.msg.request;

import lombok.Getter;
import lombok.Setter;

/**
 * @author 江文谱
 * @version 1.0
 * @date 2020/6/17
 * 语音消息：
 */
@Setter
@Getter
public class RequestVoiceMessage extends RequestBaseMessage {

    /**
     * 语音消息媒体id，可以调用多媒体文件下载接口拉取数据。
     */
    private String mediaId;

    /**
     * 语音格式，如amr，speex等
     */
    private String format;
}
