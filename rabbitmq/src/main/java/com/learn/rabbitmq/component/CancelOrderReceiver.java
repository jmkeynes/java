package com.learn.rabbitmq.component;

import com.learn.rabbitmq.service.OmsPortalOrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author：江文谱
 * @date： 2020/5/5 21:47
 * @version： 1.0
 */
@Component
@RabbitListener(queues = "learn.order.cancel")
public class CancelOrderReceiver {

    private Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private OmsPortalOrderService service;

    @RabbitHandler
    public void handle(Long orderId) {
        LOGGER.info("receive delay message orderId：{}", orderId);
        service.cancelOrder(orderId);
    }
}
