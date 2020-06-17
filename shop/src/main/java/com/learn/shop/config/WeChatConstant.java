package com.learn.shop.config;

/**
 * @author 江文谱
 * @version 1.0
 * @date 2020/6/17
 */
public interface WeChatConstant {

    /**
     * 请求消息类型：文本
     */
    String REQ_MESSAGE_TYPE_TEXT = "text";
    /**
     * 请求消息类型：图片
     */
    String REQ_MESSAGE_TYPE_IMAGE = "image";
    /**
     * 请求消息类型：语音
     */
    String REQ_MESSAGE_TYPE_VOICE = "voice";
    /**
     * 请求消息类型：视频
     */
    String REQ_MESSAGE_TYPE_VIDEO = "video";
    /**
     * 请求消息类型：小视频
     */
    String REQ_MESSAGE_TYPE_SHORTVIDEO = "shortvideo";
    /**
     * 请求消息类型：地理位置
     */
    String REQ_MESSAGE_TYPE_LOCATION = "location";
    /**
     * 请求消息类型：链接
     */
    String REQ_MESSAGE_TYPE_LINK = "link";

    /**
     * 请求消息类型：事件推送
     */
    String REQ_MESSAGE_TYPE_EVENT = "event";

    /**
     * 事件类型：subscribe(订阅)
     */
    String EVENT_TYPE_SUBSCRIBE = "subscribe";
    /**
     * 事件类型：unsubscribe(取消订阅)
     */
    String EVENT_TYPE_UNSUBSCRIBE = "unsubscribe";
    /**
     * 事件类型：scan(用户已关注时的扫描带参数二维码)
     */
    String EVENT_TYPE_SCAN = "scan";
    /**
     * 事件类型：LOCATION(上报地理位置)
     */
    String EVENT_TYPE_LOCATION = "LOCATION";
    /**
     * 事件类型：CLICK(自定义菜单)
     */
    String EVENT_TYPE_CLICK = "CLICK";

    /**
     * 响应消息类型：文本
     */
    String RESP_MESSAGE_TYPE_TEXT = "text";
    /**
     * 响应消息类型：图片
     */
    String RESP_MESSAGE_TYPE_IMAGE = "image";
    /**
     * 响应消息类型：语音
     */
    String RESP_MESSAGE_TYPE_VOICE = "voice";
    /**
     * 响应消息类型：视频
     */
    String RESP_MESSAGE_TYPE_VIDEO = "video";
    /**
     * 响应消息类型：音乐
     */
    String RESP_MESSAGE_TYPE_MUSIC = "music";
    /**
     * 响应消息类型：图文
     */
    String RESP_MESSAGE_TYPE_NEWS = "news";
}
