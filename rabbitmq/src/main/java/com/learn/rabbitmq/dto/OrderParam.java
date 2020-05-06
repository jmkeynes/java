package com.learn.rabbitmq.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;

/**
 * @author：江文谱
 * @date： 2020/5/5 21:53
 * @version： 1.0
 */
@Setter
@Getter
public class OrderParam {

    /**
     * 收货地址id
     */
    @Min(2)
    private Long memberReceiveAddressId;

    /**
     * 优惠券id
     */
    @Min(2)
    private Long couponId;

    /**
     * 使用的积分数
     */
    @Min(2)
    private Integer useIntegration;

    /**
     * 支付方式
     */
    @Min(2)
    private Integer payType;
}
