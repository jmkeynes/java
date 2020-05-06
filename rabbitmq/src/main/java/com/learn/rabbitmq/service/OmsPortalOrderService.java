package com.learn.rabbitmq.service;

import com.learn.rabbitmq.dto.OrderParam;
import com.learn.rabbitmq.pojo.Result;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author：江文谱
 * @date： 2020/5/5 21:49
 * @version： 1.0
 */
public interface OmsPortalOrderService {

    /**
     * 取消单个超时订单
     */
    @Transactional
    void cancelOrder(Long orderId);

    /**
     * 根据提交信息生成订单
     */
    @Transactional
    Result generateOrder(OrderParam param);
}
