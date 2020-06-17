package com.learn.shop.entity.wechat.msg.request;

import lombok.Getter;
import lombok.Setter;

/**
 * @author 江文谱
 * @version 1.0
 * @date 2020/6/17
 */
@Setter
@Getter
public class RequestLocationMessage extends RequestBaseMessage {

    /**
     * 地理位置维度
     */
    private String location_X;
    /**
     * 地理位置经度
     */
    private String location_Y;
    /**
     * 地图缩放大小
     */
    private String scale;
    /**
     * 地理位置信息
     */
    private String label;
}
