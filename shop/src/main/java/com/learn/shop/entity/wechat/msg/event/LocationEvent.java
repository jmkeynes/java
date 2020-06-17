package com.learn.shop.entity.wechat.msg.event;

import lombok.Getter;
import lombok.Setter;

/**
 * @author 江文谱
 * @version 1.0
 * @date 2020/6/17
 * 上报地理位置事件
 */
@Setter
@Getter
public class LocationEvent extends BaseEvent{

    /**
     * 地理位置纬度
      */
    private String latitude;
    /**
     * 地理位置经度
     */
    private String longitude;
    /**
     * 地理位置精度
     */
    private String precision;
}
