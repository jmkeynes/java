package com.learn.shop.entity.wechat.msg.response;

import lombok.Getter;
import lombok.Setter;

/**
 * @author 江文谱
 * @version 1.0
 * @date 2020/6/17
 */
@Setter
@Getter
public class Article {

    /**
     * 图文消息名称
     */
    private String Title;
    /**
     * 图文消息描述
     */
    private String Description;
    /**
     * 图片链接，支持JPG、PNG格式，较好的效果为大图640*320，小图80*80
     */
    private String PicUrl;
    /**
     * 点击图文消息跳转链接
     */
    private String Url;
}
