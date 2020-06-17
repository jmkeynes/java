package com.learn.shop.entity.wechat.strategy;

import com.learn.shop.config.WeChatConstant;
import com.learn.shop.util.MessageUtil;

import java.util.Map;

/**
 * @author 江文谱
 * @version 1.0
 * @date 2020/6/17
 */
public class UnknowMsgStrategy implements MsgStrategy {

    @Override
    public String execute(Map<String, String> requestMap) {
        return MessageUtil.sendTextMsg(requestMap, "不知道你在干嘛", WeChatConstant.RESP_MESSAGE_TYPE_TEXT);
    }
}
