package com.learn.shop.entity.wechat.strategy;

import com.learn.shop.config.WeChatConstant;
import com.learn.shop.util.MessageUtil;

import java.util.Map;

/**
 * 事件消息 - 取消关注
 */
public class UnsubscribeMsgStrategy implements MsgStrategy {

    @Override
    public String execute(Map<String, String> requestMap) {
        return MessageUtil.sendTextMsg(requestMap, "您已取关!!", WeChatConstant.RESP_MESSAGE_TYPE_TEXT);
    }
}
