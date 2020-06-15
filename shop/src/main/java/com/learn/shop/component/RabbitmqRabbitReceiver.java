package com.learn.shop.component;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/**
 * @author 江文谱
 * @version 1.0
 * @date 2020/6/15 19:47
 * @ClassName RabbitmqRabbitReceiver
 */
@Component
public class RabbitmqRabbitReceiver {

    @RabbitHandler
    public void onMessage(Message message, Channel channel) throws Exception {
        Long deliveryTag = (Long) message.getHeaders().get(AmqpHeaders.DELIVERY_TAG);
        //手工ACK
        channel.basicAck(deliveryTag, false);
    }
}
