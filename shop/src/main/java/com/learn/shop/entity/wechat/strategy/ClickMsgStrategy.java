package com.learn.shop.entity.wechat.strategy;

import com.learn.shop.config.WeChatConstant;
import com.learn.shop.util.MessageUtil;

import java.util.Map;

/**
 * @author 江文谱
 * @version 1.0
 * @date 2020/6/17
 * 事件消息 - 点击菜单
 */
public class ClickMsgStrategy implements MsgStrategy {

    @Override
    public String execute(Map<String, String> requestMap) {
        return MessageUtil.sendTextMsg(requestMap, "您点击了菜单", WeChatConstant.RESP_MESSAGE_TYPE_TEXT);
    }
}
