package com.learn.shop.entity.wechat.response;

import lombok.Getter;
import lombok.Setter;

/**
 * @author 江文谱
 * @version 1.0
 * @date 2020/6/17
 */
@Setter
@Getter
public class VoiceMessage extends BaseMessage {
    /**
     * 语音
     */
    private Voice Voice;
}
