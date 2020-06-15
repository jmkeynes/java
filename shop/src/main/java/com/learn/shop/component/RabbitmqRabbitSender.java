package com.learn.shop.component;

import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author 江文谱
 * @version 1.0
 * @date 2020/6/15 19:39
 * @ClassName RabbitmqRabbitSender
 */
@Component
public class RabbitmqRabbitSender {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    /**
     * 回调函数: confirm确认
     */
    final RabbitTemplate.ConfirmCallback confirmCallback = (correlationData, ack, cause) -> {
        System.err.println("correlationData: " + correlationData);
        System.err.println("ack: " + ack);
        if (!ack) {
            System.err.println("异常处理....");
        }
    };

    /**
     * 回调函数: return返回
     */
    final RabbitTemplate.ReturnCallback returnCallback = (message, replyCode, replyText, exchange, routingKey)
            -> System.err.println("return exchange: " + exchange + ", routingKey: "
            + routingKey + ", replyCode: " + replyCode + ", replyText: " + replyText);

    /**
     * 发送消息方法调用: 构建Message消息
     *
     * @param message message
     */
    public void send(Object message) {
        rabbitTemplate.setConfirmCallback(confirmCallback);
        rabbitTemplate.setReturnCallback(returnCallback);
        //id + 时间戳 全局唯一 666666此处只是道具
        CorrelationData correlationData = new CorrelationData("666666");
        rabbitTemplate.convertAndSend("exchange", "confirm.msg", message, correlationData);
    }

    /**
     * 自定义消息信息
     *
     * @param message    message
     * @param properties prop
     */
    public void send(Object message, Map<String, Object> properties) {
        MessageHeaders headers = new MessageHeaders(properties);
        Message msg = MessageBuilder.createMessage(message, headers);
        rabbitTemplate.setConfirmCallback(confirmCallback);
        rabbitTemplate.setReturnCallback(returnCallback);
        //id + 时间戳 全局唯一
        CorrelationData correlationData = new CorrelationData("666666");
        rabbitTemplate.convertAndSend("exchange", "msg.confirm", msg, correlationData);
    }
}
