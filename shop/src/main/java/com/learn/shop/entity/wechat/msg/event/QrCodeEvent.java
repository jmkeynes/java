package com.learn.shop.entity.wechat.msg.event;

import lombok.Getter;
import lombok.Setter;

/**
 * @author 江文谱
 * @version 1.0
 * @date 2020/6/17
 * 扫描带参数二维码事件
 */
@Setter
@Getter
public class QrCodeEvent extends BaseEvent{

    /**
     * 事件KEY值
     */
    private String eventKey;
    /**
     * 用于换取二维码图片
     */
    private String ticket;
}
