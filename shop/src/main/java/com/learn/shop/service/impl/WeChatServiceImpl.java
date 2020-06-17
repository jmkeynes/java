package com.learn.shop.service.impl;

import com.learn.shop.entity.wechat.strategy.MsgStrategy;
import com.learn.shop.entity.wechat.strategy.MsgStrategyContext;
import com.learn.shop.entity.wechat.strategy.MsgStrategyFactory;
import com.learn.shop.service.IWeChatService;
import com.learn.shop.util.MessageUtil;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author 江文谱
 * @version 1.0
 * @date 2020/6/16
 */
@Service
public class WeChatServiceImpl implements IWeChatService {

    @Override
    public String processRequest(HttpServletRequest request) {
        try {
            // 调用parseXml方法解析请求消息
            Map<String, String> requestMap = MessageUtil.parseXml(request);

            //工厂类生产策略
            MsgStrategy msgStrategy = MsgStrategyFactory.getReceiveMsg(requestMap);

            //将策略交给执行策略的上下文
            MsgStrategyContext context = new MsgStrategyContext(msgStrategy);
            return context.execute(requestMap);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
