package com.learn.shop.entity.wechat.response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author 江文谱
 * @version 1.0
 * @date 2020/6/17
 */
@Setter
@Getter
public class NewsMessage extends BaseMessage {

    /**
     * 图文消息个数，限制为10条以内
     */
    private int ArticleCount;
    /**
     * 多条图文消息信息，默认第一个item为大图
     */
    private List<Article> Articles;
}
