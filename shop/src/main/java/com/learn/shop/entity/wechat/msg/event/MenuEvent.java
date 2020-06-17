package com.learn.shop.entity.wechat.msg.event;

import lombok.Getter;
import lombok.Setter;

/**
 * @author 江文谱
 * @version 1.0
 * @date 2020/6/17
 * 自定义菜单事件
 */
@Setter
@Getter
public class MenuEvent extends BaseEvent {

    /**
     * 事件KEY值，与自定义菜单接口中KEY值对应
     */
    private String eventKey;
}
