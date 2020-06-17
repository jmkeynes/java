package com.learn.shop.entity.wechat.msg.response;

import lombok.Getter;
import lombok.Setter;

/**
 * @author 江文谱
 * @version 1.0
 * @date 2020/6/17
 * 回复语音消息
 */
@Setter
@Getter
public class Voice {
    /**
     * 媒体文件id
     */
    private String MediaId;
}
