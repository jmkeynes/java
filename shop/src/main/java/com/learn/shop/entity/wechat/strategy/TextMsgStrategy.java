package com.learn.shop.entity.wechat.strategy;

import com.learn.shop.config.WeChatConstant;
import com.learn.shop.util.MessageUtil;

import java.util.Map;

/**
 * @author 江文谱
 * @version 1.0
 * @date 2020/6/17
 * 文字消息
 */
public class TextMsgStrategy implements MsgStrategy {

    @Override
    public String execute(Map<String, String> requestMap) {
        return MessageUtil.sendTextMsg(requestMap, "您发送的是文字消息", WeChatConstant.RESP_MESSAGE_TYPE_TEXT);
    }
}
