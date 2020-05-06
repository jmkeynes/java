package com.learn.rabbitmq.service.impl;

import com.learn.rabbitmq.component.CancelOrderSender;
import com.learn.rabbitmq.dto.OrderParam;
import com.learn.rabbitmq.pojo.Result;
import com.learn.rabbitmq.service.OmsPortalOrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author：江文谱
 * @date： 2020/5/5 21:55
 * @version： 1.0
 */
@Service
public class OmsPortalOrderServiceImpl implements OmsPortalOrderService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private CancelOrderSender sender;

    @Override
    public void cancelOrder(Long orderId) {
        logger.info("process cancelOrder orderId:{}", orderId);
    }

    @Override
    public Result generateOrder(OrderParam param) {
        logger.info("process generateOrder");

        //下单完成后开启一个延迟队列消息，用于当前用户没有付款时取消，订单id在下单后生成
        this.sendDelayMessageCancelOrder(11L);
        return Result.success(null, "下单成功");
    }


    private void sendDelayMessageCancelOrder(Long orderId) {
        //获取订单超时时间，假设2分钟
        long delayTimes = 60 * 1000;
        //发送延迟消息
        this.sender.sendMessage(orderId, delayTimes);
    }
}
