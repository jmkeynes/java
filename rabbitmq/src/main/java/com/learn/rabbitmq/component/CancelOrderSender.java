package com.learn.rabbitmq.component;

import com.learn.rabbitmq.enums.QueueEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author：江文谱
 * @date： 2020/5/5 21:41
 * @version： 1.0
 */
@Component
public class CancelOrderSender {

    private Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private AmqpTemplate amqpTemplate;

    public void sendMessage(Long orderId, final long delayTimes) {
        amqpTemplate.convertAndSend(QueueEnum.QUEUE_TTL_ORDER_CANCEL.getExchange(),
                QueueEnum.QUEUE_TTL_ORDER_CANCEL.getRouteKey(),
                orderId, message -> {

            //给消息设置延迟毫秒值
            message.getMessageProperties().setExpiration(String.valueOf(delayTimes));
            return message;
        });
        LOGGER.info("send delay message orderId:{}",orderId);
    }
}
